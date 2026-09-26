package me.crashcringle.cringlebosses.rogue;
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
public class Rogue {
    public static void setup(CringleBosses cb, ItemGroup ig, Research research) {

        SlimefunItemStack rogueBell = new SlimefunItemStack("CRINGLE_ROGUE_BELL", Material.BELL,
                "&aRogue Bell",
                "",
                "&fHe was once the most wicked in the world",
                "&fNow seeking redemption",
                "&fhe brings salvation in the name of the gods",
                "",
                "&7Does not affect the ringer");

        ItemStack[] recipe = {
                Souls.FADING_SOUL,              SlimefunItems.TALISMAN_TRAVELLER,       Souls.FADING_SOUL,
                Souls.FADED_SOUL,  new ItemStack(Material.BELL),               Souls.FADED_SOUL,
                Souls.FADING_SOUL,              SlimefunItems.GOLD_24K,        Souls.FADING_SOUL};

        List<PotionEffect> potionEffects = Arrays.asList(
                new PotionEffect(PotionEffectType.INVISIBILITY, 600, 1),
                new PotionEffect(PotionEffectType.SPEED, 600, 2),
                new PotionEffect(PotionEffectType.JUMP_BOOST, 600, 3)
        );

        Bell bell = new Bell("&aRogue Bell", potionEffects, ig, rogueBell, RecipeType.ANCIENT_ALTAR, recipe);
        bell.register(cb);

        research.addItems(bell);
        research.register();
    }
}
