package com.github.redreaperlp.attackgame.Commands;

import com.github.redreaperlp.attackgame.AttackGame;
import com.github.redreaperlp.attackgame.Villagers.VillagerManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class SetVillagerSpawn {

    public AttackGame plugin;

    public SetVillagerSpawn(AttackGame ourMain) {
        plugin = ourMain;
    }

    public void villagerSpawn(Player player, String name) {

        double x = player.getLocation().getBlockX() + 0.5;
        double y = player.getLocation().getBlockY();
        double z = player.getLocation().getBlockZ() + 0.5;

        Location loc = new Location(player.getWorld(), x, y, z);

        AttackGame attackGame = AttackGame.getInstance();
        attackGame.reloadConfig();
        attackGame.getConfig().set(name, loc);
        attackGame.saveConfig();
        attackGame.reloadConfig();

        VillagerManager villagerManager = new VillagerManager(plugin);
        switch (name) {
            case "§cStoney":
                villagerManager.createVillager(loc, "§cStoney", Villager.Profession.MASON);
                break;
            case "§eImker":
                villagerManager.createVillager(loc, "§eImker", Villager.Profession.FARMER);
                break;
            case "§cSaved Grobian":
                villagerManager.createVillager(loc, "§cSaved Grobian", Villager.Profession.WEAPONSMITH);
                break;
            case "§aMeloger":
                villagerManager.createVillager(loc, "§aMeloger", Villager.Profession.FARMER);
                break;
        }
        player.sendMessage(plugin.prefix, "§eYou have set the Spawnpoint for: " + name, "§eto: §a" + x + " " + y + " " + z);
    }
}
