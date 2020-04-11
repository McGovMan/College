
public class Address
{
    private String street;
    private String town;
    private String county;
    private String country;
    private String eircode;
    
    public Address(String street, String town, String county, String country, String eircode) {
        this.street = street;
        this.town = town;
        this.county = county;
        this.country = country;
        this.eircode = eircode;
    }
    
    // Getter Functions
    public String getStreet() {
        return street;
    }
    
    public String getTown() {
        return town;
    }
    
    public String getCounty() {
        return county;
    }
    
    public String getCountry() {
        return country;
    }
    
    public String getEircode() {
        return eircode;
    }
    
}
