/* This class is used to hold the items that are in the cart and then confirm them
 * If the user wants to put them into an order */

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart
{
    // Initialising variables
    private ArrayList<Item> items;
    private Item item;
    private long cartId;
    private int total;
    private boolean cartOpen;
    
    public ShoppingCart(){
        items = new ArrayList<>();
        cartId = getCartId();
        cartOpen = true;
    }
    
    // Setter Functions
    public void addItem(Item item) {
        // The item will only be added if the cart is open
        if (cartOpen) {
            items.add(item);
            total += item.getPrice();
            System.out.println(item.getName(item) + " is now in the shopping cart");
        } else {
            System.out.println("Sorry, the shopping card is closed");
        }
    }
    
    public void removeItem(Item item) {
        // The item will only be removed if the cart is open
        if (cartOpen) {
            if (items.contains(item)) {
                total -= item.getPrice();
                items.remove(item);
                System.out.println(item.getName(item) + " has now been taken out of the shopping cart");
            }
        } else {
            System.out.println("Sorry, the shopping card is closed");
        }
    }
    
    public void close() {
        cartOpen = false;
    }
    
    public void clear() {
        items = null;
    }
    
    public void printItems() {
        // Printing all of the items in the cart
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\t" + items.get(i));
        }
    }
    
    public void confirmCart() {
        System.out.println("\nYou have added the items below to your cart:");
        printItems();
        System.out.println("\nWould you like to confirm your order, yes or no?");
        Scanner in = new Scanner(System.in);
        
        /* This code takes input from the user to see if they want to confirm the cart
         * It will also work if the user inputs only y or n */
        char input = in.next().charAt(0);
        if (input == 'y') { 
            System.out.println("Items confirmed"); 
        } else if (input == 'n') {
            System.out.println("Okay, Closing shop");
            System.exit(0);
        } else {
            System.out.println("Input invalid. Closing shop");
            System.exit(0);
        }
    }
    
    // Getter Functions
    public Item getItem(int i) {
        return items.get(i);
    }
    
    public int sizeOfItems() {
        return items.size();
    }
    
    public int getTotal() {
        return total;
    }
    
    public long getCartId() {
        return (long)(Math.random() * 99999999999999L);
    }
}
