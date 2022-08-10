package com.github.redreaperlp.attackgame.Advancements;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.List;

public class ItemAdder {

    public ItemStack addItem(NamespacedKey key, PersistentDataContainer container) {
        if (key.getKey().equals("advimker")) {
            if (AttackGame.instance.getConfig().getLocation("§eImker") != null) {
                ItemStack nextPage = new ItemStack(Material.HONEY_BLOCK);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§eImker-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (key.getKey().equals("advgrobian")) {
            if (AttackGame.instance.getConfig().getLocation("§cSaved Grobian") != null) {
                ItemStack nextPage = new ItemStack(Material.NETHERRACK);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cSaved Grobian-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (key.getKey().equals("meloger")) {
            if (AttackGame.instance.getConfig().getLocation("§aMeloger") != null) {
                ItemStack nextPage = new ItemStack(Material.MELON);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§aMeloger-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (key.getKey().equals("placeholder")) {
            ItemStack placeholder = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            ItemMeta placeholderMeta = placeholder.getItemMeta();
            placeholderMeta.setDisplayName(" ");
            placeholder.setItemMeta(placeholderMeta);
            return placeholder;
        }

        if (container.has(key)) {
            switch (key.getKey()) {
                case "firstjoin":
                    ItemStack firstjoin = new ItemStack(Material.DIAMOND_PICKAXE);
                    ItemMeta firstjoinMeta = firstjoin.getItemMeta();
                    firstjoinMeta.setDisplayName("§a[Welcome to AttackGame]");
                    firstjoinMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for Joining",
                            "§6the server for the first time",
                            "§e----------------------------"));
                    firstjoin.setItemMeta(firstjoinMeta);
                    return firstjoin;
                case "firststone":
                    ItemStack firststone = new ItemStack(Material.COBBLESTONE);
                    ItemMeta firststoneMeta = firststone.getItemMeta();
                    firststoneMeta.setDisplayName("§a[§bMost important thing§a]");
                    firststoneMeta.setLore(List.of(
                            "§e-----------------------------",
                            "§6advancement granted for breaking",
                            "§6your first stone",
                            "§e-----------------------------"));
                    firststone.setItemMeta(firststoneMeta);
                    return firststone;

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
                    quintuplecompressedMeta.setDisplayName("§a[Dense Ingot]");
                    quintuplecompressedMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§69 quadruple compressed cobblestone",
                            "§6to a §4Dense Ingot",
                            "§e----------------------------"));
                    quintuplecompressed.setItemMeta(quintuplecompressedMeta);
                    return quintuplecompressed;
                case "hasteadv":
                    ItemStack potion = new ItemStack(Material.POTION);
                    ItemMeta potionMeta = potion.getItemMeta();
                    potionMeta.setDisplayName("§a[Your first haste potion]");
                    potionMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for",
                            "§atrading 1 Haste Potion",
                            "§e----------------------------"));
                    potion.setItemMeta(potionMeta);
                    return potion;
                default:
                    ItemStack barrier = new ItemStack(Material.BARRIER);
                    ItemMeta barrierMeta = barrier.getItemMeta();
                    barrierMeta.setDisplayName("§c[Unknown Advancement]");
                    barrier.setItemMeta(barrierMeta);
                    return barrier;
            }
        } else {
            ItemStack item = new ItemStack(Material.GRAY_DYE);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("§6Not unlocked yet");
            itemMeta.setLore(List.of("§7???????"));

            item.setItemMeta(itemMeta);

            return item;
        }
    }

    public ItemStack addItem2(NamespacedKey key, PersistentDataContainer container) {
        if (key.getKey().equals("advstoney")) {
            ItemStack nextPage = new ItemStack(Material.COBBLED_DEEPSLATE);
            ItemMeta nextPageMeta = nextPage.getItemMeta();
            nextPageMeta.setDisplayName("§a[§cStoney-§6Advancements§a]");
            nextPage.setItemMeta(nextPageMeta);
            return nextPage;
        }

        if (key.getKey().equals("placeholder")) {
            ItemStack placeholder = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            ItemMeta placeholderMeta = placeholder.getItemMeta();
            placeholderMeta.setDisplayName(" ");
            placeholder.setItemMeta(placeholderMeta);
            return placeholder;
        }

        if (key.getKey().equals("advgrobian")) {
            if (AttackGame.instance.getConfig().getLocation("§cSaved Grobian") != null) {
                ItemStack nextPage = new ItemStack(Material.NETHERRACK);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cSaved Grobian-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (key.getKey().equals("meloger")) {
            if (AttackGame.instance.getConfig().getLocation("§aMeloger") != null) {
                ItemStack nextPage = new ItemStack(Material.MELON);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§aMeloger-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (container.has(key)) {
            switch (key.getKey()) {
                case "firsthoney":
                    ItemStack firsthoney = new ItemStack(Material.HONEY_BOTTLE);
                    ItemMeta firsthoneyMeta = firsthoney.getItemMeta();
                    firsthoneyMeta.setDisplayName("§a[§bHoney is important§a]");
                    firsthoneyMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for ",
                            "§6harvesting your first honey",
                            "§e----------------------------"));
                    firsthoney.setItemMeta(firsthoneyMeta);
                    return firsthoney;
                case "compressedhoney":
                    ItemStack compressedhoney = new ItemStack(Material.HONEY_BLOCK);
                    ItemMeta compressedhoneyMeta = compressedhoney.getItemMeta();
                    compressedhoneyMeta.setDisplayName("§a[Compressed Honey]");
                    compressedhoneyMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§f9 honey blocks§6 to a",
                            "§acompressed honey",
                            "§e----------------------------"));
                    compressedhoney.setItemMeta(compressedhoneyMeta);
                    return compressedhoney;
                case "doublecompressedhoney":
                    ItemStack doublecompressedhoney = new ItemStack(Material.HONEYCOMB_BLOCK);
                    ItemMeta doublecompressedhoneyMeta = doublecompressedhoney.getItemMeta();
                    doublecompressedhoneyMeta.setDisplayName("§a[Double Compressed Honey]");
                    doublecompressedhoneyMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§a9 compressed honey §6to a ",
                            "§3double compressed honey",
                            "§e----------------------------"));
                    doublecompressedhoney.setItemMeta(doublecompressedhoneyMeta);
                    return doublecompressedhoney;
                case "sweethoney":
                    ItemStack sweethoney = new ItemStack(Material.HONEYCOMB);
                    ItemMeta sweethoneyMeta = sweethoney.getItemMeta();
                    sweethoneyMeta.setDisplayName("§6Sweet Honey");
                    sweethoneyMeta.addEnchant(Enchantment.LUCK, 1, false);
                    sweethoneyMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading",
                            "§a9 double compressed honey §6to a",
                            "§asweet honey",
                            "§e----------------------------"));
                    sweethoney.setItemMeta(sweethoneyMeta);
                    return sweethoney;
                case "frogs":
                    ItemStack frogs = new ItemStack(Material.FROG_SPAWN_EGG);
                    ItemMeta frogsMeta = frogs.getItemMeta();
                    frogsMeta.setDisplayName("§a[Frogs]");
                    frogsMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for spawning",
                            "§6a frog",
                            "§e----------------------------"));
                    frogs.setItemMeta(frogsMeta);
                    return frogs;
                default:
                    ItemStack barrier = new ItemStack(Material.BARRIER);
                    ItemMeta barrierMeta = barrier.getItemMeta();
                    barrierMeta.setDisplayName("§c[Unknown Advancement]");
                    barrier.setItemMeta(barrierMeta);
                    return barrier;
            }
        } else {
            ItemStack item = new ItemStack(Material.GRAY_DYE);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("§6Not unlocked yet");
            itemMeta.setLore(List.of("§7???????"));

            item.setItemMeta(itemMeta);

            return item;
        }
    }

    public ItemStack addItem3(NamespacedKey key, PersistentDataContainer container) {
        if (key.getKey().equals("advstoney")) {
            ItemStack nextPage = new ItemStack(Material.COBBLED_DEEPSLATE);
            ItemMeta nextPageMeta = nextPage.getItemMeta();
            nextPageMeta.setDisplayName("§a[§cStoney-§6Advancements§a]");
            nextPage.setItemMeta(nextPageMeta);
            return nextPage;
        }

        if (key.getKey().equals("advimker")) {
            if (AttackGame.instance.getConfig().getLocation("§eImker") != null) {
                ItemStack nextPage = new ItemStack(Material.HONEY_BLOCK);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§eImker-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (key.getKey().equals("meloger")) {
            if (AttackGame.instance.getConfig().getLocation("§aMeloger") != null) {
                ItemStack nextPage = new ItemStack(Material.MELON);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§aMeloger-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (key.getKey().equals("placeholder")) {
            ItemStack placeholder = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            ItemMeta placeholderMeta = placeholder.getItemMeta();
            placeholderMeta.setDisplayName(" ");
            placeholder.setItemMeta(placeholderMeta);
            return placeholder;
        }

        if (container.has(key)) {
            switch (key.getKey()) {
                case "netherquartz":
                    ItemStack netherquartz = new ItemStack(Material.QUARTZ);
                    ItemMeta netherquartzMeta = netherquartz.getItemMeta();
                    netherquartzMeta.setDisplayName("§a[§bNether Quartz§a]");
                    netherquartzMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for ",
                            "§6harvesting your first nether quartz",
                            "§e----------------------------"));
                    netherquartz.setItemMeta(netherquartzMeta);
                    return netherquartz;
                case "goldnugget":
                    ItemStack goldnugget = new ItemStack(Material.GOLD_NUGGET);
                    ItemMeta goldnuggetMeta = goldnugget.getItemMeta();
                    goldnuggetMeta.setDisplayName("§a[§bGold Nugget§a]");
                    goldnuggetMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for ",
                            "§6trading your first gold nugget",
                            "§e----------------------------"));
                    goldnugget.setItemMeta(goldnuggetMeta);
                    return goldnugget;
                case "blazerod":
                    ItemStack blazerod = new ItemStack(Material.BLAZE_ROD);
                    ItemMeta blazerodMeta = blazerod.getItemMeta();
                    blazerodMeta.setDisplayName("§a[§bBlaze Rod§a]");
                    blazerodMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for ",
                            "§6trading your first blaze rod",
                            "§e----------------------------"));
                    blazerod.setItemMeta(blazerodMeta);
                    return blazerod;
                case "netherwart":
                    ItemStack netherwart = new ItemStack(Material.NETHER_WART);
                    ItemMeta netherwartMeta = netherwart.getItemMeta();
                    netherwartMeta.setDisplayName("§a[§bNether Wart§a]");
                    netherwartMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for ",
                            "§6trading your first nether wart",
                            "§e----------------------------"));
                    netherwart.setItemMeta(netherwartMeta);
                    return netherwart;
                case "soulsand":
                    ItemStack soulsand = new ItemStack(Material.SOUL_SAND);
                    ItemMeta soulsandMeta = soulsand.getItemMeta();
                    soulsandMeta.setDisplayName("§a[§bSoul Sand§a]");
                    soulsandMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for ",
                            "§6trading your first soul sand",
                            "§e----------------------------"));
                    soulsand.setItemMeta(soulsandMeta);
                    return soulsand;
                default:
                    ItemStack barrier = new ItemStack(Material.BARRIER);
                    ItemMeta barrierMeta = barrier.getItemMeta();
                    barrierMeta.setDisplayName("§c[Unknown Advancement]");
                    barrier.setItemMeta(barrierMeta);
                    return barrier;
            }
        } else {
            ItemStack item = new ItemStack(Material.GRAY_DYE);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("§6Not unlocked yet");
            itemMeta.setLore(List.of("§7???????"));

            item.setItemMeta(itemMeta);

            return item;
        }
    }

    public ItemStack addItem4(NamespacedKey key, PersistentDataContainer container) {
        if (key.getKey().equals("advstoney")) {
            ItemStack nextPage = new ItemStack(Material.COBBLED_DEEPSLATE);
            ItemMeta nextPageMeta = nextPage.getItemMeta();
            nextPageMeta.setDisplayName("§a[§cStoney-§6Advancements§a]");
            nextPage.setItemMeta(nextPageMeta);
            return nextPage;
        }

        if (key.getKey().equals("advimker")) {
            if (AttackGame.instance.getConfig().getLocation("§eImker") != null) {
                ItemStack nextPage = new ItemStack(Material.HONEY_BLOCK);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§eImker-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (key.getKey().equals("advgrobian")) {
            if (AttackGame.instance.getConfig().getLocation("§cSaved Grobian") != null) {
                ItemStack nextPage = new ItemStack(Material.NETHERRACK);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cSaved Grobian-§6Advancements§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            } else {
                ItemStack nextPage = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta nextPageMeta = nextPage.getItemMeta();
                nextPageMeta.setDisplayName("§a[§cThis Page is not unlocked yet§a]");
                nextPage.setItemMeta(nextPageMeta);
                return nextPage;
            }
        }

        if (key.getKey().equals("placeholder")) {
            ItemStack placeholder = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            ItemMeta placeholderMeta = placeholder.getItemMeta();
            placeholderMeta.setDisplayName(" ");
            placeholder.setItemMeta(placeholderMeta);
            return placeholder;
        }

        if (container.has(key)) {
            switch (key.getKey()) {
                case "firstmelon":
                    ItemStack firstmelon = new ItemStack(Material.MELON);
                    ItemMeta firstmelonMeta = firstmelon.getItemMeta();
                    firstmelonMeta.setDisplayName("§a[§bFirst Melon§a]");
                    firstmelonMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for ",
                            "§6harvesting your first melon",
                            "§e----------------------------"));
                    firstmelon.setItemMeta(firstmelonMeta);
                    return firstmelon;
                case "compressedmelon":
                    ItemStack compressedmelon = new ItemStack(Material.MOSS_BLOCK);
                    ItemMeta compressedmelonMeta = compressedmelon.getItemMeta();
                    compressedmelonMeta.setDisplayName("§a[§bCompressed Melon§a]");
                    compressedmelonMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for ",
                            "§6trading your first compressed melon",
                            "§e----------------------------"));
                    compressedmelon.setItemMeta(compressedmelonMeta);
                    return compressedmelon;
                case "doublecompressedmelon":
                    ItemStack doublecompressedmelon = new ItemStack(Material.MELON_SLICE);
                    ItemMeta doublecompressedmelonMeta = doublecompressedmelon.getItemMeta();
                    doublecompressedmelonMeta.setDisplayName("§a[§bDouble Compressed Melon§a]");
                    doublecompressedmelonMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading ",
                            "§6your first double compressed melon",
                            "§e----------------------------"));
                    doublecompressedmelon.setItemMeta(doublecompressedmelonMeta);
                    return doublecompressedmelon;
                case "triplecompressedmelon":
                    ItemStack triplecompressedmelon = new ItemStack(Material.GLISTERING_MELON_SLICE);
                    ItemMeta triplecompressedmelonMeta = triplecompressedmelon.getItemMeta();
                    triplecompressedmelonMeta.setDisplayName("§a[§bTriple Compressed Melon§a]");
                    triplecompressedmelonMeta.setLore(List.of(
                            "§e----------------------------",
                            "§6advancement granted for trading ",
                            "§6your first triple compressed melon",
                            "§e----------------------------"));
                    triplecompressedmelon.setItemMeta(triplecompressedmelonMeta);
                    return triplecompressedmelon;
                default:
                    ItemStack barrier = new ItemStack(Material.BARRIER);
                    ItemMeta barrierMeta = barrier.getItemMeta();
                    barrierMeta.setDisplayName("§c[Unknown Advancement]");
                    barrier.setItemMeta(barrierMeta);
                    return barrier;
            }
        } else {
            ItemStack item = new ItemStack(Material.GRAY_DYE);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("§6Not unlocked yet");
            itemMeta.setLore(List.of("§7???????"));

            item.setItemMeta(itemMeta);

            return item;
        }
    }
}
