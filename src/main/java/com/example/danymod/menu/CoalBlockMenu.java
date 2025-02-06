//package com.example.tutorialmod.menu;
//
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.Slot;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//
//import net.minecraft.world.SimpleContainer;
//
//public class CoalBlockMenu extends AbstractContainerMenu {
//    private final SimpleContainer inventory;
//
//    /**
//     * Конструктор для клиента (где extraData может содержать позицию блока).
//     */
//    public CoalBlockMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
//        // Здесь создаем инвентарь на 1 слот для простоты.
//        this(containerId, playerInventory, new SimpleContainer(1));
//    }
//
//    /**
//     * Основной конструктор, где передается уже созданный инвентарь.
//     */
//    public CoalBlockMenu(int containerId, Inventory playerInventory, SimpleContainer inventory) {
//        // Вместо ModMenuTypes.COAL_BLOCK_MENU.get() используйте регистрацию вашего типа меню (см. регистрацию ниже).
//        super(ModMenuTypes.COAL_BLOCK_MENU.get(), containerId);
//        this.inventory = inventory;
//
//        // Добавляем слот для блока: позиция (80, 35).
//        // Переопределяем mayPlace, чтобы в слот можно было класть только уголь.
//        this.addSlot(new Slot(inventory, 0, 80, 35) {
//            @Override
//            public boolean mayPlace(ItemStack stack) {
//                return stack.getItem() == Items.COAL;
//            }
//        });
//
//        // Добавляем слоты инвентаря игрока (3 ряда по 9 и ряд хотбара)
//        int startX = 8;
//        int startY = 84;
//        // Слоты основного инвентаря (3 ряда по 9)
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 9; col++) {
//                addSlot(new Slot(playerInventory, col + row * 9 + 9, startX + col * 18, startY + row * 18));
//            }
//        }
//        // Слоты хотбара (1 ряд из 9)
//        for (int col = 0; col < 9; col++) {
//            addSlot(new Slot(playerInventory, col, startX + col * 18, startY + 58));
//        }
//    }
//
//    @Override
//    public boolean stillValid(Player player) {
//        // Можно добавить проверку расстояния до блока, если потребуется
//        return true;
//    }
//
//    @Override
//    public ItemStack quickMoveStack(Player player, int index) {
//        // Реализуйте логику быстрого перемещения предметов (shift+click), если необходимо.
//        return ItemStack.EMPTY;
//    }
//}