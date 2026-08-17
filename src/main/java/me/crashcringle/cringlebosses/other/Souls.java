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
                "&5&kll&4Alma arrogante&5&kll",
                        "",
                        "&5El alma te susurra",
                        "&5¿Puedes oírlos llamar??",
                        "",
                        "&4&kTheSoulOfChaos");
    public static final SlimefunItemStack CRACKED_SOUL = new SlimefunItemStack("CRINGLE_CRACKED_SOUL", Material.FIRE_CHARGE,
            "&4alma rota",
            "",
            "&6Los fragmentos contaminados del alma.",
            "&6Se siente caliente al tacto",
            LoreBuilder.radioactive(Radioactivity.MODERATE),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack ROYAL_GEL = new SlimefunItemStack("CRINGLE_ROYAL_GEL", Material.HEART_OF_THE_SEA,
            "&3gel real",
            "",
            "&6Haz que el limo luzca noble");
    public static final SlimefunItemStack HARDENED_GEL = new SlimefunItemStack("CRINGLE_HARDENED_GEL", Material.NAUTILUS_SHELL,
            "&9gel endurecido",
            "",
            "&bUtilice tácticas tanto suaves como duras",
            "&bTal vez algún tipo de coleccionable.");
    public static final SlimefunItemStack FADING_SOUL = new SlimefunItemStack("CRINGLE_FADING_SOUL", Material.FIREWORK_STAR,
            "&8alma oculta",
            "",
            "&7del alma de alguien",
            "&7olvidado gradualmente");
    public static final SlimefunItemStack GLISTENING_SOUL = new SlimefunItemStack("CRINGLE_GLISTENING_SOUL", Material.NETHER_STAR,
            "&9&kll&balma brillante&9&kll",
            "",
            "&5¡Qué deslumbrante es su luz!!",
            "&5¿Pero es realmente inflamable??");
    public static final SlimefunItemStack PURIFIED_SOUL = new SlimefunItemStack("CRINGLE_PURIFIED_SOUL", Material.HONEYCOMB,
            "&6&kll&eAlma purificada&6&kll",
            "",
            "&6el alma mas pura",
            "&6Trae calidez al mundo");
    public static final SlimefunItemStack FADED_SOUL = new SlimefunItemStack("CRINGLE_FADED_SOUL", new ColoredFireworkStar(Color.WHITE,"&8Faded Soul"),
            "&8alma nocturna",
            "",
            "&7cuando alguien tropieza con la oscuridad",
            "&7se convirtió en una antigua reliquia");
    public Souls() {
    }
    public static void setup(CringleBosses cb, ItemGroup ig, Research soulsResearch) {
        List<SlimefunItem> souls = new ArrayList<>();
        souls.add(new SlimefunItem(ig, SOUL_OF_MADNESS, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(SlimefunUtils.getCustomHead(HeadTexture.CHEESE.getTexture()), "&5Mata a las criaturas del caos"), null,
                        null, null, null}));

        souls.add(new SlimefunItem(ig, CRACKED_SOUL, RecipeType.BARTER_DROP,
                new ItemStack[] {
                        null, null, null,
                        new CustomItemStack(SlimefunUtils.getCustomHead(HeadTexture.PIGLIN_HEAD.getTexture()), "cerdo"), null , new CustomItemStack(Material.NETHERITE_SWORD, "&bcaídas de la mafia", "", "&cMata criaturas corruptas"),
                        null, null, null}));

        souls.add(new SlimefunItem(ig, FADING_SOUL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.WITHER_ROSE, "&5Mata a la criatura sin alma."), null,
                        null, null, null}));
        souls.add(new SlimefunItem(ig, FADED_SOUL, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.BONE_MEAL),        null,                               new ItemStack(Material.BONE_MEAL),
                        null,                                     FADING_SOUL,            null,
                        new ItemStack(Material.BONE_MEAL),        null,                               new ItemStack(Material.BONE_MEAL) }));

        souls.add(new SlimefunItem(ig, PURIFIED_SOUL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.LILY_OF_THE_VALLEY, "&5Mata a una criatura sagrada"), null,
                        null, null, null}));

        souls.add(new SlimefunItem(ig, ROYAL_GEL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.TRIDENT, "&5Mata criaturas cámbricas"), null,
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
