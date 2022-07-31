package com.github.redreaperlp.attackgame.Advancements;

import com.github.redreaperlp.attackgame.AttackGame;
import com.github.redreaperlp.attackgame.Recepies.Recepies;
import com.github.redreaperlp.attackgame.Villagers.VillagerManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class AdvancementListener implements Listener {

    public AttackGame plugin;

    public AdvancementListener(AttackGame ourMain) {
        plugin = ourMain;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Recepies recepies = new Recepies(plugin);
        recepies.discoverRecepies(player);
        PersistentDataContainer container = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, "firstjoin");

        if (!container.has(key)) {
            container.set(key, PersistentDataType.STRING, "firstjoin");
            player.playSound(player.getLocation(), "minecraft:entity.player.levelup", 1, 1);

            ItemStack instantGrowth = new ItemStack(Material.OAK_SAPLING);
            ItemMeta instantGrowthMeta = instantGrowth.getItemMeta();
            instantGrowthMeta.setDisplayName("§aYour First Tree");
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
                {
                    ItemStack compressed = new ItemStack(Material.STONE);
                    ItemMeta compressedMeta = compressed.getItemMeta();
                    compressedMeta.setDisplayName("§aCompressed Cobblestone");
                    compressedMeta.setLore(List.of("§5Komprimierter Bruchstein"));
                    compressed.setItemMeta(compressedMeta);

                    if (e.getCurrentItem().isSimilar(compressed)) {
                        Player player = (Player) e.getWhoClicked();
                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "compressed");
                        if (!container.has(key)) {
                            container.set(key, PersistentDataType.STRING, "compressed");
                            playSound(player);
                            player.getInventory().addItem(new ItemStack(Material.SHEEP_SPAWN_EGG, 2));
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Compressed Cobblestone] §6advancement!");
                            }
                            return;
                        }
                    }
                } // Listener for Compressed Advancement


                {
                    ItemStack doubleCompressed = new ItemStack(Material.COBBLED_DEEPSLATE);
                    ItemMeta doubleCompressedMeta = doubleCompressed.getItemMeta();
                    doubleCompressedMeta.setDisplayName("§3Double Compressed Cobblestone");
                    doubleCompressedMeta.setLore(List.of("§5Doppelt Komprimierter Bruchstein"));
                    doubleCompressed.setItemMeta(doubleCompressedMeta);

                    if (e.getCurrentItem().isSimilar(doubleCompressed)) {
                        Player player = (Player) e.getWhoClicked();
                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "doublecompressed");
                        if (!container.has(key)) {
                            container.set(key, PersistentDataType.STRING, "doublecompressed");
                            playSound(player);
                            player.getInventory().addItem(new ItemStack(Material.CHICKEN_SPAWN_EGG, 2));
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Double Compressed Cobblestone] §6advancement!");
                            }
                            return;
                        }
                    }
                } // Listener for Double Compressed Advancement


                {
                    ItemStack tripleCompressed = new ItemStack(Material.DEEPSLATE);
                    ItemMeta tripleCompressedMeta = tripleCompressed.getItemMeta();
                    tripleCompressedMeta.setDisplayName("§eTriple Compressed Cobblestone");
                    tripleCompressedMeta.setLore(List.of("§5Dreifach Komprimierter Bruchstein"));
                    tripleCompressed.setItemMeta(tripleCompressedMeta);

                    if (e.getCurrentItem().isSimilar(tripleCompressed)) {
                        Player player = (Player) e.getWhoClicked();
                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "triplecompressed");
                        if (!container.has(key)) {
                            container.set(key, PersistentDataType.STRING, "triplecompressed");
                            playSound(player);
                            player.getInventory().addItem(new ItemStack(Material.COW_SPAWN_EGG, 2));
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Triple Compressed Cobblestone] §6advancement!");
                            }
                            return;
                        }
                    }
                } // Listener for triple Compressed Advancement


                {
                    ItemStack quadrupleCompressed = new ItemStack(Material.POLISHED_DEEPSLATE);
                    ItemMeta quadrupleCompressedMeta = quadrupleCompressed.getItemMeta();
                    quadrupleCompressedMeta.setDisplayName("§6Quadruple Compressed Cobblestone");
                    quadrupleCompressedMeta.setLore(List.of("§5Vierfach Komprimierter Bruchstein"));
                    quadrupleCompressed.setItemMeta(quadrupleCompressedMeta);

                    if (e.getCurrentItem().isSimilar(quadrupleCompressed)) {
                        Player player = (Player) e.getWhoClicked();
                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "quadruplecompressed");
                        if (!container.has(key)) {
                            container.set(key, PersistentDataType.STRING, "quadruplecompressed");
                            playSound(player);
                            player.getInventory().addItem(new ItemStack(Material.PIG_SPAWN_EGG, 2));
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Quadruple Compressed Cobblestone] §6advancement!");
                            }
                            return;
                        }
                    }
                } // Listener for Quadruple Compressed Advancement


                {
                    ItemStack quintupleCompressed = new ItemStack(Material.NETHERITE_INGOT);
                    ItemMeta quintupleCompressedMeta = quintupleCompressed.getItemMeta();
                    quintupleCompressedMeta.setDisplayName("§4Dense Ingot");
                    quintupleCompressedMeta.setLore(List.of("§5Fünffach Komprimierter Bruchstein"));
                    quintupleCompressed.setItemMeta(quintupleCompressedMeta);

                    if (e.getCurrentItem().isSimilar(quintupleCompressed)) {
                        Player player = (Player) e.getWhoClicked();
                        PersistentDataContainer container = player.getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(plugin, "quintuplecompressed");
                        if (!container.has(key)) {
                            container.set(key, PersistentDataType.STRING, "quintuplecompressed");
                            playSound(player);
                            player.getInventory().addItem(new ItemStack(Material.GOAT_SPAWN_EGG, 2));
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("§6" + player.getName() + " has made the §a[Dense Ingot] §6advancement!");
                            }
                            return;
                        }
                    }
                } //Listener for Quintuple Compressed Advancement
            }
        }
    }

    @EventHandler
    public void cancelInvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("§6Advancements")) {
            e.setCancelled(true);
        }
    }

    public void playSound(Player player) {
        player.playSound(player.getLocation(), "minecraft:entity.player.levelup", 1, 1);
    }

    @EventHandler
    public void onUseItem(PlayerInteractEvent e) {
        ItemStack item = e.getItem();
        if (item != null) {
            ItemStack sapling = new ItemStack(Material.OAK_SAPLING);
            ItemMeta saplingMeta = sapling.getItemMeta();
            saplingMeta.setDisplayName("§aYour First Tree");
            sapling.setItemMeta(saplingMeta);

            if (e.getInteractionPoint() != null) {
                if (item.equals(sapling)) {
                    Bukkit.broadcastMessage("Ja");
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
                                Bukkit.broadcastMessage("Richtiger Block");
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "place feature minecraft:oak " + x + " " + y + " " + z);
                                return;
                            }
                        }
                    }
                }
            } // Listener for Sapling
            int amount = item.getAmount();

            ItemStack imker = new ItemStack(Material.OCELOT_SPAWN_EGG, amount);
            ItemMeta imkerMeta = imker.getItemMeta();
            imkerMeta.setDisplayName("§eImker");
            imkerMeta.setLore(List.of("§5A new Villager"));
            imker.setItemMeta(imkerMeta);

            if (e.getInteractionPoint() != null) {
                if (item.equals(imker)) {

                    ItemStack imkerRem = new ItemStack(Material.OCELOT_SPAWN_EGG);
                    ItemMeta imkerMetaRem = imker.getItemMeta();
                    imkerMetaRem.setDisplayName("§eImker");
                    imkerMetaRem.setLore(List.of("§5A new Villager"));
                    imkerRem.setItemMeta(imkerMetaRem);

                    e.setCancelled(true);
                    Player player = e.getPlayer();
                    player.getInventory().removeItem(imkerRem);

                    VillagerManager villagerManager = new VillagerManager();
                    double x = e.getInteractionPoint().getBlockX() + 0.5;
                    int y = e.getInteractionPoint().getBlockY();
                    double z = e.getInteractionPoint().getBlockZ() + 0.5;

                    Location loc = new Location(e.getInteractionPoint().getWorld(), x, y, z);
                    villagerManager.createVillager(loc, "§eImker", Villager.Profession.FARMER);
                }
            }
        }
    }

    public boolean doIt = false;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {

        if (doIt) {
            Player player = e.getPlayer();
            PersistentDataContainer container = player.getPersistentDataContainer();
            for (String key : List.of(
                    "compressed",
                    "doublecompressed",
                    "triplecompressed",
                    "quadruplecompressed",
                    "quintuplecompressed")) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                if (container.has(namespacedKey)) {
                    container.remove(namespacedKey);
                }
            }
        }
    }
}
