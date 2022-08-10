package com.github.redreaperlp.attackgame.Villagers;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerTradeRequest implements Listener {

    public AttackGame plugin;

    public VillagerTradeRequest(AttackGame ourMain) {
        plugin = ourMain;
    }

    @EventHandler
    public void onTradeRequest(PlayerInteractEntityEvent e) {
        OpenVillagers openVillagers = new OpenVillagers();
        String name = "";
        if (e.getPlayer() == null) {
            return;
        }
        if (e.getRightClicked().getType().toString().equals("VILLAGER")) {
            name = e.getRightClicked().getCustomName();
            if (name == null) {
                return;
            }
            Player player = e.getPlayer();
            switch (name) {
                case "§cStoney":
                    e.setCancelled(true);
                    openVillagers.openStoney(player);
                    break;
                case "§eImker":
                    e.setCancelled(true);
                    openVillagers.openImker(player);
                    break;
                case "§cSaved Grobian":
                    e.setCancelled(true);
                    openVillagers.openSavedGrobian(player);
                    break;
                case "§aMeloger":
                    e.setCancelled(true);
                    openVillagers.openMeloger(player);
                default:
                    break;
            }
        }


    }
}
