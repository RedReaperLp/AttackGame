package com.github.redreaperlp.attackgame.Commands;

import com.github.redreaperlp.attackgame.Advancements.AdvancementInv;
import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.List;

public class CommandMenu implements Listener {
    public AttackGame plugin;

    public CommandMenu(AttackGame ourMain) {
        plugin = ourMain;
    }

    List<String> Items = List.of("Advancements", "holder", "holder", "holder", "holder", "holder", "holder", "holder", "adminTools");

    public void commandMenu(Player player) {
        Inventory commandMenu = plugin.getServer().createInventory(null, 9, "§6Command Menu");
        for (int i = 0; i <= Items.size() - 1; i++) {
            commandMenu.setItem(i, commandMenuItem(Items.get(i), player));
        }
        player.openInventory(commandMenu);
    }


    List<String> adminToolsList = List.of("Stoney", "Grobian", "Imker", "Meloger", "holder", "holder", "holder", "holder", "removeAdv", "remStoney", "remGrobian", "remImker", "remMeloger", "holder", "holder", "holder", "holder", "holder");

    public void adminTools(Player player) {
        Inventory adminTools = plugin.getServer().createInventory(null, 18, "§6Admin Tools");
        for (int i = 0; i <= adminToolsList.size() - 1; i++) {
            adminTools.setItem(i, commandMenuItem(adminToolsList.get(i), player));
        }
        player.openInventory(adminTools);
    }


    List<String> advancements = List.of("firstjoin", "compressed",
            "doublecompressed", "triplecompressed", "quadruplecompressed", "quintuplecompressed",
            "hasteadv", "firsthoney", "compressedhoney", "doublecompressedhoney", "sweethoney",
            "frogs", "netherquartz", "goldnugget", "blazerod", "soulsand", "netherwart", "firstmelon",
            "compressedmelon", "doublecompressedmelon", "triplecompressedmelon");

    public void removeAdvancementMenu(Player player) {
        Inventory removeAdvancementMenu = plugin.getServer().createInventory(null, 27, "§6Remove Advancement");
        for (int i = 0; i <= advancements.size() - 1; i++) {
            removeAdvancementMenu.setItem(i, advancementItem(player, advancements.get(i)));
        }
        player.openInventory(removeAdvancementMenu);
    }

    public ItemStack advancementItem(Player player, String advancement) {
        ItemStack advancementItem;
        PersistentDataContainer container = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, advancement);
        if (container.has(key)) {
            switch (advancement) {
                case "firstjoin":
                    advancementItem = createCommandMenuItem(Material.DIAMOND_PICKAXE, "§6First Join", List.of("§7Click to remove advancement"));
                    break;
                case "firststone":
                    advancementItem = createCommandMenuItem(Material.COBBLESTONE, "§6First Stone", List.of("§7Click to remove advancement"));
                    break;
                case "firsthoney":
                    advancementItem = createCommandMenuItem(Material.HONEY_BOTTLE, "§6First Honey", List.of("§7Click to remove advancement"));
                    break;
                case "firstmelon":
                    advancementItem = createCommandMenuItem(Material.MELON, "§6First Melon", List.of("§7Click to remove advancement"));
                    break;
                case "compressed":
                    advancementItem = createCommandMenuItem(Material.STONE, "§6Compressed Stone", List.of("§7Click to remove advancement"));
                    break;
                case "doublecompressed":
                    advancementItem = createCommandMenuItem(Material.COBBLED_DEEPSLATE, "§6Double Compressed Stone", List.of("§7Click to remove advancement"));
                    break;
                case "triplecompressed":
                    advancementItem = createCommandMenuItem(Material.DEEPSLATE, "§6Triple Compressed Stone", List.of("§7Click to remove advancement"));
                    break;
                case "quadruplecompressed":
                    advancementItem = createCommandMenuItem(Material.POLISHED_DEEPSLATE, "§6Quadruple Compressed Stone", List.of("§7Click to remove advancement"));
                    break;
                case "quintuplecompressed":
                    advancementItem = createCommandMenuItem(Material.NETHERITE_INGOT, "§6Quintuple Compressed Stone", List.of("§7Click to remove advancement"));
                    break;
                case "hasteadv":
                    advancementItem = createCommandMenuItem(Material.POTION, "§6Haste Advancement", List.of("§7Click to remove advancement"));
                    break;
                case "compressedhoney":
                    advancementItem = createCommandMenuItem(Material.ORANGE_STAINED_GLASS, "§6Compressed Honey", List.of("§7Click to remove advancement"));
                    break;
                case "doublecompressedhoney":
                    advancementItem = createCommandMenuItem(Material.HONEYCOMB_BLOCK, "§6Double Compressed Honey", List.of("§7Click to remove advancement"));
                    break;
                case "sweethoney":
                    advancementItem = createCommandMenuItem(Material.HONEYCOMB, "§6Sweet Honey", List.of("§7Click to remove advancement"));
                    break;
                case "frogs":
                    advancementItem = createCommandMenuItem(Material.FROG_SPAWN_EGG, "§6Frog", List.of("§7Click to remove advancement"));
                    break;
                case "netherquartz":
                    advancementItem = createCommandMenuItem(Material.QUARTZ, "§6Nether Quartz", List.of("§7Click to remove advancement"));
                    break;
                case "goldnugget":
                    advancementItem = createCommandMenuItem(Material.GOLD_NUGGET, "§6Gold Nugget", List.of("§7Click to remove advancement"));
                    break;
                case "blazerod":
                    advancementItem = createCommandMenuItem(Material.BLAZE_ROD, "§6Blaze Rod", List.of("§7Click to remove advancement"));
                    break;
                case "soulsand":
                    advancementItem = createCommandMenuItem(Material.SOUL_SAND, "§6Soul Sand", List.of("§7Click to remove advancement"));
                    break;
                case "netherwart":
                    advancementItem = createCommandMenuItem(Material.NETHER_WART, "§6Nether Wart", List.of("§7Click to remove advancement"));
                    break;
                case "compressedmelon":
                    advancementItem = createCommandMenuItem(Material.MOSS_BLOCK, "§6Compressed Melon", List.of("§7Click to remove advancement"));
                    break;
                case "doublecompressedmelon":
                    advancementItem = createCommandMenuItem(Material.MELON_SLICE, "§6Double Compressed Melon", List.of("§7Click to remove advancement"));
                    break;
                case "triplecompressedmelon":
                    advancementItem = createCommandMenuItem(Material.GLISTERING_MELON_SLICE, "§6Triple Compressed Melon", List.of("§7Click to remove advancement"));
                    break;
                default:
                    advancementItem = createCommandMenuItem(Material.BARRIER, "§cUnknown Advancement", null);
                    break;
            }
        } else {
            advancementItem = createCommandMenuItem(Material.GRAY_DYE, "§eYou haven't got this advancement yet", List.of("§e?????"));
        }
        return advancementItem;
    }


    public ItemStack commandMenuItem(String item, Player player) {
        ItemStack doneItem;
        switch (item) {
            case "adminTools":
                doneItem = createCommandMenuItem(Material.COMMAND_BLOCK, "§cAdmin Tools", player.hasPermission("attackgame.admintools") ? List.of("§7Click to open the Admin Tools") : noPerm());
                break;
            case "Advancements":
                doneItem = createCommandMenuItem(Material.GOLD_INGOT, "§6Advancement Menu", List.of("§7Click to open the Advancement Menu"));
                break;
            case "holder":
                doneItem = createCommandMenuItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " ", null);
                break;
            case "removeAdv":
                doneItem = createCommandMenuItem(Material.REDSTONE_BLOCK, "§6Remove Advancement", List.of("§7Click to remove Advancements"));
                break;
            case "Stoney":
                doneItem = createCommandMenuItem(Material.SILVERFISH_SPAWN_EGG, "§6Place §cStoney", player.hasPermission("attackgame.admintools.stoney") ? List.of("§7Click to place Stoney") : noPerm());
                break;
            case "Grobian":
                doneItem = createCommandMenuItem(Material.STRIDER_SPAWN_EGG, "§6Place §cGrobian", player.hasPermission("attackgame.admintools.grobian") ? List.of("§7Click to place Grobian") : noPerm());
                break;
            case "Imker":
                doneItem = createCommandMenuItem(Material.OCELOT_SPAWN_EGG, "§6Place §eImker", player.hasPermission("attackgame.admintools.imker") ? List.of("§7Click to place Imker") : noPerm());
                break;
            case "Meloger":
                doneItem = createCommandMenuItem(Material.PARROT_SPAWN_EGG, "§6Place §aMeloger", player.hasPermission("attackgame.admintools.meloger") ? List.of("§7Click to place Meloger") : noPerm());
                break;
            case "remStoney":
                doneItem = createCommandMenuItem(Material.SILVERFISH_SPAWN_EGG, "§6Remove §cStoney", player.hasPermission("attackgame.admintools.stoney") ? List.of("§7Click to remove Stoney") : noPerm());
                break;
            case "remGrobian":
                doneItem = createCommandMenuItem(Material.STRIDER_SPAWN_EGG, "§6Remove §cGrobian", player.hasPermission("attackgame.admintools.grobian") ? List.of("§7Click to remove Grobian") : noPerm());
                break;
            case "remImker":
                doneItem = createCommandMenuItem(Material.OCELOT_SPAWN_EGG, "§6Remove §eImker", player.hasPermission("attackgame.admintools.imker") ? List.of("§7Click to remove Imker") : noPerm());
                break;
            case "remMeloger":
                doneItem = createCommandMenuItem(Material.PARROT_SPAWN_EGG, "§6Remove §aMeloger", player.hasPermission("attackgame.admintools.meloger") ? List.of("§7Click to remove Meloger") : noPerm());
                break;
            default:
                doneItem = createCommandMenuItem(Material.BARRIER, "§cUnknown Service", null);
                break;
        }
        return doneItem;
    }

    public ItemStack createCommandMenuItem(Material item, String displayName, List<String> lore) {
        ItemStack commandMenuItem = new ItemStack(item);
        ItemMeta commandMenuItemMeta = commandMenuItem.getItemMeta();
        commandMenuItemMeta.setDisplayName(displayName);
        commandMenuItemMeta.setLore(lore);
        commandMenuItem.setItemMeta(commandMenuItemMeta);
        return commandMenuItem;
    }
    
    @EventHandler
    public void onClickEvent(InventoryClickEvent e) {
        List<String> invs = List.of("§6Command Menu", "§6Admin Tools", "§6Remove Advancement");
        if (invs.contains(e.getView().getTitle())) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Player player = (Player) e.getWhoClicked();
                SetVillagerSpawn setVillagerSpawn = new SetVillagerSpawn(plugin);
                ItemStack clickedItem = e.getCurrentItem();

                {
                    ItemStack advMenu = createCommandMenuItem(Material.GOLD_INGOT, "§6Advancement Menu", List.of("§7Click to open the Advancement Menu"));
                    if (clickedItem.isSimilar(advMenu)) {
                        AdvancementInv advancementInv = new AdvancementInv(plugin);
                        advancementInv.invStoney(player);
                        return;
                    }
                } //Listener for going to Advancement Menu
                {
                    ItemStack stoney = createCommandMenuItem(Material.SILVERFISH_SPAWN_EGG, "§6Place §cStoney", List.of("§7Click to place Stoney"));
                    if (clickedItem.isSimilar(stoney)) {
                        setVillagerSpawn.villagerSpawn(player, "§cStoney");
                        return;
                    }
                } //Listener for placing Stoney
                {
                    ItemStack grobian = createCommandMenuItem(Material.STRIDER_SPAWN_EGG, "§6Place §cGrobian", List.of("§7Click to place Grobian"));
                    if (clickedItem.isSimilar(grobian)) {
                        setVillagerSpawn.villagerSpawn(player, "§cSaved Grobian");
                        return;
                    }
                } //Listener for placing Grobian
                {
                    ItemStack imker = createCommandMenuItem(Material.OCELOT_SPAWN_EGG, "§6Place §eImker", List.of("§7Click to place Imker"));
                    if (clickedItem.isSimilar(imker)) {
                        setVillagerSpawn.villagerSpawn(player, "§eImker");
                        return;
                    }
                } //Listener for placing Imker
                {
                    ItemStack meloger = createCommandMenuItem(Material.PARROT_SPAWN_EGG, "§6Place §aMeloger", List.of("§7Click to place Meloger"));
                    if (clickedItem.isSimilar(meloger)) {
                        setVillagerSpawn.villagerSpawn(player, "§aMeloger");
                        return;
                    }
                } //Listener for placing Meloger

                {
                    ItemStack remStoney = createCommandMenuItem(Material.SILVERFISH_SPAWN_EGG, "§6Remove §cStoney", List.of("§7Click to remove Stoney"));
                    if (clickedItem.isSimilar(remStoney)) {
                        remVillager(player, "§cStoney");
                        return;
                    }
                } //Listener for removing Stoney
                {
                    ItemStack remGrobian = createCommandMenuItem(Material.STRIDER_SPAWN_EGG, "§6Remove §cGrobian", List.of("§7Click to remove Grobian"));
                    if (clickedItem.isSimilar(remGrobian)) {
                        remVillager(player, "§cSaved Grobian");
                        return;
                    }
                } //Listener for removing Grobian
                {
                    ItemStack remImker = createCommandMenuItem(Material.OCELOT_SPAWN_EGG, "§6Remove §eImker", List.of("§7Click to remove Imker"));
                    if (clickedItem.isSimilar(remImker)) {
                        remVillager(player, "§eImker");
                        return;
                    }
                } //Listener for removing Imker
                {
                    ItemStack remMeloger = createCommandMenuItem(Material.PARROT_SPAWN_EGG, "§6Remove §aMeloger", List.of("§7Click to remove Meloger"));
                    if (clickedItem.isSimilar(remMeloger)) {
                        remVillager(player, "§aMeloger");
                        return;
                    }
                } //Listener for removing Meloger

                {
                    ItemStack removeAdv = createCommandMenuItem(Material.REDSTONE_BLOCK, "§6Remove Advancement", List.of("§7Click to remove Advancements"));
                    if (clickedItem.isSimilar(removeAdv)) {
                        removeAdvancementMenu(player);
                        return;
                    }
                } //Listener for removing Advancements
                {
                    ItemStack adminToolsItem = createCommandMenuItem(Material.COMMAND_BLOCK, "§cAdmin Tools", List.of("§7Click to open the Admin Tools"));
                    if (clickedItem.isSimilar(adminToolsItem)) {
                        adminTools(player);
                        return;
                    }
                } //Listener for going to Admin Tools


                {
                    ItemStack remfirstjoin = createCommandMenuItem(Material.DIAMOND_PICKAXE, "§6First Join", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(remfirstjoin)) {
                        removeAdvancements(player, "firstjoin");
                        return;
                    }
                } //Listener for removing first join
                {
                    ItemStack remcompressed = createCommandMenuItem(Material.STONE, "§6Compressed Stone", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(remcompressed)) {
                        removeAdvancements(player, "compressed");
                        return;
                    }
                } //Listener for removing compressed
                {
                    ItemStack doublecompressed = createCommandMenuItem(Material.COBBLED_DEEPSLATE, "§6Double Compressed Stone", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(doublecompressed)) {
                        removeAdvancements(player, "doublecompressed");
                        return;
                    }
                } //Listener for removing doublecompressed
                {
                    ItemStack triplecompressed = createCommandMenuItem(Material.DEEPSLATE, "§6Triple Compressed Stone", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(triplecompressed)) {
                        removeAdvancements(player, "triplecompressed");
                        return;
                    }
                } //Listener for removing triplecompressed
                {
                    ItemStack quadruplecompressed = createCommandMenuItem(Material.POLISHED_DEEPSLATE, "§6Quadruple Compressed Stone", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(quadruplecompressed)) {
                        removeAdvancements(player, "quadruplecompressed");
                        return;
                    }
                } //Listener for removing quadruplecompressed
                {
                    ItemStack quintuplecompressed = createCommandMenuItem(Material.NETHERITE_INGOT, "§6Quintuple Compressed Stone", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(quintuplecompressed)) {
                        removeAdvancements(player, "quintuplecompressed");
                        return;
                    }
                } //Listener for removing quintuplecompressed
                {
                    ItemStack haste = createCommandMenuItem(Material.POTION, "§6Haste Advancement", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(haste)) {
                        removeAdvancements(player, "hasteadv");
                        return;
                    }
                } //Listener for removing haste
                {
                    ItemStack firsthoney = createCommandMenuItem(Material.HONEY_BOTTLE, "§6First Honey", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(firsthoney)) {
                        removeAdvancements(player, "firsthoney");
                        return;
                    }
                } //Listener for removing firsthoney
                {
                    ItemStack compressedhoney = createCommandMenuItem(Material.ORANGE_STAINED_GLASS, "§6Compressed Honey", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(compressedhoney)) {
                        removeAdvancements(player, "compressedhoney");
                        return;
                    }
                } //Listener for removing compressedhoney
                {
                    ItemStack doublecompressedhoney = createCommandMenuItem(Material.HONEYCOMB_BLOCK, "§6Double Compressed Honey", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(doublecompressedhoney)) {
                        removeAdvancements(player, "doublecompressedhoney");
                        return;
                    }
                } //Listener for removing doublecompressedhoney
                {
                    ItemStack sweethoney = createCommandMenuItem(Material.HONEYCOMB, "§6Sweet Honey", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(sweethoney)) {
                        removeAdvancements(player, "sweethoney");
                        return;
                    }
                } //Listener for removing sweethoney
                {
                    ItemStack frog = createCommandMenuItem(Material.FROG_SPAWN_EGG, "§6Frog", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(frog)) {
                        removeAdvancements(player, "frogs");
                        return;
                    }
                } //Listener for removing frogs
                {
                    ItemStack Quartz = createCommandMenuItem(Material.QUARTZ, "§6Nether Quartz", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(Quartz)) {
                        removeAdvancements(player, "netherquartz");
                        return;
                    }
                } //Listener for removing quartz
                {
                    ItemStack goldnuggets = createCommandMenuItem(Material.GOLD_NUGGET, "§6Gold Nugget", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(goldnuggets)) {
                        removeAdvancements(player, "goldnugget");
                        return;
                    }
                } //Listener for removing goldnuggets
                {
                    ItemStack blaze = createCommandMenuItem(Material.BLAZE_ROD, "§6Blaze Rod", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(blaze)) {
                        removeAdvancements(player, "blazerod");
                        return;
                    }
                } //Listener for removing blazerod
                {
                    ItemStack soulsand = createCommandMenuItem(Material.SOUL_SAND, "§6Soul Sand", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(soulsand)) {
                        removeAdvancements(player, "soulsand");
                        return;
                    }
                } //Listener for removing soulsand
                {
                    ItemStack netherwart = createCommandMenuItem(Material.NETHER_WART, "§6Nether Wart", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(netherwart)) {
                        removeAdvancements(player, "netherwart");
                        return;
                    }
                } //Listener for removing netherwart
                {
                    ItemStack firstMelon = createCommandMenuItem(Material.MELON, "§6First Melon", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(firstMelon)) {
                        removeAdvancements(player, "firstmelon");
                        return;
                    }
                } //Listener for removing firstmelon
                {
                    ItemStack compressedMelon = createCommandMenuItem(Material.MOSS_BLOCK, "§6Compressed Melon", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(compressedMelon)) {
                        removeAdvancements(player, "compressedmelon");
                        return;
                    }
                } //Listener for removing compressedmelon
                {
                    ItemStack doublecompressedMelon = createCommandMenuItem(Material.MELON_SLICE, "§6Double Compressed Melon", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(doublecompressedMelon)) {
                        removeAdvancements(player, "doublecompressedmelon");
                        return;
                    }
                } //Listener for removing doublecompressedmelon
                {
                    ItemStack triplecompressedMelon = createCommandMenuItem(Material.GLISTERING_MELON_SLICE, "§6Triple Compressed Melon", List.of("§7Click to remove advancement"));
                    if (clickedItem.isSimilar(triplecompressedMelon)) {
                        removeAdvancements(player, "triplecompressedmelon");
                        return;
                    }
                } //Listener for removing triplecompressedmelon

            }
        }
    }

    public void removeAdvancements(Player player, String advancement) {
        PersistentDataContainer container = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, advancement);
        if (container.has(key)) {
            container.remove(key);
            player.sendMessage("§aRemoved " + advancement + " advancement");
        } else {
            player.sendMessage("§cYou don't have that advancement");
        }
        container.remove(key);
    }

    public List<String> noPerm() {
        return List.of("§cYou don't have permission to use this");
    }

    public void remVillager(Player player, String villagerString) {
        List<Entity> entities = player.getWorld().getEntities();
        for (Entity entity : entities) {
            if (entity instanceof Villager) {
                Villager villager = (Villager) entity;
                if (villager.getCustomName() != null) {
                    if (villager.getCustomName().equals(villagerString)) {
                        villager.remove();
                        plugin.getConfig().set(villagerString, null);
                        plugin.saveConfig();
                    }
                }
            }
        }
    }
}
