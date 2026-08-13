package me.crashcringle.cringlebosses.chaos;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.api.researches.Research;
import com.github.drakescraft_labs.slimefun4.implementation.SlimefunItems;
import me.crashcringle.cringlebosses.CringleBoss;
import me.crashcringle.cringlebosses.CringleBosses;
import me.crashcringle.cringlebosses.other.Bell;
import me.crashcringle.cringlebosses.other.Souls;
import me.crashcringle.cringlebosses.other.SummoningAltar;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

public class Chaos {

    public static void setup(CringleBosses cb, ItemGroup ig, Research chaosResearch) {

        SlimefunItemStack spectreOfChaos = new SlimefunItemStack("CRINGLE_SPECTRE_OF_CHAOS", Material.ENDERMAN_SPAWN_EGG,
                "&5Esencia del espectro del caos",
                "",
                "&7Sirve para invocar al espectro del caos",
                "",
                "&cDebe usarse sobre un altar de invocación adecuado");

        ItemStack[] spectreRecipe = {
                new ItemStack(Material.END_CRYSTAL),        SlimefunItems.ENDER_RUNE,                               new ItemStack(Material.END_CRYSTAL),
                SlimefunItems.ENDER_LUMP_3,                  Souls.SOUL_OF_MADNESS,                     SlimefunItems.ENDER_LUMP_3,
                new ItemStack(Material.END_CRYSTAL),        SlimefunItems.ENDER_RUNE,                               new ItemStack(Material.END_CRYSTAL) };

        CringleBoss spectre = new CringleBoss(ig, spectreOfChaos, SummoningAltar.SUMMONING_ALTAR, spectreRecipe);
        spectre.register(cb);


        SlimefunItemStack chaosBell = new SlimefunItemStack("CRINGLE_CHAOS_BELL", Material.BELL,
                "&4Campana espectral",
                "",
                "&fConfunde y revela a los jugadores cercanos",
                "",
                "&7No afecta a quien toca la campana");

        ItemStack[] recipe = {
                Souls.SOUL_OF_MADNESS,              SlimefunItems.TALISMAN_MAGICIAN,        Souls.SOUL_OF_MADNESS,
                SlimefunItems.CHEESE,               new ItemStack(Material.BELL),         SlimefunItems.CHEESE,
                Souls.SOUL_OF_MADNESS,              SlimefunItems.GOLD_24K,        Souls.SOUL_OF_MADNESS};

        List<PotionEffect> potionEffects = Arrays.asList(
                new PotionEffect(PotionEffectType.LEVITATION, 60, 2),
                new PotionEffect(PotionEffectType.GLOWING, 220, 1),
                new PotionEffect(PotionEffectType.LUCK, 220, 1),
                new PotionEffect(PotionEffectType.NAUSEA, 600, 2),
                new PotionEffect(PotionEffectType.BLINDNESS, 100, 2)
        );

        Bell bell = new Bell("&4Campana espectral", potionEffects, ig, chaosBell, RecipeType.ANCIENT_ALTAR, recipe);
        bell.register(cb);

        chaosResearch.addItems(spectre, bell);
        chaosResearch.register();


    }
}
