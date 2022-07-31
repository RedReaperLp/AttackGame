package com.github.redreaperlp.attackgame.Listener;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

public class DefaultInventoryOnPlayerJoin implements Listener {
    public AttackGame plugin;
    public DefaultInventoryOnPlayerJoin(AttackGame ourMain) {
        plugin = ourMain;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        player.getInventory().clear();
        PersistentDataContainer container = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, "firstjoin");
        if (container.has(key)) {
            container.remove(key);
        }

    }
}
