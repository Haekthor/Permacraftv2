package dev.kolind.permacraft.functions.bossmobs;


import dev.kolind.permacraft.functions.customitems.CustomItems;
import dev.kolind.permacraft.gui.items.ItemSmith;
import dev.kolind.permacraft.main.Main;
import dev.kolind.permacraft.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Bossmobs implements Listener {

	//Deprecated class

	public static ItemSmith Item = new ItemSmith();
	//Constructor
	Main instance;
	public Bossmobs(Main plugin) {
		instance = plugin;
	}
	ItemSmith itemSmith = new ItemSmith();
	CustomItems customItems = new CustomItems();


    //Eventhandler
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent event) {
		if (instance.getConfig().getBoolean("Features.Bossmobs.Enabled")) {
			Entity entity = event.getEntity();
			Random rand = new Random();
			int procent = rand.nextInt(101);
			int seed = rand.nextInt(101);
			
			//Zombie

			
			if (entity instanceof Zombie) {


				
				//Common
				if (procent <= 1) {
					entity.setCustomName("Common Zombie");
					//Item in hand
					ItemStack Zombiesword = new ItemStack(itemSmith.makeItem(Material.WOODEN_SWORD, "Zombie Sword", "Common", null, 1));
					Zombiesword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
					
					ItemStack Ghostsword = new ItemStack(itemSmith.makeItem(Material.IRON_SWORD, "Ghost sword", "Common", null, 1));
					Ghostsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
					Ghostsword.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setItemInMainHand(Zombiesword);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setItemInMainHand(Ghostsword);
					} else {

					}
					
					
					
					//Helmet
					ItemStack Zombiehelmet = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Zombie Helmet", "Common", null, 1));
					Zombiehelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Ghosthelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Ghost Helmet", "Common", null, 1));
					Ghosthelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Ghosthelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setHelmet(Zombiehelmet);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setHelmet(Ghosthelmet);
					} else {
						
					}
					
					
					
					//Chestplate
					ItemStack Zombiechestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Zombie Chestplate", "Common", null, 1));
					Zombiechestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Ghostchestplate = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_CHESTPLATE, "Ghost Chestplate", "Common", null, 1));
					Ghostchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Ghostchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setChestplate(Zombiechestplate);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setChestplate(Ghostchestplate);
					} else {
						
					}
						
						
					//Leggings
					ItemStack Zombieleggings = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Zombie Leggings", "Common", null, 1));
					Zombieleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Ghostleggings = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_LEGGINGS, "Ghost Leggings", "Common", null, 1));
					Ghostleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Ghostleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setLeggings(Zombieleggings);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setLeggings(Ghostleggings);
					} else {
						
					}
						
						
					//Boots
					ItemStack Zombieboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Zombie Boots", "Common", null, 1));
					Zombieboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Ghostboots = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Ghost Boots", "Common", null, 1));
					Ghostboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Ghostboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setBoots(Zombieboots);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setBoots(Ghostboots);
					} else {
						
					}
					
					((Zombie) entity).getEquipment().setItemInMainHandDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					((Zombie) entity).getEquipment().setHelmetDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					((Zombie) entity).getEquipment().setChestplateDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					((Zombie) entity).getEquipment().setLeggingsDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					((Zombie) entity).getEquipment().setBootsDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					
					
					
				} else if (procent <= 75 && procent >= 50) { //**RARE**
					//Rare
					
					entity.setCustomName(ChatColor.DARK_PURPLE + "Rare Zombie");
					//Item in hand
					ItemStack Wield = new ItemStack(itemSmith.makeItem(Material.DIAMOND_SWORD, "Wield Sword", ChatColor.DARK_PURPLE + "Rare", "Be careful! Its heavily used!", 1));
					Wield.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
					Wield.setDurability((short) 500);
					
					ItemStack Ender = new ItemStack(itemSmith.makeItem(Material.DIAMOND_SWORD, "Ender", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Ender.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
					Ender.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setItemInMainHand(Wield);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setItemInMainHand(Ender);
					} else {
						
					}
					
					
					
					//Helmet
					ItemStack Minershat = new ItemStack(itemSmith.makeItem(Material.LEGACY_GOLD_HELMET, "Miner's hat", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Minershat.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
					
					ItemStack Brainer = new ItemStack(itemSmith.makeItem(Material.DIAMOND_HELMET, "Brain Helmet", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Brainer.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
					Brainer.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setHelmet(Minershat);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setHelmet(Brainer);
					} else {
						
					}
					
					
					
					//Chestplate
					ItemStack Snowset = new ItemStack(itemSmith.makeItem(Material.DIAMOND_CHESTPLATE, "Snow Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Snowset.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					
					ItemStack Pyro = new ItemStack(itemSmith.makeItem(Material.LEGACY_GOLD_CHESTPLATE, "Pyroman's Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Pyro.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
					Pyro.setDurability((short) 100); 
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setChestplate(Snowset);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setChestplate(Pyro);
					} else {
						
					}
						
						
					//Leggings
					ItemStack boltlegs = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Bolt Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
					boltlegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
					
					ItemStack Netherpants = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Nether Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
					Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					Netherpants.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setLeggings(boltlegs);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setLeggings(Netherpants);
					} else {
						
					}
						
						
					//Boots
					ItemStack Feathers = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Angel's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
					
					ItemStack Thorns = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Troll's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Thorns.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					Thorns.addUnsafeEnchantment(Enchantment.THORNS, 5);
					Thorns.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setBoots(Feathers);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setBoots(Thorns);
					} else {
						
					}
					
					
					((Zombie) entity).getEquipment().setItemInMainHandDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					((Zombie) entity).getEquipment().setHelmetDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					((Zombie) entity).getEquipment().setChestplateDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					((Zombie) entity).getEquipment().setLeggingsDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					((Zombie) entity).getEquipment().setBootsDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					
					
				} else if (procent <= 50 && procent >= 1) { //**UNCOMMON**
					
							
					entity.setCustomName(ChatColor.BLUE + "Uncommon Zombie");
					//Item in hand
					ItemStack Undeadsword = new ItemStack(itemSmith.makeItem(Material.STONE_SWORD, "Undead Sword", ChatColor.BLUE + "Uncommon", "Be careful! Its heavily used!", 1));
					Undeadsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
					Undeadsword.setDurability((short) 100);
					
					ItemStack Spear = new ItemStack(itemSmith.makeItem(Material.IRON_SWORD, "Spear of sparta", ChatColor.BLUE + "Uncommon", null, 1));
					Spear.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
					Spear.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setItemInMainHand(Undeadsword);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setItemInMainHand(Spear);
					} else {
						
					}
					
					
					
					//Helmet
					ItemStack Undeadhelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Undead Helmet", ChatColor.BLUE + "Uncommon", null, 1));
					Undeadhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Spartanhelmet = new ItemStack(itemSmith.makeItem(Material.IRON_HELMET, "Spartan Helmet", ChatColor.BLUE + "Uncommon", null, 1));
					Spartanhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Spartanhelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setHelmet(Undeadhelmet);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setHelmet(Spartanhelmet);
					} else {
						
					}
					
					
					
					//Chestplate
					ItemStack Undeadchestplate = new ItemStack(itemSmith.makeItem(Material.IRON_CHESTPLATE, "Undead Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
					Undeadchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Spartanchestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Spartan Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
					Spartanchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Spartanchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setChestplate(Undeadchestplate);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setChestplate(Spartanchestplate);
					} else {
						
					}
						
						
					//Leggings
					ItemStack Undeadleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Undead Leggings", ChatColor.BLUE + "Uncommon", null, 1));
					Undeadleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Spartanleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Spartan Leggings", ChatColor.BLUE + "Uncommon", null, 1));
					Spartanleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Spartanleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setLeggings(Undeadleggings);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setLeggings(Spartanleggings);
					} else {
						
					}
						
						
					//Boots
					ItemStack Undeadboots = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Undead Boots", ChatColor.BLUE + "Uncommon", null, 1));
					Undeadboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Spartanboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Spartan Boots", ChatColor.BLUE + "Uncommon", null, 1));
					Spartanboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Spartanboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setBoots(Undeadboots);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setBoots(Spartanboots);
					} else {
						
					}
					
					((Zombie) entity).getEquipment().setItemInMainHandDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					((Zombie) entity).getEquipment().setHelmetDropChance(instance.getConfig().getInt("LootDrops.Rare.Uncommon"));
					((Zombie) entity).getEquipment().setChestplateDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					((Zombie) entity).getEquipment().setLeggingsDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					((Zombie) entity).getEquipment().setBootsDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					
					
				} else if (procent <= 80 && procent >= 75) { //**LEGENDARY**
					//Legendary
					
					entity.setCustomName(ChatColor.DARK_PURPLE + "Legendary Zombie");
					
					
					
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
						((Zombie) entity).getEquipment().setItemInMainHand(Aegis);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setItemInMainHand(Cadaceus);
					} else {
						
					}
					
					
					
					//Helmet
					ItemStack AdamantineHelmet = new ItemStack(itemSmith.makeItem(Material.NETHERITE_HELMET, "Adamantine Helmet", ChatColor.GOLD + "Legendary", "Perseus used an adamantine sword to decapitate the Gorgon Medusa.", 1));
					AdamantineHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					
					ItemStack Winged = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Winged Helmet", ChatColor.GOLD + "Legendary", "Winged helmet wore by Hermes.", 1));
					Winged.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
					Winged.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					//Enables fly
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setHelmet(AdamantineHelmet);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setHelmet(Winged);
					} else {
						
					}
					
					
					
					//Chestplate
					ItemStack NessusShirt = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Shirt of Nessus", ChatColor.GOLD + "Legendary", "Shirt poisoned with Nessus tainted/poisoned blood,\n used to poison and kill Heracles.", 1));
					NessusShirt.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					//bearer gets poison
					
					ItemStack AdamantineChestplate = new ItemStack(itemSmith.makeItem(Material.NETHERITE_CHESTPLATE, "Adamantine Chestplate", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology. ", 1));
					AdamantineChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setChestplate(NessusShirt);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setChestplate(AdamantineChestplate);
					} else {
						
					}
						
						
					//Leggings
					ItemStack AdamantineLeggings = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Leggings", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology.", 1));
					AdamantineLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					
					ItemStack NemeanHide = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Hide of the Nemean Lion", ChatColor.GOLD + "Legendary", "Earned by Heracles, it was impenetrable, at least by conventional weapons.", 1));
					NemeanHide.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					NemeanHide.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setLeggings(AdamantineLeggings);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setLeggings(NemeanHide);
					} else {
						
					}
						
						
					//Boots
					ItemStack WingedSandals = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Winged Sandals", ChatColor.GOLD + "Legendary", "Winged Sandals wore by Hermes, allowing the god to fly.", 1));
					//Lets the bearer fly
					
					ItemStack AdamantineBoots = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Boots", ChatColor.GOLD + "Legendary", null, 1));
					AdamantineBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					
					if (seed <= 40) {
						((Zombie) entity).getEquipment().setBoots(WingedSandals);
					} else if (seed >= 40) {
						((Zombie) entity).getEquipment().setBoots(AdamantineBoots);
					} else {
						
					}
					
					
					((Zombie) entity).getEquipment().setItemInMainHandDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					((Zombie) entity).getEquipment().setHelmetDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					((Zombie) entity).getEquipment().setChestplateDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					((Zombie) entity).getEquipment().setLeggingsDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					((Zombie) entity).getEquipment().setBootsDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					
					
					
				} else if (procent <= 100 && procent >= 80) {
					entity.setCustomName("Normal Zombie");
				}
				
			} 
			
			//Skeleton
			if (entity instanceof Skeleton) {

				
				//Common
				if (procent <= 1) {
					
					entity.setCustomName("Common Skeleton");
					//Item in hand
					ItemStack Skeletonsword = new ItemStack(itemSmith.makeItem(Material.BOW, "Skeleton Bow", "Common", null, 1));
					Skeletonsword.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					
					ItemStack Ghostsword = new ItemStack(itemSmith.makeItem(Material.BOW, "Ghost bow", "Common", null, 1));
					Ghostsword.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					Ghostsword.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setItemInMainHand(Skeletonsword);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setItemInMainHand(Ghostsword);
					} else {
						
					}
					
					
					
					//Helmet
					ItemStack Skeletonhelmet = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Skeleton Helmet", "Common", null, 1));
					Skeletonhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Ghosthelmet = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_HELMET, "Ghost Helmet", "Common", null, 1));
					Ghosthelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Ghosthelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setHelmet(Skeletonhelmet);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setHelmet(Ghosthelmet);
					} else {
						
					}
					
					
					
					//Chestplate
					ItemStack Skeletonchestplate = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Skeleton Chestplate", "Common", null, 1));
					Skeletonchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Ghostchestplate = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_CHESTPLATE, "Ghost Chestplate", "Common", null, 1));
					Ghostchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Ghostchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setChestplate(Skeletonchestplate);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setChestplate(Ghostchestplate);
					} else {
						
					}
						
						
					//Leggings
					ItemStack Skeletonleggings = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Skeleton Leggings", "Common", null, 1));
					Skeletonleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Ghostleggings = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_LEGGINGS, "Ghost Leggings", "Common", null, 1));
					Ghostleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Ghostleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setLeggings(Skeletonleggings);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setLeggings(Ghostleggings);
					} else {
						
					}
						
						
					//Boots
					ItemStack Skeletonboots = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Skeleton Boots", "Common", null, 1));
					Skeletonboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Ghostboots = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Ghost Boots", "Common", null, 1));
					Ghostboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Ghostboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setBoots(Skeletonboots);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setBoots(Ghostboots);
					} else {
						
					}
					
					((Skeleton) entity).getEquipment().setItemInMainHandDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					((Skeleton) entity).getEquipment().setHelmetDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					((Skeleton) entity).getEquipment().setChestplateDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					((Skeleton) entity).getEquipment().setLeggingsDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					((Skeleton) entity).getEquipment().setBootsDropChance(instance.getConfig().getInt("LootDrops.Common.Chance"));
					
				} else if (procent <= 75 && procent >= 50) { //**RARE**
					//Rare
					
					entity.setCustomName(ChatColor.DARK_PURPLE + "Rare Skeleton");
					//Item in hand
					ItemStack Wield = new ItemStack(itemSmith.makeItem(Material.BOW, "Wield Bow", ChatColor.DARK_PURPLE + "Rare", "Be careful! Its heavily damaged!", 1));
					Wield.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
					Wield.setDurability((short) 500);
					
					ItemStack Ender = new ItemStack(itemSmith.makeItem(Material.BOW, "Ender", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Ender.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
					Ender.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setItemInMainHand(Wield);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setItemInMainHand(Ender);
					} else {
						
					}
					
					
					
					//Helmet
					ItemStack Minershat = new ItemStack(itemSmith.makeItem(Material.LEGACY_GOLD_HELMET, "Miner's hat", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Minershat.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
					
					ItemStack Brainer = new ItemStack(itemSmith.makeItem(Material.DIAMOND_HELMET, "Brain Helmet", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Brainer.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
					Brainer.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setHelmet(Minershat);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setHelmet(Brainer);
					} else {
						
					}
					
					
					
					//Chestplate
					ItemStack Snowset = new ItemStack(itemSmith.makeItem(Material.DIAMOND_CHESTPLATE, "Snow Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Snowset.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					
					ItemStack Pyro = new ItemStack(itemSmith.makeItem(Material.LEGACY_GOLD_CHESTPLATE, "Pyroman's Chestplate", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Pyro.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
					Pyro.setDurability((short) 100); 
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setChestplate(Snowset);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setChestplate(Pyro);
					} else {
						
					}
						
						
					//Leggings
					ItemStack boltlegs = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Bolt Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
					boltlegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
					
					ItemStack Netherpants = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Nether Leggings", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
					Netherpants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					Netherpants.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setLeggings(boltlegs);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setLeggings(Netherpants);
					} else {
						
					}
						
						
					//Boots
					ItemStack Feathers = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Angel's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					Feathers.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
					
					ItemStack Thorns = new ItemStack(itemSmith.makeItem(Material.CHAINMAIL_BOOTS, "Troll's Boots", ChatColor.DARK_PURPLE + "Rare", null, 1));
					Thorns.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					Thorns.addUnsafeEnchantment(Enchantment.THORNS, 5);
					Thorns.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setBoots(Feathers);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setBoots(Thorns);
					} else {
						
					}
					
					((Skeleton) entity).getEquipment().setItemInMainHandDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					((Skeleton) entity).getEquipment().setHelmetDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					((Skeleton) entity).getEquipment().setChestplateDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					((Skeleton) entity).getEquipment().setLeggingsDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					((Skeleton) entity).getEquipment().setBootsDropChance(instance.getConfig().getInt("LootDrops.Rare.Chance"));
					
				} else if (procent <= 50 && procent >= 1) { 
					
							
					entity.setCustomName(ChatColor.BLUE + "Uncommon Skeleton");
					//Item in hand
					ItemStack Undeadsword = new ItemStack(itemSmith.makeItem(Material.BOW, "Undead Bow", ChatColor.BLUE + "Uncommon", "Be careful! Its heavily used!", 1));
					Undeadsword.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
					Undeadsword.setDurability((short) 100);
					
					ItemStack Athenian = new ItemStack(itemSmith.makeItem(Material.BOW, "Athenian archer bow", ChatColor.BLUE + "Uncommon", null, 1));
					Athenian.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
					Athenian.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setItemInMainHand(Undeadsword);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setItemInMainHand(Athenian);
					} else {
						
					}
					
					
					
					//Helmet
					ItemStack Undeadhelmet = new ItemStack(itemSmith.makeItem(Material.IRON_HELMET, "Undead Helmet", ChatColor.BLUE + "Uncommon", null, 1));
					Undeadhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Spartanhelmet = new ItemStack(itemSmith.makeItem(Material.IRON_HELMET, "Spartan Helmet", ChatColor.BLUE + "Uncommon", null, 1));
					Spartanhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Spartanhelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setHelmet(Undeadhelmet);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setHelmet(Spartanhelmet);
					} else {
						
					}
					
					
					
					//Chestplate
					ItemStack Undeadchestplate = new ItemStack(itemSmith.makeItem(Material.IRON_CHESTPLATE, "Undead Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
					Undeadchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Spartanchestplate = new ItemStack(itemSmith.makeItem(Material.IRON_CHESTPLATE, "Spartan Chestplate", ChatColor.BLUE + "Uncommon", null, 1));
					Spartanchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Spartanchestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setChestplate(Undeadchestplate);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setChestplate(Spartanchestplate);
					} else {
						
					}
						
						
					//Leggings
					ItemStack Undeadleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Undead Leggings", ChatColor.BLUE + "Uncommon", null, 1));
					Undeadleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Spartanleggings = new ItemStack(itemSmith.makeItem(Material.IRON_LEGGINGS, "Spartan Leggings", ChatColor.BLUE + "Uncommon", null, 1));
					Spartanleggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Spartanleggings.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setLeggings(Undeadleggings);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setLeggings(Spartanleggings);
					} else {
						
					}
						
						
					//Boots
					ItemStack Undeadboots = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Undead Boots", ChatColor.BLUE + "Uncommon", null, 1));
					Undeadboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					ItemStack Spartanboots = new ItemStack(itemSmith.makeItem(Material.IRON_BOOTS, "Spartan Boots", ChatColor.BLUE + "Uncommon", null, 1));
					Spartanboots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
					Spartanboots.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setBoots(Undeadboots);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setBoots(Spartanboots);
					} else {
						
					}
					
					((Skeleton) entity).getEquipment().setItemInMainHandDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					((Skeleton) entity).getEquipment().setHelmetDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					((Skeleton) entity).getEquipment().setChestplateDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					((Skeleton) entity).getEquipment().setLeggingsDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					((Skeleton) entity).getEquipment().setBootsDropChance(instance.getConfig().getInt("LootDrops.Uncommon.Chance"));
					
				} else if (procent <= 80 && procent >= 75) { //**LEGENDARY**
					//Legendary
					
					entity.setCustomName(ChatColor.DARK_PURPLE + "Legendary Skeleton");
					
					
					
					//Item in hand
					ItemStack HeraclesBow = new ItemStack(itemSmith.makeItem(Material.BOW, "Heracles's Bow", ChatColor.GOLD + "Legendary", "Bow that belonged to the demi-god Heracles, with arrows tipped with the Hydra's poison.", 1));
					HeraclesBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 7);
					HeraclesBow.setDurability((short) 500);

					
					ItemStack Appolo = new ItemStack(itemSmith.makeItem(Material.BOW, "Bow of appolo", ChatColor.GOLD + "Legendary", "The Cadaceus is a staff that is most often carried by Hermes.", 1));
					Appolo.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10);
					Appolo.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setItemInMainHand(HeraclesBow);
						((Skeleton) entity).getEquipment().setItemInOffHand(itemSmith.makeItem(Material.SPECTRAL_ARROW, "Heracles's arrows", ChatColor.GOLD + "Legendary", "Arrows tipped with the Hydra's poison.", 64));;
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setItemInMainHand(Appolo);
					} else {
						
					}
					
					
					
					//Helmet
					ItemStack Helmofdarkness = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Helm of Darkness", ChatColor.GOLD + "Legendary", "The Helmet of Darkness, also known as helmet or Cap of Invisibility, was a headgear created by the Cyclopes for Hades (Pluto).", 1));
					
					ItemStack Winged = new ItemStack(itemSmith.makeItem(Material.LEATHER_HELMET, "Winged Helmet", ChatColor.GOLD + "Legendary", "Winged helmet wore by Hermes.", 1));
					Winged.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setHelmet(Helmofdarkness);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setHelmet(Winged);
					} else {
						
					}
					
					
					
					//Chestplate
					ItemStack NessusShirt = new ItemStack(itemSmith.makeItem(Material.LEATHER_CHESTPLATE, "Shirt of Nessus", ChatColor.GOLD + "Legendary", "Shirt poisoned with Nessus tainted/poisoned blood, used to poison and kill Heracles.", 1));
					NessusShirt.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					
					ItemStack AdamantineChestplate = new ItemStack(itemSmith.makeItem(Material.NETHERITE_CHESTPLATE, "Adamantine Chestplate", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology. ", 1));
					AdamantineChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setChestplate(NessusShirt);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setChestplate(AdamantineChestplate);
					} else {
						
					}
						
						
					//Leggings
					ItemStack AdamantineLeggings = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Leggings", ChatColor.GOLD + "Legendary", "A rare, hard and durable element mentioned in Greek mythology.", 1));
					AdamantineLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					
					ItemStack NemeanHide = new ItemStack(itemSmith.makeItem(Material.LEATHER_LEGGINGS, "Hide of the Nemean Lion", ChatColor.GOLD + "Legendary", "Earned by Heracles, it was impenetrable, at least by conventional weapons.", 1));
					NemeanHide.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					NemeanHide.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setLeggings(AdamantineLeggings);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setLeggings(NemeanHide);
					} else {
						
					}
						
						
					//Boots
					ItemStack WingedSandals = new ItemStack(itemSmith.makeItem(Material.LEATHER_BOOTS, "Winged Sandals", ChatColor.GOLD + "Legendary", "Winged Sandals wore by Hermes, allowing the god to fly. ", 1));

					ItemStack AdamantineBoots = new ItemStack(itemSmith.makeItem(Material.NETHERITE_LEGGINGS, "Adamantine Boots", ChatColor.GOLD + "Legendary", null, 1));
					AdamantineBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					
					if (seed <= 40) {
						((Skeleton) entity).getEquipment().setBoots(WingedSandals);
					} else if (seed >= 40) {
						((Skeleton) entity).getEquipment().setBoots(AdamantineBoots);
					} else {
						
					}
					
					((Skeleton) entity).getEquipment().setItemInMainHandDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					((Skeleton) entity).getEquipment().setHelmetDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					((Skeleton) entity).getEquipment().setChestplateDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					((Skeleton) entity).getEquipment().setLeggingsDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					((Skeleton) entity).getEquipment().setBootsDropChance(instance.getConfig().getInt("LootDrops.Legendary.Chance"));
					
				} else if (procent <= 100 && procent >= 80) {
					entity.setCustomName("Normal Skeleton");
				}
				
			}
				
				
		}
		
	}
	
	
}