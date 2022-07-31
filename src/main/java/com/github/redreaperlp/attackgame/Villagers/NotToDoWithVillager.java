package com.github.redreaperlp.attackgame.Villagers;

import com.github.redreaperlp.attackgame.AttackGame;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;

import java.util.List;
import java.util.stream.Stream;

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
        if (List.of("§cStoney").contains(name)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (Stream.of("§cStoney").anyMatch(name -> name.equals(e.getEntity().getCustomName()))) {
            e.setCancelled(true);
            return;
        }
    }
}
