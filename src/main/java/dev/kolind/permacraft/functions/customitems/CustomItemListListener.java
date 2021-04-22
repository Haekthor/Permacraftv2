package dev.kolind.permacraft.functions.customitems;


import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.gui.pages.mainmenu.Mainpage;
import dev.kolind.permacraft.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class CustomItemListListener implements Listener {
	
	
	public static ItemSmith smithy = new ItemSmith();
	//constructor
	Main instance;
	public CustomItemListListener(Main plugin) {
		instance = plugin;
	}


    @EventHandler
	public void onInventoryClick(InventoryClickEvent event) { //on click in an inventory
		Player player = (Player) event.getWhoClicked(); //Get the person who clicked
		if (player.getOpenInventory().getTitle().equals("Custom Items") && event.getSlotType() != SlotType.OUTSIDE) { //Make sure its in the GUI we opened
			
			ItemStack clicked = event.getCurrentItem(); //Get the item clicked
			
				if (clicked.equals(Bossmobitems.Back)) {
					Mainpage.openGUI(player);
				}
			
				player.getInventory().addItem(clicked);
			
			
			event.setCancelled(true);
			//player.closeInventory();	
		}
	} 
}