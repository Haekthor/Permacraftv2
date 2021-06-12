package dev.kolind.permacraft.functions.bossmobs.mobs.hostile.common;

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

public class Zombie {

    boolean lookClose = true;
    boolean allowKnockback = false;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.AIR, 1);

    int eyeRange = 8; //Blocks
    double reach = 1.3; //Blocks
    double attackRate = 1.5; //Seconds delay
    int damage = 2; //Half hearts
    int health = 10; //Half-hearts
    int regenSpeed = 0; //Idfk
    int attackMovementSpeed = 1; //Blocks pr. second
    float wanderMovementSpeed = 0.7F; //Blocks pr. second
    int wanderRange = 10; //Blocks //Max 25

    String npcRarity = ChatColor.GRAY + "" + ChatColor.BOLD + "COMMON";
    String npcType = "Zombie";
    String skinName = "haekthor";
    String skinSignature = "PYDq0LyuhZ6LpQN9hdjQhXz+YLrum3ggdypgZ4Et+dVC+ofzzb2N1V1iUtJ868nzONXFjEGlDbkEqwFtISJApkfhn/qVKwNwQYb82WDEWAu3vX9T3XTRMGIH/FuOhvQORWNClaxwlPhIiNcx0IASUTc0YjtkzscM389AEJ3b/gYVQPTOh2CGQfF4m2i2iTfb7z3sbiFB5xNqSUpfzlajTjCk4kziQ7IHNkCQj/OL8Pfeb3kW4rQ14Ik+IfqP5nzeflMWLd5GeEOfxXQ/BJZIVrDq3c0+K9lESAx2kCvpOFbBynYsEGDFztibVsHfS1femTbPwaujs+AYKiuqJi4pdtt695CPDdCZZnx+sAGl0ElSpwkZ2Si0b3ZCjEFDjj2uO2xfd82NQwbUM9CuWVK0bxY6xj9jscnxkSn9Eb17htacbImf7BXbRbCXxA9XPt2YYDdLPOUbc5ievLgDoIWiCj1gAm29Q1yUVk34UhOrqb6UsUmFpQCbh5fNmhsS+csQuDfLmC37HSw/JNoJkxuCRfsVIDkZ9q5J97KfkVKAChRPE0EE37zwabAorLuMkpyAGMFTw9dzD+pjxgvVpBdyhaGa3poqsy6zQTpgYPK/1bObds4WkhOvTG+sdTxZ+JByyrSwgfawi+UW5GC3KxikTzzX2ZOT7448WXY5BJpPdpg=";
    String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYxOTQ0ODAwMDIzOSwKICAicHJvZmlsZUlkIiA6ICIyMWUzNjdkNzI1Y2Y0ZTNiYjI2OTJjNGEzMDBhNGRlYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJHZXlzZXJNQyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lM2Y2Mzc0YWZiZWEzOGM3OTk4OTBlYjgzZDZmZjE4OTZmNjFiNGNjOGZiOWYyNjZhZGQ5YTM5NWViOWZkMTVlIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=";
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
