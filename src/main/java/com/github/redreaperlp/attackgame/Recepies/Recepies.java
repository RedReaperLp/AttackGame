package com.github.redreaperlp.attackgame.Recepies;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.List;

public class Recepies {
    public AttackGame plugin;

    public Recepies(AttackGame ourMain) {
        plugin = ourMain;
    }

    public void addRecepie() {
        NamespacedKey sand = new NamespacedKey(plugin, "Gravel");
        ShapedRecipe sandRecipe = new ShapedRecipe(sand, new ItemStack(Material.GRAVEL, 2));
        sandRecipe.shape("SS", "SS");
        sandRecipe.setIngredient('S', Material.COBBLESTONE);

        Bukkit.addRecipe(sandRecipe);


        NamespacedKey gravel = new NamespacedKey(plugin, "Sand");
        ShapedRecipe gravelRecipe = new ShapedRecipe(gravel, new ItemStack(Material.SAND, 2));
        gravelRecipe.shape("ST", "ST");
        gravelRecipe.setIngredient('S', Material.GRAVEL);
        gravelRecipe.setIngredient('T', Material.COBBLESTONE);

        Bukkit.addRecipe(gravelRecipe);
    }

    public void discoverRecepies(Player player){
        List<String> recepies = List.of("Sand", "Gravel");

        for (String recepie : recepies) {
            NamespacedKey key = new NamespacedKey(plugin, recepie);
            if (!player.discoverRecipe(key)) {
                player.discoverRecipe(key);
            }
        }
    }
}
