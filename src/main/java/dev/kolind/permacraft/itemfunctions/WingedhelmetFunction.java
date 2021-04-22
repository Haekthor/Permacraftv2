package dev.kolind.permacraft.itemfunctions;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class WingedhelmetFunction implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public WingedhelmetFunction(Main plugin) {
		instance = plugin;
	}
	ItemSmith itemSmith = new ItemSmith();
	
	
	
	//Eventhandler 
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		
		
		
		if (event.getPlayer().getInventory().getHelmet() != null) {
			
			if (event.getPlayer().getInventory().getHelmet().hasItemMeta() && event.getPlayer().getInventory().getHelmet().getItemMeta().getLore() != null) {
				
		
				
				
				if (event.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains("Winged helmet wore by Hermes.")) {
					
					Player player = (Player) event.getPlayer();
					player.setAllowFlight(true);




				} else  {
					//Player player = (Player) event.getPlayer();
					//player.setAllowFlight(false);

					
				}
			} 

		}

	} 
	
	@EventHandler
	public void onPlayerMove(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		
		if (event.getCurrentItem() != null) {
			if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getLore() != null) {
				
				
				if (event.getCurrentItem().getItemMeta().getLore().contains("Winged helmet wore by Hermes.")) {
					
					if (player.getInventory().getHelmet() != null) {
						
						if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().getLore().contains("Winged helmet wore by Hermes.")) {
							
							player.setAllowFlight(false);
						} 
					} else {
						player.setAllowFlight(true);
					}
				} 
			}
		}


	}
	
}