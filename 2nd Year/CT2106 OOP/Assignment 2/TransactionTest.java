import java.util.Scanner;

public class TransactionTest
{
    public static void main(String[] args)
    {
       TransactionTest test = new TransactionTest();
       test.transaction1(); // calls the method with our test scenario
       test.transaction2(); // calls the method with our test scenario
    }
    
    public void transaction1() {
        System.out.println("\nWelcome to the shop\n"); // Welcoming message
        Customer customer1 = new Customer("Conor", "McGovern", "C.McGovern15@nuigalway.ie"); // Creating Customer object
        ShoppingCart cart = new ShoppingCart(); // Creating ShoppingCart object
        
        // Creating item objects
        Item item1 = new Item("OnePlus 6", 13, 499);
        Item item2 = new Item("Lawnmower", 14, 899);
        Item item3 = new Item("College Degree", 15, 16999);
        
        // Adding items to cart
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.confirmCart();
        cart.close();
        
        // Setting addresses
        Address deliveryAddress = new Address("28 Greenfields Road", "Newcastle", "Co. Galway", "Ireland", "H91 CX68");
        Address billingAddress = new Address("Knocknaskeagh", "Kiltimagh", "Co. Mayo", "Ireland", "F12 A272");
        
        Payment firstPayment = new Payment("Visa", 4319444455556666L, "10/20", "Bank Of Ireland"); // Creating payment object
        
        Order firstOrder = new Order(cart, firstPayment); // Creating order object
        
        // Setting addresses in order and payment
        firstOrder.setDelAdd(deliveryAddress);
        firstPayment.setBillAdd(billingAddress);
        
        // Creating email object and sending email
        Email email = new Email(customer1);
        email.sendEmail(firstOrder);
    }
    
    public void transaction2() {  
        System.out.println("\n Welcome to the shop\n");
        Customer customer2 = new Customer("Niamh", "O'Leary", "niamhol@zmail.com");
        ShoppingCart cart = new ShoppingCart();
        
        Item item1 = new Item("Sausage", 10, 2);
        Item item2 = new Item("Eggs", 11, 3);
        Item item3 = new Item("Bread", 12, 1);
        
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.removeItem(item1);
        cart.confirmCart();
        cart.close();
        
        Address deliveryAddress = new Address("28 Greenfields Road", "Newcastle", "Co. Galway", "Ireland", "H91 CX68");
        Address billingAddress = new Address("Knocknaskeagh", "Kiltimagh", "Co. Mayo", "Ireland", "F12 A272");
        Payment firstPayment = new Payment("Visa", 4319444455556666L, "10/18", "Bank Of Ireland");
        Order firstOrder = new Order(cart, firstPayment);
        firstOrder.setDelAdd(deliveryAddress);
        firstPayment.setBillAdd(billingAddress);
        
        Email email = new Email(customer2);
        email.sendEmail(firstOrder);
    }
}