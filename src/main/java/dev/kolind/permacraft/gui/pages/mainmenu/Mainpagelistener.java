package dev.kolind.permacraft.gui.pages.mainmenu;


import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.gui.pages.bossmobs.Bossmobspage;
import dev.kolind.permacraft.gui.pages.deathban.Deathbanpage;
import dev.kolind.permacraft.gui.pages.ghost.Ghostpage;
import dev.kolind.permacraft.gui.pages.items.Itempage;
import dev.kolind.permacraft.main.Main;
import dev.kolind.permacraft.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class Mainpagelistener implements Listener {
	
	
	public static ItemSmith smithy = new ItemSmith();
	//constructor
	Main instance;
	public Mainpagelistener(Main plugin) {
		instance = plugin;
	}


	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) { //on click in an inventory
		Player player = (Player) event.getWhoClicked(); //Get the person who clicked
		if (player.getOpenInventory().getTitle().equals("Mainpage") && event.getSlotType() != SlotType.OUTSIDE) { //Make sure its in the GUI we opened
			
			ItemStack clicked = event.getCurrentItem(); //Get the item clicked
			
			
			
			if (clicked.equals(Bossmobitems.Ghosts)) {
				
				Ghostpage.openGUI(player);
			}
			
			if (clicked.equals(Bossmobitems.Deathban)) {
				
				Deathbanpage.openGUI(player);
			}
			
			if (clicked.equals(Bossmobitems.Items)) {
				
				Itempage.openGUI(player);
			}
			if (clicked.equals(Bossmobitems.Bossmobs)) {
				
				Bossmobspage.openGUI(player);
			}
			event.setCancelled(true);
			//player.closeInventory();	
		}
	} 
}