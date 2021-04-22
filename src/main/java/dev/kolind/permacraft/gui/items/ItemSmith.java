package dev.kolind.permacraft.gui.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemSmith {

	
	
	//The smithing taple
	
	public ItemStack makeItem(Material m, String name, String desc, String desc1, int amount) {
		
		ItemStack item = new ItemStack (m, amount);
		
		//Create the item's meta data (name, lore/desc text, etc.)
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		//Create the lore
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(desc);
		lore.add(desc1);
		im.setLore(lore);
		//Hide the vanilla Minecraft tooltip text
		//im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		//im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		//sets the items meta data to the custom "im" meta data
		item.setItemMeta(im);
		
		return item;
	}
	
	public ItemStack renItem(Material m, String name, String desc) {
		
		ItemStack item = new ItemStack (m);
		
		//Create the item's meta data (name, lore/desc text, etc.)
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(desc);
		im.setLore(lore);
		//sets the items meta data to the custom "im" meta data
		item.setItemMeta(im);
		
		return item;
	}
	
	
	
	
	
	//Weapons
}
