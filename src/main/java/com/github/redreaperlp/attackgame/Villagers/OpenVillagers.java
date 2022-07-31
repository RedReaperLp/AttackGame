package com.github.redreaperlp.attackgame.Villagers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class OpenVillagers {
    public void openStoney(Player player) {

        List<MerchantRecipe> recipes = new ArrayList<>();
        VillagerManager villagerManager = new VillagerManager();

        recipes.add(villagerManager.createRecipe(Material.COBBLESTONE, 9, null, null, Material.STONE, 1, "§aCompressed Cobblestone", List.of("§5Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.STONE, 9, "§aCompressed Cobblestone", List.of("§5Komprimierter Bruchstein"), Material.COBBLED_DEEPSLATE, 1, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.COBBLED_DEEPSLATE, 9, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), Material.DEEPSLATE, 1, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.DEEPSLATE, 9, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), Material.POLISHED_DEEPSLATE, 1, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.POLISHED_DEEPSLATE, 9, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein"), Material.NETHERITE_INGOT, 1, "§4Dense Ingot", List.of("§5Fünffach Komprimierter Bruchstein")));
        recipes.add(villagerManager.createToolRecipe(Material.STONE_PICKAXE, List.of(Enchantment.DIG_SPEED, Enchantment.DURABILITY), List.of(4, 15), "§6Stoneys Nice", List.of("§eYour first better mining tool"), Material.DEEPSLATE, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), 2));
        recipes.add(villagerManager.createPotionRecipe(List.of(PotionEffectType.FAST_DIGGING), List.of(0), List.of(18000), "§eSmall haste Potion (0:15:00)", List.of("§6Kleine Haste Potion"), Material.COBBLED_DEEPSLATE, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), 2));
        recipes.add(villagerManager.createPotionRecipe(List.of(PotionEffectType.FAST_DIGGING), List.of(1), List.of(36000), "§eMedium haste Potion (0:30:00)", List.of("§6Mittlere Haste Potion"), Material.COBBLED_DEEPSLATE, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), 4));
        recipes.add(villagerManager.createPotionRecipe(List.of(PotionEffectType.FAST_DIGGING), List.of(2), List.of(72000), "§eBig haste Potion (1:00:00)", List.of("§6Große Haste Potion"), Material.DEEPSLATE, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), 1));
        recipes.add(villagerManager.createRecipe(Material.POLISHED_DEEPSLATE, 1, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein"), Material.OCELOT_SPAWN_EGG, 1, "§eImker", List.of("§5A new Villager")));

        Merchant merchant = Bukkit.createMerchant("§cStoney");
        merchant.setRecipes(recipes);

        player.openMerchant(merchant, true);

    }

    public void openImker(Player player) {

        List<MerchantRecipe> recipes = new ArrayList<>();
        VillagerManager villagerManager = new VillagerManager();

        recipes.add(villagerManager.createRecipe(Material.HONEY_BLOCK, 9, null, null, Material.HONEY_BLOCK, 1, "§aCompressed Honey", List.of("§5Komprimierter Honig")));
        recipes.add(villagerManager.createRecipe(Material.HONEY_BLOCK, 9, "§aCompressed Honey", List.of("§5Komprimierter Honig"), Material.HONEY_BLOCK, 1, "§3Double Compressed Honey", List.of("§5Doppelt Komprimierter Honig")));

        Merchant merchant = Bukkit.createMerchant("§eImker");
        merchant.setRecipes(recipes);

        player.openMerchant(merchant, true);
    }


}



