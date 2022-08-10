package com.github.redreaperlp.attackgame.Commands;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    public AttackGame plugin;

    public MainCommand(AttackGame ourMain) {
        plugin = ourMain;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        CommandMenu commandMenu = new CommandMenu(this.plugin);
        commandMenu.commandMenu((Player) sender);
        return true;
    }
}
