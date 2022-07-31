package com.github.redreaperlp.attackgame;

import com.github.redreaperlp.attackgame.Advancements.AdvancementListener;
import com.github.redreaperlp.attackgame.Commands.MainCommand;
import com.github.redreaperlp.attackgame.Villagers.NotToDoWithVillager;
import com.github.redreaperlp.attackgame.Villagers.VillagerManager;
import com.github.redreaperlp.attackgame.Villagers.VillagerTradeRequest;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.stream.Stream;

public final class AttackGame extends JavaPlugin implements Listener {


    public static AttackGame getInstance() {
        return instance;
    }

    public static AttackGame instance;
    public String prefix = "§a[§bRedAttack§a] ";
    public List<String> Villagers = Stream.of("§cStoney").toList();
    public List<String> VillagerNames = Stream.of("Stoney").toList();
    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new VillagerTradeRequest(this), this);
        getServer().getPluginManager().registerEvents(new NotToDoWithVillager(this), this);
        getServer().getPluginManager().registerEvents(new AdvancementListener(this), this);

        getCommand("attackgame").setExecutor(new MainCommand(this));
        getCommand("attackgame").setTabCompleter(new MainCommand(this));


        VillagerManager villagerManager = new VillagerManager();
        for (String checkVillager : Villagers) {
            if (!villagerManager.checkForVillagerLoc(checkVillager)) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.isOp()) {
                        player.sendMessage(prefix + "§eYou have to set the Spawnpoint for: " + checkVillager);
                    }
                }
                console.sendMessage(prefix + "§eYou have to set the Spawnpoint for: " + checkVillager);
            } else {
                Location loc = getConfig().getLocation(checkVillager);
                villagerManager.createVillager(loc, checkVillager, Villager.Profession.MASON);
            }
        }
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
