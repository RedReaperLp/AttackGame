package com.github.redreaperlp.attackgame.Commands;

import com.github.redreaperlp.attackgame.AttackGame;
import com.github.redreaperlp.attackgame.Villagers.VillagerManager;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class SetVillagerSpawn {

    public AttackGame plugin;
    public SetVillagerSpawn(AttackGame ourMain) {
        plugin = ourMain;
    }
    public void villagerSpawn(CommandSender sender, String name) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            double x = player.getLocation().getBlockX() + 0.5;
            double y = player.getLocation().getBlockY();
            double z = player.getLocation().getBlockZ() + 0.5;

            Location loc = new Location(player.getWorld(), x, y, z);

            AttackGame attackGame = AttackGame.getInstance();
            attackGame.getConfig().set(name, loc);

            VillagerManager villagerManager = new VillagerManager();
            villagerManager.createVillager(loc, name, Villager.Profession.MASON);

            sender.sendMessage(plugin.prefix, "§eYou have set the Spawnpoint for: " + name, "§eto: §a" + x + " " + y + " " + z);
        }

    }
}
