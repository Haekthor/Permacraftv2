package dev.kolind.permacraft.functions.undeadplayer;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import dev.kolind.permacraft.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Undeadplayer implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public Undeadplayer(Main plugin) {
		instance = plugin;
	}


	//Eventhandler
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerDeath(EntityDeathEvent event) {
		if (event.getEntity() instanceof Player) {
			if (instance.getConfig().getBoolean("Features.Ghosts.Enabled") == true) {
				Player player = (Player) event.getEntity();
		
				if (player.getLastDamageCause().getCause() == DamageCause.FIRE || player.getLastDamageCause().getCause() == DamageCause.LAVA || player.getLastDamageCause().getCause() == DamageCause.FIRE_TICK) {
					if (instance.getConfig().getBoolean("Features.Ghosts.Skeletonfire")) {
						//Death by fire (make it skeleton)
						Skeleton skeleton = (Skeleton) player.getWorld().spawnEntity(player.getLocation(), EntityType.SKELETON);
						skeleton.setCustomName(ChatColor.YELLOW + "[" + player.getDisplayName() + "]'s" + ChatColor.GRAY + " Ghost");
						//Equip with playergear
						if (instance.getConfig().getBoolean("Features.Ghosts.Playergear") == true) {
							skeleton.getEquipment().setHelmet(player.getEquipment().getHelmet());
							skeleton.getEquipment().setChestplate(player.getEquipment().getChestplate());
							skeleton.getEquipment().setLeggings(player.getEquipment().getLeggings());
							skeleton.getEquipment().setBoots(player.getEquipment().getBoots());
							skeleton.getEquipment().setItemInHand(player.getItemInHand());
							skeleton.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 255, true));
							event.getDrops().clear();
						}	
					} else {
						Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
						zombie.setCustomName(ChatColor.YELLOW + "[" + player.getDisplayName() + "]'s" + ChatColor.GRAY + " Ghost");
						if (instance.getConfig().getBoolean("Features.Ghosts.Playergear") == true) {
							zombie.getEquipment().setHelmet(player.getEquipment().getHelmet());
							zombie.getEquipment().setChestplate(player.getEquipment().getChestplate());
							zombie.getEquipment().setLeggings(player.getEquipment().getLeggings());
							zombie.getEquipment().setBoots(player.getEquipment().getBoots());
							zombie.getEquipment().setItemInHand(player.getItemInHand());
							event.getDrops().clear();
						}
					}
					
				} else {
					//Not death by fire
					Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
					zombie.setCustomName(ChatColor.YELLOW + "[" + player.getDisplayName() + "]'s" + ChatColor.GRAY + " Ghost");
					if (instance.getConfig().getBoolean("Features.Ghosts.Playergear") == true) {
						zombie.getEquipment().setHelmet(player.getEquipment().getHelmet());
						zombie.getEquipment().setChestplate(player.getEquipment().getChestplate());
						zombie.getEquipment().setLeggings(player.getEquipment().getLeggings());
						zombie.getEquipment().setBoots(player.getEquipment().getBoots());
						zombie.getEquipment().setItemInHand(player.getItemInHand());
						event.getDrops().clear();
					}	
				} 
			}
		} 
	}
}