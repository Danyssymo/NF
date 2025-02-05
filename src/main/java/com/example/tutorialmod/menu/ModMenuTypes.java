package com.example.tutorialmod.menu;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;
import com.example.tutorialmod.MyMod;

public class ModMenuTypes {
    // Регистрируем контейнеры
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(BuiltInRegistries.MENU, MyMod.MOD_ID);

    // Регистрируем контейнер для нашего блока
    public static final DeferredHolder<MenuType<?>, MenuType<MyBlockContainer>> MY_BLOCK_CONTAINER = CONTAINERS.register("my_block_container",
            () -> IMenuTypeExtension.create(MyBlockContainer::new));

    // Метод для регистрации контейнеров
    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
