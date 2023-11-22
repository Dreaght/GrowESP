package com.github.dreaght;

import com.github.dreaght.command.SlimesCommand;
import com.github.dreaght.listener.RenderGameOverlayListener;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;
import net.weavemc.loader.api.event.EventBus;

public class GrowESP implements ModInitializer {
    @Override
    public void preInit() {
        EventBus.subscribe(new RenderGameOverlayListener());
    }
}