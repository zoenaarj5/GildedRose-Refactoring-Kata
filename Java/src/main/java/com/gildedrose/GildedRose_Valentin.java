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
        int qualityChange;
        if (item.name.equals(SULFURAS)) {
            qualityChange = 0;
        } else {
            switch (item.name){
                case AGED_BRIE:
                    qualityChange = item.quality < MAX_AGE ? 1 : 0;
                    break;
                case BACKSTAGE_PASSES:
                    qualityChange = item.sellIn > 10 ? 1 : (item.sellIn > 5 ? 2 : (item.sellIn > 0 ? 3 : -item.sellIn));
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
        }1
        item.quality+=qualityChange;
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
        }
    }
}
