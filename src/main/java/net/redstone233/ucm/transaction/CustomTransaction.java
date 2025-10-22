package net.redstone233.ucm.transaction;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import net.redstone233.ucm.items.ModItems;

public class CustomTransaction {
    public static void init() {
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.WEAPONSMITH, 6, factories -> {
                    factories.add(new TradeOffers.BuyItemFactory(ModItems.ICE_FREEZE_SWORD,1,2,5,500));
                    factories.add(new TradeOffers.SellItemFactory(ModItems.ICE_FREEZE_SWORD,400,1,2,5,0.5f));
                }
        );

        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.WEAPONSMITH, 6, factories -> {
                    factories.add(new TradeOffers.BuyItemFactory(ModItems.BLAZING_FLAME_SWORD,1,2,5,500));
                    factories.add(new TradeOffers.SellItemFactory(ModItems.BLAZING_FLAME_SWORD,400,1,2,5,0.5f));
                }
        );
    }
}
