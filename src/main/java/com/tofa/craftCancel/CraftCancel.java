package com.tofa.craftCancel;

import com.tofa.craftCancel.config.ConfigurationLoader;
import com.tofa.craftCancel.listener.PrepareCraftListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftCancel extends JavaPlugin {

    private ConfigurationLoader configurationLoader;

    @Override
    public void onEnable() {
        this.configurationLoader = new ConfigurationLoader("config.conf", getDataFolder());

        Bukkit.getPluginManager().registerEvents(
                new PrepareCraftListener(configurationLoader.getDisabledCraftsConfiguration()), this
        );
    }
}
