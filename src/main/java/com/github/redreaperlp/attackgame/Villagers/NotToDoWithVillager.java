package com.github.redreaperlp.attackgame.Villagers;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Bat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;

import java.util.List;

public class NotToDoWithVillager implements Listener {

    public AttackGame plugin;

    public NotToDoWithVillager(AttackGame ourMain) {
        plugin = ourMain;
    }

    @EventHandler
    public void moveVillager(VehicleEnterEvent e) {
        String name = e.getEntered().getCustomName();
        if (name == null) {
            return;
        }
        if (List.of("§cStoney", "§eImker", "§cSaved Grobian", "§aMeloger").contains(name)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity().getCustomName() != null) {
            if (plugin.getConfig().getLocation(e.getEntity().getCustomName()) != null) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        if (e.getEntity() instanceof Bat) {
            int x = e.getLocation().getBlockX();
            int y = e.getLocation().getBlockY();
            int z = e.getLocation().getBlockZ();

            Bukkit.broadcastMessage("§3Bat at " + x + " " + y + " " + z);
            e.setCancelled(true);
        }
    }
}
