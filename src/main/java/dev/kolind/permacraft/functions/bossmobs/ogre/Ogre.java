package dev.kolind.permacraft.functions.bossmobs.ogre;

import dev.kolind.permacraft.functions.customitems.CustomItems;
import dev.kolind.permacraft.gui.items.Bossmobitems;
import dev.kolind.permacraft.tools.CustomItemList;
import dev.kolind.permacraft.tools.ItemSmith;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.goals.WanderGoal;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.trait.Equipment;
import net.citizensnpcs.trait.SkinTrait;
import net.citizensnpcs.trait.waypoint.WanderWaypointProvider;
import net.citizensnpcs.trait.waypoint.Waypoints;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.mcmonkey.sentinel.SentinelTrait;

public class Ogre {

    CustomItems customItems = new CustomItems();

    public void summonOgre(Location location) {

        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Ogre");
        npc.spawn(location);

        //Get sentinel trait
        SentinelTrait sentinal = npc.getOrAddTrait(SentinelTrait.class);

        //Set players as targets
        sentinal.allTargets.targets.add("players");

        //Set attack movement speed
        sentinal.speed = 1;

        //Set wander movement speed
        npc.getNavigator().getDefaultParameters().speed(0.7F);

        //Set skin
        String skinSignature = "V7cVFXhi5W9snly4LkxHyIuZK4gZNnDTffsXcx5j0s7cBzwsdoDoD6y+N9COLCo2cY7LyThacX9dhxINbpcQxVGnHPUtVU83j+8FVuw66fhhF7EoiGb5WBrmMvnXFIgowb3GIixE3ay/qo8n5uupKIHwZWJ3Yx5N2iSdYWVoK1wtOcQkZStHa32FkcayAn8ufhhCSvrovfwH7laMsG/hr+4lpjpTzvDpM5/gd+Z+W9Mfrxr4f+O/+nIoqeE/F/3H+kSu7x2KPdzDHIg93KWrQ14Rd59h6iTIuBP8kwRRQ1XPPzdASXwDQNafZoCZqZBA/QT1Uz/NqXWUDHWrYeTZKbgkliwH7WL6DYwty4ad1MHHJ5w5GWWr8yQChV5s/h/xxDr6y8eY7BBVESMUbtyU69z6FR/HmCwbsJQFgUVcFXYEGMWYYaSXMySNry4pGxlTenHInToR//xo8ye0zDDybJ+uoyGD4UGRx+enYGP3QxonxBm0gGPeIFKWB+59kahYkyJz033VmPRTaQg3kLr60tG0ljJqPsMDhmGNMNgAcFJe/EL77MLWyP5HPsx4HA+kC6uqRTwYRDWsSDJ8Rzi6ZvIArvmq3NvL4Ti236uN5ZCwX0SPFkBLkzrM9oeVSePAailgiNWg+263H/BruHPeHX8VI7ZN3LROHNQhi8zAh7k=";
        String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYwMzEzNTYzMTIxNSwKICAicHJvZmlsZUlkIiA6ICJmNjE1NzFmMjY1NzY0YWI5YmUxODcyMjZjMTEyYWEwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJGZWxpeF9NYW5nZW5zZW4iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmVmNmU2NmM3MzAzZWY3NDJkNThhMjhiOTQ1YjdkY2NlMmI3ZjgwZGQyODJlOTc2NWI2OTM0ZWU3NTdkZmZmNSIKICAgIH0KICB9Cn0=";

        npc.getOrAddTrait(SkinTrait.class).setSkinPersistent("ogre", skinSignature, skinData);

        //Set attack rate
        sentinal.attackRate = (int) 0.3;

        //Set held item
        npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.HAND, customItems.randomzombiesword());

        //Set knockback
        sentinal.allowKnockback = false;

        //Use new pathfinder
        wander(npc);

    }

    public void wander(NPC npc) {
        //Wander around
        npc.getNavigator().getDefaultParameters().range(10);
        //Stop teleporting
        npc.getNavigator().getDefaultParameters().stuckAction(null);
        npc.data().setPersistent(NPC.DISABLE_DEFAULT_STUCK_ACTION_METADATA, true);
        //Wander
        Waypoints waypoints = npc.getOrAddTrait(Waypoints.class);
        waypoints.setWaypointProvider("wander");
    }

    public void stopWander(NPC npc) {
        //Wander around
        GoalController goalSelector = npc.getDefaultGoalController();

        goalSelector.clear();
    }



}
