package com.gildedrose;
class GildedRose {
    Item[] items;
    static final String AGED_BRIE="Aged Brie";
    static final String SULFURAS="Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES="Backstage passes to a TAFKAL80ETC concert";
    public GildedRose(Item[] items) {
        this.items = items;
    }
    private void updateQuality(Item item) {
        final int MAX_AGE = 50;
        final int SUL_QUA = 80;
        int qualityChange;
        if (item.name.equals(SULFURAS)) {
            if(item.quality!=SUL_QUA) {
                item.quality = SUL_QUA;
            }
        } else {
            switch (item.name){
                case AGED_BRIE:
                    qualityChange = item.quality < MAX_AGE ? 1 : 0;
                    break;
                case BACKSTAGE_PASSES:
                    qualityChange = item.sellIn > 10 ? 1 : (item.sellIn > 5 ? 2 : ((item.sellIn > 0) ? 3 : -item.sellIn));
                    break;
                default:
                    qualityChange = -1;
            }
            if (item.name.toUpperCase().contains("CONJURED")) {
                qualityChange *= 2;
            }
            if (item.sellIn <= 0) {
                qualityChange *= 2;
            }
            item.quality+=qualityChange;
            item.sellIn--;
        }
        if(item.quality<0){
            item.quality=0;
        }
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
        }
    }
}
