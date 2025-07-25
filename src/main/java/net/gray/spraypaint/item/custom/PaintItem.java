package net.gray.spraypaint.item.custom;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Vector;

public class PaintItem extends Item {
    private int r, g, b;
    World myWorld;
    private Vector<Position> positionVector;
    public PaintItem(Settings settings, int rn, int gn, int bn) {
        super(settings);
        r = rn;
        g = gn;
        b = bn;
        positionVector = new Vector<>();
        myWorld = null;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        myWorld = context.getWorld();
        if (!context.getWorld().isClient) {
            positionVector.add(context.getHitPos());
        }
        return super.useOnBlock(context);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
            for (int j = 0; j < positionVector.size(); j++) {
                Position i = positionVector.elementAt(j);
                world.spawnParticles(ParticleTypes.END_ROD, i.getX(), i.getY(), i.getZ(), 20, .2, .2, .2, 0);

            }
        super.inventoryTick(stack, world, entity, slot);
    }
}
