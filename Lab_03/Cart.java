public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 50;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full, please remove some items before adding this one.");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        ++qtyOrdered;
        System.out.println("The disc has been added");
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        }
    }

    // public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    // if (qtyOrdered + dvdList.length >= MAX_NUMBERS_ORDERED){
    // System.out.println("The cart is already full, please remove some items before
    // adding this one.");
    // return;
    // }
    // for (DigitalVideoDisc dvd : dvdList){
    // addDigitalVideoDisc(dvd);
    // }
    // }
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full, please remove some items before adding this one.");
            return;
        }
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full, please remove some items before adding this one.");
            return;
        }
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);

    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; ++i) {
            if (itemsOrdered[i] == disc) {
                --qtyOrdered;
                System.out.println("The disc has been removed");
                for (int j = i + 1; j < qtyOrdered; ++j) {
                    itemsOrdered[j - 1] = itemsOrdered[j];
                }
                itemsOrdered[qtyOrdered] = null;
                return;
            }
        }
        System.out.println("Cannot find the item.");
    }

    public float totalCost() {
        float cost = 0;
        for (DigitalVideoDisc item : itemsOrdered) {
            if (item != null)
                cost += item.getCost();
        }
        return cost;
    }

    @Override
    public String toString() {
        String stringOut = "";
        String qtyOrderedString = String.format("The cart has %d items\n", qtyOrdered);
        stringOut += qtyOrderedString;
        for (int i = 0; i < qtyOrdered; ++i) {
            String itemString = String.format("Item #%d, Title: %s, Cost: %f\n", i + 1, itemsOrdered[i].getTitle(),
                    itemsOrdered[i].getCost());
            stringOut += itemString;
        }
        String totalCostString = String.format("Total Cost: %f\n", totalCost());
        stringOut += totalCostString;
        return stringOut;
    }

}
