package dev.kolind.permacraft.gui.pages.items;


import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.gui.pages.mainmenu.Mainpage;
import dev.kolind.permacraft.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class Itempagelistener implements Listener {
	
	
	public static ItemSmith smithy = new ItemSmith();
	//constructor
	Main instance;
	public Itempagelistener(Main plugin) {
		instance = plugin;
	}



    @EventHandler
	public void onInventoryClick(InventoryClickEvent event) { //on click in an inventory
		Player player = (Player) event.getWhoClicked(); //Get the person who clicked
		if (player.getOpenInventory().getTitle().equals("Deathban") && event.getSlotType() != SlotType.OUTSIDE) { //Make sure its in the GUI we opened
			
			ItemStack clicked = event.getCurrentItem(); //Get the item clicked
			
			
			
			if (clicked.equals(Bossmobitems.Enablenoitemdespawn)) {
				
				instance.getConfig().set("Features.Items.Nodespawn", true);
				instance.saveConfig();
				player.sendMessage(ChatColor.GREEN + "Enabled No item despawn");
				//player.closeInventory();
				Itempage.openGUI(player);	
				
			} else if (clicked.equals(Bossmobitems.Disablenoitemdespawn)) {
				
				instance.getConfig().set("Features.Items.Nodespawn", false);
				instance.saveConfig();
				player.sendMessage(ChatColor.RED + "Disabled No item despawn");
				//player.closeInventory();
				Itempage.openGUI(player);

			} else if (clicked.equals(Bossmobitems.Back)) {
				
				//player.closeInventory();
				Mainpage.openGUI(player);

			}
			
			
			event.setCancelled(true);
			//player.closeInventory();	
		}
	} 
}