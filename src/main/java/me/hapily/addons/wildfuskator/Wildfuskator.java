package me.hapily.addons.wildfuskator;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Wildfuskator extends JavaPlugin {

    Wildfuskator instance;
    SkriptAddon addon;

    public void onEnable() {
        instance = this;
        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("me.hapily.addons.wildfuskator", "elements");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bukkit.getLogger().info("[Wildfuskator] has been enabled!");
    }

    public Wildfuskator getInstance() {
        return instance;
    }

    public SkriptAddon getAddonInstance() {
        return addon;
    }
}
