package net.gray.spraypaint;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.gray.spraypaint.item.ModItems;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.tick.Tick;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraysSpraypaint implements ModInitializer {
	public static final String MOD_ID = "spraypaint";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		final SimpleParticleType RED_PARTICLE = FabricParticleTypes.simple();
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "red_particle"), RED_PARTICLE);
		final SimpleParticleType BLUE_PARTICLE = FabricParticleTypes.simple();
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "blue_particle"), BLUE_PARTICLE);
		final SimpleParticleType GREEN_PARTICLE = FabricParticleTypes.simple();
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "green_particle"), GREEN_PARTICLE);

		// For this example, we will use the end rod particle behaviour.
		ParticleFactoryRegistry.getInstance().register(RED_PARTICLE, fabricSpriteProvider -> (type, world, x, y, z, velocityX, velocityY, velocityZ) -> {
			SpriteBillboardParticle particle = new SpriteBillboardParticle(world, x, y, z, 0, 0, 0) {
				@Override public void tick() {}

				@Override
				public ParticleTextureSheet getType() {
					return null;
				}
			};
			particle.setSprite(fabricSpriteProvider);
			particle.setColor(1, 0, 0);
			particle.setMaxAge(Integer.MAX_VALUE);
			return particle;
		}
		);
		ParticleFactoryRegistry.getInstance().register(BLUE_PARTICLE, fabricSpriteProvider -> (type, world, x, y, z, velocityX, velocityY, velocityZ) -> {
					SpriteBillboardParticle particle = new SpriteBillboardParticle(world, x, y, z, 0, 0, 0) {
						@Override public void tick() {}

						@Override
						public ParticleTextureSheet getType() {
							return null;
						}
					};
					particle.setSprite(fabricSpriteProvider);
					particle.setColor(0, 0, 1);
					particle.setMaxAge(Integer.MAX_VALUE);
					return particle;
				}
		);
		ParticleFactoryRegistry.getInstance().register(GREEN_PARTICLE, fabricSpriteProvider -> (type, world, x, y, z, velocityX, velocityY, velocityZ) -> {
					SpriteBillboardParticle particle = new SpriteBillboardParticle(world, x, y, z, 0, 0, 0) {
						@Override public void tick() {}

						@Override
						public ParticleTextureSheet getType() {
							return null;
						}
					};
					particle.setSprite(fabricSpriteProvider);
					particle.setColor(0, 1, 0);
					particle.setMaxAge(Integer.MAX_VALUE);
					return particle;
				}
		);
	}
}