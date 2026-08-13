package me.crashcringle.cringlebosses.holy;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.api.researches.Research;
import com.github.drakescraft_labs.slimefun4.implementation.SlimefunItems;
import me.crashcringle.cringlebosses.CringleBosses;
import me.crashcringle.cringlebosses.other.Bell;
import me.crashcringle.cringlebosses.other.Souls;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

public class Holy {
    public static void setup(CringleBosses cb, ItemGroup ig, Research research) {

        SlimefunItemStack holyBell = new SlimefunItemStack("CRINGLE_HOLY_BELL", Material.BELL,
                "&eCampana sagrada",
                "",
                "&fMejora a los jugadores cercanos",
                "",
                "&7No afecta a quien toca la campana");

        ItemStack[] recipe = {
                Souls.PURIFIED_SOUL,              SlimefunItems.TALISMAN_KNIGHT,       Souls.PURIFIED_SOUL,
                new ItemStack(Material.ENCHANTED_GOLDEN_APPLE),  new ItemStack(Material.BELL),        new ItemStack(Material.ENCHANTED_GOLDEN_APPLE),
                Souls.PURIFIED_SOUL,              SlimefunItems.GOLD_24K,        Souls.PURIFIED_SOUL};

        List<PotionEffect> potionEffects = Arrays.asList(
                new PotionEffect(PotionEffectType.INSTANT_HEALTH, 1, 20),
                new PotionEffect(PotionEffectType.REGENERATION, 1200, 1),
                new PotionEffect(PotionEffectType.HEALTH_BOOST, 600, 40)
        );

        Bell bell = new Bell("&eCampana sagrada", potionEffects, ig, holyBell, RecipeType.ANCIENT_ALTAR, recipe);
        bell.register(cb);

        research.addItems(bell);
        research.register();
    }
}
