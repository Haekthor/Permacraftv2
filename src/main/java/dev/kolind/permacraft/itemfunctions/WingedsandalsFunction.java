package dev.kolind.permacraft.itemfunctions;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class WingedsandalsFunction implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public WingedsandalsFunction(Main plugin) {
		instance = plugin;
	}
	ItemSmith itemSmith = new ItemSmith();
	
	
	
	//Eventhandler 
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		
		
		
		if (event.getPlayer().getInventory().getBoots() != null) {
			
			if (event.getPlayer().getInventory().getBoots().hasItemMeta() && event.getPlayer().getInventory().getBoots().getItemMeta().getLore() != null) {
				
		
				
				
				if (event.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains("Winged Sandals wore by Hermes, allowing the god to fly.")) {
					
					Player player = (Player) event.getPlayer();
					player.setAllowFlight(true);




				} else  {
					Player player = (Player) event.getPlayer();
					player.setAllowFlight(false);

					
				}
			} 

		}

	} 
	
	@EventHandler
	public void onPlayerMove(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		
		if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getLore() != null) {
			
			
			if (event.getCurrentItem().getItemMeta().getLore().contains("Winged Sandals wore by Hermes, allowing the god to fly.")) {
				
				if (player.getInventory().getBoots() != null) {
					
					if (event.getWhoClicked().getInventory().getBoots().getItemMeta().getLore().contains("Winged Sandals wore by Hermes, allowing the god to fly.")) {
						
						player.setAllowFlight(false);
					} 
				} else {
					player.setAllowFlight(true);
				}
			} 
		}

	}
	
}