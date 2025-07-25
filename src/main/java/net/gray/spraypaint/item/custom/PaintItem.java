package net.gray.spraypaint.item.custom;

import net.gray.spraypaint.GraysSpraypaint;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.DustColorTransitionParticleEffect;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class PaintItem extends Item {
    private int r, g, b;
    public PaintItem(Settings settings, int rn, int gn, int bn) {
        super(settings);
        r = rn;
        g = gn;
        b = bn;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            return null;
        }
        return super.useOnBlock(context);
    }
}
