package com.example.tutorialmod.menu;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;

public class MyBlockContainer extends AbstractContainerMenu {
    private final Level level;

    public MyBlockContainer(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, playerInventory.player.level());
    }

    public MyBlockContainer(int windowId, Inventory playerInventory, Level level) {
        super(ModMenuTypes.MY_BLOCK_CONTAINER.get(), windowId); // Используем зарегистрированный контейнер
        this.level = level;

        // Добавляем слоты для инвентаря игрока
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Добавляем слоты для горячей панели игрока
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }

        // Добавляем слоты для верстака и угля
        this.addSlot(new Slot(new MyBlockInventory(), 0, 56, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() == Items.CRAFTING_TABLE;
            }
        });

        this.addSlot(new Slot(new MyBlockInventory(), 1, 116, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() == Items.COAL;
            }
        });
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
