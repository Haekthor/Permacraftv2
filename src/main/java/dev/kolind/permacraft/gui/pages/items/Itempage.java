package dev.kolind.permacraft.gui.pages.items;

import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Itempage {
		
		public static Inventory Deathban = Bukkit.createInventory(null, 27, "Deathban");
		
		Main instance;
		public Itempage(Main plugin) {
			instance = plugin;
		}
		
		//Icons
		
		public static boolean openGUI(Player player) {
			
			
			
			Deathban.setItem(0, Bossmobitems.Back);
			Deathban.setItem(1, Bossmobitems.backGround);
			Deathban.setItem(2, Bossmobitems.backGround);
			Deathban.setItem(3, Bossmobitems.backGround);
			if (Main.plugin.getConfig().getBoolean("Features.Items.Nodespawn") == false) {
				Deathban.setItem(4, Bossmobitems.Enabled);
			} else {
				Deathban.setItem(4, Bossmobitems.Disabled);
			}
			Deathban.setItem(5, Bossmobitems.backGround);
			Deathban.setItem(6, Bossmobitems.backGround);
			Deathban.setItem(7, Bossmobitems.backGround);
			Deathban.setItem(8, Bossmobitems.backGround);
			
			//Next row
			Deathban.setItem(9, Bossmobitems.backGround);
			Deathban.setItem(10, Bossmobitems.focusedBackGround);
			Deathban.setItem(11, Bossmobitems.focusedBackGround);
			Deathban.setItem(12, Bossmobitems.focusedBackGround);
			
			if (Main.plugin.getConfig().getBoolean("Features.Items.Nodespawn") == false) {
				Deathban.setItem(13, Bossmobitems.Enablenoitemdespawn);
			} else {
				Deathban.setItem(13, Bossmobitems.Disablenoitemdespawn);
			}
			
			Deathban.setItem(14, Bossmobitems.focusedBackGround);
			Deathban.setItem(15, Bossmobitems.focusedBackGround);
			Deathban.setItem(16, Bossmobitems.focusedBackGround);
			Deathban.setItem(17, Bossmobitems.backGround);
			//Next row
			Deathban.setItem(18, Bossmobitems.backGround);
			Deathban.setItem(19, Bossmobitems.backGround);
			Deathban.setItem(20, Bossmobitems.backGround);
			Deathban.setItem(21, Bossmobitems.backGround);
			Deathban.setItem(22, Bossmobitems.backGround);
			Deathban.setItem(23, Bossmobitems.backGround);
			Deathban.setItem(24, Bossmobitems.backGround);
			Deathban.setItem(25, Bossmobitems.backGround);
			Deathban.setItem(26, Bossmobitems.backGround);
													
			
			player.openInventory(Deathban);
			
			
			return true;
			
		}
		
	}

	

