package cafe.siornya.ability;

import com.mojang.serialization.Codec;

public enum Abilities {
    ELECTROMASTER,
    TELEPORTER,
    AEROHANDS,
    PSYCHOKINESIS;

    public static final Codec<Abilities> CODEC =
            Codec.STRING.xmap(Abilities::valueOf, Abilities::name);
}
