package com.example.tutorialmod.menu;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;

public class MyBlockInventory implements Container {
    private final ItemStack[] items = new ItemStack[2]; // Два слота: для верстака и угля

    @Override
    public int getContainerSize() {
        return items.length;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack item : items) {
            if (!item.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        return items[index];
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        ItemStack item = items[index];
        if (!item.isEmpty()) {
            if (item.getCount() <= count) {
                items[index] = ItemStack.EMPTY;
            } else {
                item = item.split(count);
            }
        }
        return item;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        ItemStack item = items[index];
        if (!item.isEmpty()) {
            items[index] = ItemStack.EMPTY;
        }
        return item;
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        items[index] = stack;
    }

    @Override
    public void setChanged() {
        // Логика при изменении инвентаря
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < items.length; i++) {
            items[i] = ItemStack.EMPTY;
        }
    }
}
