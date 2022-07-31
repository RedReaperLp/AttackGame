package com.github.redreaperlp.attackgame.Commands;

import com.github.redreaperlp.attackgame.Advancements.AdvancementInv;
import com.github.redreaperlp.attackgame.Advancements.AdvancementListener;
import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class MainCommand implements CommandExecutor, TabCompleter {

    public AttackGame plugin;

    public MainCommand(AttackGame ourMain) {
        plugin = ourMain;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        SetVillagerSpawn setVillagerSpawn = new SetVillagerSpawn(this.plugin);
        if (args.length == 0) {
            sender.sendMessage(plugin.prefix + "§cThis is not a valid Command!");
            return true;
        }
        switch (args[0].toLowerCase(Locale.ROOT)) {
            case "setvillagerspawn":
                if (args.length >= 2) {
                    switch (args[1].toLowerCase(Locale.ROOT)) {
                        case "stoney":
                            setVillagerSpawn.villagerSpawn(sender, "§cStoney");
                            break;
                        default:
                            sender.sendMessage(plugin.prefix + "§cThis is not a valid Name!");
                            break;
                    }
                } else {
                    sender.sendMessage(plugin.prefix + "§cThis is not a valid Name!");
                    break;
                }
                break;
            case "advancements":
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    AdvancementInv advancementInv = new AdvancementInv(this.plugin);
                    advancementInv.Inventory(player);
                }
                break;
            case "remadv":
                AdvancementListener advancementListener = new AdvancementListener(this.plugin);
                advancementListener.doIt = !advancementListener.doIt;
                break;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        String value = args[0].toLowerCase(Locale.ROOT);
        if (args.length == 1) {
            List<String> completions = Stream.of("setVillagerSpawn", "advancements", "remAdv").filter(s -> s.toLowerCase(Locale.ROOT).startsWith(value)).toList();
            return completions;
        }
        if (args.length == 2) {
            if (args[0].toLowerCase(Locale.ROOT).equals("setvillagerspawn")) {
                String value2 = args[1].toLowerCase(Locale.ROOT);
                List<String> completions = Stream.of("Stoney").filter(s -> s.toLowerCase(Locale.ROOT).startsWith(value2)).toList();
                return completions;
            }

        }

        return List.of();
    }
}
