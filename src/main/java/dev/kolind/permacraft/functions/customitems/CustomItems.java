package dev.kolind.permacraft.functions.customitems;

import dev.kolind.permacraft.tools.ItemSmith;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class CustomItems {

	//TODO rewrite this huge fkn mess
	//I will do it later, for now, PAaAAAAaaaAarrerrrtatatyatatatayAYYYYY

	ItemSmith itemSmith = new ItemSmith();
	//The smithing taple
	
	@SuppressWarnings("deprecation")
	public ItemStack randomzombiesword() {
		
		Random rand = new Random();
		int procent = rand.nextInt(101);
		int seed = rand.nextInt(101);
		ItemStack air = new ItemStack(Material.AIR);

			
			//Common
			if (procent <= 1) {
				//Item in hand
				ItemStack Zombiesword = new ItemStack(itemSmith.makeItem(Material.WOODEN_SWORD, "Zombie Sword", "Common", null, 1));
				Zombiesword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
				
				ItemStack Ghostsword = new ItemStack(itemSmith.makeItem(Material.IRON_SWORD, "Ghost sword", "Common", null, 1));
				Ghostsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
				Ghostsword.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Zombiesword;
				} else if (seed >= 40) {
					return Ghostsword;
				} else {

				}
				
				
				
				
				
				
			} else if (procent <= 75 && procent >= 50) { //**RARE**
				//Rare
				

				//Item in hand
				ItemStack Wield = new ItemStack(itemSmith.makeItem(Material.DIAMOND_SWORD, "Wield Sword", ChatColor.DARK_PURPLE + "Rare", "Be careful! Its heavily used!", 1));
				Wield.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				Wield.setDurability((short) 500);
				
				ItemStack Ender = new ItemStack(itemSmith.makeItem(Material.DIAMOND_SWORD, "Ender", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Ender.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				Ender.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
				
				if (seed <= 40) {
					return Wield;
				} else if (seed >= 40) {
					return Ender;
				} else {
					
				}
				
				
				

				
				
				
			} else if (procent <= 50 && procent >= 1) { //UNCOMMON
				

				//Item in hand
				ItemStack Undeadsword = new ItemStack(itemSmith.makeItem(Material.STONE_SWORD, "Undead Sword", ChatColor.BLUE + "Uncommon", "Be careful! Its heavily used!", 1));
				Undeadsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
				Undeadsword.setDurability((short) 100);
				
				ItemStack Spear = new ItemStack(itemSmith.makeItem(Material.IRON_SWORD, "Spear of sparta", ChatColor.BLUE + "Uncommon", null, 1));
				Spear.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
				Spear.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				
				if (seed <= 40) {
					return Undeadsword;
				} else if (seed >= 40) {
					return Spear;
				} else {
					
				}
				
				
				

				
				
			} else if (procent <= 80 && procent >= 75) { //**LEGENDARY**
				//Legendary

				
				//Item in hand
				ItemStack Aegis = new ItemStack(itemSmith.makeItem(Material.NETHERITE_SWORD, "The Aegis", ChatColor.GOLD + "Legendary", "Zeus, Perseus, and especially Athena used the Aegis at one time or another.", 1));
				Aegis.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
				Aegis.setDurability((short) 500);
				//Swims faster
				
				
				ItemStack Cadaceus = new ItemStack(itemSmith.makeItem(Material.NETHERITE_SWORD, "The Cadaceus", ChatColor.GOLD + "Legendary", "The Cadaceus is a staff that is most often carried by Hermes.", 1));
				Cadaceus.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
				Cadaceus.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				//Runs faster on grass
				
				if (seed <= 40) {
					return Aegis;
				} else if (seed >= 40) {
					return Cadaceus;
				} else {
					
				}
				
				
				
				
				
			} else if (procent <= 100 && procent >= 80) {
				
				return air;
			}
			
		
		return air;

	}
	
	@SuppressWarnings("deprecation")
	public ItemStack randomhelmet() {
		
		Random rand = new Random();
		int procent = rand.nextInt(101);
		int seed = rand.nextInt(101);
		ItemStack air = new ItemStack(Material.AIR);

			
			//Common
			if (procent <= 1) {

				
				
				//Helmet
				ItemStack Zombiehelmet = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Zombie Helmet", "Common", null, 1));
				Zombiehelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Ghosthelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Ghost Helmet", "Common", null, 1));
				Ghosthelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Ghosthelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Zombiehelmet;
				} else if (seed >= 40) {
					return Ghosthelmet;
				} else {
					
				}

				
				
			} else if (procent <= 75 && procent >= 50) { //**RARE**
				//Rare
				

				//Helmet
				ItemStack Minershat = new ItemStack(itemSmith.makeItem(Material.LEGACY_GOLD_HELMET, "Miner's hat", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Minershat.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
				
				ItemStack Brainer = new ItemStack(itemSmith.makeItem(Material.DIAMOND_HELMET, "Brain Helmet", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Brainer.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				Brainer.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Minershat;
				} else if (seed >= 40) {
					return Brainer;
				} else {
					
				}

				
				
				
				
			} else if (procent <= 50 && procent >= 1) { //UNCOMMON
				

				
				
				
				//Helmet
				ItemStack Undeadhelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Undead Helmet", ChatColor.BLUE + "Uncommon", null, 1));
				Undeadhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Spartanhelmet = new ItemStack(itemSmith.makeItem(Material.IRON_HELMET, "Spartan Helmet", ChatColor.BLUE + "Uncommon", null, 1));
				Spartanhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Spartanhelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Undeadhelmet;
				} else if (seed >= 40) {
					return Spartanhelmet;
				} else {
					
				}

				
				
			} else if (procent <= 80 && procent >= 75) { //**LEGENDARY**
				//Legendary


				//Helmet
				ItemStack AdamantineHelmet = new ItemStack(itemSmith.makeItem(Material.NETHERITE_HELMET, "Adamantine Helmet", ChatColor.GOLD + "Legendary", "Perseus used an adamantine sword to decapitate the Gorgon Medusa.", 1));
				AdamantineHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				
				ItemStack Winged = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Winged Helmet", ChatColor.GOLD + "Legendary", "Winged helmet wore by Hermes.", 1));
				Winged.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				Winged.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				//Enables fly
				
				if (seed <= 40) {
					return AdamantineHelmet;
				} else if (seed >= 40) {
					return Winged;
				} else {
					
				}
				
				
				
				
			} else if (procent <= 100 && procent >= 80) {
				
				return air;
			}
			
		
		return air;

	}
	
	@SuppressWarnings("deprecation")
	public ItemStack randomchestplate() {
		
		Random rand = new Random();
		int procent = rand.nextInt(101);
		int seed = rand.nextInt(101);
		ItemStack air = new ItemStack(Material.AIR);

			
			//Common
			if (procent <= 1) {

				
				
				
				//Chestplate
				ItemStack Zombiechestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Zombie Chestplate", "Common", null, 1));
				Zombiechestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Ghostchestplate = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_CHESTPLATE, "Ghost Chestplate", "Common", null, 1));
				Ghostchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Ghostchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Zombiechestplate;
				} else if (seed >= 40) {
					return Ghostchestplate;
				} else {
					
				}

				
				
			} else if (procent <= 75 && procent >= 50) { //**RARE**
				//Rare

				
				
				
				//Chestplate
				ItemStack Snowset = new ItemStack(itemSmith.makeItem(Material.DIAMOND_CHESTPLATE, "Snow Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Snowset.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				
				ItemStack Pyro = new ItemStack(itemSmith.makeItem(Material.LEGACY_GOLD_CHESTPLATE, "Pyroman's Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Pyro.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
				Pyro.setDurability((short) 100); 
				
				if (seed <= 40) {
					return Snowset;
				} else if (seed >= 40) {
					return Pyro;
				} else {
					
				}
				
				
				
			} else if (procent <= 50 && procent >= 1) { //UNCOMMON
				
				
				//Chestplate
				ItemStack Undeadchestplate = new ItemStack(itemSmith.makeItem(Material.IRON_CHESTPLATE, "Undead Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
				Undeadchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Spartanchestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Spartan Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
				Spartanchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Spartanchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Undeadchestplate;
				} else if (seed >= 40) {
					return Spartanchestplate;
				} else {
					
				}
				
				
			} else if (procent <= 80 && procent >= 75) { //**LEGENDARY**
				//Legendary
				
				
				
				//Chestplate
				ItemStack NessusShirt = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Shirt of Nessus", ChatColor.GOLD + "Legendary", "Shirt poisoned with Nessus tainted/poisoned blood,\n used to poison and kill Heracles.", 1));
				NessusShirt.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				//bearer gets poison
				
				ItemStack AdamantineChestplate = new ItemStack(itemSmith.makeItem(Material.NETHERITE_CHESTPLATE, "Adamantine Chestplate", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology. ", 1));
				AdamantineChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				
				if (seed <= 40) {
					return NessusShirt;
				} else if (seed >= 40) {
					return AdamantineChestplate;
				} else {
					return air;
				}
					
				
			} else if (procent <= 100 && procent >= 80) {
				
				return air;
			}
			
		
		return air;

	}
	
	
	public ItemStack randomleggings() {
		
		Random rand = new Random();
		int procent = rand.nextInt(101);
		int seed = rand.nextInt(101);
		ItemStack air = new ItemStack(Material.AIR);

			
			//Common
			if (procent <= 1) {

					
					
				//Leggings
				ItemStack Zombieleggings = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Zombie Leggings", "Common", null, 1));
				Zombieleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Ghostleggings = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_LEGGINGS, "Ghost Leggings", "Common", null, 1));
				Ghostleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Ghostleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Zombieleggings;
				} else if (seed >= 40) {
					return Ghostleggings;
				} else {
					
				}

				
				
			} else if (procent <= 75 && procent >= 50) { //**RARE**
				//Rare
					
					
				//Leggings
				ItemStack boltlegs = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Bolt Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
				boltlegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
				
				ItemStack Netherpants = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Nether Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
				Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				Netherpants.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return boltlegs;
				} else if (seed >= 40) {
					return Netherpants;
				} else {
					
				}
				
				
				
			} else if (procent <= 50 && procent >= 1) { //UNCOMMON

	
				//Leggings
				ItemStack Undeadleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Undead Leggings", ChatColor.BLUE + "Uncommon", null, 1));
				Undeadleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Spartanleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Spartan Leggings", ChatColor.BLUE + "Uncommon", null, 1));
				Spartanleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Spartanleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Undeadleggings;
				} else if (seed >= 40) {
					return Spartanleggings;
				} else {
					
				}
					
				
				
			} else if (procent <= 80 && procent >= 75) { //**LEGENDARY**
				//Legendary
					
					
				//Leggings
				ItemStack AdamantineLeggings = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Leggings", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology.", 1));
				AdamantineLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				
				ItemStack NemeanHide = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Hide of the Nemean Lion", ChatColor.GOLD + "Legendary", "Earned by Heracles, it was impenetrable, at least by conventional weapons.", 1));
				NemeanHide.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				NemeanHide.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				//TODO TEST Bearer only takes damage to enchated weapons.
				
				if (seed <= 40) {
					return AdamantineLeggings;
				} else if (seed >= 40) {
					return NemeanHide;
				} else {
					
				}
					
					
				
				
			} else if (procent <= 100 && procent >= 80) {
				
				return air;
			}
			
		
		return air;

	}
	
	public ItemStack randomboots() {
		
		Random rand = new Random();
		int procent = rand.nextInt(101);
		int seed = rand.nextInt(101);
		ItemStack air = new ItemStack(Material.AIR);

			
			//Common
			if (procent <= 1) {

					
					
				//Boots
				ItemStack Zombieboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Zombie Boots", "Common", null, 1));
				Zombieboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Ghostboots = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Ghost Boots", "Common", null, 1));
				Ghostboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Ghostboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Zombieboots;
				} else if (seed >= 40) {
					return Ghostboots;
				} else {
					
				}
				
				
			} else if (procent <= 75 && procent >= 50) { //**RARE**
				//Rare
					
					
				//Boots
				ItemStack Feathers = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Angel's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
				
				ItemStack Thorns = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Troll's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Thorns.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				Thorns.addUnsafeEnchantment(Enchantment.THORNS, 5);
				Thorns.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Feathers;
				} else if (seed >= 40) {
					return Thorns;
				} else {
					
				}
				
				
				
			} else if (procent <= 50 && procent >= 1) { //UNCOMMON
				

					
					
				//Boots
				ItemStack Undeadboots = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Undead Boots", ChatColor.BLUE + "Uncommon", null, 1));
				Undeadboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Spartanboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Spartan Boots", ChatColor.BLUE + "Uncommon", null, 1));
				Spartanboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Spartanboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 40) {
					return Undeadboots;
				} else if (seed >= 40) {
					return Spartanboots;
				} else {
					
				}
				
				
			} else if (procent <= 80 && procent >= 75) { //**LEGENDARY**
				//Legendary

					
				//Boots
				ItemStack WingedSandals = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Winged Sandals", ChatColor.GOLD + "Legendary", "Winged Sandals wore by Hermes, allowing the god to fly.", 1));
				//Lets the bearer fly
				
				ItemStack AdamantineBoots = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Boots", ChatColor.GOLD + "Legendary", null, 1));
				AdamantineBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				
				if (seed <= 40) {
					return WingedSandals;
				} else if (seed >= 40) {
					return AdamantineBoots;
				} else {
					return air;
				}
				
				
				
			} else if (procent <= 100 && procent >= 80) {
				
				return air;
			}
			
		
		return air;

	}
	
	@SuppressWarnings("deprecation")
	public ItemStack randomitem() {
		
		Random rand = new Random();
		int procent = rand.nextInt(101);
		int seed = rand.nextInt(101);
		ItemStack air = new ItemStack(Material.AIR);

			
			//Common
			if (procent <= 1) {
				//Item in hand
				ItemStack Zombiesword = new ItemStack(itemSmith.makeItem(Material.WOODEN_SWORD, "Zombie Sword", "Common", null, 1));
				Zombiesword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
				
				ItemStack Ghostsword = new ItemStack(itemSmith.makeItem(Material.IRON_SWORD, "Ghost sword", "Common", null, 1));
				Ghostsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
				Ghostsword.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				

	
				//Helmet
				ItemStack Zombiehelmet = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Zombie Helmet", "Common", null, 1));
				Zombiehelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Ghosthelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Ghost Helmet", "Common", null, 1));
				Ghosthelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Ghosthelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
					
				
				//Chestplate
				ItemStack Zombiechestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Zombie Chestplate", "Common", null, 1));
				Zombiechestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Ghostchestplate = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_CHESTPLATE, "Ghost Chestplate", "Common", null, 1));
				Ghostchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Ghostchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
					
					
				//Leggings
				ItemStack Zombieleggings = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Zombie Leggings", "Common", null, 1));
				Zombieleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Ghostleggings = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_LEGGINGS, "Ghost Leggings", "Common", null, 1));
				Ghostleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Ghostleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
					
					
				//Boots
				ItemStack Zombieboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Zombie Boots", "Common", null, 1));
				Zombieboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Ghostboots = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Ghost Boots", "Common", null, 1));
				Ghostboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Ghostboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 10) {
					return Zombiesword;
				} else if (seed <= 20 && seed >= 10) {
					return Ghostsword;
				} else if (seed <= 30 && seed >= 20) {
					return Zombiehelmet;
				} else if (seed <= 40 && seed >= 30) {
					return Zombiechestplate;
				} else if (seed <= 50 && seed >= 40) {
					return Ghostchestplate;
				} else if (seed <= 60 && seed >= 50) {
					return Zombieleggings;
				} else if (seed <= 70 && seed >= 60) {
					return Ghostleggings;
				} else if (seed <= 80 && seed >= 70) {
					return Zombieboots;
				} else if (seed <= 90 && seed >= 80) {
					return Ghostboots;
				} else if (seed <= 100 && seed >= 90) {
					return Ghosthelmet;
				} 
				
				
			} else if (procent <= 75 && procent >= 50) { //**RARE**
				//Rare
				

				//Item in hand
				ItemStack Wield = new ItemStack(itemSmith.makeItem(Material.DIAMOND_SWORD, "Wield Sword", ChatColor.DARK_PURPLE + "Rare", "Be careful! Its heavily used!", 1));
				Wield.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				Wield.setDurability((short) 500);
				
				ItemStack Ender = new ItemStack(itemSmith.makeItem(Material.DIAMOND_SWORD, "Ender", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Ender.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				Ender.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
				
				
				
				
				//Helmet
				ItemStack Minershat = new ItemStack(itemSmith.makeItem(Material.LEGACY_GOLD_HELMET, "Miner's hat", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Minershat.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
				
				ItemStack Brainer = new ItemStack(itemSmith.makeItem(Material.DIAMOND_HELMET, "Brain Helmet", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Brainer.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				Brainer.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				
				
				
				//Chestplate
				ItemStack Snowset = new ItemStack(itemSmith.makeItem(Material.DIAMOND_CHESTPLATE, "Snow Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Snowset.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				
				ItemStack Pyro = new ItemStack(itemSmith.makeItem(Material.LEGACY_GOLD_CHESTPLATE, "Pyroman's Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Pyro.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
				Pyro.setDurability((short) 100); 
				
					
					
				//Leggings
				ItemStack boltlegs = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Bolt Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
				boltlegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
				
				ItemStack Netherpants = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Nether Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
				Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				Netherpants.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
					
					
				//Boots
				ItemStack Feathers = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Angel's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
				
				ItemStack Thorns = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Troll's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
				Thorns.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				Thorns.addUnsafeEnchantment(Enchantment.THORNS, 5);
				Thorns.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 10) {
					return Wield;
				} else if (seed <= 20 && seed >= 10) {
					return Ender;
				} else if (seed <= 30 && seed >= 20) {
					return Minershat;
				} else if (seed <= 40 && seed >= 30) {
					return Brainer;
				} else if (seed <= 50 && seed >= 40) {
					return Snowset;
				} else if (seed <= 60 && seed >= 50) {
					return Pyro;
				} else if (seed <= 70 && seed >= 60) {
					return boltlegs;
				} else if (seed <= 80 && seed >= 70) {
					return Netherpants;
				} else if (seed <= 90 && seed >= 80) {
					return Feathers;
				} else if (seed <= 100 && seed >= 90) {
					return Thorns;
				} 
				
				
				
			} else if (procent <= 50 && procent >= 1) { //UNCOMMON
				

				//Item in hand
				ItemStack Undeadsword = new ItemStack(itemSmith.makeItem(Material.STONE_SWORD, "Undead Sword", ChatColor.BLUE + "Uncommon", "Be careful! Its heavily used!", 1));
				Undeadsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
				Undeadsword.setDurability((short) 100);
				
				ItemStack Spear = new ItemStack(itemSmith.makeItem(Material.IRON_SWORD, "Spear of sparta", ChatColor.BLUE + "Uncommon", null, 1));
				Spear.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
				Spear.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				
				
				
				
				//Helmet
				ItemStack Undeadhelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Undead Helmet", ChatColor.BLUE + "Uncommon", null, 1));
				Undeadhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Spartanhelmet = new ItemStack(itemSmith.makeItem(Material.IRON_HELMET, "Spartan Helmet", ChatColor.BLUE + "Uncommon", null, 1));
				Spartanhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Spartanhelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				
				//Chestplate
				ItemStack Undeadchestplate = new ItemStack(itemSmith.makeItem(Material.IRON_CHESTPLATE, "Undead Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
				Undeadchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Spartanchestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Spartan Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
				Spartanchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Spartanchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
					
				//Leggings
				ItemStack Undeadleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Undead Leggings", ChatColor.BLUE + "Uncommon", null, 1));
				Undeadleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Spartanleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Spartan Leggings", ChatColor.BLUE + "Uncommon", null, 1));
				Spartanleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Spartanleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
					
				//Boots
				ItemStack Undeadboots = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Undead Boots", ChatColor.BLUE + "Uncommon", null, 1));
				Undeadboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack Spartanboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Spartan Boots", ChatColor.BLUE + "Uncommon", null, 1));
				Spartanboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
				Spartanboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				
				if (seed <= 10) {
					return Undeadsword;
				} else if (seed <= 20 && seed >= 10) {
					return Spear;
				} else if (seed <= 30 && seed >= 20) {
					return Undeadhelmet;
				} else if (seed <= 40 && seed >= 30) {
					return Spartanhelmet;
				} else if (seed <= 50 && seed >= 40) {
					return Undeadchestplate;
				} else if (seed <= 60 && seed >= 50) {
					return Spartanchestplate;
				} else if (seed <= 70 && seed >= 60) {
					return Undeadleggings;
				} else if (seed <= 80 && seed >= 70) {
					return Spartanleggings;
				} else if (seed <= 90 && seed >= 80) {
					return Undeadboots;
				} else if (seed <= 100 && seed >= 90) {
					return Spartanboots;
				} 
				
				
			} else if (procent <= 80 && procent >= 75) { //**LEGENDARY**
				//Legendary

				
				//Item in hand
				ItemStack Aegis = new ItemStack(itemSmith.makeItem(Material.NETHERITE_SWORD, "The Aegis", ChatColor.GOLD + "Legendary", "Zeus, Perseus, and especially Athena used the Aegis at one time or another.", 1));
				Aegis.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
				Aegis.setDurability((short) 500);
				//Swims faster
				
				
				ItemStack Cadaceus = new ItemStack(itemSmith.makeItem(Material.NETHERITE_SWORD, "The Cadaceus", ChatColor.GOLD + "Legendary", "The Cadaceus is a staff that is most often carried by Hermes.", 1));
				Cadaceus.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
				Cadaceus.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				//Runs faster on grass
				
				
				
				
				//Helmet
				ItemStack AdamantineHelmet = new ItemStack(itemSmith.makeItem(Material.NETHERITE_HELMET, "Adamantine Helmet", ChatColor.GOLD + "Legendary", "Perseus used an adamantine sword to decapitate the Gorgon Medusa.", 1));
				AdamantineHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				
				ItemStack Winged = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Winged Helmet", ChatColor.GOLD + "Legendary", "Winged helmet wore by Hermes.", 1));
				Winged.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				Winged.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				//Enables fly
				
				
				
				
				//Chestplate
				ItemStack NessusShirt = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Shirt of Nessus", ChatColor.GOLD + "Legendary", "Shirt poisoned with Nessus tainted/poisoned blood,\n used to poison and kill Heracles.", 1));
				NessusShirt.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				//bearer gets poison
				
				ItemStack AdamantineChestplate = new ItemStack(itemSmith.makeItem(Material.NETHERITE_CHESTPLATE, "Adamantine Chestplate", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology. ", 1));
				AdamantineChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				
					
					
				//Leggings
				ItemStack AdamantineLeggings = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Leggings", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology.", 1));
				AdamantineLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				
				ItemStack NemeanHide = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Hide of the Nemean Lion", ChatColor.GOLD + "Legendary", "Earned by Heracles, it was impenetrable, at least by conventional weapons.", 1));
				NemeanHide.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				NemeanHide.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				//TODO TEST Bearer only takes damage to enchated weapons.
				
					
					
				//Boots
				ItemStack WingedSandals = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Winged Sandals", ChatColor.GOLD + "Legendary", "Winged Sandals wore by Hermes, allowing the god to fly.", 1));
				//Lets the bearer fly
				
				ItemStack AdamantineBoots = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Boots", ChatColor.GOLD + "Legendary", null, 1));
				AdamantineBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				
				if (seed <= 10) {
					return Aegis;
				} else if (seed <= 20 && seed >= 10) {
					return Cadaceus;
				} else if (seed <= 30 && seed >= 20) {
					return AdamantineHelmet;
				} else if (seed <= 40 && seed >= 30) {
					return Winged;
				} else if (seed <= 50 && seed >= 40) {
					return NessusShirt;
				} else if (seed <= 60 && seed >= 50) {
					return AdamantineChestplate;
				} else if (seed <= 70 && seed >= 60) {
					return AdamantineLeggings;
				} else if (seed <= 80 && seed >= 70) {
					return NemeanHide;
				} else if (seed <= 90 && seed >= 80) {
					return WingedSandals;
				} else if (seed <= 100 && seed >= 90) {
					return AdamantineBoots;
				} 
				
				
				
			} else if (procent <= 100 && procent >= 80) {
				
				return air;
			}
			
		
		return air;

	}
	
	
	
	
	//Weapons
}
