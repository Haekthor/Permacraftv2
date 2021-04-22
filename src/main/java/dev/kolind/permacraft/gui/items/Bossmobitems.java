package dev.kolind.permacraft.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Bossmobitems {
	
	public static ItemSmith smithy = new ItemSmith();
	
	
	public static ItemStack backGround = new ItemStack(smithy.renItem(Material.GRAY_STAINED_GLASS_PANE, " ", null));
	public static ItemStack focusedBackGround = new ItemStack(smithy.renItem(Material.WHITE_STAINED_GLASS_PANE, " ", null));
	
	public static ItemStack Back = new ItemStack(smithy.renItem(Material.ARROW, "Main menu", "Go back to the main menu"));

	public static ItemStack Ghosts = new ItemStack(smithy.renItem(Material.SKELETON_SKULL, "Ghosts", "Access this funtions features"));
	public static ItemStack Enabled = new ItemStack(smithy.renItem(Material.RED_STAINED_GLASS_PANE, ChatColor.GREEN + "Enabled", " "));
	public static ItemStack Disabled = new ItemStack(smithy.renItem(Material.GREEN_STAINED_GLASS_PANE, ChatColor.RED + "Disabled", " "));
	
	
	//Ghostpage only
	public static ItemStack EnablePlayergear = new ItemStack(smithy.renItem(Material.NETHERITE_CHESTPLATE, ChatColor.YELLOW + "Player gear", "Enable this funtion"));
	public static ItemStack DisablePlayergear = new ItemStack(smithy.renItem(Material.NETHERITE_CHESTPLATE, ChatColor.YELLOW + "Player gear", "Disable this funtion"));
	
	public static ItemStack EnableSkeletonfire = new ItemStack(smithy.renItem(Material.SKELETON_SKULL, ChatColor.YELLOW + "Skeleton fire", "Enable this funtion"));
	public static ItemStack DisableSkeletonfire = new ItemStack(smithy.renItem(Material.SKELETON_SKULL, ChatColor.YELLOW + "Skeleton fire", "Disable this funtion"));
	
	public static ItemStack Enableghosts = new ItemStack(smithy.renItem(Material.ZOMBIE_HEAD, "Ghosts", "Enable this funtion"));
	public static ItemStack Disableghosts = new ItemStack(smithy.renItem(Material.ZOMBIE_HEAD, "Ghosts", "Disable this funtion"));
	
	
	//Deathban page only
	public static ItemStack Enabledeathban = new ItemStack(smithy.renItem(Material.BARRIER, "Deathban", "Enable this funtion"));
	public static ItemStack Disabledeathban = new ItemStack(smithy.renItem(Material.BARRIER, "Deathban", "Disable this funtion"));
	public static ItemStack Deathban = new ItemStack(smithy.renItem(Material.BARRIER, "Deathban", "Access this funtions features"));
	
	
	//Item page only
	public static ItemStack Enablenoitemdespawn = new ItemStack(smithy.renItem(Material.IRON_INGOT, "No item despawning", "Enable this funtion"));
	public static ItemStack Disablenoitemdespawn = new ItemStack(smithy.renItem(Material.IRON_INGOT, "No item despawning", "Disable this funtion"));
	public static ItemStack Items = new ItemStack(smithy.renItem(Material.IRON_INGOT, "Items", "Access this funtions features"));
	
	
	//Boss mobs
	public static ItemStack Bossmobs = new ItemStack(smithy.renItem(Material.ZOMBIE_HEAD, "Boss mobs", "Access this funtions features"));
	public static ItemStack Enablebossmobs = new ItemStack(smithy.renItem(Material.ZOMBIE_HEAD, "Boss mobs", "Enable this funtion"));
	public static ItemStack Disablebossmobs = new ItemStack(smithy.renItem(Material.ZOMBIE_HEAD, "Boss mobs", "Disable this funtion"));
	
	public static ItemStack Customitems = new ItemStack(smithy.renItem(Material.LEATHER_HELMET, "Custom Items", "See all custom items"));


}
