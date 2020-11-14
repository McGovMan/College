/*
 * Base class Product
 * @author Conor Mc Govern (18343763)
 */

// Java core packages
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// External packages
import org.joda.money.Money;

public class Product implements Comparable<Product> {

    private Long itemCode;
    private String itemName;
    private Money itemCost;
    private String description;
    private Integer inventory;

    // default constructor
    public Product() {

    }

    // constructor
    public Product(long itemCode, String itemName, Money itemCost, String description, Integer inventory) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.description = description;
        this.inventory = inventory;
    }

    /*
     * Name: readFile
     * Reads a file line by line and gives the line to readObject, the object returned by readObject is then added to a list, which is returned.
     * @param String filename
     * @throws IOException
     * @return List<Product>
     */
    public static List<Product> readFile(String filename) throws IOException {
        List<Product> products = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();

        while (line != null) {
            // Add object to list
            products.add(Product.readObject(line));

            // read in next line
            line = reader.readLine();
        }

        return products;
    }

    /*
     * Name: readObject
     * Creates a Product object from CSV line
     * @param String str - a single line of a CSV file
     * @return Product
     */
    public static Product readObject(String str) {
        String[] att = str.split(",");

        long itemCode = Long.parseLong(att[0]);
        String itemName = att[1];
        Money itemCost = Money.parse(att[2]);
        String description = att[3];
        Integer inventory = Integer.parseInt(att[4]);

        return new Product(itemCode, itemName, itemCost, description, inventory);
    }

    // Code taken from module examples and modified to suit this assignment
    // Equality and identity are not necessarily the same e.g. two String objects could have the same string value but be different objects
    // Override the equals() method inherited from java.lang.Object to properly define equality between objects of this class
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // Also possible to use instanceof here but getClass() is recommended, especially if the object being checked could be an instance of a subclass (not relevant here)
        // if (!(o instanceof Product))
        //  return false;
        Product p = (Product) o;
        // field comparison
        return itemCode.equals(p.itemCode) && itemName.equals(p.itemName) && itemCost.equals(p.itemCost) && description.equals(p.description) && inventory.equals(p.inventory);
    }

    // Code taken from module examples and modified to suit this assignment
    // Also override the hashCode() method inherited from java.lang.Object - this returns a value which can be seen as an object’s equality boiled down to an integer value
    // Instances with the same hash code are not necessarily equal but equal instances will always have the same hash code
    // The hash code can greatly reduce the number of possible matches when searching for an object in a data structure like a HashMap
    // Such data structures are often named after this technique, recognisable by the Hash in their name, with HashMap the most notable representative
    public int hashCode() {
        // If two objects are equal according to the equals() method, then calling the hashCode method on each of the two objects must produce the same integer result
        // A common algorithm is to start with some arbitrary number and to repeatedly multiply it with another (often a small prime) before adding a field’s hash
        // This might result in overflows, which is not particularly problematic because they cause no exceptions in Java
        int prime = 31;
        int result = 1;

        result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
        result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
        result = prime * result + ((itemCost == null) ? 0 : itemCost.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
        return result;
    }

    // Print out something useful about the object
    public String toString() {
        return "Item Code: " + itemCode + "\tItem Name: " + itemName + "\tItem Cost: " + itemCost.toString() + "\tDescription: " + description + "\tInventory: " + inventory;
    }

    /*
     * Getter Methods
     */
    public long getItemCode() {
        return this.itemCode;
    }

    public String getItemName() {
        return this.itemName;
    }

    public Money getItemCost() {
        return this.itemCost;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getInventory() {
        return this.inventory;
    }

    /*
     * Setter Methods
     */
    public void setItemCode(long itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemCost(Money itemCost) {
        this.itemCost = itemCost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    // Implement the Comparable interface which defines the natural order for objects of this class
    @Override
    public int compareTo(Product p) {
        return itemCode.compareTo(p.itemCode);
    }
}
