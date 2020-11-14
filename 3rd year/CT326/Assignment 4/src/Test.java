/*
 * Class Test
 * @author Conor Mc Govern (18343763)
 */
import org.joda.money.Money;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Test {

    private static String filename = "/home/conor/Documents/CT326/Assignment 4/products.csv";
    private static List<Product> products;

    /*
     * The main entry point for the application.
     * > Reads in product information from products.csv and adds product objects to a List.
     * > Sorts the list in natural order and prints the modified list to console.
     * > Sorts the list by cost in descending order using an anonymous function and prints the modified list to console.
     * > Sorts the list by cost in ascending order using a lambda function and prints the modified list to console.
     * > Sorts the list in natural order and prints the modified list to console.
     * > Searches the list for product(s) using binary search, returns the position number if found or adds it to the list if not found.
     * > Adds the entire list to a hashmap and using the item code as the key for each row.
     * > Searches the hashmap for a given item code, e.g. 29301001124, and returns the object to be printed to the console.
     */
    public static void main(String[] args) {
        // Get products from CSV
        try {
            products = Product.readFile(filename);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 1.
        // Put the products in natural order
        System.out.println("\nSorting products in natural order.");
        Collections.sort(products);
        for (Product p : products) {
            System.out.println(p.toString());
        }

        // 2.
        // Sort based on item cost using a Comparator implemented as an anonymous inner class
        // Descending order based on cost
        System.out.println("\nSorting products by cost in descending order.");
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p2.getItemCost().compareTo(p1.getItemCost());
            }
        });

        for (Product p : products) {
            System.out.println(p.toString());
        }

        // 3.
        // Sort based on item cost using a Comparator implemented as lamba function
        // Ascending order inventory
        System.out.println("\nSorting products by inventory in ascending order.");
        Comparator<Product> comparatorByInventory = (p1, p2) -> p1.getInventory().compareTo(p2.getInventory());
        Collections.sort(products, comparatorByInventory);

        for (Product p : products) {
            System.out.println(p.toString());
        }

        // 4.
        // Search list for a random products, one already in existence and one that is not.
        // Searching list by cost in ascending order
        System.out.println("\nSearching products for product.");
        Comparator<Product> comparatorByCost = (p1, p2) -> p1.getItemCost().compareTo(p2.getItemCost());
        Collections.sort(products, comparatorByCost);
        searchList(products, products.get(0), comparatorByCost);
        searchList(products, new Product(Long.parseLong("29301001150"), "JCB TOUGHphone Tradesman", Money.parse("EUR 69.00"),
                "The Power of Experience", 25), comparatorByCost);

        // 5.
        // Store products in hashmap where item code is key
        Map<Long, Product> productsMap = new HashMap<>();
        for(Product p : products) {
            productsMap.put(p.getItemCode(), p);
        }

        // 6.
        System.out.println("\nSearching productsMap for product with itemCode 29301001124.");
        Product p = productsMap.get(Long.parseLong("29301001124"));
        System.out.println("Product info: " + p.toString());

        /*
         * Are there any potential advantages in using a Map instead of a List type data structure to store the list of products in memory?
         * Advantages of using a hashmap:
         * > The hashmap does not contain duplicate product keys which means you could not input inventory for the product twice.
         * > A hashmap allows for reasonable lookup times, O(log(n)).
         * > In this case it is best use a hashmap as we are using the itemCode as a key, this cannot be done with Lists unless you are to
         * iterate through all products and check their itemCode. By using a hashmap we can use the itemCode as a key to grab the product
         * without iterating.
         * > The main advantage is that we can access an object by their key.
         */
    }

    // Search for Product in list and add to list in correct (Comparator defined) position if not found
    private static void searchList(List<Product> l, Product key, Comparator<Product> c) {
        int pos = Collections.binarySearch(l, key, c);

        if (pos >= 0) {
            System.out.println(key.getItemName() + " already in the list in position " + pos);
        }
        else {
            l.add(-pos-1, key);
            System.out.println(key.getItemName() + " not found in the list, added to position " + (-pos-1));
        }
    }
}
