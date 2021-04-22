package dev.kolind.permacraft.gui.pages.ghost;

import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Ghostpage {
		
		public static Inventory Ghostpage = Bukkit.createInventory(null, 27, "Ghostpage");
		
		Main instance;
		public Ghostpage(Main plugin) {
			instance = plugin;
		}
		
		//Icons
		
		public static boolean openGUI(Player player) {
			
			
			
			Ghostpage.setItem(0, Bossmobitems.Back);
			Ghostpage.setItem(1, Bossmobitems.backGround);
			
			if (Main.plugin.getConfig().getBoolean("Features.Ghosts.Playergear") == false) {
				Ghostpage.setItem(2, Bossmobitems.Enabled);
			} else {
				Ghostpage.setItem(2, Bossmobitems.Disabled);
			}	
			
			Ghostpage.setItem(3, Bossmobitems.backGround);
			
			if (Main.plugin.getConfig().getBoolean("Features.Ghosts.Enabled") == false) {
				Ghostpage.setItem(4, Bossmobitems.Enabled);
			} else {
				Ghostpage.setItem(4, Bossmobitems.Disabled);
			}
			
			Ghostpage.setItem(5, Bossmobitems.backGround);
			
			
			if (Main.plugin.getConfig().getBoolean("Features.Ghosts.Skeletonfire") == false) {
				Ghostpage.setItem(6, Bossmobitems.Enabled);
			} else {
				Ghostpage.setItem(6, Bossmobitems.Disabled);
			}
			
			
			Ghostpage.setItem(7, Bossmobitems.backGround);
			Ghostpage.setItem(8, Bossmobitems.backGround);
			
			//Next row
			Ghostpage.setItem(9, Bossmobitems.backGround);
			Ghostpage.setItem(10, Bossmobitems.focusedBackGround);
			
			if (Main.plugin.getConfig().getBoolean("Features.Ghosts.Playergear") == false) {
				Ghostpage.setItem(11, Bossmobitems.EnablePlayergear);
			} else {
				Ghostpage.setItem(11, Bossmobitems.DisablePlayergear);
			}
			
			Ghostpage.setItem(12, Bossmobitems.focusedBackGround);
			
			if (Main.plugin.getConfig().getBoolean("Features.Ghosts.Enabled") == false) {
				Ghostpage.setItem(13, Bossmobitems.Enableghosts);
			} else {
				Ghostpage.setItem(13, Bossmobitems.Disableghosts);
			}
			
			Ghostpage.setItem(14, Bossmobitems.focusedBackGround);
			
			
			if (Main.plugin.getConfig().getBoolean("Features.Ghosts.Skeletonfire") == false) {
				Ghostpage.setItem(15, Bossmobitems.EnableSkeletonfire);
			} else {
				Ghostpage.setItem(15, Bossmobitems.DisableSkeletonfire);
			}
			
			
			
			Ghostpage.setItem(16, Bossmobitems.focusedBackGround);
			Ghostpage.setItem(17, Bossmobitems.backGround);
			//Next row
			Ghostpage.setItem(18, Bossmobitems.backGround);
			Ghostpage.setItem(19, Bossmobitems.backGround);
			Ghostpage.setItem(20, Bossmobitems.backGround);
			Ghostpage.setItem(21, Bossmobitems.backGround);
			Ghostpage.setItem(22, Bossmobitems.backGround);
			Ghostpage.setItem(23, Bossmobitems.backGround);
			Ghostpage.setItem(24, Bossmobitems.backGround);
			Ghostpage.setItem(25, Bossmobitems.backGround);
			Ghostpage.setItem(26, Bossmobitems.backGround);
													
			
			player.openInventory(Ghostpage);
			
			
			return true;
			
		}
		
	}

	

