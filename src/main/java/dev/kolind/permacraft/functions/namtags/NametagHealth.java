package dev.kolind.permacraft.functions.namtags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NametagHealth implements Listener {

    @EventHandler
    public void EntityDamage(EntityDamageEvent Event) {
        Entity entity = Event.getEntity();
        String EntityName = Event.getEntity().getCustomName();

        if (!(entity instanceof Player)) {
            if (EntityName.contains("Common") || EntityName.contains("Uncommon") || EntityName.contains("Rare") || EntityName.contains("Legendary")) {
                switch (EntityName){
                    case "Common":
                        entity.setCustomName("Common" + ChatColor.DARK_RED + "  ♥ " + ChatColor.RED + ((LivingEntity) entity).getHealth() + ChatColor.DARK_RED + "/" + ChatColor.RED + ((LivingEntity)entity).getMaxHealth());
                    case "Uncommon":
                        entity.setCustomName("Uncommon" + ChatColor.DARK_RED + "  ♥ " + ChatColor.RED + ((LivingEntity) entity).getHealth() + ChatColor.DARK_RED + "/" + ChatColor.RED + ((LivingEntity)entity).getMaxHealth());
                    case "Rare":
                        entity.setCustomName("Rare" + ChatColor.DARK_RED + "  ♥ " + ChatColor.RED + ((LivingEntity) entity).getHealth() + ChatColor.DARK_RED + "/" + ChatColor.RED + ((LivingEntity)entity).getMaxHealth());
                    case "Legendary":
                        entity.setCustomName("Legendary" + ChatColor.DARK_RED + "  ♥ " + ChatColor.RED + ((LivingEntity) entity).getHealth() + ChatColor.DARK_RED + "/" + ChatColor.RED + ((LivingEntity)entity).getMaxHealth());
                }
            }
        }
    }
}
