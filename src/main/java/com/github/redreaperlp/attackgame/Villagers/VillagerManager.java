package com.github.redreaperlp.attackgame.Villagers;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class VillagerManager {

    public AttackGame plugin;

    public VillagerManager(AttackGame ourMain) {
        plugin = ourMain;
    }

    public boolean checkForVillagerLoc(String name) {
        Location loc = AttackGame.instance.getConfig().getLocation(name);
        return loc != null;
    }

    public void createVillager(Location loc, String name, Villager.Profession job) {
        List<Entity> entities = Bukkit.getWorld("world").getEntities();
        for (Entity entity : entities) {
            if (entity.getCustomName() != null) {
                if (entity.getCustomName().equals(name)) {
                    entity.remove();
                }
            }
        }

        Villager villager = Bukkit.getWorld("world").spawn(loc, Villager.class);
        villager.setCustomName(name);
        villager.setProfession(job);
        villager.setAI(false);

        plugin.getConfig().set(name, loc);
        plugin.saveConfig();
    }

    public MerchantRecipe createRecipe(Material sellItems, int sellAmount, String sellDisplayName, List<String> sellLore, Material results, int resultAmount, String resultSisplayName, List<String> resultLore) {
        ItemStack sellItem = new ItemStack(sellItems, sellAmount);
        ItemMeta sellItemMeta = sellItem.getItemMeta();
        sellItemMeta.setDisplayName(sellDisplayName);
        sellItemMeta.setLore(sellLore);
        sellItem.setItemMeta(sellItemMeta);

        ItemStack resultItem = new ItemStack(results, resultAmount);
        ItemMeta resultItemMeta = resultItem.getItemMeta();
        resultItemMeta.setDisplayName(resultSisplayName);
        resultItemMeta.setLore(resultLore);
        resultItem.setItemMeta(resultItemMeta);

        MerchantRecipe recipe = new MerchantRecipe(resultItem, 1000);
        recipe.addIngredient(sellItem);

        return recipe;
    }

    public MerchantRecipe createToolRecipe(Material toolToCreate, List<Enchantment> enchantments, List<Integer> enchantmentLevel, String displayName, List<String> lore, Material acceptedItem, String acceptedDisplayName, List<String> acceptedLore, int acceptedAmount) {
        ItemStack tool = new ItemStack(toolToCreate);
        ItemMeta toolMeta = tool.getItemMeta();

        int enchantmentAmount = enchantments.size();
        for (int i = 0; i <= enchantmentAmount - 1; i++) {
            toolMeta.addEnchant(enchantments.get(i), enchantmentLevel.get(i), true);
        }

        toolMeta.setDisplayName(displayName);
        toolMeta.setLore(lore);
        tool.setItemMeta(toolMeta);

        MerchantRecipe recipe = new MerchantRecipe(tool, 10000);

        ItemStack acceptItem = new ItemStack(acceptedItem, acceptedAmount);
        ItemMeta acceptedMeta = acceptItem.getItemMeta();
        acceptedMeta.setDisplayName(acceptedDisplayName);
        acceptedMeta.setLore(acceptedLore);
        acceptItem.setItemMeta(acceptedMeta);

        recipe.addIngredient(acceptItem);

        return recipe;
    }

    public MerchantRecipe createPotionRecipe(List<PotionEffectType> effectTypes, List<Integer> effectLevel, List<Integer> duration, String displayName, List<String> lore, Material acceptedItem, String acceptedDisplayName, List<String> acceptedLore, int acceptedAmount) {
        ItemStack potion = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
        for (int i = 0; i <= effectTypes.size() - 1; i++) {
            potionMeta.addCustomEffect(new PotionEffect(effectTypes.get(i), duration.get(i), effectLevel.get(i)), true);
        }
        potionMeta.setDisplayName(displayName);
        potionMeta.setLore(lore);
        potion.setItemMeta(potionMeta);

        MerchantRecipe recipe = new MerchantRecipe(potion, 10000);
        ItemStack acceptItem = new ItemStack(acceptedItem, acceptedAmount);
        ItemMeta acceptedMeta = acceptItem.getItemMeta();
        acceptedMeta.setDisplayName(acceptedDisplayName);
        acceptedMeta.setLore(acceptedLore);
        acceptItem.setItemMeta(acceptedMeta);

        recipe.addIngredient(acceptItem);
        return recipe;
    }

    public void spawnVillager() {
        Location locStoney = plugin.getConfig().getLocation("§cStoney");
        Location locImker = plugin.getConfig().getLocation("§eImker");
        Location locSavedGrobian = plugin.getConfig().getLocation("§cSaved Grobian");
        Location locMeloger = plugin.getConfig().getLocation("§aMeloger");

        if (locStoney != null) {
            createVillager(locStoney, "§cStoney", Villager.Profession.MASON);
        } else {
            plugin.console.sendMessage(plugin.prefix + "§cThe Villager Spawnpoint for Stoney is not set!");
        }
        if (locImker != null) {
            createVillager(locImker, "§eImker", Villager.Profession.FARMER);
        }
        if (locSavedGrobian != null) {
            createVillager(locSavedGrobian, "§cSaved Grobian", Villager.Profession.WEAPONSMITH);
        }
        if (locMeloger != null) {
            createVillager(locMeloger, "§aMeloger", Villager.Profession.FARMER);
        }
    }
}
