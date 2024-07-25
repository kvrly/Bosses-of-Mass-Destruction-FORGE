package com.kvrly.bosses_of_mass_destruction.entity.custom.void_blossom.hitbox;

import com.kvrly.kvrlys_api.api.multipart_entities.entity.EntityBounds;

public interface ICompoundHitbox {
    void updatePosition();
    EntityBounds getBounds();
    void setNextDamagedPart(String part);
}
