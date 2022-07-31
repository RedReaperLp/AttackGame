package com.github.redreaperlp.attackgame.Advancements;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.List;

public class AdvancementInv {
    public AttackGame plugin;

    public AdvancementInv(AttackGame ourMain) {
        plugin = ourMain;
    }

    List<String> advancements = List.of("firstjoin",
            "compressed",
            "doublecompressed",
            "triplecompressed",
            "quadruplecompressed",
            "quintuplecompressed",
            "placeholder",
            "placeholder",
            "placeholder");

    public void Inventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 18, "§6Advancements");
        PersistentDataContainer container = player.getPersistentDataContainer();
        int advancementSize = advancements.size();
        for (int i = 0; i <= advancementSize - 1; i++) {
            NamespacedKey key = new NamespacedKey(plugin, advancements.get(i));
            ItemAdder itemAdder = new ItemAdder();
            inv.setItem(i, itemAdder.addItem(key, container));
        }
        player.openInventory(inv);
    }
}
