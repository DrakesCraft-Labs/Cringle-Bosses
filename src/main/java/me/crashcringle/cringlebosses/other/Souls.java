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
                "&5&kll&4Soul of Madness&5&kll",
                        "",
                        "&5The souls whisper to you",
                        "&5Can you hear their call?",
                        "",
                        "&4&kTheSoulOfChaos");
    public static final SlimefunItemStack CRACKED_SOUL = new SlimefunItemStack("CRINGLE_CRACKED_SOUL", Material.FIRE_CHARGE,
            "&4Cracked Soul",
            "",
            "&6A stained soul fragment",
            "&6Burns upon touch",
            LoreBuilder.radioactive(Radioactivity.MODERATE),
            LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack ROYAL_GEL = new SlimefunItemStack("CRINGLE_ROYAL_GEL", Material.HEART_OF_THE_SEA,
            "&3Royal Gel",
            "",
            "&6Makes slime look noble");
    public static final SlimefunItemStack HARDENED_GEL = new SlimefunItemStack("CRINGLE_HARDENED_GEL", Material.NAUTILUS_SHELL,
            "&9Hardened Gel",
            "",
            "&bBoth hard and soft",
            "&bPerhaps a collector's item");
    public static final SlimefunItemStack FADING_SOUL = new SlimefunItemStack("CRINGLE_FADING_SOUL", Material.FIREWORK_STAR,
            "&8Fading Soul",
            "",
            "&7Originates from someone's soul",
            "&7slowly fading into oblivion");
    public static final SlimefunItemStack GLISTENING_SOUL = new SlimefunItemStack("CRINGLE_GLISTENING_SOUL", Material.NETHER_STAR,
            "&9&kll&bGlistening Soul&9&kll",
            "",
            "&5How dazzling is its light!",
            "&5Is it truly combustible?");
    public static final SlimefunItemStack PURIFIED_SOUL = new SlimefunItemStack("CRINGLE_PURIFIED_SOUL", Material.HONEYCOMB,
            "&6&kll&ePurified Soul&6&kll",
            "",
            "&6The purest soul",
            "&6Brings warmth to the world");
    public static final SlimefunItemStack FADED_SOUL = new SlimefunItemStack("CRINGLE_FADED_SOUL", new ColoredFireworkStar(Color.WHITE,"&8Faded Soul"),
            "&8Night Soul",
            "",
            "&7When one loses their way in darkness",
            "&7they become an ancient relic");
    public Souls() {
    }
    public static void setup(CringleBosses cb, ItemGroup ig, Research soulsResearch) {
        List<SlimefunItem> souls = new ArrayList<>();
        souls.add(new SlimefunItem(ig, SOUL_OF_MADNESS, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(SlimefunUtils.getCustomHead(HeadTexture.CHEESE.getTexture()), "&5Kill Chaos creatures"), null,
                        null, null, null}));

        souls.add(new SlimefunItem(ig, CRACKED_SOUL, RecipeType.BARTER_DROP,
                new ItemStack[] {
                        null, null, null,
                        new CustomItemStack(SlimefunUtils.getCustomHead(HeadTexture.PIGLIN_HEAD.getTexture()), "Piglin"), null , new CustomItemStack(Material.NETHERITE_SWORD, "&bMob Drop", "", "&cKill Corrupted creatures"),
                        null, null, null}));

        souls.add(new SlimefunItem(ig, FADING_SOUL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.WITHER_ROSE, "&5Kill Soulless creatures"), null,
                        null, null, null}));
        souls.add(new SlimefunItem(ig, FADED_SOUL, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.BONE_MEAL),        null,                               new ItemStack(Material.BONE_MEAL),
                        null,                                     FADING_SOUL,            null,
                        new ItemStack(Material.BONE_MEAL),        null,                               new ItemStack(Material.BONE_MEAL) }));

        souls.add(new SlimefunItem(ig, PURIFIED_SOUL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.LILY_OF_THE_VALLEY, "&5Kill Holy creatures"), null,
                        null, null, null}));

        souls.add(new SlimefunItem(ig, ROYAL_GEL, REALIX_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.TRIDENT, "&5Kill Primordial creatures"), null,
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
