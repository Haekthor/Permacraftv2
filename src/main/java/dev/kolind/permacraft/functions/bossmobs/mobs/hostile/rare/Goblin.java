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

public class Goblin {

    boolean lookClose = true;
    boolean allowKnockback = true;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.AIR, 1);

    int eyeRange = 14; //Blocks
    double reach = 2.5; //Blocks
    double attackRate = 0.2; //Seconds delay
    int damage = 1; //Half hearts
    int health = 10; //Half-hearts
    int regenSpeed = 0; //Idfk
    double attackMovementSpeed = 1.3; //Blocks pr. second
    float wanderMovementSpeed = 0.75F; //Blocks pr. second
    int wanderRange = 10; //Blocks //Max 25

    String npcRarity = ChatColor.GOLD + "" + ChatColor.BOLD + "Rare";
    String npcType = "Goblin";
    String skinName = "haekthor";
    String skinSignature = "i/SbVPflrkDA5JuLmV0Xg/sH43oJ35KXhlNk+2tv0iNlTtDaYAb0j2wn967pgOUyoGbPiyWyVk1ywkR6EWhjtNCJpttb0L0oV7lFDakqIz3pzVaWoT7zqdHu7Vzzcw4jx2YGgs+Qoz7djZrqOMMZnEkDVgDG7aS90A8WZAHiohYUS2ImQa1L4dhfvFFWf/oLQZ3vpR8k/5Jg/ziBZjSDLMIfg9mUxhZwnWk3vj5OlldxXLpdJoK6NINk4piJ/9Mak7FTurQ/2N+W1QTaUkb/dkm3eI2OTPUlnQgDU2pNcaPicKAIGYsoMKu0qimtAaOAY6LSjzoCrHsZx6tSYb1Aln7ptPzfurHdAchVp+hLTsGixbwFYOxhTgxgd+BqFvt6Ak9mH/PlS4DP54N1GhG5JKxzuXx5vQFElA9pNNYXpsrwbom/mej+XPHy2nS4g91T4i8pVbZ3sI7HW8ubFHknTQ7rQlYeWD86ie95IHaTn4KxzG+087WgKlGVlX7kiP091NyUZUrNGg4hjWIHlAZid5gOkpqB8oUGiH0nyBnChBYwPL5jFOwEfay4yGYBJx7o8vGhucOYLkaTIIIZPFjqYlv5mijj5tbpowJcOEts4xoCYev/g971X0CjS7DkS93ln2gCNkg5N3I3WYLjiKkVEzU63fl/Z85kbghmFkUXBMs=";
    String skinData = "ewogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJpZCIgOiAiOWY5YjdmMGUxZGQyNGJiNDlkOGRiYmVmZDZmOTJhNWEiLAogICAgICAidHlwZSIgOiAiU0tJTiIsCiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQ0ZTg3MWZiNzI4YTFiOWM3Zjc2MzQ2YmU1NmIzZjA4MDE4NTEzZjk3ODY2YzA2ZGI3NjNjNjY5YmM2NTQ4OCIsCiAgICAgICJwcm9maWxlSWQiIDogIjczODJkZGZiZTQ4NTQ1NWM4MjVmOTAwZjg4ZmQzMmY4IiwKICAgICAgInRleHR1cmVJZCIgOiAiZDQ0ZTg3MWZiNzI4YTFiOWM3Zjc2MzQ2YmU1NmIzZjA4MDE4NTEzZjk3ODY2YzA2ZGI3NjNjNjY5YmM2NTQ4OCIKICAgIH0KICB9LAogICJza2luIiA6IHsKICAgICJpZCIgOiAiOWY5YjdmMGUxZGQyNGJiNDlkOGRiYmVmZDZmOTJhNWEiLAogICAgInR5cGUiIDogIlNLSU4iLAogICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9kNDRlODcxZmI3MjhhMWI5YzdmNzYzNDZiZTU2YjNmMDgwMTg1MTNmOTc4NjZjMDZkYjc2M2M2NjliYzY1NDg4IiwKICAgICJwcm9maWxlSWQiIDogIjczODJkZGZiZTQ4NTQ1NWM4MjVmOTAwZjg4ZmQzMmY4IiwKICAgICJ0ZXh0dXJlSWQiIDogImQ0NGU4NzFmYjcyOGExYjljN2Y3NjM0NmJlNTZiM2YwODAxODUxM2Y5Nzg2NmMwNmRiNzYzYzY2OWJjNjU0ODgiCiAgfSwKICAiY2FwZSIgOiBudWxsCn0=";
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
