
public class Email
{
    // Initialising variables
    private Customer customer;
    private Order order;
    
    public Email (Customer customer) {
        // copying passed in customer into our costomer
        this.customer = customer;
    }
    
    public void sendEmail(Order order) {
        /* This function takes the passed through order, grabs all the customer,
         * grabs all the customer information and generates a confirmation letter,
         * Unless the payment information is incorrect */
        System.out.println("----------------------");
        System.out.println("Mailto:" + customer.getEmailAddress());
        System.out.println("\nMr/Mrs " + customer.getFirstName() + " " + customer.getSurName() + ",\n");
        if(order.getPayment().isValid()){
            System.out.println("Below are the details for your order, I hope everything is saticfactory");
            System.out.println("\n   Order no. " + order.getOrderId());
            System.out.println("   Items: ");
            order.printItems();
            System.out.println("   Total: " + order.getTotalPrice());
            System.out.println("\n   Delivery address: " + order.getDelAdd()); // Will display N/A if no address is given
            System.out.println("\n   Billing address: " + order.getPayment().getBillAdd()); // Will display N/A if no address is given
            System.out.println("\nThank you again for shopping here\nKind Regards,\nThe Shop Staff");
        }
        else{
            System.out.println("We couldn't validate your payment information.\nUnfortunetly your order has not been processed.");
            System.out.println("\nKind Regards\nThe Shop Staff");
        }
    }
}


