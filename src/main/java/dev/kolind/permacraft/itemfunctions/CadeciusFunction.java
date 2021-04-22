package dev.kolind.permacraft.itemfunctions;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CadeciusFunction implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public CadeciusFunction(Main plugin) {
		instance = plugin;
	}
	ItemSmith itemSmith = new ItemSmith();
	
	
	
	//Eventhandler
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {

		if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR && event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null) {
			
			if (event.getPlayer().getItemInHand().getItemMeta().getLore().contains("The Cadaceus is a staff that is most often carried by Hermes.")) {
				if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GRASS_BLOCK) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 1));

				}
			}

		}

	}
}