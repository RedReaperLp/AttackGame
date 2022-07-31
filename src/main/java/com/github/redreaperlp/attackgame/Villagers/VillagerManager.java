package com.github.redreaperlp.attackgame.Villagers;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class VillagerManager {
    public boolean checkForVillagerLoc(String name) {
        Location loc = AttackGame.instance.getConfig().getLocation(name);
        if ( loc == null) {
            return false;
        } else {
            return true;
        }
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
}
