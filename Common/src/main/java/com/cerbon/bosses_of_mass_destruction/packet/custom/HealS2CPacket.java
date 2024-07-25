package com.kvrly.bosses_of_mass_destruction.packet.custom;

import com.kvrly.bosses_of_mass_destruction.block.custom.VoidBlossomBlock;
import com.kvrly.kvrlys_api.api.network.data.PacketContext;
import com.kvrly.kvrlys_api.api.network.data.Side;
import com.kvrly.kvrlys_api.api.static_utilities.PacketUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;

public class HealS2CPacket {
    private final Vec3 source;
    private final Vec3 dest;

    public HealS2CPacket(Vec3 source, Vec3 dest) {
        this.source = source;
        this.dest = dest;
    }

    public HealS2CPacket(FriendlyByteBuf buf) {
        this.source = PacketUtils.readVec3(buf);
        this.dest = PacketUtils.readVec3(buf);
    }

    public void write(FriendlyByteBuf buf) {
        PacketUtils.writeVec3(buf, this.source);
        PacketUtils.writeVec3(buf, this.dest);
    }

    public static void handle(PacketContext<HealS2CPacket> ctx) {
        if (ctx.side().equals(Side.SERVER)) return;

        HealS2CPacket packet = ctx.message();

        Minecraft client = Minecraft.getInstance();
        ClientLevel level = client.level;
        if (level == null) return;

        client.execute(() -> VoidBlossomBlock.handleVoidBlossomHeal(level, packet.source, packet.dest));
    }
}