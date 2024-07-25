package com.kvrly.bosses_of_mass_destruction.packet.custom;

import com.kvrly.bosses_of_mass_destruction.entity.custom.gauntlet.GauntletEntity;
import com.kvrly.kvrlys_api.api.network.data.PacketContext;
import com.kvrly.kvrlys_api.api.network.data.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;

public class ChangeHitboxS2CPacket {
    private final int entityId;
    private final boolean open;

    public ChangeHitboxS2CPacket(int entityId, boolean open) {
        this.entityId = entityId;
        this.open = open;
    }

    public ChangeHitboxS2CPacket(FriendlyByteBuf buf) {
        this.entityId = buf.readInt();
        this.open = buf.readBoolean();
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeBoolean(open);
    }

    public static void handle(PacketContext<ChangeHitboxS2CPacket> ctx) {
        if (ctx.side().equals(Side.SERVER)) return;

        ChangeHitboxS2CPacket packet = ctx.message();

        Minecraft client = Minecraft.getInstance();
        ClientLevel level = client.level;
        if (level == null) return;

        client.execute(() -> {
            Entity entity = level.getEntity(packet.entityId);

            if (entity instanceof GauntletEntity gauntletEntity) {
                if (packet.open) gauntletEntity.hitboxHelper.setOpenHandHitbox();
                else gauntletEntity.hitboxHelper.setClosedFistHitbox();
            }
        });
    }
}