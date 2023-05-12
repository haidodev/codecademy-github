package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    
    public static final int MAX_NUMBERS_ITEMS = 50;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_ITEMS];
    private int qtyOrdered;

    public void addDVD(DigitalVideoDisc disc) {
        itemsInStore[qtyOrdered] = disc;
        ++qtyOrdered;
        System.out.println("The disc has been added");
    }

    // public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    // if (qtyOrdered + dvdList.length >= MAX_NUMBERS_ITEMS){
    // System.out.println("The cart is already full, please remove some items before
    // adding this one.");
    // return;
    // }
    // for (DigitalVideoDisc dvd : dvdList){
    // addDigitalVideoDisc(dvd);
    // }
    // }
    public void addDVD(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDVD(dvd);
        }
    }

    // public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    //     if (qtyOrdered + 2 > MAX_NUMBERS_ITEMS) {
    //         System.out.println("The cart is already full, please remove some items before adding this one.");
    //         return;
    //     }
    //     addDVD(dvd1);
    //     addDVD(dvd2);

    // }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; ++i) {
            if (itemsInStore[i] == disc) {
                --qtyOrdered;
                System.out.println("The disc has been removed");
                for (int j = i + 1; j < qtyOrdered; ++j) {
                    itemsInStore[j - 1] = itemsInStore[j];
                }
                itemsInStore[qtyOrdered] = null;
                return;
            }
        }
        System.out.println("Cannot find the item.");
    }

    @Override
    public String toString() {
        String cartString = "";
        String cartHeader = "***********************STORE**********************\n";
        String cartTitle = "All Items: \n";
        cartString += cartHeader;
        cartString += cartTitle;
        for (int i = 0; i < qtyOrdered; ++i) {
            String itemString = String.format("%d. DVD - %s - %s - %d:  %f$\n", 
                i + 1, 
                itemsInStore[i].getTitle(),
                itemsInStore[i].getCategory(),
                itemsInStore[i].getLength(),
                itemsInStore[i].getCost());
            cartString += itemString;
        }
        String cartFooter = "**************************************************\n";
        cartString += cartFooter;
        return cartString;
    }
    // @Override
    // public String toString() {
    //     String cartString = "";
    //     String cartHeader = "***********************CART***********************\n";
    //     String cartFooter = "**************************************************\n";
    //     String cartTitle = "Ordered Items: \n";
    //     String stringOut = "";
    //     String qtyOrderedString = String.format("The cart has %d items\n", qtyOrdered);
    //     stringOut += qtyOrderedString;
    //     for (int i = 0; i < qtyOrdered; ++i) {
    //         String itemString = String.format("Item #%d, Title: %s, Cost: %f\n", i + 1, itemsInStore[i].getTitle(),
    //                 itemsInStore[i].getCost());
    //         itemString = String.format("%d. DVD - [%s] - [%s] - [%d]: - [%f]$\n", 
    //             i + 1, 
    //             itemsInStore[i].getTitle(),
    //             itemsInStore[i].getCategory(),
    //             itemsInStore[i].getLength(),
    //             itemsInStore[i].getCost());
    //         stringOut += itemString;
    //     }
    //     String totalCostString = String.format("Total Cost: %f\n", totalCost());
    //     stringOut += totalCostString;
    //     return stringOut;
    // }

}