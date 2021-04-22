package dev.kolind.permacraft.itemfunctions;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NessusshirtFunction implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public NessusshirtFunction(Main plugin) {
		instance = plugin;
	}
	
	ItemSmith itemSmith = new ItemSmith();
	
	//Eventhandler
	@EventHandler

	public void onPlayerMove(PlayerMoveEvent event) {
		
		if (event.getPlayer().getInventory().getChestplate() != null) {
			
			if (event.getPlayer().getInventory().getChestplate().hasItemMeta() && event.getPlayer().getInventory().getChestplate().getItemMeta().getLore() != null) {
				if (event.getPlayer().getInventory().getChestplate().getItemMeta().getLore().contains("Shirt poisoned with Nessus tainted/poisoned blood,\n used to poison and kill Heracles.")) {
					

			        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

			            @Override
			            public void run(){
			            	event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 9, 10));
			            }
			        }, 10L);
				} 
			} 	
			
		}

	}
}