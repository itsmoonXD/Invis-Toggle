package com.moon.invis;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public void onEnable() {
        getCommand("invis").setExecutor(new InvisCommand());
    }
}
