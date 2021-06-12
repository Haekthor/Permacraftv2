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

public class Ogre {

    boolean lookClose = true;
    boolean allowKnockback = false;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.AIR, 1);

    int eyeRange = 8; //Blocks
    double reach = 1.3; //Blocks
    double attackRate = 1.5; //Seconds delay
    int damage = 3; //Half hearts
    int health = 20; //Half-hearts
    int regenSpeed = 0; //Idfk
    int attackMovementSpeed = 1; //Blocks pr. second
    float wanderMovementSpeed = 0.7F; //Blocks pr. second
    int wanderRange = 10; //Blocks //Max 25

    String npcRarity = ChatColor.GRAY + "" + ChatColor.BOLD + "COMMON";
    String npcType = "Ogre";
    String skinName = "haekthor";
    String skinSignature = "V7cVFXhi5W9snly4LkxHyIuZK4gZNnDTffsXcx5j0s7cBzwsdoDoD6y+N9COLCo2cY7LyThacX9dhxINbpcQxVGnHPUtVU83j+8FVuw66fhhF7EoiGb5WBrmMvnXFIgowb3GIixE3ay/qo8n5uupKIHwZWJ3Yx5N2iSdYWVoK1wtOcQkZStHa32FkcayAn8ufhhCSvrovfwH7laMsG/hr+4lpjpTzvDpM5/gd+Z+W9Mfrxr4f+O/+nIoqeE/F/3H+kSu7x2KPdzDHIg93KWrQ14Rd59h6iTIuBP8kwRRQ1XPPzdASXwDQNafZoCZqZBA/QT1Uz/NqXWUDHWrYeTZKbgkliwH7WL6DYwty4ad1MHHJ5w5GWWr8yQChV5s/h/xxDr6y8eY7BBVESMUbtyU69z6FR/HmCwbsJQFgUVcFXYEGMWYYaSXMySNry4pGxlTenHInToR//xo8ye0zDDybJ+uoyGD4UGRx+enYGP3QxonxBm0gGPeIFKWB+59kahYkyJz033VmPRTaQg3kLr60tG0ljJqPsMDhmGNMNgAcFJe/EL77MLWyP5HPsx4HA+kC6uqRTwYRDWsSDJ8Rzi6ZvIArvmq3NvL4Ti236uN5ZCwX0SPFkBLkzrM9oeVSePAailgiNWg+263H/BruHPeHX8VI7ZN3LROHNQhi8zAh7k=";
    String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYwMzEzNTYzMTIxNSwKICAicHJvZmlsZUlkIiA6ICJmNjE1NzFmMjY1NzY0YWI5YmUxODcyMjZjMTEyYWEwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJGZWxpeF9NYW5nZW5zZW4iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmVmNmU2NmM3MzAzZWY3NDJkNThhMjhiOTQ1YjdkY2NlMmI3ZjgwZGQyODJlOTc2NWI2OTM0ZWU3NTdkZmZmNSIKICAgIH0KICB9Cn0=";
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
