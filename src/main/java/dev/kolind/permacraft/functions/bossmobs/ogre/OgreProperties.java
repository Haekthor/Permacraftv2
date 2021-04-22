package dev.kolind.permacraft.functions.bossmobs.ogre;

import dev.kolind.permacraft.main.Main;
import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.goals.WanderGoal;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class OgreProperties extends Trait {

    Boolean isWandering = false;
    Boolean npcPushable = false;

    public OgreProperties() {
        super("ogreProperties");
        plugin = JavaPlugin.getPlugin(Main.class);
    }

    Main plugin = null;

    // Called every tick
    @Override
    public void run() {


        //citizens attack method

        if (npc.isSpawned()){
            Player target = getNewTarget(npc, 8);
            if (target != null) {
                if (isWandering) {
                    GoalController goalSelector = npc.getDefaultGoalController();
                    goalSelector.clear();
                }
                npc.getNavigator().setTarget(target, true);

                isWandering = false;
            } else {
                if (isWandering) {

                } else {
                    npc.getNavigator().cancelNavigation();
                    wander();
                }

            }
        }




    }

    //Run code when your trait is attached to a NPC.
    //This is called BEFORE onSpawn, so npc.getEntity() will return null
    //This would be a good place to load configurable defaults for new NPCs.
    @Override
    public void onAttach() {

        //Adds ogre skin
        String skinSignature = "V7cVFXhi5W9snly4LkxHyIuZK4gZNnDTffsXcx5j0s7cBzwsdoDoD6y+N9COLCo2cY7LyThacX9dhxINbpcQxVGnHPUtVU83j+8FVuw66fhhF7EoiGb5WBrmMvnXFIgowb3GIixE3ay/qo8n5uupKIHwZWJ3Yx5N2iSdYWVoK1wtOcQkZStHa32FkcayAn8ufhhCSvrovfwH7laMsG/hr+4lpjpTzvDpM5/gd+Z+W9Mfrxr4f+O/+nIoqeE/F/3H+kSu7x2KPdzDHIg93KWrQ14Rd59h6iTIuBP8kwRRQ1XPPzdASXwDQNafZoCZqZBA/QT1Uz/NqXWUDHWrYeTZKbgkliwH7WL6DYwty4ad1MHHJ5w5GWWr8yQChV5s/h/xxDr6y8eY7BBVESMUbtyU69z6FR/HmCwbsJQFgUVcFXYEGMWYYaSXMySNry4pGxlTenHInToR//xo8ye0zDDybJ+uoyGD4UGRx+enYGP3QxonxBm0gGPeIFKWB+59kahYkyJz033VmPRTaQg3kLr60tG0ljJqPsMDhmGNMNgAcFJe/EL77MLWyP5HPsx4HA+kC6uqRTwYRDWsSDJ8Rzi6ZvIArvmq3NvL4Ti236uN5ZCwX0SPFkBLkzrM9oeVSePAailgiNWg+263H/BruHPeHX8VI7ZN3LROHNQhi8zAh7k=";
        String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYwMzEzNTYzMTIxNSwKICAicHJvZmlsZUlkIiA6ICJmNjE1NzFmMjY1NzY0YWI5YmUxODcyMjZjMTEyYWEwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJGZWxpeF9NYW5nZW5zZW4iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmVmNmU2NmM3MzAzZWY3NDJkNThhMjhiOTQ1YjdkY2NlMmI3ZjgwZGQyODJlOTc2NWI2OTM0ZWU3NTdkZmZmNSIKICAgIH0KICB9Cn0=";

        npc.getOrAddTrait(SkinTrait.class).setSkinPersistent("ogre", skinSignature, skinData);

        //Make vulnerable to damage
        npc.setProtected(false);
        npc.data().setPersistent(NPC.DEFAULT_PROTECTED_METADATA, false);


        //Npc attack values
        npc.getNavigator().getDefaultParameters().useNewPathfinder(true);


        //TODO Make npc's "pushable"
        npc.data().setPersistent(NPC.COLLIDABLE_METADATA, true);
        npcPushable = true;


    }
    // Run code when the NPC is despawned. This is called before the entity actually despawns so npc.getEntity() is still valid.
    @Override
    public void onDespawn() {
    }

    //Run code when the NPC is spawned. Note that npc.getEntity() will be null until this method is called.
    //This is called AFTER onAttach and AFTER Load when the server is started.
    @Override
    public void onSpawn() {

        wander();

    }

    //run code when the NPC is removed. Use this to tear down any repeating tasks.
    @Override
    public void onRemove() {
    }

    public Player getNewTarget(NPC npc, double viewDistance) {

        Player player = null;
        double lastDistance = viewDistance;
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getLocation().distance(npc.getEntity().getLocation()) < lastDistance) {
                lastDistance = p.getLocation().distance(npc.getEntity().getLocation());
                player = p;
            }
        }
        if (player == null) {
            return null;
        } else {
            return player;
        }
    }


    public void wander() {
        //Wander around
        GoalController goalSelector = npc.getDefaultGoalController();
        WanderGoal wanderGoal = WanderGoal.createWithNPC(npc);

        goalSelector.addGoal(wanderGoal, 1);
        isWandering = true;
    }

    @EventHandler
    public void click(net.citizensnpcs.api.event.NPCPushEvent event){
        event.setCancelled(!npcPushable);
    }


}