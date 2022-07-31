package com.github.redreaperlp.attackgame.Villagers;

import com.github.redreaperlp.attackgame.AttackGame;
import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Merchant;

public class VillagerTradeRequest implements Listener {

    public AttackGame plugin;

    public VillagerTradeRequest(AttackGame ourMain) {
        plugin = ourMain;
    }

    @EventHandler
    public void onTradeRequest(PlayerInteractEntityEvent e) {
        StoneVillager stoneVillager = new StoneVillager();
        String name = "";
        if (e.getPlayer() == null) {
            return;
        }
        if (e.getRightClicked().getType().toString().equals("VILLAGER")) {
            name = e.getRightClicked().getCustomName();
            if (name == null) {
                return;
            }
            switch (name) {
                case "§cStoney":
                    e.setCancelled(true);
                    Player player = e.getPlayer();
                    stoneVillager.openStoney(player);
                    break;
                default:
                    break;
            }
        }


    }
}
