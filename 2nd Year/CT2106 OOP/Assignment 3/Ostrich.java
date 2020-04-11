
public class Ostrich extends Bird
{
    // instance variables - replace the example below with your own
    Boolean isTall;
    Boolean hasLongThinLegs;

    /**
     * Constructor for objects of class Canary
     */
    public Ostrich(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "pink"; // this overrides the value inherited from Bird
        flies = false;
        isTall = true;
        hasLongThinLegs = true;
    }

    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     **/

    @Override
    public boolean flies() {
        return flies;
    }

    public boolean isTall() {
        return isTall;
    }

    public boolean hasLongThinLegs() { return hasLongThinLegs; }

    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from?
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "Ostrich; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "; ";
        strng+= "\n";
        strng+= "Skin: ";
        strng+= hasSkin();
        strng+= "; ";
        strng+= "Wings: ";
        strng+= hasWings();
        strng+= "; ";
        strng+= "Feathers: ";
        strng+= hasFeathers();
        strng+= "; ";
        strng+= "Is Tall: ";
        strng+= isTall();
        strng+= "; ";
        strng+= "Has long thin legs: ";
        strng+= hasLongThinLegs();
        strng+= "; ";
        strng+= "Can fly: ";
        strng+= flies;
        strng+= "\n\n";
        // TOD0 Your job is to include the fields and attributes inherited
        //from Bird and Animal in the String representation
        return strng;
    }


    /**
     * equals method defines how equality is defined between
     * the instances of the Ostrich class
     * param Object
     * return true or false depending on whether the input object is
     * equal to this Ostrich object
     */

    @Override
    public boolean equals(java.lang.Object object){
        //TODO : You have to define an equals method for this class
        // Checks if an object has been given.
        if (object == null) {
            System.out.print("Object given is NULL\n");
            return false;
        }

        // Check if object given is the same type, or else the object cannot be casted
        if (object instanceof Ostrich) {
            // Casting the object and checking all the details are the same as the existing object
            Ostrich ostrich = (Ostrich) object;
            if (this.getName() == ostrich.getName() && this.getColour() == ostrich.getColour()) {
                return true;
            }
        }

        return false;
    }
}
