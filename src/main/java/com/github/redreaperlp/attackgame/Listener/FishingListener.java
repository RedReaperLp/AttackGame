package com.github.redreaperlp.attackgame.Listener;

import com.github.redreaperlp.attackgame.AttackGame;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class FishingListener implements Listener {

    public AttackGame plugin;

    public FishingListener(AttackGame ourMain) {
        plugin = ourMain;
    }

    @EventHandler
    public void onFishing(PlayerFishEvent e) {

        if (e.getState().toString().equals("CAUGHT_FISH")) {
            ItemStack offhand = e.getPlayer().getInventory().getItemInOffHand();

            ItemStack sweethoney = new ItemStack(Material.HONEYCOMB);
            ItemMeta sweethoneyMeta = sweethoney.getItemMeta();
            sweethoneyMeta.setDisplayName("§6Sweet Honey");
            sweethoneyMeta.setLore(List.of("§5Eignet sich sehr gut als Köder!"));
            sweethoneyMeta.addEnchant(Enchantment.LUCK, 100, true);
            sweethoney.setItemMeta(sweethoneyMeta);
            if (e.getCaught() instanceof Item) {
                if (offhand.isSimilar(sweethoney)) {
                    int random = (int) (Math.random() * 20);
                    if (random == 1) {

                        Item caught = (Item) e.getCaught();

                        ItemStack coralFan = new ItemStack(Material.FIRE_CORAL_FAN, 1);
                        ItemMeta coralFanMeta = coralFan.getItemMeta();
                        coralFanMeta.setDisplayName("§6Steves lost key");
                        coralFanMeta.setLore(List.of("§5Dieser Schlüssel wird für quarrys benötigt!"));
                        coralFanMeta.addEnchant(Enchantment.MENDING, 1, true);
                        coralFan.setItemMeta(coralFanMeta);

                        e.getPlayer().sendTitle("§cYou caught the key!", "§3Steve lost it!");

                        caught.setItemStack(coralFan);
                    }
                }
            }
        }
    }

}
