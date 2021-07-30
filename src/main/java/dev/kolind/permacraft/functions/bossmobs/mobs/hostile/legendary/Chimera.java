package dev.kolind.permacraft.functions.bossmobs.mobs.hostile.legendary;

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

public class Chimera {

    boolean lookClose = true;
    boolean allowKnockback = true;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.STICK, 1);

    int eyeRange = 14; //Blocks
    double reach = 4; //Blocks
    double attackRate = 1.5; //Seconds delay
    int damage = 15; //Half hearts
    int health = 470; //Half-hearts
    int regenSpeed = 0; //Idfk
    double attackMovementSpeed = 1.2; //Blocks pr. second
    float wanderMovementSpeed = 0.75F; //Blocks pr. second
    int wanderRange = 10; //Blocks //Max 25

    String npcRarity = ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY";
    String npcType = "Chimera";
    String skinName = "haekthor";
    String skinSignature = "ANS9JjXz8Fi0UCDhHywDd9R0CFkJ//Lry1RhVOq55lRwW0qhZqC50Rchpofbj/obtpkXGo78DJzciqWPbt1f7meNd/oCqiq1gGQAZ7T9pKdL/ZDOiQ3gEVBOvS2XY2iXaZ3fk31N0CfgfJ2E0ODRbOVg7RREKazIX7v65m7aB316GKJ9YrjCAfoW/Sic0I+mY+bkRTenf8edhLex1dPp34QDItNC5wiylh8bhkJ+lwFV6kZE/cVInMdZYBUTaBo99JkP4101uB9BevFarBdqfgGuRSaOhOrfXRZ3y5V5UFxHDBsDvYG6/db/jtSuPMa1J3yEO0DsFOSTR4DImbxQUlA+KJy4BfBaX34OL4m44L+af4X/gdmkKfx7YXsoCo32mwrCnt977TaeV5DncfC7tTzoN9JodLl0AOF5ZqJRFcceYGHm6NUucL/S6bvw/Tsq8zLwiTwWklt4H/Mdv+6FLxz45KrSXaDwmbKUK1UlxmOLbHyNAkaiJl/PLgajCQpo5hCfcjwIlhGFghHlfWLLGaNHB6T7ABcuMZDkb6KFjfKLVw6wpG/2s3z8tAt0jvJml6bJxMazn7zgFqIPUxtYDY1y0uW/GjQ5RMYdoeoehZAbHNRXxA1hqTP8d8V24zRX0u+R/WFAzhnuns94QImMnq+kC5BwP2oMP+lddps0sV8=";
    String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYxOTIyMjMwMDg5NSwKICAicHJvZmlsZUlkIiA6ICJmMjc0YzRkNjI1MDQ0ZTQxOGVmYmYwNmM3NWIyMDIxMyIsCiAgInByb2ZpbGVOYW1lIiA6ICJIeXBpZ3NlbCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS80MDc4NWJjN2IzZjYxN2ZmNWY5ZDQ4MjgwMmQ3MzQ1ZjAzNTNiZDUxYWQxY2EwNjYzYzEzM2JlMGI1YTI5MjExIgogICAgfQogIH0KfQ==";
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
        heldItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
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
