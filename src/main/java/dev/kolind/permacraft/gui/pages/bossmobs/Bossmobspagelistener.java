package dev.kolind.permacraft.gui.pages.bossmobs;


import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.gui.pages.mainmenu.Mainpage;
import dev.kolind.permacraft.main.Main;
import dev.kolind.permacraft.tools.CustomItemList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class Bossmobspagelistener implements Listener {
	
	
	public static ItemSmith smithy = new ItemSmith();
	//constructor
	Main instance;
	public Bossmobspagelistener(Main plugin) {
		instance = plugin;
	}


    @EventHandler
	public void onInventoryClick(InventoryClickEvent event) { //on click in an inventory
		Player player = (Player) event.getWhoClicked(); //Get the person who clicked
		if (player.getOpenInventory().getTitle().equals("Bossmobs") && event.getSlotType() != SlotType.OUTSIDE) { //Make sure its in the GUI we opened
			
			ItemStack clicked = event.getCurrentItem(); //Get the item clicked
			
			
			
			if (clicked.equals(Bossmobitems.Enablebossmobs)) {
				
				instance.getConfig().set("Features.Bossmobs.Enabled", true);
				instance.saveConfig();
				player.sendMessage(ChatColor.GREEN + "Enabled Bossmobs");
				//player.closeInventory();
				Bossmobspage.openGUI(player);	
				
			} else if (clicked.equals(Bossmobitems.Disablebossmobs)) {
				
				instance.getConfig().set("Features.Bossmobs.Enabled", false);
				instance.saveConfig();
				player.sendMessage(ChatColor.RED + "Disabled Bossmobs");
				//player.closeInventory();
				Bossmobspage.openGUI(player);

			} else if (clicked.equals(Bossmobitems.Back)) {
				
				//player.closeInventory();
				Mainpage.openGUI(player);

			} else if (clicked.equals(Bossmobitems.Customitems)) {
				
				//player.closeInventory();
				CustomItemList.openGUI(player);

			}
			
			
			event.setCancelled(true);
			//player.closeInventory();	
		}
	} 
}