package dev.kolind.permacraft.tools;

import dev.kolind.permacraft.gui.items.Bossmobitems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomItemList {

	public static Inventory CustomItems = Bukkit.createInventory(null, 54, "Custom Items");
	static ItemSmith itemSmith = new ItemSmith();
	
	//The smithing taple
	
	@SuppressWarnings("deprecation")
	public static boolean openGUI(Player player) {
		
		ItemStack Zombiesword = new ItemStack(itemSmith.makeItem(Material.WOODEN_SWORD, "Zombie Sword", "Common", null, 1));
		Zombiesword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		
		ItemStack Ghostsword = new ItemStack(itemSmith.makeItem(Material.IRON_SWORD, "Ghost sword", "Common", null, 1));
		Ghostsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		Ghostsword.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Zombiehelmet = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Zombie Helmet", "Common", null, 1));
		Zombiehelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		
		ItemStack Ghosthelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Ghost Helmet", "Common", null, 1));
		Ghosthelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		Ghosthelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Zombiechestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Zombie Chestplate", "Common", null, 1));
		Zombiechestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		
		ItemStack Ghostchestplate = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_CHESTPLATE, "Ghost Chestplate", "Common", null, 1));
		Ghostchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		Ghostchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Zombieleggings = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Zombie Leggings", "Common", null, 1));
		Zombieleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		
		ItemStack Ghostleggings = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_LEGGINGS, "Ghost Leggings", "Common", null, 1));
		Ghostleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		Ghostleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Zombieboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Zombie Boots", "Common", null, 1));
		Zombieboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		
		ItemStack Ghostboots = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Ghost Boots", "Common", null, 1));
		Ghostboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		Ghostboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Wield = new ItemStack(itemSmith.makeItem(Material.DIAMOND_SWORD, "Wield Sword", ChatColor.DARK_PURPLE + "Rare", "Be careful! Its heavily used!", 1));
		Wield.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		Wield.setDurability((short) 500);
		
		ItemStack Ender = new ItemStack(itemSmith.makeItem(Material.DIAMOND_SWORD, "Ender", ChatColor.DARK_PURPLE + "Rare", null, 1));
		Ender.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		Ender.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		
		ItemStack Minershat = new ItemStack(itemSmith.makeItem(Material.GOLDEN_HELMET, "Miner's hat", ChatColor.DARK_PURPLE + "Rare", null, 1));
		Minershat.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
		
		ItemStack Brainer = new ItemStack(itemSmith.makeItem(Material.DIAMOND_HELMET, "Brain Helmet", ChatColor.DARK_PURPLE + "Rare", null, 1));
		Brainer.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Brainer.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Snowset = new ItemStack(itemSmith.makeItem(Material.DIAMOND_CHESTPLATE, "Snow Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
		Snowset.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		ItemStack Pyro = new ItemStack(itemSmith.makeItem(Material.GOLDEN_CHESTPLATE, "Pyroman's Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
		Pyro.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
		Pyro.setDurability((short) 100);
		
		ItemStack boltlegs = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Bolt Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
		boltlegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
		
		ItemStack Netherpants = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Nether Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
		Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
		Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		Netherpants.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Feathers = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Angel's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
		Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
		
		ItemStack Thorns = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Troll's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
		Thorns.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		Thorns.addUnsafeEnchantment(Enchantment.THORNS, 5);
		Thorns.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Undeadsword = new ItemStack(itemSmith.makeItem(Material.STONE_SWORD, "Undead Sword", ChatColor.BLUE + "Uncommon", "Be careful! Its heavily used!", 1));
		Undeadsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		Undeadsword.setDurability((short) 100);
		
		ItemStack Spear = new ItemStack(itemSmith.makeItem(Material.IRON_SWORD, "Spear of sparta", ChatColor.BLUE + "Uncommon", null, 1));
		Spear.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		Spear.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		ItemStack Undeadhelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Undead Helmet", ChatColor.BLUE + "Uncommon", null, 1));
		Undeadhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		
		ItemStack Spartanhelmet = new ItemStack(itemSmith.makeItem(Material.IRON_HELMET, "Spartan Helmet", ChatColor.BLUE + "Uncommon", null, 1));
		Spartanhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		Spartanhelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Undeadchestplate = new ItemStack(itemSmith.makeItem(Material.IRON_CHESTPLATE, "Undead Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
		Undeadchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		
		ItemStack Spartanchestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Spartan Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
		Spartanchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		Spartanchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Undeadleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Undead Leggings", ChatColor.BLUE + "Uncommon", null, 1));
		Undeadleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		
		ItemStack Spartanleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Spartan Leggings", ChatColor.BLUE + "Uncommon", null, 1));
		Spartanleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		Spartanleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Undeadboots = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Undead Boots", ChatColor.BLUE + "Uncommon", null, 1));
		Undeadboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		
		ItemStack Spartanboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Spartan Boots", ChatColor.BLUE + "Uncommon", null, 1));
		Spartanboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		Spartanboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		
		ItemStack Aegis = new ItemStack(itemSmith.makeItem(Material.NETHERITE_SWORD, "The Aegis", ChatColor.GOLD + "Legendary", "Zeus, Perseus, and especially Athena used the Aegis at one time or another.", 1));
		Aegis.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
		Aegis.setDurability((short) 500);
		//Swims faster
		
		
		ItemStack Cadaceus = new ItemStack(itemSmith.makeItem(Material.NETHERITE_SWORD, "The Cadaceus", ChatColor.GOLD + "Legendary", "The Cadaceus is a staff that is most often carried by Hermes.", 1));
		Cadaceus.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		Cadaceus.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		//Runs faster on grass
		
		ItemStack AdamantineHelmet = new ItemStack(itemSmith.makeItem(Material.NETHERITE_HELMET, "Adamantine Helmet", ChatColor.GOLD + "Legendary", "Perseus used an adamantine sword to decapitate the Gorgon Medusa.", 1));
		AdamantineHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		
		ItemStack Winged = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Winged Helmet", ChatColor.GOLD + "Legendary", "Winged helmet wore by Hermes.", 1));
		Winged.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		Winged.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		ItemStack NessusShirt = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Shirt of Nessus", ChatColor.GOLD + "Legendary", "Shirt poisoned with Nessus tainted/poisoned blood,\n used to poison and kill Heracles.", 1));
		NessusShirt.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		//bearer gets poison
		
		ItemStack AdamantineChestplate = new ItemStack(itemSmith.makeItem(Material.NETHERITE_CHESTPLATE, "Adamantine Chestplate", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology. ", 1));
		AdamantineChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		
		ItemStack AdamantineLeggings = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Leggings", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology.", 1));
		AdamantineLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		
		ItemStack NemeanHide = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Hide of the Nemean Lion", ChatColor.GOLD + "Legendary", "Earned by Heracles, it was impenetrable, at least by conventional weapons.", 1));
		NemeanHide.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		NemeanHide.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		ItemStack WingedSandals = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Winged Sandals", ChatColor.GOLD + "Legendary", "Winged Sandals wore by Hermes, allowing the god to fly.", 1));
		//Lets the bearer fly
		
		ItemStack AdamantineBoots = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Boots", ChatColor.GOLD + "Legendary", null, 1));
		AdamantineBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		
		
		ItemStack HeraclesBow = new ItemStack(itemSmith.makeItem(Material.BOW, "Heracles's Bow", ChatColor.GOLD + "Legendary", "Bow that belonged to the demi-god Heracles, with arrows tipped with the Hydra's poison.", 1));
		HeraclesBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 7);
		HeraclesBow.setDurability((short) 500);

		
		ItemStack Appolo = new ItemStack(itemSmith.makeItem(Material.BOW, "Bow of appolo", ChatColor.GOLD + "Legendary", "The Cadaceus is a staff that is most often carried by Hermes.", 1));
		Appolo.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10);
		Appolo.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		
		ItemStack Helmofdarkness = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Helm of Darkness", ChatColor.GOLD + "Legendary", "The Helmet of Darkness, also known as helmet or Cap of Invisibility, was a headgear created by the Cyclopes for Hades (Pluto).", 1));
		//TODO Test bearer invisible
		
		CustomItems.setItem(0, Bossmobitems.Back);
		CustomItems.setItem(1, Bossmobitems.backGround);
		CustomItems.setItem(2, Bossmobitems.backGround);
		CustomItems.setItem(3, Bossmobitems.backGround);
		CustomItems.setItem(4, Bossmobitems.backGround);
		CustomItems.setItem(5, Bossmobitems.backGround);
		CustomItems.setItem(6, Bossmobitems.backGround);
		CustomItems.setItem(7, Bossmobitems.backGround);
		CustomItems.setItem(8, Bossmobitems.backGround);
		//Next row
		CustomItems.setItem(9, Zombiesword);
		CustomItems.setItem(10, Ghostsword);
		CustomItems.setItem(11, Zombiehelmet);
		CustomItems.setItem(12, Ghosthelmet);
		CustomItems.setItem(13, Zombiechestplate);
		CustomItems.setItem(14, Ghostchestplate);
		CustomItems.setItem(15, Zombieleggings);
		CustomItems.setItem(16, Ghostleggings);
		CustomItems.setItem(17, Zombieboots);
		//Next row
		CustomItems.setItem(18, Ghostboots);
		CustomItems.setItem(19, Wield);
		CustomItems.setItem(20, Ender);
		CustomItems.setItem(21, Minershat);
		CustomItems.setItem(22, Brainer);
		CustomItems.setItem(23, Snowset);
		CustomItems.setItem(24, Pyro);
		CustomItems.setItem(25, boltlegs);
		CustomItems.setItem(26, Netherpants);
		//Next row
		CustomItems.setItem(27, Feathers);
		CustomItems.setItem(28, Thorns);
		CustomItems.setItem(29, Undeadsword);
		CustomItems.setItem(30, Spear);
		CustomItems.setItem(31, Undeadhelmet);
		CustomItems.setItem(32, Spartanhelmet);
		CustomItems.setItem(33, Undeadchestplate);
		CustomItems.setItem(34, Spartanchestplate);
		CustomItems.setItem(35, Undeadleggings);
		//Next row
		CustomItems.setItem(36, Spartanleggings);
		CustomItems.setItem(37, Undeadboots);
		CustomItems.setItem(38, Spartanboots);
		CustomItems.setItem(39, Aegis);
		CustomItems.setItem(40, Cadaceus);
		CustomItems.setItem(41, AdamantineHelmet);
		CustomItems.setItem(42, Winged);
		CustomItems.setItem(43, NessusShirt);
		CustomItems.setItem(44, AdamantineChestplate);
		//Next row
		CustomItems.setItem(45, AdamantineLeggings);
		CustomItems.setItem(46, NemeanHide);
		CustomItems.setItem(47, WingedSandals);
		CustomItems.setItem(48, AdamantineBoots);
		CustomItems.setItem(49, HeraclesBow);
		CustomItems.setItem(50, Appolo);
		CustomItems.setItem(51, Helmofdarkness);
		
		player.openInventory(CustomItems);
		
		
		return true;
		
	}
	
	
	
	
	
	//Weapons
}
