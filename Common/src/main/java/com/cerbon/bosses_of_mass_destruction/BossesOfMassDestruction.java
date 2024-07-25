package com.kvrly.bosses_of_mass_destruction;

import com.kvrly.bosses_of_mass_destruction.block.BMDBlockEntities;
import com.kvrly.bosses_of_mass_destruction.block.BMDBlocks;
import com.kvrly.bosses_of_mass_destruction.config.BMDConfig;
import com.kvrly.bosses_of_mass_destruction.entity.BMDEntities;
import com.kvrly.bosses_of_mass_destruction.item.BMDCreativeModeTabs;
import com.kvrly.bosses_of_mass_destruction.item.BMDItems;
import com.kvrly.bosses_of_mass_destruction.packet.BMDPackets;
import com.kvrly.bosses_of_mass_destruction.particle.BMDParticles;
import com.kvrly.bosses_of_mass_destruction.sound.BMDSounds;
import com.kvrly.bosses_of_mass_destruction.structure.BMDStructures;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class BossesOfMassDestruction {

	public static void init() {
		AutoConfig.register(BMDConfig.class, JanksonConfigSerializer::new);
		AutoConfig.getConfigHolder(BMDConfig.class).getConfig().postInit();
		AutoConfig.getConfigHolder(BMDConfig.class).save();

		BMDCreativeModeTabs.register();
		BMDBlocks.register();
		BMDItems.register();

		BMDEntities.register();
		BMDBlockEntities.register();
		BMDPackets.register();

		BMDSounds.register();
		BMDParticles.register();
		BMDStructures.register();
	}
}
