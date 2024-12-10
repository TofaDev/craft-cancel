package com.tofa.craftCancel.config;

import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

import java.util.List;

@ConfigSerializable
public class DisabledCraftsConfiguration {

    @Setting("disabled-crafts")
    private List<String> disabledItemCrafts;

    public List<String> getDisabledItemCrafts() {
        return disabledItemCrafts;
    }
}
