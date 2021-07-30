package dev.kolind.permacraft.functions.bossmobs.mobs.hostile.uncommon;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.AttackStrategy;
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

public class Troll {

    boolean lookClose = true;
    boolean allowKnockback = true;
    boolean wander = true;
    boolean respawn = false;

    ItemStack heldItem = new ItemStack(Material.AIR, 1);

    int eyeRange = 3; //Blocks
    double reach = 5; //Blocks
    double attackRate = 6; //Seconds delay
    int damage = 10; //Half hearts
    int health = 35; //Half-hearts
    int regenSpeed = 0; //Idfk
    double attackMovementSpeed = 1; //Blocks pr. second
    float wanderMovementSpeed = 0.5F; //Blocks pr. second
    int wanderRange = 5; //Blocks //Max 25

    String npcRarity = ChatColor.BLUE + "" + ChatColor.BOLD + "UNCOMMON";
    String npcType = "Troll";
    String skinName = "haekthor";
    String skinSignature = "EWT+yn2bqMCJ/kzWPYl3pKxgXp1xPZwJ8ioUz5+YbUPKQlbkkTqXNbQqbxTejJMqfDWFiA94WOaHtmSilF9dl/Jv0WfkMZ3qxK4nB13zOmzrnlG89UI0+1gceoi/iCDxT8f5sU3/P+AW96ZOrysBn1hKtTGPr6XkjOrKlmAiATVXeLJZWFMFxdSErpuQJjUzlPNiB5/W3qAXaK2OYJda/AzR2woCzlbMU1wp26ehZXELVElTgC6nEF0M9pG3/xD2y5Yfi7HwaAP4MBIDXoeXzA6rajfMgJS5mL2dn9G+rsWlnPguq0uLe3hNKBtvivla7qz8v1WptwrW/63U5WEGGV3IJZFWEIJBr5zbOMyqoydpkSIoGCBXH73MpdzrOXMe/GQVLypfCXzEPQnh9ISXG90abFDxKBFh4qtrKMk+nV7kgOo/ZN6bBRdL22ZyRIIkpVnFb8+i7XW/PW3UyfWLg2vOOp84CpQsTCwikuJihQVO1CET0WhTi/crOJCCz00NjNEm5MM+TZjaBDaTt53slc6EyYjqpunjSr8Dxcjb46PcpDfkwrOkc1/xzxkq7WTKLbrDpxhVrkaWtFZD7KQiKVvp3owkSjnOE1LNTYL5xGTDF5nJ1dqEPL5qpLOosIhtGsnbPTp1b/OYHdLMfxrrNHroawoUp0+OLH1H/1rqWus=";
    String skinData = "ewogICJ0aW1lc3RhbXAiIDogMTYyNzY1NjU3ODc1MywKICAicHJvZmlsZUlkIiA6ICJiNzQ3OWJhZTI5YzQ0YjIzYmE1NjI4MzM3OGYwZTNjNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTeWxlZXgiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYzYTNkYjgwYjAxNjYxNGMwZjk1MDk2YmE3MGQ5ZGNhNzViMzIzMjhiMmU3ZDYyNDhiNjgyMmVlYWJlNDBkNyIKICAgIH0KICB9Cn0=";
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
