package com.kvrly.bosses_of_mass_destruction.config.mob;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ObsidilithConfig {
    public double health = 600.0;
    public double armor = 28.0;
    public double attack = 16.0;
    public float idleHealingPerTick = 0.5f;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 10000)
    public int experienceDrop = 1000;
    public boolean spawnPillarOnDeath = true;
    public float anvilAttackExplosionStrength = 4.0f;
}
