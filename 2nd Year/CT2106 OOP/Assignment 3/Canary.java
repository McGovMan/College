
public class Canary extends Bird
{
    // instance variables - replace the example below with your own
    Boolean sing;

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
        sing = true;
    }

    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void sing(){
        System.out.println("tweet tweet tweet");
    }

    public boolean canSing() {
        return sing;
    }

    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from?
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "Canary; ";
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
        strng+= "Can fly: ";
        strng+= flies;
        strng+= "; ";
        strng+= "Can sing: ";
        strng+= canSing();
        strng+= "\n\n";
        // TOD0 Your job is to include the fields and attributes inherited
        //from Bird and Animal in the String representation
        return strng;
    }


    /**
     * equals method defines how equality is defined between
     * the instances of the Canary class
     * param Object
     * return true or false depending on whether the input object is
     * equal to this Canary object
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
        if (object instanceof Canary) {
            // Casting the object and checking all the details are the same as the existing object
            Canary canary = (Canary) object;
            if (this.getName() == canary.getName() && this.getColour() == canary.getColour()) {
                return true;
            }
        }

        return false;
    }
}
