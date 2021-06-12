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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.mcmonkey.sentinel.SentinelTrait;

public class Oni {

    boolean lookClose = true;
    boolean allowKnockback = true;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.STICK, 1);

    int eyeRange = 14; //Blocks
    double reach = 3; //Blocks
    double attackRate = 1; //Seconds delay
    int damage = 5; //Half hearts
    int health = 60; //Half-hearts
    int regenSpeed = 0; //Idfk
    double attackMovementSpeed = 1.35; //Blocks pr. second
    float wanderMovementSpeed = 0.7F; //Blocks pr. second
    int wanderRange = 10; //Blocks //Max 25

    String npcRarity = ChatColor.BLUE + "" + ChatColor.BOLD + "UNCOMMON";
    String npcType = "Oni";
    String skinName = "haekthor";
    String skinSignature = "kAX0OLoY/FtEm5DgCU1z6boB28Db3QpsK1viaTBCLVc6pQfrqThNjIcpBegAxeBlS9aXExOMPqFF1bZ/gX47caYPxeGcZ7bjNr40nPONFV8LyLSEI82zs3KTGxGpb1ZpNPr4Hvmd+X8p8LjrFlc7uUgPRdbgRTZLg6+JZhFVwhWprZiimCmaLN3kf1StEidVCl4f2+xfUznCmW33bhtyviFFdmyQTXsNUFVBbrJh+f9VvBofH8cpAjGk8ss6fcwJF9TEqEdLOt0nGvcJXaamd0tXLu+sjaRwGajfkii9YbAyMB1PGvGV9VduvvXftfNR4rPl7j/9R+KfLo5V3OoZFZFRtATskrQT3Qf1Tr7HQWcyZZBC/wxQzTV0riahNRB2rIwHF5hJFtGLqaZzkWXnz7m+c7ytk7RuHFXVFkIFBszt014qiDHh+skVKTjeHbJz8P+ktNkl6F3KoXR6Gyjr3Ibnv3ChGuggLEyv5GmE9hoYfx0CWrHop3l5kZRU0ybsyBvqS0xvs7ztCfRpQnLNz4dcZaLotO9EYhigOArAMQ8HddE7Vpz+A+Zv9Rvm5qL6r7UDH8wX+VnwIzfm9/9WEoL4VzMV3u9x58rSDhOPVJGL4fZSh3X8ebHPFgA//YO8lP4LQEcQHPiOCtiF0boId3CjDaI49c2UekwHPljj1ok=";
    String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYyMDQ4OTY5NTQ5MSwKICAicHJvZmlsZUlkIiA6ICI2MWVhMDkyM2FhNDQ0OTEwYmNlZjViZmQ2ZDNjMGQ1NyIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVEYXJ0aEZhdGhlciIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9kMTJkOWU0ODMzMjgwMGZlNjVlYjU3MzRhYmY0N2Q5NTc0MTIyNTc2NWIxOGE0YjVmZjY2Y2Y2YzYxYjU2MWQ1IgogICAgfQogIH0KfQ==";
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
        heldItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
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
