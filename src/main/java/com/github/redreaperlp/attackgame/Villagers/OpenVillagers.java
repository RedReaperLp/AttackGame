package com.github.redreaperlp.attackgame.Villagers;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class OpenVillagers {
    public void openStoney(Player player) {

        List<MerchantRecipe> recipes = new ArrayList<>();
        VillagerManager villagerManager = new VillagerManager(AttackGame.instance);

        recipes.add(villagerManager.createRecipe(Material.COBBLESTONE, 9, null, null, Material.STONE, 1, "§aCompressed Cobblestone", List.of("§5Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.STONE, 9, "§aCompressed Cobblestone", List.of("§5Komprimierter Bruchstein"), Material.COBBLED_DEEPSLATE, 1, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.COBBLED_DEEPSLATE, 9, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), Material.DEEPSLATE, 1, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.DEEPSLATE, 9, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), Material.POLISHED_DEEPSLATE, 1, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein")));
        recipes.add(villagerManager.createRecipe(Material.POLISHED_DEEPSLATE, 9, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein"), Material.NETHERITE_INGOT, 1, "§4Dense Ingot", List.of("§5Fünffach Komprimierter Bruchstein")));
        recipes.add(villagerManager.createToolRecipe(Material.STONE_PICKAXE, List.of(Enchantment.DIG_SPEED, Enchantment.DURABILITY), List.of(4, 15), "§6Stoneys Nice", List.of("§eYour first better mining tool"), Material.DEEPSLATE, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), 2));
        recipes.add(villagerManager.createPotionRecipe(List.of(PotionEffectType.FAST_DIGGING), List.of(0), List.of(18000), "§eSmall haste Potion (0:15:00)", List.of("§6Kleine Haste Potion"), Material.COBBLED_DEEPSLATE, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), 2));
        recipes.add(villagerManager.createPotionRecipe(List.of(PotionEffectType.FAST_DIGGING), List.of(1), List.of(36000), "§eMedium haste Potion (0:30:00)", List.of("§6Mittlere Haste Potion"), Material.COBBLED_DEEPSLATE, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), 4));
        recipes.add(villagerManager.createPotionRecipe(List.of(PotionEffectType.FAST_DIGGING), List.of(2), List.of(72000), "§eBig haste Potion (1:00:00)", List.of("§6Große Haste Potion"), Material.DEEPSLATE, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), 1));
        recipes.add(villagerManager.createRecipe(Material.POLISHED_DEEPSLATE, 4, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein"), Material.OCELOT_SPAWN_EGG, 1, "§eHe Works with Bees", List.of("§5A new Villager")));
        recipes.add(villagerManager.createRecipe(Material.POLISHED_DEEPSLATE, 1, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein"), Material.STRIDER_SPAWN_EGG, 1, "§cSaved Grobian", List.of("§5A new Villager")));

        Merchant merchant = Bukkit.createMerchant("§cStoney");
        merchant.setRecipes(recipes);

        player.openMerchant(merchant, true);

    }

    public void openImker(Player player) {

        List<MerchantRecipe> recipes = new ArrayList<>();
        VillagerManager villagerManager = new VillagerManager(AttackGame.instance);

        recipes.add(villagerManager.createRecipe(Material.HONEY_BLOCK, 9, null, null, Material.ORANGE_STAINED_GLASS, 1, "§aCompressed Honey", List.of("§5Komprimierter Honig")));
        recipes.add(villagerManager.createRecipe(Material.ORANGE_STAINED_GLASS, 9, "§aCompressed Honey", List.of("§5Komprimierter Honig"), Material.HONEYCOMB_BLOCK, 1, "§3Double Compressed Honey", List.of("§5Doppelt Komprimierter Honig")));
        recipes.add(villagerManager.createToolRecipe(Material.HONEYCOMB, List.of(Enchantment.LUCK), List.of(100), "§6Sweet Honey", List.of("§5Eignet sich sehr gut als Köder!"), Material.HONEYCOMB_BLOCK, "§3Double Compressed Honey", List.of("§5Doppelt Komprimierter Honig"), 2));
        recipes.add(villagerManager.createRecipe(Material.HONEYCOMB_BLOCK, 2, "§3Double Compressed Honey", List.of("§5Doppelt Komprimierter Honig"), Material.FROG_SPAWN_EGG, 1, "§fWhite Frog", List.of("§5This spawns a White Frog")));
        recipes.add(villagerManager.createRecipe(Material.HONEYCOMB_BLOCK, 2, "§3Double Compressed Honey", List.of("§5Doppelt Komprimierter Honig"), Material.FROG_SPAWN_EGG, 1, "§cBrown Frog", List.of("§5This spawns a Brown Frog")));
        recipes.add(villagerManager.createRecipe(Material.HONEYCOMB_BLOCK, 2, "§3Double Compressed Honey", List.of("§5Doppelt Komprimierter Honig"), Material.FROG_SPAWN_EGG, 1, "§aGreen Frog", List.of("§5This spawns a Green Frog")));
        recipes.add(villagerManager.createRecipe(Material.HONEYCOMB_BLOCK, 16, "§3Double Compressed Honey", List.of("§5Doppelt Komprimierter Honig"), Material.PARROT_SPAWN_EGG, 1, "§aMeloger", List.of("§5He Trades Melons!")));

        Merchant merchant = Bukkit.createMerchant("§eImker");
        merchant.setRecipes(recipes);

        player.openMerchant(merchant, true);
    }

    public void openSavedGrobian(Player player) {
        List<MerchantRecipe> recipes = new ArrayList<>();
        VillagerManager villagerManager = new VillagerManager(AttackGame.instance);

        recipes.add(villagerManager.createRecipe(Material.COBBLED_DEEPSLATE, 1, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), Material.QUARTZ, 16, null, null));
        recipes.add(villagerManager.createRecipe(Material.COBBLED_DEEPSLATE, 1, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), Material.GOLD_NUGGET, 1, null, null));
        recipes.add(villagerManager.createRecipe(Material.COBBLED_DEEPSLATE, 1, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), Material.BLAZE_ROD, 1, null, null));
        recipes.add(villagerManager.createRecipe(Material.DEEPSLATE, 1, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), Material.NETHER_WART, 1, null, null));
        recipes.add(villagerManager.createRecipe(Material.COBBLED_DEEPSLATE, 1, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), Material.SOUL_SAND, 1, null, null));

    /*
        PlayerProfile profile = Bukkit.createProfile("RedReaperLp");
        PlayerTextures textures = profile.getTextures();

        try {
            URL url = new URL("http://textures.minecraft.net/texture/3e6b76ec5af332bee74cae3ab47f4172ed242c53f8374c47cad719820de26688");
            textures.setSkin(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        profile.setTextures(textures);

        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwnerProfile(profile);
        itemStack.setItemMeta(meta);

        recipes.add(createRecipe(itemStack, itemStack)); */

        Merchant merchant = Bukkit.createMerchant("§cSaved Grobian");
        merchant.setRecipes(recipes);


        player.openMerchant(merchant, true);
    }

    public void openMeloger(Player player) {
        List<MerchantRecipe> recipes = new ArrayList<>();
        VillagerManager villagerManager = new VillagerManager(AttackGame.instance);

        recipes.add(villagerManager.createRecipe(Material.MELON, 9, null, null, Material.MOSS_BLOCK, 1, "§aCompressed Melon", List.of("§5Komprimierte Melone")));
        recipes.add(villagerManager.createRecipe(Material.MOSS_BLOCK, 9, "§aCompressed Melon", List.of("§5Komprimierte Melone"), Material.MELON_SLICE, 1, "§3Double Compressed Melon", List.of("§5Doppelt Komprimierte Melone")));
        recipes.add(villagerManager.createRecipe(Material.MELON_SLICE, 9, "§3Double Compressed Melon", List.of("§5Doppelt Komprimierte Melone"), Material.GLISTERING_MELON_SLICE, 1, "§eTriple Compressed Melon", List.of("§5Dreifach Komprimierte Melone")));


        Merchant merchant = Bukkit.createMerchant("§aMeloger");
        merchant.setRecipes(recipes);

        player.openMerchant(merchant, true);
    }

    public ItemStack skull(String url, String name, List<String> lore) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);

        if (url == null) {
            return skull;
        }

        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(name);
        skullMeta.setLore(lore);
        skullMeta.setOwner(url);
        skull.setItemMeta(skullMeta);
        return skull;
    }

    public MerchantRecipe createRecipe(ItemStack result, ItemStack ingredient) {
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(ingredient);
        return recipe;
    }

    public ItemStack createItemStack(Material material, String name, List<String> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}



