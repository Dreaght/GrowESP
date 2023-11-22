package com.github.dreaght.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySlime;
import net.weavemc.loader.api.event.RenderGameOverlayEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.minecraft.client.renderer.GlStateManager;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static org.lwjgl.opengl.GL11.*;

public class RenderGameOverlayListener {
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        List<Entity> entities = Minecraft.getMinecraft().theWorld.getLoadedEntityList();
        List<Integer> sizes = new ArrayList<>();

        for (Entity entity : entities) {
            if (entity instanceof EntitySlime) {
                Integer size = ((EntitySlime) entity).getSlimeSize();
                sizes.add(size);
            }
        }

        OptionalDouble average = sizes
                .stream()
                .mapToDouble(a -> a)
                .average();

        double average_size = average.isPresent() ? average.getAsDouble() : 0;
        if (average_size == 0) {
            return;
        }

        String text = String.format("Grow: %s/10", average_size);

        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        font.drawStringWithShadow(text, 10, 10, 0xFFFFFF);
    }
}
