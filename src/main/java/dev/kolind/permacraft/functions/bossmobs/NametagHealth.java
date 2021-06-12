package dev.kolind.permacraft.functions.bossmobs;

import dev.kolind.permacraft.main.Main;
import net.citizensnpcs.Citizens;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.CitizensNPC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.mcmonkey.sentinel.SentinelTrait;

import java.text.DecimalFormat;

public class NametagHealth implements Listener {

    Main instance;
    public NametagHealth(Main main) {
        instance = main;
    }

    @EventHandler
    public void entityDamageEvent(EntityDamageEvent event) {
        if (CitizensAPI.getNPCRegistry().isNPC(event.getEntity())) {
            Bukkit.getScheduler().runTaskLater(instance, () -> {
                NPC npc = CitizensAPI.getNPCRegistry().getNPC(event.getEntity());
                String maxHealth = new DecimalFormat("##").format(npc.getOrAddTrait(SentinelTrait.class).health);
                String currentHealth = new DecimalFormat("##").format(((LivingEntity) event.getEntity()).getHealth());
                npc.setName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + npc.data().get("rarity") + ChatColor.DARK_GRAY + "] " + ChatColor.RED + npc.data().get("type") + " " + ChatColor.GREEN + currentHealth + ChatColor.GRAY + "/" + ChatColor.GREEN + maxHealth);
            }, 5L);
        }
    }

}
