package dev.kolind.permacraft.itemfunctions;


import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class NemeanhideFunction implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public NemeanhideFunction(Main plugin) {
		instance = plugin;
	}
	
	
	
	
	//Eventhandler
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(EntityDamageByEntityEvent event) {
		
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player victim = (Player) event.getEntity();
			Player attacker = (Player) event.getDamager();
			
			if (victim.getInventory().getLeggings() != null) {
				
				if (victim.getInventory().getLeggings().hasItemMeta() && victim.getInventory().getLeggings().getItemMeta().getLore() != null) {
					if (victim.getInventory().getLeggings().getItemMeta().getLore().contains("Earned by Heracles, it was impenetrable, at least by conventional weapons.")) {
					
							if (attacker.getItemInHand().getEnchantments() == null) {
								event.setCancelled(true);
							}
						
					} 
				} 	
				
			}

		}
						
	}
		
}
