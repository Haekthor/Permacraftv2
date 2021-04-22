package dev.kolind.permacraft.functions.deathban;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Date;

public class Deathban implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public Deathban(Main plugin) {
		instance = plugin;
	}


	//Eventhandler
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (instance.getConfig().getBoolean("Features.Deathban.Enabled") == true) {
				Player player = (Player) event.getEntity();
				Bukkit.getBanList(BanList.Type.NAME).addBan(player.getDisplayName(), ChatColor.RED + "You have been Deathbanned!" + ChatColor.YELLOW, new Date(System.currentTimeMillis()+86400000), null);
				player.setHealth(0);
				player.kickPlayer(ChatColor.RED + "You have been Deathbanned!" + " Return in 24 hours to continue playing!" + ChatColor.YELLOW);
		}
	}
}