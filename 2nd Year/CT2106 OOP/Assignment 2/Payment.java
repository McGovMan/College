import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Payment
{
    // Initialising Variables
    private Address billingAddress;
    private String ccType;
    private long ccNumber;
    private String ccDate;
    private String ccBankName;
    private Customer customer;
    private boolean billingAddressAvailability;
    
    public Payment(String ccType, long ccNumber, String ccDate, String ccBankName) {
        // Copying passed through variables into local variables
        this.ccNumber = ccNumber;
        this.ccType = ccType;
        this.ccDate = ccDate;
        this.ccBankName = ccBankName;
    }
    
    // This function validates if payment details are correct
    public boolean isValid() {
        String ccNumStr = Long.toString(ccNumber); // Converting to string so we can check position 0
        if (String.valueOf(ccNumber).length() == 16) { // Checking if card number is 16 digits long
            // Check if ccType is a valid payment type and if first number is corresponding to the payment type
            if ((ccType == "Mastercard" && ccNumStr.charAt(0) == '5') || (ccType == "Visa" && ccNumStr.charAt(0) == '4')) {
                // Using dates to validate cc expiry
                Date date = new Date(); // Getting today's date
                SimpleDateFormat sdfMMYY = new SimpleDateFormat("MM/yy"); // Formating today's Month and year as MM/yy
                
                try {
                    Date sdfcc = sdfMMYY.parse(ccDate); // Formatting ccDate as MM/YY
                    Date dateMMYY = sdfMMYY.parse(sdfMMYY.format(date)); // Formating today's date to MM/YY
                    
                    if (dateMMYY.compareTo(sdfcc) <= 0) { // Checking if ccDate is ahead of todays month and year or ahead of todays time
                        return true;
                    } else {
                        return false;
                    }
                } catch (ParseException e) {
                    System.out.println("Cannot parse cc expiry date given");
                }
            }
        }
        return false;
    }
    
    public void setBillAdd(Address billingAddress) {
        billingAddressAvailability = true;
        this.billingAddress = billingAddress;
    }
    
    public String getBillAdd() {
        if (billingAddressAvailability) { // Checks if delieryAddress has been set
            String out = billingAddress.getStreet() + ",\n\t\t\t" + billingAddress.getTown() + ",\n\t\t\t" + billingAddress.getCounty() + ",\n\t\t\t" + billingAddress.getCountry() + ",\n\t\t\t" + billingAddress.getEircode() + ".";
            return out;
        } else {
            String out = "N/A";
            return out;
        }
    }
}
