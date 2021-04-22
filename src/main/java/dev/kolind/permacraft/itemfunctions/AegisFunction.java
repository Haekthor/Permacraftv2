package dev.kolind.permacraft.itemfunctions;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AegisFunction implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public AegisFunction(Main plugin) {
		instance = plugin;
	}
	ItemSmith itemSmith = new ItemSmith();
	
	
	
	//Eventhandler
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {

		if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR && event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null) {
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("Zeus, Perseus, and especially Athena used the Aegis at one time or another.")) {
				
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 5, 1));

			} 
		} 	
	}
}