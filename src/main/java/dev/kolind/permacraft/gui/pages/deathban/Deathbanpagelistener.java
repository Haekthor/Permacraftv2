package dev.kolind.permacraft.gui.pages.deathban;


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

public class Deathbanpagelistener implements Listener {
	
	
	public static ItemSmith smithy = new ItemSmith();
	//constructor
	Main instance;
	public Deathbanpagelistener(Main plugin) {
		instance = plugin;
	}


	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) { //on click in an inventory
		Player player = (Player) event.getWhoClicked(); //Get the person who clicked
		if (player.getOpenInventory().getTitle().equals("Deathban") && event.getSlotType() != SlotType.OUTSIDE) { //Make sure its in the GUI we opened
			
			ItemStack clicked = event.getCurrentItem(); //Get the item clicked
			
			
			
			if (clicked.equals(Bossmobitems.Enabledeathban)) {
				
				instance.getConfig().set("Features.Deathban.Enabled", true);
				instance.saveConfig();
				player.sendMessage(ChatColor.GREEN + "Enabled Deathban");
				//player.closeInventory();
				Deathbanpage.openGUI(player);	
				
			} else if (clicked.equals(Bossmobitems.Disabledeathban)) {
				
				instance.getConfig().set("Features.Deathban.Enabled", false);
				instance.saveConfig();
				player.sendMessage(ChatColor.RED + "Disabled Deathban");
				//player.closeInventory();
				Deathbanpage.openGUI(player);

			} else if (clicked.equals(Bossmobitems.Back)) {
				
				//player.closeInventory();
				Mainpage.openGUI(player);

			}
			
			
			event.setCancelled(true);
			//player.closeInventory();	
		}
	} 
}