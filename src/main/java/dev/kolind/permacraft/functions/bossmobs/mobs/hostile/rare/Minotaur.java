package dev.kolind.permacraft.functions.bossmobs.mobs.hostile.rare;

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

public class Minotaur {

    boolean lookClose = true;
    boolean allowKnockback = false;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.AIR, 1);

    int eyeRange = 14; //Blocks
    double reach = 4; //Blocks
    double attackRate = 4; //Seconds delay
    int damage = 10; //Half hearts
    int health = 100; //Half-hearts
    int regenSpeed = 0; //Idfk
    double attackMovementSpeed = 1; //Blocks pr. second
    float wanderMovementSpeed = 0.75F; //Blocks pr. second
    int wanderRange = 10; //Blocks //Max 25

    String npcRarity = ChatColor.GOLD + "" + ChatColor.BOLD + "Rare";
    String npcType = "Minotaur";
    String skinName = "haekthor";
    String skinSignature = "j/tq2Q+2hPDi1PI/kyRAXM5kaQ+Cn93EprcvDSvJzs1jDcUV0WEmmFE0hgMnU7RnAxv6+yJ8M+Hg72WNivHC4awYUvXj/dPEuOFFN4wwx2w+qQrz+JQsJ12BLfhAPK7zt2F1IL1kv4PMrJZ/rwhoSzwxyL7wNT2eyp20e2xQSCnwjVGdqzlXro4A+AhG2/N7Bk/GQmwVxFnazGqwff5C1RbA/CryfnrplfXPZZ1TQLrB5wA6cGxuf7IpGQ4mIjBfuuAa0VDPMmigb3ud50QUT7Z/pGdudxKutddLtFpXqaTLCJdAjjvBsA2bSrBoCXO3Rbfx+Xxo9l06VYA/Zs9zlumHZ6KMxHTehR69MSlle5M85DUPY9jz/tsMeM1FUZkVWS+TmNgkmaEX504lheBx+O25Qwq87g+kvKPTGrh6TAwm6wQ8AoVyrcA+Ka20f/AYSZv/cRtR/p1n5+3n2CFzrdJmAIVf01eBLBlbc3ZZKEibisH55Rl6LLdZ7P0wtpLY46WQUZr3vZMNTchd9QNrqyvV6WwCCkb2ZZE+ibOHbqPuZeAv8p3r26Zxhpt60xb6SdK8fk/s3G+1GE56XrygaPjvplsnH/abAuiUjlkhF0X5Paw6jCHeB6OGGrWxOpe1HA9ll18Qpe7woJbP6Slt+l9C+IiFLU0A2FfHi33WT6M=";
    String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTU5ODI5MjM3NTc3NCwKICAicHJvZmlsZUlkIiA6ICI3MmNiMDYyMWU1MTA0MDdjOWRlMDA1OTRmNjAxNTIyZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJNb3M5OTAiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2Y5MmQ4MTRiOTk3ZmI3YTY3NmZjOGNkMTVkZjIzYjdkNDg1ZDYxMTEwNjBiM2YxZGUzZGQxYjljZmE4MTExYyIKICAgIH0KICB9Cn0=";
    String targets = "players";

    public void summon (Location location) {


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
