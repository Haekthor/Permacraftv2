package dev.kolind.permacraft.functions.chestloot;


import dev.kolind.permacraft.functions.customitems.CustomItems;
import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ChestLoot implements Listener {
	
	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public ChestLoot(Main plugin) {
		instance = plugin;
	}
	
	ItemSmith itemSmith = new ItemSmith();
	CustomItems randomItem = new CustomItems();
	
	//Eventhandler
	@EventHandler
    public void onGeneration(ChunkPopulateEvent e) {
        ItemStack item = randomItem.randomitem();
        BlockState[] tileEntities = e.getChunk().getTileEntities();

        for(BlockState state : tileEntities) {
        	if(state.getType() == Material.CHEST && new Random().nextBoolean()) {
                ((Chest) state.getBlock().getState()).getBlockInventory().addItem(item);
                ((BlockState) state.getBlock().getState()).update(true);
            }
        }
    }
}