package dev.kolind.permacraft.main;

import dev.kolind.permacraft.functions.bossmobs.Bossmobs;
import dev.kolind.permacraft.functions.bossmobs.NametagHealth;
import dev.kolind.permacraft.functions.bossmobs.mobs.Ogre;
import dev.kolind.permacraft.functions.chestloot.ChestLoot;
import dev.kolind.permacraft.functions.customitems.CustomItemListListener;
import dev.kolind.permacraft.functions.deathban.Deathban;
import dev.kolind.permacraft.functions.itemdespawncontrol.Noitemdespawn;
import dev.kolind.permacraft.functions.undeadplayer.Undeadplayer;
import dev.kolind.permacraft.gui.pages.bossmobs.Bossmobspagelistener;
import dev.kolind.permacraft.gui.pages.deathban.Deathbanpagelistener;
import dev.kolind.permacraft.gui.pages.ghost.Ghostpagelistener;
import dev.kolind.permacraft.gui.pages.items.Itempagelistener;
import dev.kolind.permacraft.gui.pages.mainmenu.Mainpage;
import dev.kolind.permacraft.gui.pages.mainmenu.Mainpagelistener;
import dev.kolind.permacraft.itemfunctions.*;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.trait.waypoint.Waypoints;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;


public class Main extends JavaPlugin {

	public String pluginprefix;
    public static Main plugin;
    Ogre ogre = new Ogre();
	
	
    @Override
    public void onEnable() {

    	pluginprefix = getConfig().getString("pluginprefix");
        getLogger().info("Has been enabled");
        
        //Listener registers
        PluginManager pm = getServer().getPluginManager();
        
        pm.registerEvents(new Ghostpagelistener(this), this);
        pm.registerEvents(new Mainpagelistener(this), this);
        pm.registerEvents(new Undeadplayer(this), this);
        pm.registerEvents(new Deathbanpagelistener(this), this);
        pm.registerEvents(new Deathban(this), this);
        pm.registerEvents(new Noitemdespawn(this), this);
        pm.registerEvents(new Itempagelistener(this), this);
        pm.registerEvents(new Bossmobs(this), this);
        pm.registerEvents(new Bossmobspagelistener(this), this);
        pm.registerEvents(new AegisFunction(this), this);
        pm.registerEvents(new CadeciusFunction(this), this);
        pm.registerEvents(new WingedhelmetFunction(this), this);
        pm.registerEvents(new NessusshirtFunction(this), this);
        pm.registerEvents(new NemeanhideFunction(this), this);
        pm.registerEvents(new ChestLoot(this), this);
        pm.registerEvents(new CustomItemListListener(this), this);
        pm.registerEvents(new HelmofdarknessFunction(this), this);
        pm.registerEvents(new NametagHealth(this), this);
        
        
        getConfig().set("LootDrops.resetnextstartup", true);
        saveConfig();
        if (getConfig().getBoolean("LootDrops.resetnextstartup", true)) {
    		getConfig().set("LootDrops.Common.Chance", 1f);
    		getConfig().set("LootDrops.Uncommon.Chance", 1f);
    		getConfig().set("LootDrops.Rare.Chance", 1f);
    		getConfig().set("LootDrops.Legendary.Chance", 1f);
    		getConfig().set("LootDrops.resetnextstartup", false);
    		saveConfig();
        }
        
        plugin = this;


        //Restart mobs
        for (NPCRegistry npcRegistry : CitizensAPI.getNPCRegistries()) {
            for (Iterator<NPC> it = npcRegistry.iterator(); it.hasNext(); ) {
                NPC npc = it.next();
                if (npc.hasTrait(Waypoints.class)) {
                    npc.getOrAddTrait(Waypoints.class).setWaypointProvider("wander");
                }
            }
        }
    }

    @Override
    public void onDisable() {
    	getLogger().info("Has been disabled");
    }  
    
    //Commands
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
        	String lowerCmd = cmd.getName().toLowerCase(); //Make the send command lowercase	
        	switch (lowerCmd) {
        		case "permacraft":
        			Mainpage.openGUI(player);
	        	return true;

                case "summon":
                    if(args.length >= 1) {
                        switch (args[0]) {
                            case "ogre":
                                ogre.summon(player.getLocation());
                            return true;
                        }
                    }

                case "reset":
                    CitizensAPI.getNPCRegistry().deregisterAll();
                    CitizensAPI.getNPCRegistry().despawnNPCs(DespawnReason.REMOVAL);
                return true;
        	}
        }
		return true;
    }

}