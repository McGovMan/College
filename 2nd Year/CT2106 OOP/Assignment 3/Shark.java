
public class Shark extends Fish
{
    // instance variables - replace the example below with your own
    Boolean canBite;
    Boolean isDangerous;

    /**
     * Constructor for objects of class Shark
     */
    public Shark(String name)
    {
        super(); // call the constructor of the superclass fish
        this.name = name;
        isDangerous = true;
        canBite = true;
    }

    /**
     * Sing method overrides the sing method
     * inherited from superclass fish
     */
    public boolean isDangerous(){
        return isDangerous;
    }

    public boolean canBite() {
        return canBite;
    }

    /**
     * toString method returns a String representation of the fish
     * What superclass has Canary inherited this method from?
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "Shark; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "; ";
        strng+= "\n";
        strng+= "Gills: ";
        strng+= hasGills();
        strng+= "; ";
        strng+= "Fins: ";
        strng+= hasFins();
        strng+= "; ";
        strng+= "Swim: ";
        strng+= swims();
        strng+= "; ";
        strng+= "Dangerous: ";
        strng+= isDangerous();
        strng+= "; ";
        strng+= "Can bite: ";
        strng+= canBite();
        strng+= "\n\n";
        // TOD0 Your job is to include the fields and attributes inherited
        //from Fish and Animal in the String representation
        return strng;
    }


    /**
     * equals method defines how equality is defined between
     * the instances of the Shark class
     * param Object
     * return true or false depending on whether the input object is
     * equal to this Shark object
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
        if (object instanceof Shark) {
            // Casting the object and checking all the details are the same as the existing object
            Shark shark = (Shark) object;
            if (this.getName() == shark.getName() && this.getColour() == shark.getColour()) {
                return true;
            }
        }

        return false;
    }
}
