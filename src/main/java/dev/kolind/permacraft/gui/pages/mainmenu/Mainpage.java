package dev.kolind.permacraft.gui.pages.mainmenu;

import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Mainpage {
	
	public static Inventory Mainpage = Bukkit.createInventory(null, 27, "Mainpage");

	//The gui
	public static boolean openGUI(Player player) {
		

		
		
		Mainpage.setItem(0, Bossmobitems.backGround);
		if (Main.plugin.getConfig().getBoolean("Features.Deathban.Enabled") == false) {
			Mainpage.setItem(1, Bossmobitems.Enabled);
		} else {
			Mainpage.setItem(1, Bossmobitems.Disabled);
		}
		
		Mainpage.setItem(2, Bossmobitems.backGround);
		
		if (Main.plugin.getConfig().getBoolean("Features.Ghosts.Enabled") == false) {
			Mainpage.setItem(3, Bossmobitems.Enabled);
		} else {
			Mainpage.setItem(3, Bossmobitems.Disabled);
		}
		
		
		Mainpage.setItem(4, Bossmobitems.backGround);
		
		
		if (Main.plugin.getConfig().getBoolean("Features.Items.Nodespawn") == false) {
			Mainpage.setItem(5, Bossmobitems.Enabled);
		} else {
			Mainpage.setItem(5, Bossmobitems.Disabled);
		}
		
		
		
		Mainpage.setItem(6, Bossmobitems.backGround);
		
		
		if (Main.plugin.getConfig().getBoolean("Features.Bossmobs.Enabled") == false) {
			Mainpage.setItem(7, Bossmobitems.Enabled);
		} else {
			Mainpage.setItem(7, Bossmobitems.Disabled);
			
			
		}
		Mainpage.setItem(8, Bossmobitems.backGround);
		//Next row
		Mainpage.setItem(9, Bossmobitems.backGround);
		Mainpage.setItem(10, Bossmobitems.Deathban);
		Mainpage.setItem(11, Bossmobitems.focusedBackGround);
		Mainpage.setItem(12, Bossmobitems.Ghosts);
		Mainpage.setItem(13, Bossmobitems.focusedBackGround);
		Mainpage.setItem(14, Bossmobitems.Items);
		Mainpage.setItem(15, Bossmobitems.focusedBackGround);
		Mainpage.setItem(16, Bossmobitems.Bossmobs);
		Mainpage.setItem(17, Bossmobitems.backGround);
		//Next row
		Mainpage.setItem(18, Bossmobitems.backGround);
		Mainpage.setItem(19, Bossmobitems.backGround);
		Mainpage.setItem(20, Bossmobitems.backGround);
		Mainpage.setItem(21, Bossmobitems.backGround);
		Mainpage.setItem(22, Bossmobitems.backGround);
		Mainpage.setItem(23, Bossmobitems.backGround);
		Mainpage.setItem(24, Bossmobitems.backGround);
		Mainpage.setItem(25, Bossmobitems.backGround);
		Mainpage.setItem(26, Bossmobitems.backGround);
												
		
		player.openInventory(Mainpage);
		
		
		return true;
		
	}
	
}
