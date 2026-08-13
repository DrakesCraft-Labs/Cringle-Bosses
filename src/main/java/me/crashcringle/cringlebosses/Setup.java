package me.crashcringle.cringlebosses;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.api.items.groups.NestedItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.groups.SubItemGroup;
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.api.researches.Research;
import com.github.drakescraft_labs.slimefun4.implementation.SlimefunItems;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;
import me.crashcringle.cringlebosses.CringleBosses;
import me.crashcringle.cringlebosses.chaos.Chaos;
import me.crashcringle.cringlebosses.corrupt.Corrupt;
import me.crashcringle.cringlebosses.holy.Holy;
import me.crashcringle.cringlebosses.old.Old;
import me.crashcringle.cringlebosses.other.Souls;
import me.crashcringle.cringlebosses.other.SummoningAltar;
import me.crashcringle.cringlebosses.other.SummoningAltarListener;
import me.crashcringle.cringlebosses.other.SummoningPedestal;
import me.crashcringle.cringlebosses.prime.Prime;
import me.crashcringle.cringlebosses.rogue.Rogue;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class Setup {
    public static SlimefunItemStack SUMMONING_ALTAR = new SlimefunItemStack("CRINGLE_SUMMONING_ALTAR", Material.ENCHANTING_TABLE,
            "&4Altar de invocación",
            "",
            "&cUn altar de varios bloques",
            "&cSirve para invocar a los distintos jefes");

    public static final SlimefunItemStack SUMMONING_PEDESTAL = new SlimefunItemStack("CRINGLE_SUMMONING_PEDESTAL", Material.RESPAWN_ANCHOR,
            "&4Pedestal de invocación",
            "",
            "&cParte del altar de invocación");
    
    private NestedItemGroup nestedItemGroup;
    private ItemGroup resourcesItemGroup;
    private ItemGroup chaosItemGroup;
    private ItemGroup corruptItemGroup;
    private ItemGroup primeItemGroup;
    private ItemGroup oldItemGroup;
    private ItemGroup holyItemGroup;
    private ItemGroup rogueItemGroup;

    private Research chaosResearch;
    private Research holyResearch;
    private Research oldResearch;
    private Research corruptResearch;
    private Research rogueResearch;

    private Research primeResearch;
    private Research soulResearch;

    public Setup() {

        ItemStack itemGroupItem = new CustomItemStack(Material.SOUL_CAMPFIRE, "&7Jefe del caos", "", "&a> Clic para abrir");

        nestedItemGroup = new NestedItemGroup(new NamespacedKey(CringleBosses.inst(), "cringle_bosses"), itemGroupItem);
        resourcesItemGroup = new SubItemGroup(new NamespacedKey(CringleBosses.inst(), "cringle_resources"), nestedItemGroup, new CustomItemStack(Material.LANTERN, "&6Receta"));
        chaosItemGroup = new SubItemGroup(new NamespacedKey(CringleBosses.inst(), "chaos"), nestedItemGroup, new CustomItemStack(Material.REDSTONE, "&4Caos"));
        primeItemGroup = new SubItemGroup(new NamespacedKey(CringleBosses.inst(), "primordial"), nestedItemGroup, new CustomItemStack(Material.TRIDENT, "&bPrimigenio"));
        rogueItemGroup = new SubItemGroup(new NamespacedKey(CringleBosses.inst(), "rogue"), nestedItemGroup, new CustomItemStack(Material.WITHER_ROSE, "&2Pecado"));
        holyItemGroup = new SubItemGroup(new NamespacedKey(CringleBosses.inst(), "holy"), nestedItemGroup, new CustomItemStack(Material.HONEYCOMB, "&eSagrado"));
        corruptItemGroup = new SubItemGroup(new NamespacedKey(CringleBosses.inst(), "corrupt"), nestedItemGroup, new CustomItemStack(Material.FIRE_CHARGE, "&5Corrupción"));
        oldItemGroup = new SubItemGroup(new NamespacedKey(CringleBosses.inst(), "old"), nestedItemGroup, new CustomItemStack(Material.TOTEM_OF_UNDYING, "&8Reliquia"));


        NamespacedKey researchKey = new NamespacedKey(CringleBosses.inst(), "Chaos_bosses_research");
        soulResearch = new Research(researchKey, 12600001, "La verdad del alma", 45);
        chaosResearch = new Research(researchKey, 12600002, "Pasos del caos", 60);
        primeResearch = new Research(researchKey, 12600003, "Manuscrito de los ancestros", 65);
        holyResearch = new Research(researchKey, 12600004, "La palabra de los dioses", 56);
        oldResearch = new Research(researchKey, 12600005, "Una historia antigua", 82);
        rogueResearch = new Research(researchKey, 12600006, "Olvidado en el mundo", 94);
        corruptResearch = new Research(researchKey, 12600007, "El fruto prohibido del conocimiento", 100);

        ItemStack[] altarRecipe = {
                null,                                       SlimefunItems.ANCIENT_ALTAR,                          null,
                SlimefunItems.ENDER_LUMP_2,                 SlimefunItems.GOLD_10K,                               SlimefunItems.ENDER_LUMP_2,
                SlimefunItems.WITHER_PROOF_OBSIDIAN,        SlimefunItems.GOLD_10K,                               SlimefunItems.WITHER_PROOF_OBSIDIAN };

        SummoningAltar altar = new SummoningAltar(chaosItemGroup, SUMMONING_ALTAR, RecipeType.MAGIC_WORKBENCH, altarRecipe);
        altar.register(CringleBosses.inst());



        ItemStack[] pedestalRecipe = {
                new ItemStack(Material.CRYING_OBSIDIAN),    new ItemStack(Material.CRYING_OBSIDIAN),            new ItemStack(Material.CRYING_OBSIDIAN),
                new ItemStack(Material.GLOWSTONE),          SlimefunItems.MAGIC_LUMP_3,                  new ItemStack(Material.GLOWSTONE),
                new ItemStack(Material.CRYING_OBSIDIAN),    new ItemStack(Material.CRYING_OBSIDIAN),            new ItemStack(Material.CRYING_OBSIDIAN) };

        SummoningPedestal pedestal = new SummoningPedestal(chaosItemGroup, SUMMONING_PEDESTAL, RecipeType.MAGIC_WORKBENCH, pedestalRecipe, new SlimefunItemStack(SUMMONING_PEDESTAL, 4));
        pedestal.register(CringleBosses.inst());

        new SummoningAltarListener(CringleBosses.inst(), altar, pedestal);

        Souls.setup(CringleBosses.inst(), resourcesItemGroup, soulResearch);
        Chaos.setup(CringleBosses.inst(), chaosItemGroup, chaosResearch);
        Prime.setup(CringleBosses.inst(), primeItemGroup, primeResearch);
        Holy.setup(CringleBosses.inst(), holyItemGroup, holyResearch);
        Corrupt.setup(CringleBosses.inst(), corruptItemGroup, corruptResearch);
        Old.setup(CringleBosses.inst(), oldItemGroup, oldResearch);
        Rogue.setup(CringleBosses.inst(), rogueItemGroup, rogueResearch);


    }
}
