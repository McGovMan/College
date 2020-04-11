import java.util.ArrayList;
import java.util.Arrays;

public class Order
{
    // Initialising variables
    private Address deliveryAddress;
    private boolean deliveryAddressAvailability;
    private Payment payment;
    private ShoppingCart cart;
    private ArrayList<Item> confirmedItems;
    private long orderNumber;
    private int totalPrice;
    
    public Order(ShoppingCart cart, Payment payment) {
        confirmedItems = new ArrayList<>(); // Initialising ArrayList
        orderNumber = setOrderId(); // Creating order ID
        
        // Copying passed through objects
        this.cart = cart;
        this.payment = payment;
        
        this.totalPrice = cart.getTotal(); // Getting total price for order
        
        for (int i = 0; i < cart.sizeOfItems(); i++) {
            confirmedItems.add(cart.getItem(i)); // Adding items individually to order
        }
        
        cart.clear(); // Clearing shopping cart
    }
    
    // Setter Functions
    public long setOrderId() {
        return (long)(Math.random() * 99999999999999L);
    }
    
    public void setDelAdd(Address deliveryAddress) {
        deliveryAddressAvailability = true;
        this.deliveryAddress = deliveryAddress;
    }
    
    public void printItems() {
        for (int i = 0; i < confirmedItems.size(); i++) {
            System.out.println("\t" + confirmedItems.get(i));
        }
    }
    
    // Getter Functions
    public String getDelAdd() {   
        if (deliveryAddressAvailability) { // Checks if delieryAddress has been set
            String out = deliveryAddress.getStreet() + ",\n\t\t\t" + deliveryAddress.getTown() + ",\n\t\t\t" + deliveryAddress.getCounty() + ",\n\t\t\t" + deliveryAddress.getCountry() + ",\n\t\t\t" + deliveryAddress.getEircode() + ".";
            return out;
        } else {
            String out = "N/A";
            return out;
        }
    }
    
    public int getTotalPrice() {
        return totalPrice;
    }
    
    public long getOrderId() {
        return orderNumber;
    }
    
    public Payment getPayment() {
        return payment;
    }
}
