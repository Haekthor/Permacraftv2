package dev.kolind.permacraft.itemfunctions;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HelmofdarknessFunction implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public HelmofdarknessFunction(Main plugin) {
		instance = plugin;
	}
	
	ItemSmith itemSmith = new ItemSmith();
	
	//Eventhandler
	@EventHandler

	public void onPlayerMove(PlayerMoveEvent event) {
		
		if (event.getPlayer().getInventory().getHelmet() != null) {
			
			if (event.getPlayer().getInventory().getHelmet().hasItemMeta() && event.getPlayer().getInventory().getHelmet().getItemMeta().getLore() != null) {
				if (event.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains("The Helmet of Darkness, also known as helmet or Cap of Invisibility, was a headgear created by the Cyclopes for Hades (Pluto).")) {
					

			        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

			            @Override
			            public void run(){
			            	event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9, 10));
			            }
			        }, 10L);
				} 
			} 	
			
		}

	}
}