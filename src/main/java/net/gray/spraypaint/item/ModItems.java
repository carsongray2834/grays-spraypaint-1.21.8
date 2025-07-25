package net.gray.spraypaint.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gray.spraypaint.GraysSpraypaint;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RED_SPRAY_PAINT = registerItem("red_spray_paint", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GraysSpraypaint.MOD_ID,"red_spray_paint")))));
    public static final Item BLUE_SPRAY_PAINT = registerItem("blue_spray_paint", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GraysSpraypaint.MOD_ID,"blue_spray_paint")))));
    public static final Item GREEN_SPRAY_PAINT = registerItem("green_spray_paint", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GraysSpraypaint.MOD_ID,"green_spray_paint")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GraysSpraypaint.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GraysSpraypaint.LOGGER.info("Registering Mod Items for " + GraysSpraypaint.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(RED_SPRAY_PAINT);
            entries.add(BLUE_SPRAY_PAINT);
            entries.add(GREEN_SPRAY_PAINT);
        });
    }
}
