package com.tofa.craftCancel.listener;

import com.tofa.craftCancel.config.DisabledCraftsConfiguration;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;

import java.util.List;

public class PrepareCraftListener implements Listener {

    private final DisabledCraftsConfiguration disabledCraftsConfiguration;

    public PrepareCraftListener(DisabledCraftsConfiguration disabledCraftsConfiguration) {
        this.disabledCraftsConfiguration = disabledCraftsConfiguration;
    }

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent e) {
        if(e.getRecipe() == null) return;

        Material craftResult = e.getRecipe().getResult().getType();

        List<String> disabledCraftsList = disabledCraftsConfiguration.getDisabledItemCrafts();

        boolean isCraftDisabled = disabledCraftsList.stream()
                .anyMatch(disabled -> disabled.equalsIgnoreCase(craftResult.name()));

        if(isCraftDisabled) {
            e.getInventory().setResult(null);
        }
    }
}
