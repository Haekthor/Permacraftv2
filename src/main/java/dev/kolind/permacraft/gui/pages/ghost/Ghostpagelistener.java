package dev.kolind.permacraft.gui.pages.ghost;


import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.gui.pages.mainmenu.Mainpage;
import dev.kolind.permacraft.main.Main;
import dev.kolind.permacraft.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class Ghostpagelistener implements Listener {
	
	
	public static ItemSmith smithy = new ItemSmith();
	//constructor
	Main instance;
	public Ghostpagelistener(Main plugin) {
		instance = plugin;
	}


	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) { //on click in an inventory
		Player player = (Player) event.getWhoClicked(); //Get the person who clicked
		if (player.getOpenInventory().getTitle().equals("Ghostpage") && event.getSlotType() != SlotType.OUTSIDE) { //Make sure its in the GUI we opened
			
			ItemStack clicked = event.getCurrentItem(); //Get the item clicked
			
			
			
			if (clicked.equals(Bossmobitems.Enableghosts)) {
				
				instance.getConfig().set("Features.Ghosts.Enabled", true);
				instance.saveConfig();
				player.sendMessage(ChatColor.GREEN + "Enabled ghosts");
				//player.closeInventory();
				Ghostpage.openGUI(player);	
				
			} else if (clicked.equals(Bossmobitems.Disableghosts)) {
				
				instance.getConfig().set("Features.Ghosts.Enabled", false);
				instance.saveConfig();
				player.sendMessage(ChatColor.RED + "Disabled ghosts");
				//player.closeInventory();
				Ghostpage.openGUI(player);

			} else if (clicked.equals(Bossmobitems.Ghosts)) {
				
				//player.closeInventory();
				Mainpage.openGUI(player);
				
			} else if (clicked.equals(Bossmobitems.EnablePlayergear)) {
				
				instance.getConfig().set("Features.Ghosts.Playergear", true);
				instance.saveConfig();
				player.sendMessage(ChatColor.RED + "Enabled Player gear");
				//player.closeInventory();
				Ghostpage.openGUI(player);

			} else if (clicked.equals(Bossmobitems.DisablePlayergear)) {
				
				instance.getConfig().set("Features.Ghosts.Playergear", false);
				instance.saveConfig();
				player.sendMessage(ChatColor.RED + "Disabled Player gear");
				//7player.closeInventory();
				Ghostpage.openGUI(player);

			} else if (clicked.equals(Bossmobitems.EnableSkeletonfire)) {
				
				instance.getConfig().set("Features.Ghosts.Skeletonfire", true);
				instance.saveConfig();
				player.sendMessage(ChatColor.GREEN + "Enabled Skeleton fire");
				//player.closeInventory();
				Ghostpage.openGUI(player);

			} else if (clicked.equals(Bossmobitems.DisableSkeletonfire)) {
				
				instance.getConfig().set("Features.Ghosts.Skeletonfire", false);
				instance.saveConfig();
				player.sendMessage(ChatColor.RED + "Disabled Skeleton fire");
				//player.closeInventory();
				Ghostpage.openGUI(player);

			}
			 else if (clicked.equals(Bossmobitems.Back)) {
					
					//player.closeInventory();
					Mainpage.openGUI(player);

				}
			
			
			event.setCancelled(true);
			//player.closeInventory();	
		}
	} 
}