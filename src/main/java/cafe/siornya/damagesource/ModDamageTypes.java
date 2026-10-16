package cafe.siornya.damagesource;

import cafe.siornya.AcademyCity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> ELECTRO_MASTER_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE,
            Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, "electro_master_damage"));
    public static final ResourceKey<DamageType> TELEPORTER_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE,
			Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, "teleporter_damage"));
}
