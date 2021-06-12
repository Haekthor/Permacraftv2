package dev.kolind.permacraft.functions.bossmobs.mobs.hostile.uncommon;

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

public class Cyclops {

    boolean lookClose = true;
    boolean allowKnockback = true;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.AIR, 1);

    int eyeRange = 14; //Blocks
    double reach = 4; //Blocks
    double attackRate = 5; //Seconds delay
    int damage = 15; //Half hearts
    int health = 120; //Half-hearts
    int regenSpeed = 0; //Idfk
    double attackMovementSpeed = 1; //Blocks pr. second
    float wanderMovementSpeed = 0.75F; //Blocks pr. second
    int wanderRange = 10; //Blocks //Max 25

    String npcRarity = ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY";
    String npcType = "Cyclops";
    String skinName = "haekthor";
    String skinSignature = "lVKutGlBAp3iILdMWAPEL2u4SF7KDZxgVnSIAIcinHCabg35maNzeCilmhAIYUSmePAHXdm3NsDAF/Dy27BGa/OEvJJ0m3qoxDu2Pj54DkkCcvy7PzgjP0A5eeym1Xcb+U3hZOBs+pFJUxJAIsVtJB4amN+zBBl93y2LBu8xTYopQa9Q1OlHWwHnUFC/Gw6IEqqfB6JReM5WsZdS3N8JnB2FvoiF++zOwO7mvqBgSlPATGpfVgYwYVbaUuwzUa7MHpg+UEPpxQiTkMBPNXDQm3mASOssstCxxzhvAaNcfRUpL2lIs2rH3JPOVn2uoqvK598v+Qfzm/OkvL00/8kiA0p/LM9Py1M2ZrkXjyjfnXsulcFmZoVHY3C+eWZnfUpGbgkq2+ddlbDlT2oPcSDweXtsfkTrusvGZHlXpqPkeBbctzNuGTHSPik8JCXC7s+xYoOEMxCo2O405FCtWwUXzAdVx3Kj9T2mwPEs8znnSP09XMhgX1vzC2ULKQao5BOmuE5dYEKWvCGBq9aAwUgUBe6kJI8EufGQ6yAxWa7oQ/kcau3h4OWiWfZlRgWoVg5hCIuwSyehNHS6ru+bghZ2jyWPUeP6MgGn4zs5zxfdSJecJ14uEUWWjROHxIp6hdtqbYW+wF2o3zoUn7YbM3eGoRvlv5iw53KqShI4AFsK5Q8=";
    String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYyMzUxNTU3MzAwNSwKICAicHJvZmlsZUlkIiA6ICJmYzUwMjkzYTVkMGI0NzViYWYwNDJhNzIwMWJhMzBkMiIsCiAgInByb2ZpbGVOYW1lIiA6ICJDVUNGTDE3IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzc5YmZhODU5OGY5OWJjNTJiYTYzZTJhMjMyZDJiZTU0NzU5NWM0N2I5NTJhMGI4YzYwOWEzMmU2ZWY0MjI5OTgiCiAgICB9CiAgfQp9";
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
        npc.getOrAddTrait(LookClose.class).setRange(8);
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
