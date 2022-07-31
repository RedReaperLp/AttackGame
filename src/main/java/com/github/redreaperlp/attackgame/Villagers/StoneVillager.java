package com.github.redreaperlp.attackgame.Villagers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class StoneVillager {
    public void openStoney(Player player) {

        List<MerchantRecipe> recipes = new ArrayList<>();
        VillagerManager villagerManager = new VillagerManager();

        recipes.add(villagerManager.createRecipe(Material.COBBLESTONE, 9, null, null, Material.STONE, 1, "§aCompressed Cobblestone", List.of("§5Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.STONE, 9, "§aCompressed Cobblestone", List.of("§5Komprimierter Bruchstein"), Material.COBBLED_DEEPSLATE, 1, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.COBBLED_DEEPSLATE, 9, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), Material.DEEPSLATE, 1, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.DEEPSLATE, 9, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), Material.POLISHED_DEEPSLATE, 1, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.POLISHED_DEEPSLATE, 9, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein"), Material.NETHERITE_INGOT, 1, "§4Quintuple Compressed Cobblestone", List.of("§5Fünffach Komprimierter Bruchstein")));

        Merchant merchant = Bukkit.createMerchant("§cStoney");
        merchant.setRecipes(recipes);

        player.openMerchant(merchant, true);

    }


}



