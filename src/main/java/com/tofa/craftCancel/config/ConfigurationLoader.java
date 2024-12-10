package com.tofa.craftCancel.config;

import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ConfigurationLoader {

    private final HoconConfigurationLoader loader;
    private final DisabledCraftsConfiguration disabledCraftsConfiguration;

    private final CommentedConfigurationNode rootNode;

    public ConfigurationLoader(String fileConfigurationName, File pluginDataFolder) {
        Path configurationPath = pluginDataFolder.toPath().resolve(fileConfigurationName);

        createFileConfigurationIfNotExists(configurationPath);

        loader = HoconConfigurationLoader.builder()
                .path(configurationPath)
                .build();

        try {
            rootNode = loader.load();
            disabledCraftsConfiguration = rootNode.get(DisabledCraftsConfiguration.class);
        } catch (ConfigurateException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFileConfigurationIfNotExists(Path configurationPath) {
        if(!Files.exists(configurationPath)) {
            try {
                Files.createDirectories(configurationPath.getParent());
                try (InputStream inputStream = ConfigurationLoader.class.getResourceAsStream("/config.conf")) {
                    if(inputStream == null) {
                        throw  new IllegalStateException("jar file must have a config.conf in resource folder!");
                    }
                    Files.copy(inputStream, configurationPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw  new RuntimeException(e);
            }
        }
    }

    public DisabledCraftsConfiguration getDisabledCraftsConfiguration() {
        return disabledCraftsConfiguration;
    }
}
