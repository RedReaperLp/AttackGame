package com.github.redreaperlp.attackgame.Advancements;

import com.github.redreaperlp.attackgame.AttackGame;
import com.github.redreaperlp.attackgame.Villagers.VillagerManager;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Beehive;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.stream.Stream;

public class AdvancementListener implements Listener {

    public AttackGame plugin;

    public AdvancementListener(AttackGame ourMain) {
        plugin = ourMain;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.discoverRecipe(new NamespacedKey(plugin, "Gravel"));
        player.discoverRecipe(new NamespacedKey(plugin, "Sand"));

        PersistentDataContainer container = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, "firstjoin");

        if (!container.has(key)) {
            container.set(key, PersistentDataType.STRING, "firstjoin");
            player.playSound(player.getLocation(), "minecraft:entity.player.levelup", 1, 1);

            ItemStack instantGrowth = new ItemStack(Material.OAK_SAPLING);
            ItemMeta instantGrowthMeta = instantGrowth.getItemMeta();
            instantGrowthMeta.setDisplayName("§aYour First Tree");
            instantGrowthMeta.setLore(List.of("§5Place it at a free space", "§5and it will grow instantly"));
            instantGrowth.setItemMeta(instantGrowthMeta);

            player.getInventory().setItem(0, instantGrowth);
            player.getInventory().setItem(9, new ItemStack(Material.ICE, 1));
            player.getInventory().setItem(10, new ItemStack(Material.LAVA_BUCKET, 1));
            player.getInventory().setItem(13, new ItemStack(Material.MANGROVE_PROPAGULE, 1));
            player.getInventory().setItem(14, new ItemStack(Material.DARK_OAK_SAPLING, 4));
            player.getInventory().setItem(16, new ItemStack(Material.POINTED_DRIPSTONE, 1));
            player.getInventory().setItem(17, new ItemStack(Material.MOSS_BLOCK, 1));
            player.getInventory().setItem(18, new ItemStack(Material.MELON, 1));
            player.getInventory().setItem(19, new ItemStack(Material.PUMPKIN_SEEDS, 1));
            player.getInventory().setItem(22, new ItemStack(Material.BIRCH_SAPLING, 1));
            player.getInventory().setItem(23, new ItemStack(Material.SPRUCE_SAPLING, 1));
            player.getInventory().setItem(25, new ItemStack(Material.CHEST, 1));
            player.getInventory().setItem(26, new ItemStack(Material.GRASS_BLOCK, 64));
            player.getInventory().setItem(27, new ItemStack(Material.SUGAR_CANE, 1));
            player.getInventory().setItem(28, new ItemStack(Material.CACTUS, 1));
            player.getInventory().setItem(31, new ItemStack(Material.JUNGLE_SAPLING, 1));
            player.getInventory().setItem(32, new ItemStack(Material.ACACIA_SAPLING, 1));
            player.getInventory().setItem(34, new ItemStack(Material.WARPED_NYLIUM, 1));
            player.getInventory().setItem(35, new ItemStack(Material.CRIMSON_NYLIUM, 1));

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§6" + player.getName() + " has made the §a[First Join] §6advancement!");
            }
        }
    }

    @EventHandler
    public void invClickEvent(InventoryClickEvent e) {
        if (e.getCurrentItem() != null) {
            if (e.getWhoClicked().getGameMode() == GameMode.SURVIVAL) {
                Player player = (Player) e.getWhoClicked();
                {

                    PersistentDataContainer container = player.getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(plugin, "compressed");
                    if (checkAdv(container, Material.STONE, "§aCompressed Cobblestone", List.of("§5Komprimierter Bruchstein"), key, e.getCurrentItem())) {
                        player.getInventory().addItem(new ItemStack(Material.SHEEP_SPAWN_EGG, 2));
                        container.set(key, PersistentDataType.STRING, "compressed");
                        playSound(player);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage("§6" + player.getName() + " has made the §a[Compressed Cobblestone] §6advancement!");
                        }
                        return;
                    }

                } //Listener for Compressed Advancement
                {

                    PersistentDataContainer container = player.getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(plugin, "doublecompressed");
                    if (checkAdv(container, Material.COBBLED_DEEPSLATE, "§3Double Compressed Cobblestone", List.of("§5Doppelt Komprimierter Bruchstein"), key, e.getCurrentItem())) {
                        player.getInventory().addItem(new ItemStack(Material.CHICKEN_SPAWN_EGG, 2));
                        container.set(key, PersistentDataType.STRING, "doublecompressed");
                        playSound(player);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage("§6" + player.getName() + " has made the §a[Double Compressed Cobblestone] §6advancement!");
                        }
                        return;
                    }

                } //Listener for Double Compressed Advancement
                {

                    PersistentDataContainer container = player.getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(plugin, "triplecompressed");
                    if (checkAdv(container, Material.DEEPSLATE, "§eTriple Compressed Cobblestone", List.of("§5Dreifach Komprimierter Bruchstein"), key, e.getCurrentItem())) {
                        container.set(key, PersistentDataType.STRING, "triplecompressed");
                        playSound(player);
                        player.getInventory().addItem(new ItemStack(Material.COW_SPAWN_EGG, 2));
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage("§6" + player.getName() + " has made the §a[Triple Compressed Cobblestone] §6advancement!");
                        }
                        return;
                    }
                } //Listener for triple Compressed Advancement
                {

                    PersistentDataContainer container = player.getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(plugin, "quadruplecompressed");
                    if (checkAdv(container, Material.POLISHED_DEEPSLATE, "§6Quadruple Compressed Cobblestone", List.of("§5Vierfach Komprimierter Bruchstein"), key, e.getCurrentItem())) {
                        container.set(key, PersistentDataType.STRING, "quadruplecompressed");
                        playSound(player);
                        player.getInventory().addItem(new ItemStack(Material.PIG_SPAWN_EGG, 2));
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage("§6" + player.getName() + " has made the §a[Quadruple Compressed Cobblestone] §6advancement!");
                        }
                        return;
                    }
                } //Listener for Quadruple Compressed Advancement
                {

                    PersistentDataContainer container = player.getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(plugin, "quintuplecompressed");
                    if (checkAdv(container, Material.NETHERITE_INGOT, "§4Dense Ingot", List.of("§5Fünffach Komprimierter Bruchstein"), key, e.getCurrentItem())) {
                        container.set(key, PersistentDataType.STRING, "quintuplecompressed");
                        playSound(player);
                        player.getInventory().addItem(new ItemStack(Material.GOAT_SPAWN_EGG, 2));
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage("§6" + player.getName() + " has made the §a[Dense Ingot] §6advancement!");
                        }
                        return;
                    }
                } //Listener for Quintuple Compressed Advancement
                {

                    PersistentDataContainer container = player.getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(plugin, "hasteadv");
                    if (!container.has(key)) {
                        ItemStack potion = new ItemStack(Material.POTION);
                        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
                        potionMeta.setDisplayName("§eSmall haste Potion (0:15:00)");
                        potionMeta.setLore(List.of("§6Kleine Haste Potion"));
                        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 18000, 0, true), true);
                        potion.setItemMeta(potionMeta);

                        ItemStack potion2 = new ItemStack(Material.POTION);
                        PotionMeta potionMeta2 = (PotionMeta) potion2.getItemMeta();
                        potionMeta2.setDisplayName("§eMedium haste Potion (0:30:00)");
                        potionMeta2.setLore(List.of("§6Mittlere Haste Potion"));
                        potionMeta2.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 36000, 1, true), true);
                        potion2.setItemMeta(potionMeta2);

                        ItemStack potion3 = new ItemStack(Material.POTION);
                        PotionMeta potionMeta3 = (PotionMeta) potion3.getItemMeta();
                        potionMeta3.setDisplayName("§eBig haste Potion (1:00:00)");
                        potionMeta3.setLore(List.of("§6Große Haste Potion"));
                        potionMeta3.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 72000, 2, true), true);
                        potion3.setItemMeta(potionMeta3);

                        if (e.getCurrentItem().isSimilar(potion) || e.getCurrentItem().isSimilar(potion2) || e.getCurrentItem().isSimilar(potion3)) {
                            playSound(player);
                            container.set(key, PersistentDataType.STRING, "hasteadv");
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Haste Potion] §6advancement!");
                            }
                            return;
                        }
                    }
                } //Listener for Haste Advancements


                if (plugin.getConfig().getLocation("§eImker") != null) {
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "compressedhoney");
                        if (checkAdv(container, Material.ORANGE_STAINED_GLASS, "§aCompressed Honey", List.of("§5Komprimierter Honig"), key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "compressedhoney");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Compressed Honey] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for compressed honey
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "doublecompressedhoney");
                        if (checkAdv(container, Material.HONEYCOMB_BLOCK, "§3Double Compressed Honey", List.of("§5Doppelt Komprimierter Honig"), key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "doublecompressedhoney");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Double Compressed Honey] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for double compressed honey

                    {
                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "sweethoney");
                        if (!container.has(key)) {
                            ItemStack sweethoney = new ItemStack(Material.HONEYCOMB);
                            ItemMeta sweethoneyMeta = sweethoney.getItemMeta();
                            sweethoneyMeta.setDisplayName("§6Sweet Honey");
                            sweethoneyMeta.setLore(List.of("§5Eignet sich sehr gut als Köder!"));
                            sweethoneyMeta.addEnchant(Enchantment.LUCK, 100, true);
                            sweethoney.setItemMeta(sweethoneyMeta);
                            if (e.getCurrentItem().isSimilar(sweethoney)) {
                                playSound(player);
                                container.set(key, PersistentDataType.STRING, "sweethoney");
                                for (Player players : Bukkit.getOnlinePlayers()) {
                                    players.sendMessage("§6" + player.getName() + " has made the §a[Sweet Honey] §6advancement!");
                                }
                                return;
                            }
                        }
                    } //Listener for Sweet Honey
                }


                if (plugin.getConfig().getLocation("§cSaved Grobian") != null) {
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "netherquartz");
                        if (checkAdv(container, Material.QUARTZ, null, null, key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "netherquartz");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Nether Quartz] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for Nether Quartz Advancement
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "goldnugget");
                        if (checkAdv(container, Material.GOLD_NUGGET, null, null, key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "goldnugget");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Gold Nugget] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for Gold Nugget Advancement
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "blazerod");
                        if (checkAdv(container, Material.BLAZE_ROD, null, null, key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "blazerod");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Blaze Rod] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for Blaze Rod Advancement
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "netherwart");
                        if (checkAdv(container, Material.NETHER_WART, null, null, key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "netherwart");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Nether Wart] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for Nether Wart Advancement
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "soulsand");
                        if (checkAdv(container, Material.SOUL_SAND, null, null, key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "soulsand");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Soul Sand] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for Soul Sand Advancement
                }

                if (plugin.getConfig().getLocation("§aMeloger") != null) {
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "firstmelon");
                        if (checkAdv(container, Material.MELON_SLICE, null, null, key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "firstmelon");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[First Melon] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for First Melon Advancement
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "compressedmelon");
                        if (checkAdv(container, Material.MOSS_BLOCK, "§aCompressed Melon", List.of("§5Komprimierte Melone"), key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "compressedmelon");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Compressed Melon] §6advancement!");
                            }
                            return;
                        }

                    } //Listener for Compressed Melon Advancement
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "doublecompressedmelon");
                        if (checkAdv(container, Material.MELON_SLICE, "§3Double Compressed Melon", List.of("§5Doppelt Komprimierte Melone"), key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "doublecompressedmelon");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Double Compressed Melon] §6advancement!");
                            }
                        }
                    } //Listener for Double Compressed Melon Advancement
                    {

                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "triplecompressedmelon");
                        if (checkAdv(container, Material.GLISTERING_MELON_SLICE, "§eTriple Compressed Melon", List.of("§5Dreifach Komprimierte Melone"), key, e.getCurrentItem())) {
                            container.set(key, PersistentDataType.STRING, "triplecompressedmelon");
                            playSound(player);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Triple Compressed Melon] §6advancement!");
                            }
                            return;
                        }
                    } //Listener for Triple Compressed Melon
                }
            }
        }
    }

    public boolean checkAdv(PersistentDataContainer container, Material checkForItem, String itemsName, List<String> itemsLore, NamespacedKey key, ItemStack currentItem) {
        if (!container.has(key)) {
            ItemStack item = new ItemStack(checkForItem);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(itemsName);
            itemMeta.setLore(itemsLore);
            item.setItemMeta(itemMeta);
            if (currentItem.isSimilar(item)) {
                return true;
            }
        }
        return false;
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            PersistentDataContainer container = player.getPersistentDataContainer();
            if (e.getBlock().getType() == Material.STONE) {
                NamespacedKey key = new NamespacedKey(plugin, "firststone");
                if (!container.has(key)) {
                    container.set(key, PersistentDataType.STRING, "firststone");
                    playSound(player);
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage("§6" + player.getName() + " has made the §a[First Stone] §6advancement!");
                    }
                }
            }
        }
    }

    @EventHandler
    public void cancelInvClick(InventoryClickEvent e) {
        List<String> titles = Stream.of("§6Advancements §cStoney", "§6Advancements §eImker", "§6Advancements §cSaved Grobian", "§6Advancements §aMeloger").toList();
        if (titles.contains(e.getView().getTitle())) {
            if (e.getCurrentItem() == null) {
                return;
            }
            e.setCancelled(true);

            ItemStack imker = new ItemStack(Material.HONEY_BLOCK);
            ItemMeta imkerMeta = imker.getItemMeta();
            imkerMeta.setDisplayName("§a[§eImker-§6Advancements§a]");
            imker.setItemMeta(imkerMeta);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem().isSimilar(imker)) {
                AdvancementInv advancementInv = new AdvancementInv(this.plugin);
                player.closeInventory();
                advancementInv.invImker(player);
            }

            ItemStack stoney = new ItemStack(Material.COBBLED_DEEPSLATE);
            ItemMeta stoneyMeta = stoney.getItemMeta();
            stoneyMeta.setDisplayName("§a[§cStoney-§6Advancements§a]");
            stoney.setItemMeta(stoneyMeta);
            if (e.getCurrentItem().isSimilar(stoney)) {
                AdvancementInv advancementInv = new AdvancementInv(this.plugin);
                player.closeInventory();
                advancementInv.invStoney(player);
            }

            ItemStack savedgrobian = new ItemStack(Material.NETHERRACK);
            ItemMeta savedgrobianMeta = savedgrobian.getItemMeta();
            savedgrobianMeta.setDisplayName("§a[§cSaved Grobian-§6Advancements§a]");
            savedgrobian.setItemMeta(savedgrobianMeta);
            if (e.getCurrentItem().isSimilar(savedgrobian)) {
                AdvancementInv advancementInv = new AdvancementInv(this.plugin);
                player.closeInventory();
                advancementInv.invGrobian(player);
            }

            ItemStack meloger = new ItemStack(Material.MELON);
            ItemMeta melogerMeta = meloger.getItemMeta();
            melogerMeta.setDisplayName("§a[§aMeloger-§6Advancements§a]");
            meloger.setItemMeta(melogerMeta);
            if (e.getCurrentItem().isSimilar(meloger)) {
                AdvancementInv advancementInv = new AdvancementInv(this.plugin);
                player.closeInventory();
                advancementInv.invMeloger(player);
            }
        }
    }

    public void playSound(Player player) {
        player.playSound(player.getLocation(), "minecraft:entity.player.levelup", 1, 1);
    }

    @EventHandler
    public void onUseItem(PlayerInteractEvent e) {
        ItemStack item = e.getItem();

        if (item != null) {
            {
                ItemStack sapling = new ItemStack(Material.OAK_SAPLING);
                ItemMeta saplingMeta = sapling.getItemMeta();
                saplingMeta.setDisplayName("§aYour First Tree");
                saplingMeta.setLore(List.of("§5Place it at a free space", "§5and it will grow instantly"));
                sapling.setItemMeta(saplingMeta);

                if (e.getInteractionPoint() != null) {
                    if (item.equals(sapling)) {
                        Location interActPoint = e.getInteractionPoint();
                        if (interActPoint != null) {
                            if (interActPoint.getBlock().getType().equals(Material.AIR)) {
                                int x = interActPoint.getBlockX();
                                int y = interActPoint.getBlockY() - 1;
                                int z = interActPoint.getBlockZ();
                                Location loc = new Location(interActPoint.getWorld(), x, y, z);
                                List<Material> validBlocks = List.of(Material.DIRT, Material.GRASS_BLOCK);
                                Material block = loc.getBlock().getType();
                                if (validBlocks.contains(block)) {
                                    y++;
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "place feature minecraft:oak " + x + " " + y + " " + z);
                                    return;
                                }
                            }
                        }
                    }
                }
            } // Listener for Sapling


            {
                int amount = item.getAmount();

                ItemStack imker = new ItemStack(Material.OCELOT_SPAWN_EGG, amount);
                ItemMeta imkerMeta = imker.getItemMeta();
                imkerMeta.setDisplayName("§eHe Works with Bees");
                imkerMeta.setLore(List.of("§5A new Villager"));
                imker.setItemMeta(imkerMeta);

                if (e.getInteractionPoint() != null) {
                    if (item.equals(imker)) {

                        ItemStack imkerRem = new ItemStack(Material.OCELOT_SPAWN_EGG);
                        ItemMeta imkerMetaRem = imker.getItemMeta();
                        imkerMetaRem.setDisplayName("§eHe Works with Bees");
                        imkerMetaRem.setLore(List.of("§5A new Villager"));
                        imkerRem.setItemMeta(imkerMetaRem);

                        e.setCancelled(true);
                        Player player = e.getPlayer();
                        player.getInventory().removeItem(imkerRem);

                        VillagerManager villagerManager = new VillagerManager(AttackGame.instance);
                        double x = e.getInteractionPoint().getBlockX() + 0.5;
                        int y = e.getInteractionPoint().getBlockY();
                        double z = e.getInteractionPoint().getBlockZ() + 0.5;


                        Location loc = new Location(e.getInteractionPoint().getWorld(), x, y, z);

                        if (plugin.getConfig().getLocation("§eImker") == null) {
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§aA new Advancement Page has been unlocked!");
                                playSound(players);
                            }
                        }
                        plugin.getConfig().set("§eImker", loc);
                        villagerManager.createVillager(loc, "§eImker", Villager.Profession.FARMER);
                    }
                }
            } // Listener for Imker


            {
                int amount = item.getAmount();

                ItemStack savedGrobian = new ItemStack(Material.STRIDER_SPAWN_EGG, amount);
                ItemMeta savedGrobianMeta = savedGrobian.getItemMeta();
                savedGrobianMeta.setDisplayName("§cSaved Grobian");
                savedGrobianMeta.setLore(List.of("§5A new Villager"));
                savedGrobian.setItemMeta(savedGrobianMeta);

                if (e.getInteractionPoint() != null) {
                    if (item.equals(savedGrobian)) {
                        ItemStack savedGrobianRem = new ItemStack(Material.STRIDER_SPAWN_EGG);
                        ItemMeta savedGrobianMetaRem = savedGrobian.getItemMeta();
                        savedGrobianMetaRem.setDisplayName("§cSaved Grobian");
                        savedGrobianMetaRem.setLore(List.of("§5A new Villager"));
                        savedGrobianRem.setItemMeta(savedGrobianMetaRem);

                        e.setCancelled(true);
                        Player player = e.getPlayer();
                        player.getInventory().removeItem(savedGrobianRem);

                        VillagerManager villagerManager = new VillagerManager(AttackGame.instance);
                        double x = e.getInteractionPoint().getBlockX() + 0.5;
                        int y = e.getInteractionPoint().getBlockY();
                        double z = e.getInteractionPoint().getBlockZ() + 0.5;

                        Location loc = new Location(e.getInteractionPoint().getWorld(), x, y, z);
                        if (plugin.getConfig().getLocation("§cSaved Grobian") == null) {
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§aA new Advancement Page has been unlocked!");
                                playSound(players);
                            }
                        }
                        plugin.getConfig().set("§cSaved Grobian", loc);
                        villagerManager.createVillager(loc, "§cSaved Grobian", Villager.Profession.WEAPONSMITH);
                    }
                }
            } // Listener for SavedGrobian

            {
                int amount = item.getAmount();

                ItemStack meloger = new ItemStack(Material.PARROT_SPAWN_EGG, amount);
                ItemMeta melogerMeta = meloger.getItemMeta();
                melogerMeta.setDisplayName("§aMeloger");
                melogerMeta.setLore(List.of("§5He Trades Melons!"));
                meloger.setItemMeta(melogerMeta);

                if (e.getInteractionPoint() != null) {
                    if (item.equals(meloger)) {
                        ItemStack melogerRem = new ItemStack(Material.PARROT_SPAWN_EGG);
                        ItemMeta melogerMetaRem = meloger.getItemMeta();
                        melogerMetaRem.setDisplayName("§aMeloger");
                        melogerMetaRem.setLore(List.of("§5He Trades Melons!"));
                        melogerRem.setItemMeta(melogerMetaRem);

                        e.setCancelled(true);
                        Player player = e.getPlayer();
                        player.getInventory().removeItem(melogerRem);

                        VillagerManager villagerManager = new VillagerManager(AttackGame.instance);
                        double x = e.getInteractionPoint().getBlockX() + 0.5;
                        int y = e.getInteractionPoint().getBlockY();
                        double z = e.getInteractionPoint().getBlockZ() + 0.5;

                        Location loc = new Location(e.getInteractionPoint().getWorld(), x, y, z);
                        if (plugin.getConfig().getLocation("§aMeloger") == null) {
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§aA new Advancement Page has been unlocked!");
                                playSound(players);
                            }
                        }
                        plugin.getConfig().set("§aMeloger", loc);
                        villagerManager.createVillager(loc, "§aMeloger", Villager.Profession.FARMER);
                    }
                }
            } // Listener for Meloger

            if (plugin.getConfig().getLocation("§eImker") != null) {
                {
                    Block beesBlock = e.getClickedBlock();
                    Player player = e.getPlayer();
                    PersistentDataContainer container = player.getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(AttackGame.instance, "firsthoney");
                    if (!container.has(key) && player.getGameMode() == GameMode.SURVIVAL) {
                        if (beesBlock != null) {
                            if (beesBlock.getType() == Material.BEE_NEST || beesBlock.getType() == Material.BEEHIVE) {

                                Beehive beehive = (Beehive) beesBlock.getBlockData();
                                if (beehive.getHoneyLevel() == 5) {
                                    if (item.getType() == Material.GLASS_BOTTLE) {
                                        container.set(key, PersistentDataType.STRING, "firsthoney");
                                        playSound(player);
                                        for (Player players : Bukkit.getOnlinePlayers()) {
                                            players.sendMessage("§6" + player.getName() + " has made the §a[First Honey] §6advancement!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                } //Listener for firstHoney}
            }

            {
                int amount = item.getAmount();
                ItemStack desertFrog = new ItemStack(Material.FROG_SPAWN_EGG, amount);
                ItemMeta desertFrogMeta = desertFrog.getItemMeta();
                desertFrogMeta.setDisplayName("§fWhite Frog");
                desertFrogMeta.setLore(List.of("§5This spawns a White Frog"));
                desertFrog.setItemMeta(desertFrogMeta);

                ItemStack plainsFrog = new ItemStack(Material.FROG_SPAWN_EGG, amount);
                ItemMeta plainsFrogMeta = plainsFrog.getItemMeta();
                plainsFrogMeta.setDisplayName("§cBrown Frog");
                plainsFrogMeta.setLore(List.of("§5This spawns a Brown Frog"));
                plainsFrog.setItemMeta(plainsFrogMeta);

                ItemStack mountainsFrog = new ItemStack(Material.FROG_SPAWN_EGG, amount);
                ItemMeta mountainsFrogMeta = mountainsFrog.getItemMeta();
                mountainsFrogMeta.setDisplayName("§aGreen Frog");
                mountainsFrogMeta.setLore(List.of("§5This spawns a Green Frog"));
                mountainsFrog.setItemMeta(mountainsFrogMeta);

                if (e.getInteractionPoint() != null) {
                    if (item.equals(desertFrog)) {
                        ItemStack desertFrogRem = new ItemStack(Material.FROG_SPAWN_EGG);
                        ItemMeta desertFrogMetaRem = desertFrog.getItemMeta();
                        desertFrogMetaRem.setDisplayName("§fWhite Frog");
                        desertFrogMetaRem.setLore(List.of("§5This spawns a White Frog"));
                        desertFrogRem.setItemMeta(desertFrogMetaRem);

                        e.setCancelled(true);
                        Player player = e.getPlayer();
                        player.getInventory().removeItem(desertFrogRem);

                        Location loc = e.getInteractionPoint();
                        Entity entity = loc.getWorld().spawnEntity(loc, EntityType.FROG);
                        Frog frog = (Frog) entity;
                        frog.setVariant(Frog.Variant.WARM);
                        onFrog(player);
                    }
                    if (item.equals(plainsFrog)) {
                        ItemStack plainsFrogRem = new ItemStack(Material.FROG_SPAWN_EGG);
                        ItemMeta plainsFrogMetaRem = plainsFrog.getItemMeta();
                        plainsFrogMetaRem.setDisplayName("§cBrown Frog");
                        plainsFrogMetaRem.setLore(List.of("§5This spawns a Brown Frog"));
                        plainsFrogRem.setItemMeta(plainsFrogMetaRem);

                        e.setCancelled(true);
                        Player player = e.getPlayer();
                        player.getInventory().removeItem(plainsFrogRem);

                        Location loc = e.getInteractionPoint();
                        Entity entity = loc.getWorld().spawnEntity(loc, EntityType.FROG);
                        Frog frog = (Frog) entity;
                        frog.setVariant(Frog.Variant.TEMPERATE);
                        onFrog(player);
                    }
                    if (item.equals(mountainsFrog)) {
                        ItemStack mountainsFrogRem = new ItemStack(Material.FROG_SPAWN_EGG);
                        ItemMeta mountainsFrogMetaRem = mountainsFrog.getItemMeta();
                        mountainsFrogMetaRem.setDisplayName("§aGreen Frog");
                        mountainsFrogMetaRem.setLore(List.of("§5This spawns a Green Frog"));
                        mountainsFrogRem.setItemMeta(mountainsFrogMetaRem);

                        e.setCancelled(true);
                        Player player = e.getPlayer();
                        player.getInventory().removeItem(mountainsFrogRem);

                        Location loc = e.getInteractionPoint();
                        Entity entity = loc.getWorld().spawnEntity(loc, EntityType.FROG);
                        Frog frog = (Frog) entity;
                        frog.setVariant(Frog.Variant.COLD);
                        onFrog(player);
                    }
                }
            } //Listener for Frogs
        }
    }

    public void onFrog(Player player) {
        PersistentDataContainer container = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(AttackGame.instance, "frogs");
        if (!container.has(key) && player.getGameMode() == GameMode.SURVIVAL && plugin.getConfig().getLocation("§eImker") != null) {
            container.set(key, PersistentDataType.STRING, "frogs");
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§6" + player.getName() + " has made the §a[Frogs] §6advancement!");
            }
        }
    }
}
//TODO: in Advancement inv add if statement to check if player has an item in his hand (Inventory Click event)
