package dev.kolind.permacraft.functions.itemdespawncontrol;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

public class Noitemdespawn implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public Noitemdespawn(Main plugin) {
		instance = plugin;
	}



    //Eventhandler
	@EventHandler
	public void onPlayerDeath(ItemDespawnEvent event) {
		if (instance.getConfig().getBoolean("Features.Items.Nodespawn") == true) {
			event.setCancelled(true);
		}
	}
}