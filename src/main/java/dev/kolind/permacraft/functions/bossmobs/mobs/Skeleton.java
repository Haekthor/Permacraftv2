package dev.kolind.permacraft.functions.bossmobs.mobs;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.trait.Equipment;
import net.citizensnpcs.trait.LookClose;
import net.citizensnpcs.trait.SkinTrait;
import net.citizensnpcs.trait.waypoint.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.mcmonkey.sentinel.SentinelTrait;

public class Skeleton {

    boolean lookClose = true;
    boolean allowKnockback = true;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.BOW, 1);

    int eyeRange = 8; //Blocks
    double reach = 1.3; //Blocks
    double attackRate = 1.5; //Seconds delay
    int damage = 5; //Half hearts
    int health = 15; //Half-hearts
    int regenSpeed = 0; //Idfk
    int attackMovementSpeed = 2; //Blocks pr. second
    float wanderMovementSpeed = 0.8F; //Blocks pr. second
    int wanderRange = 10; //Blocks //Max 25

    String npcRarity = "UNCOMMON";
    String npcType = "Skeleton";
    String skinName = "haekthor";
    String skinSignature = "J6M+Ma6I/2tdDLL/yK+30K1gdMmrCFNNg7rJ20x0Vk/BFFe4rgjT4DkD6gQ3gAXpjshmPfaMdZnoO3jZzJQWqJVcJ/RX3z2ykhuOU0+HCukNE21PcrSTetZDZ9rVTpq1vPXFdvex6r/pSvrr385w3pVgt81Xq6vACowck45KhEKJnvgEWqkUjLdwNGt4oh5FPNUK3dOhL3kutbisTjR3g9SIqXlS53kligOaeVV8by/bclokH59kgdzKuTxE5111mz+pNHHcjN33y8db8Ec0bK3yzNtb9R83lmhEfR2NP7zlEtZXXYv7bH5SD6hbFzWuyPyBwbNbbLI9YSsCHPnBQNj4naFfjfpmprk3APy+S/GLDfvU6aH1FR7PT4g52hnnoCnLPB3u8ViCGlKmxJPUIt1yOBjA2Lc+jOc3bZ7jEnejB9OQEsgRObZi+uR+08pO5dVj30I3XT4+WurX2zIS4T8i4i/u5sukzZJDzpvjdsArsG4IqdAHRJUE+JliAz3x3w2VC/DAhQlRX+n/FH30nI/qJpgTe0GP+WRQHK71FnmtechPi0WHb50el3NlY+Bq5qxJnSO5k85bmpjpYL/r6tjr0Wlsdyb4YXBazS8XEd48ic2EK9JuxI16ODNqmqFpVm1vBm9PZsxlCbqiaJYrCHscJ3BDItuAaPMY4koCERY=";
    String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYxOTQ0MTMyODcyNSwKICAicHJvZmlsZUlkIiA6ICI2ZDk1OWZjY2UwY2E0NGZmOGQ0OWY0YTJhZTlmOGRlOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTa2VsZXRvbiIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iZjBmNTIzMDMyN2VlZmZiNzYzMWYzN2JlNTQ4YWQ3YmRiMzJjYTc0M2MwNjc5MWRjYjc3NDNiYjk2MTY2OTkxIgogICAgfQogIH0KfQ==";
    String targets = "players";

    public void summon(Location location) {

        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "");
        npc.spawn(location);

        //Get sentinel trait
        SentinelTrait sentinal = npc.getOrAddTrait(SentinelTrait.class);

        //Set players as targets
        sentinal.allTargets.targets.add(targets);

        //Set attack movement speed
        sentinal.speed = attackMovementSpeed;

        //Set wander movement speed
        npc.getNavigator().getDefaultParameters().speed(wanderMovementSpeed);

        //Set skin
        npc.getOrAddTrait(SkinTrait.class).setSkinPersistent(skinName, skinSignature, skinData);

        //Set attack rate
        //Delay in ticks
        sentinal.attackRate = (int) (attackRate * 20);

        //Set reach
        sentinal.reach = reach;

        //Set damage
        sentinal.damage = damage;

        //Set eyeRange
        sentinal.range = eyeRange;

        //Make lookclose
        npc.getOrAddTrait(LookClose.class).setRange(eyeRange);
        if (lookClose) {
            npc.getOrAddTrait(LookClose.class).toggle();
        }

        //Set held item
        npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.HAND, heldItem);

        //Set knockback
        sentinal.allowKnockback = allowKnockback;

        //Set regenarationspeed
        sentinal.healRate = regenSpeed;

        //Set health
        sentinal.setHealth(health);

        //Use new pathfinder
        wander(npc, wander);

        //Disable respawning
        if (!respawn) {
            sentinal.respawnTime = -1;
        }

        //Set metadata
        npc.data().setPersistent("type", npcType);
        npc.data().setPersistent("rarity", npcRarity);

        //Set npc name
        npc.setName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + npc.data().get("rarity") + ChatColor.DARK_GRAY + "] " + ChatColor.RED + npc.data().get("type") + " " + ChatColor.GREEN + ((LivingEntity) npc.getEntity()).getHealth() + ChatColor.GRAY + "/" + ChatColor.GREEN + sentinal.health);
    }

    public void wander(NPC npc, Boolean shouldWander) {
        if (shouldWander) {
            //Wander around
            npc.getNavigator().getDefaultParameters().range(wanderRange);
            //Stop teleporting
            npc.getNavigator().getDefaultParameters().stuckAction(null);
            npc.data().setPersistent(NPC.DISABLE_DEFAULT_STUCK_ACTION_METADATA, true);
            //Wander
            Waypoints waypoints = npc.getOrAddTrait(Waypoints.class);
            waypoints.setWaypointProvider("wander");
        } else {
            if (npc.hasTrait(Waypoints.class)) {
                npc.removeTrait(Waypoints.class);
            }
        }
    }



}
