package dev.kolind.permacraft.gui.pages.bossmobs;

import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Bossmobspage {
		
		public static Inventory Bossmobs = Bukkit.createInventory(null, 27, "Bossmobs");
		
		Main instance;
		public Bossmobspage(Main plugin) {
			instance = plugin;
		}
		
		//Icons
		
		public static boolean openGUI(Player player) {
			
			
			
			Bossmobs.setItem(0, Bossmobitems.Back);
			Bossmobs.setItem(1, Bossmobitems.backGround);
			Bossmobs.setItem(2, Bossmobitems.backGround);
			Bossmobs.setItem(3, Bossmobitems.backGround);
			if (Main.plugin.getConfig().getBoolean("Features.Bossmobs.Enabled") == false) {
				Bossmobs.setItem(4, Bossmobitems.Enabled);
			} else {
				Bossmobs.setItem(4, Bossmobitems.Disabled);
			}
			Bossmobs.setItem(5, Bossmobitems.backGround);
			Bossmobs.setItem(6, Bossmobitems.backGround);
			Bossmobs.setItem(7, Bossmobitems.backGround);
			Bossmobs.setItem(8, Bossmobitems.backGround);
			
			//Next row
			Bossmobs.setItem(9, Bossmobitems.backGround);
			
			Bossmobs.setItem(10, Bossmobitems.focusedBackGround);
			

			Bossmobs.setItem(11, Bossmobitems.Customitems);
			Bossmobs.setItem(12, Bossmobitems.focusedBackGround);
			
			if (Main.plugin.getConfig().getBoolean("Features.Bossmobs.Enabled") == false) {
				Bossmobs.setItem(13, Bossmobitems.Enablebossmobs);
			} else {
				Bossmobs.setItem(13, Bossmobitems.Disablebossmobs);
			}
			
			Bossmobs.setItem(14, Bossmobitems.focusedBackGround);
			Bossmobs.setItem(15, Bossmobitems.focusedBackGround);
			Bossmobs.setItem(16, Bossmobitems.focusedBackGround);
			Bossmobs.setItem(17, Bossmobitems.backGround);
			//Next row
			Bossmobs.setItem(18, Bossmobitems.backGround);
			Bossmobs.setItem(19, Bossmobitems.backGround);
			Bossmobs.setItem(20, Bossmobitems.backGround);
			Bossmobs.setItem(21, Bossmobitems.backGround);
			Bossmobs.setItem(22, Bossmobitems.backGround);
			Bossmobs.setItem(23, Bossmobitems.backGround);
			Bossmobs.setItem(24, Bossmobitems.backGround);
			Bossmobs.setItem(25, Bossmobitems.backGround);
			Bossmobs.setItem(26, Bossmobitems.backGround);
													
			
			player.openInventory(Bossmobs);
			
			
			return true;
			
		}
		
	}

	

