package me.crashcringle.cringlebosses.other;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.api.researches.Research;
import com.github.drakescraft_labs.slimefun4.core.attributes.Radioactivity;
import com.github.drakescraft_labs.slimefun4.implementation.SlimefunItems;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;
import com.github.drakescraft_labs.slimefun4.utils.HeadTexture;
import com.github.drakescraft_labs.slimefun4.utils.LoreBuilder;
import com.github.drakescraft_labs.slimefun4.utils.SlimefunUtils;
import com.github.drakescraft_labs.slimefun4.utils.itemstack.ColoredFireworkStar;
import me.crashcringle.cringlebosses.CringleBoss;
import me.crashcringle.cringlebosses.CringleBosses;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Souls {
    public static final RecipeType REALIX_DROP = new RecipeType(new NamespacedKey(CringleBosses.inst(), "realix_drop"), new CustomItemStack(Material.NETHERITE_SWORD, "&bMob Drop", "", "&rKill the specified Mob Type to obtain this Item"));

    public static final SlimefunItemStack SOUL_OF_MADNESS = new SlimefunItemStack("CRINGLE_SOUL_OF_CHAOS", Material.ENDER_EYE,
                "&5&kll&4Alma soberbia&5&kll",
                        "",
                        "&5Las almas te susurran",
                        "&5¿Alcanzas a oír su llamada?",
                        "",
                        "&4&kTheSoulOfChaos");
    public static final SlimefunItemStack CRACKED_SOUL = new SlimefunItemStack("CRINGLE_CRACKED_SOUL", Material.FIRE_CHARGE,
            "&4Alma rota",
            "",
            "&6Un fragmento manchado de un alma",
            "&6Quema al tocarla",
            LoreBuilder.radioactive(Radioactivity.MODERATE),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack ROYAL_GEL = new SlimefunItemStack("CRINGLE_ROYAL_GEL", Material.HEART_OF_THE_SEA,
            "&3Gel real",
            "",
            "&6Hace que el limo parezca noble");
    public static final SlimefunItemStack HARDENED_GEL = new SlimefunItemStack("CRINGLE_HARDENED_GEL", Material.NAUTILUS_SHELL,
            "&9Gel endurecido",
            "",
            "&bDuro y blando a la vez",
            "&bQuizá sea una pieza de coleccionista");
    public static final SlimefunItemStack FADING_SOUL = new SlimefunItemStack("CRINGLE_FADING_SOUL", Material.FIREWORK_STAR,
            "&8Alma oculta",
            "",
            "&7Procede del alma de alguien",
            "&7y poco a poco cae en el olvido");
    public static final SlimefunItemStack GLISTENING_SOUL = new SlimefunItemStack("CRINGLE_GLISTENING_SOUL", Material.NETHER_STAR,
            "&9&kll&bAlma reluciente&9&kll",
            "",
            "&5¡Qué deslumbrante es su luz!",
            "&5¿Pero de verdad arde?");
    public static final SlimefunItemStack PURIFIED_SOUL = new SlimefunItemStack("CRINGLE_PURIFIED_SOUL", Material.HONEYCOMB,
            "&6&kll&eAlma purificada&6&kll",
            "",
            "&6El alma más pura",
            "&6Trae calor al mundo");
    public static final SlimefunItemStack FADED_SOUL = new SlimefunItemStack("CRINGLE_FADED_SOUL", new ColoredFireworkStar(Color.WHITE,"&8Faded Soul"),
            "&8Alma de la noche",
            "",
            "&7Cuando alguien se pierde en la oscuridad",
            "&7acaba convertido en una reliquia antigua");
    public Souls() {
    }
    public static void setup(CringleBosses cb, ItemGroup ig, Research soulsResearch) {
        List<SlimefunItem> souls = new ArrayList<>();
        souls.add(new SlimefunItem(ig, SOUL_OF_MADNESS, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(SlimefunUtils.getCustomHead(HeadTexture.CHEESE.getTexture()), "&5Mata criaturas del caos"), null,
                        null, null, null}));

        souls.add(new SlimefunItem(ig, CRACKED_SOUL, RecipeType.BARTER_DROP,
                new ItemStack[] {
                        null, null, null,
                        new CustomItemStack(SlimefunUtils.getCustomHead(HeadTexture.PIGLIN_HEAD.getTexture()), "Piglin"), null , new CustomItemStack(Material.NETHERITE_SWORD, "&bBotín de criatura", "", "&cMata criaturas corruptas"),
                        null, null, null}));

        souls.add(new SlimefunItem(ig, FADING_SOUL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.WITHER_ROSE, "&5Mata criaturas sin alma"), null,
                        null, null, null}));
        souls.add(new SlimefunItem(ig, FADED_SOUL, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.BONE_MEAL),        null,                               new ItemStack(Material.BONE_MEAL),
                        null,                                     FADING_SOUL,            null,
                        new ItemStack(Material.BONE_MEAL),        null,                               new ItemStack(Material.BONE_MEAL) }));

        souls.add(new SlimefunItem(ig, PURIFIED_SOUL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.LILY_OF_THE_VALLEY, "&5Mata criaturas sagradas"), null,
                        null, null, null}));

        souls.add(new SlimefunItem(ig, ROYAL_GEL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.TRIDENT, "&5Mata criaturas primigenias"), null,
                        null, null, null}));
        souls.add(new SlimefunItem(ig, HARDENED_GEL, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.BONE_MEAL),        null,                               new ItemStack(Material.BONE_MEAL),
                        null,                                     ROYAL_GEL,            null,
                        new ItemStack(Material.BONE_MEAL),        null,                               new ItemStack(Material.BONE_MEAL) }));

        souls.add(new SlimefunItem(ig, GLISTENING_SOUL, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.HEATING_COIL,         SlimefunItems.MAGIC_LUMP_3,                               SlimefunItems.HEATING_COIL,
                        SlimefunItems.HEATING_COIL,        CRACKED_SOUL,            SlimefunItems.HEATING_COIL,
                        SlimefunItems.HEATING_COIL,        SlimefunItems.MAGIC_LUMP_3,                               SlimefunItems.HEATING_COIL }));

        for (SlimefunItem soul : souls) {
            soul.register(cb);
            soulsResearch.addItems(soul);
        }
        soulsResearch.register();
    }
}
