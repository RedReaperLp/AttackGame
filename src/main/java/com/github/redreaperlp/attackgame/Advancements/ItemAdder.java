package com.github.redreaperlp.attackgame.Advancements;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.List;

public class ItemAdder {

    public ItemStack addItem(NamespacedKey key, PersistentDataContainer container) {
        if (key.getKey().equals("placeholder")) {
            ItemStack placeholder = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            ItemMeta placeholderMeta = placeholder.getItemMeta();
            placeholderMeta.setDisplayName("");
            int xplaceholder = 100000 + (int) (Math.random() * ((999999 - 100000) + 1));
            placeholderMeta.setLore(List.of("§k" + xplaceholder));
            placeholder.setItemMeta(placeholderMeta);
            return placeholder;
        }

        if (container.has(key)) {
            switch (key.getKey()) {
                case "firstjoin":
                    ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§a[Welcome to AttackGame]");
                    meta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for Joining",
                            "§6the server for the first time",
                            "§e----------------------------"));
                    item.setItemMeta(meta);
                    return item;

                case "compressed":
                    ItemStack compressed = new ItemStack(Material.STONE);
                    ItemMeta compressedMeta = compressed.getItemMeta();
                    compressedMeta.setDisplayName("§a[Compressed Cobblestone]");
                    compressedMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§f9 cobblestone§6 to a",
                            "§acompressed cobblestone",
                            "§e----------------------------"));
                    compressed.setItemMeta(compressedMeta);
                    return compressed;
                case "doublecompressed":
                    ItemStack doublecompressed = new ItemStack(Material.COBBLED_DEEPSLATE);
                    ItemMeta doublecompressedMeta = doublecompressed.getItemMeta();
                    doublecompressedMeta.setDisplayName("§a[Double Compressed Cobblestone]");
                    doublecompressedMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§a9 compressed cobblestone §6to a ",
                            "§3double compressed cobblestone",
                            "§e----------------------------"));
                    doublecompressed.setItemMeta(doublecompressedMeta);
                    return doublecompressed;
                case "triplecompressed":
                    ItemStack triplecompressed = new ItemStack(Material.DEEPSLATE);
                    ItemMeta triplecompressedMeta = triplecompressed.getItemMeta();
                    triplecompressedMeta.setDisplayName("§a[Triple Compressed Cobblestone]");
                    triplecompressedMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§39 double compressed cobblestone",
                            "§6to a §etriple compressed cobblestone",
                            "§e----------------------------"));
                    triplecompressed.setItemMeta(triplecompressedMeta);
                    return triplecompressed;
                case "quadruplecompressed":
                    ItemStack quadruplecompressed = new ItemStack(Material.POLISHED_DEEPSLATE);
                    ItemMeta quadruplecompressedMeta = quadruplecompressed.getItemMeta();
                    quadruplecompressedMeta.setDisplayName("§a[Quadruple Compressed Cobblestone]");
                    quadruplecompressedMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§e9 triple compressed cobblestone",
                            "§6to a §6quadruple compressed cobblestone",
                            "§e----------------------------"));
                    quadruplecompressed.setItemMeta(quadruplecompressedMeta);
                    return quadruplecompressed;
                case "quintuplecompressed":
                    ItemStack quintuplecompressed = new ItemStack(Material.NETHERITE_INGOT);
                    ItemMeta quintuplecompressedMeta = quintuplecompressed.getItemMeta();
                    quintuplecompressedMeta.setDisplayName("§a[Quintuple Compressed Cobblestone]");
                    quintuplecompressedMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§69 quadruple compressed cobblestone",
                            "§6to a §4quintuple compressed cobblestone",
                            "§e----------------------------"));
                    quintuplecompressed.setItemMeta(quintuplecompressedMeta);
                    return quintuplecompressed;
                default:
                    ItemStack barrier = new ItemStack(Material.BARRIER);
                    ItemMeta barrierMeta = barrier.getItemMeta();
                    barrierMeta.setDisplayName("§c[Unknown Advancement]");
                    int x = 100000 + (int) (Math.random() * ((999999 - 100000) + 1));
                    barrierMeta.setLore(List.of("§k" + x));
                    barrier.setItemMeta(barrierMeta);
                    return barrier;


            }
        } else {
            int x = 100000 + (int) (Math.random() * ((999999 - 100000) + 1));
            ItemStack item = new ItemStack(Material.GRAY_DYE);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("§6Not unlocked yet");
            itemMeta.setLore(List.of("§7???????", "§k" + x));

            item.setItemMeta(itemMeta);

            return item;
        }
    }
}
