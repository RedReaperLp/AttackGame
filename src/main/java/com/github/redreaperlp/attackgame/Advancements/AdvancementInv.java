package com.github.redreaperlp.attackgame.Advancements;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.List;

public class AdvancementInv {
    public AttackGame plugin;

    public AdvancementInv(AttackGame ourMain) {
        plugin = ourMain;
    }

    List<String> advancementsP1 = List.of("firstjoin", "firststone", "compressed", "doublecompressed", "triplecompressed", "quadruplecompressed", "quintuplecompressed", "hasteadv", "placeholder", "advgrobian", "advgrobian", "advgrobian", "advimker", "advimker", "advimker", "meloger", "meloger", "meloger");
    List<String> advancementsP2 = List.of("firsthoney", "compressedhoney", "doublecompressedhoney","sweethoney", "frogs",  "placeholder", "placeholder", "placeholder", "placeholder", "advstoney", "advstoney", "advstoney", "advgrobian", "advgrobian", "advgrobian", "meloger", "meloger", "meloger");
    List<String> advancementsP3 = List.of("netherquartz", "goldnugget", "blazerod", "netherwart", "soulsand", "placeholder", "placeholder", "placeholder", "placeholder", "advstoney", "advstoney", "advstoney", "advimker", "advimker", "advimker", "meloger", "meloger", "meloger");

    List<String> advancementsP4 = List.of("firstmelon", "compressedmelon", "doublecompressedmelon", "triplecompressedmelon", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "advstoney", "advstoney", "advstoney", "advgrobian", "advgrobian", "advgrobian", "advimker", "advimker", "advimker");

    public void invStoney(Player player) {
        Inventory inv = Bukkit.createInventory(null, 18, "§6Advancements §cStoney");
        PersistentDataContainer container = player.getPersistentDataContainer();
        int advancementSize = advancementsP1.size();
        for (int i = 0; i <= advancementSize - 1; i++) {
            NamespacedKey key = new NamespacedKey(plugin, advancementsP1.get(i));
            ItemAdder itemAdder = new ItemAdder();
            inv.setItem(i, itemAdder.addItem(key, container));
        }
        player.openInventory(inv);
    }

    public void invImker(Player player) {
        Inventory inv = Bukkit.createInventory(null, 18, "§6Advancements §eImker");
        PersistentDataContainer container = player.getPersistentDataContainer();
        int advancementSize = advancementsP2.size();
        for (int i = 0; i <= advancementSize - 1; i++) {
            NamespacedKey key = new NamespacedKey(plugin, advancementsP2.get(i));
            ItemAdder itemAdder = new ItemAdder();
            inv.setItem(i, itemAdder.addItem2(key, container));
        }
        player.openInventory(inv);
    }

    public void invGrobian(Player player) {
        Inventory inv = Bukkit.createInventory(null, 18, "§6Advancements §cSaved Grobian");
        PersistentDataContainer container = player.getPersistentDataContainer();
        int advancementSize = advancementsP3.size();
        for (int i = 0; i <= advancementSize - 1; i++) {
            NamespacedKey key = new NamespacedKey(plugin, advancementsP3.get(i));
            ItemAdder itemAdder = new ItemAdder();
            inv.setItem(i, itemAdder.addItem3(key, container));
        }
        player.openInventory(inv);
    }

    public void invMeloger(Player player) {
        Inventory inv = Bukkit.createInventory(null, 18, "§6Advancements §aMeloger");
        PersistentDataContainer container = player.getPersistentDataContainer();
        int advancementSize = advancementsP4.size();
        for (int i = 0; i <= advancementSize - 1; i++) {
            NamespacedKey key = new NamespacedKey(plugin, advancementsP4.get(i));
            ItemAdder itemAdder = new ItemAdder();
            inv.setItem(i, itemAdder.addItem4(key, container));
        }
        player.openInventory(inv);
    }
}
