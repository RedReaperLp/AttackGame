package com.github.redreaperlp.attackgame;

import com.github.redreaperlp.attackgame.Advancements.AdvancementListener;
import com.github.redreaperlp.attackgame.Commands.CommandMenu;
import com.github.redreaperlp.attackgame.Commands.MainCommand;
import com.github.redreaperlp.attackgame.Listener.FishingListener;
import com.github.redreaperlp.attackgame.Recepies.Recepies;
import com.github.redreaperlp.attackgame.Villagers.NotToDoWithVillager;
import com.github.redreaperlp.attackgame.Villagers.VillagerManager;
import com.github.redreaperlp.attackgame.Villagers.VillagerTradeRequest;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AttackGame extends JavaPlugin implements Listener {


    public static AttackGame getInstance() {
        return instance;
    }

    public static AttackGame instance;
    public String prefix = "§a[§bRedAttack§a] ";

    public ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new VillagerTradeRequest(this), this);
        getServer().getPluginManager().registerEvents(new NotToDoWithVillager(this), this);
        getServer().getPluginManager().registerEvents(new AdvancementListener(this), this);
        getServer().getPluginManager().registerEvents(new CommandMenu(this), this);
        getServer().getPluginManager().registerEvents(new FishingListener(this), this);

        getCommand("attackgame").setExecutor(new MainCommand(this));

        Recepies recepies = new Recepies(this);
        recepies.addRecepie();


        VillagerManager villagerManager = new VillagerManager(AttackGame.instance);
        villagerManager.spawnVillager();

        for (Player player : Bukkit.getOnlinePlayers()) {
            recepies.overRecepies(player);
        }

        lightLevel();
    }

    @Override
    public void onDisable() {

    }

    public void lightLevel() {
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                Location loc = player.getLocation();
                int lightLevel = loc.getBlock().getLightLevel();
                if (lightLevel < 7) {
                    player.sendActionBar("§c" + lightLevel);
                } else {
                    player.sendActionBar(" ");
                }
            }
        }, 0, 5);
    }
}
