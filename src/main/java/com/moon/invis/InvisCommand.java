package com.moon.invis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvisCommand implements CommandExecutor {
    private List<UUID> invis = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (this.invis.contains(player.getUniqueId())) {
                this.invis.remove(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers())
                    target.showPlayer(player);
                player.sendMessage(ChatColor.AQUA + "You are visible.");
            } else {
                this.invis.add(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers())
                    target.hidePlayer(player);
                player.sendMessage(ChatColor.AQUA + "You are invisible.");
            }
        }
        return false;
    }
}
