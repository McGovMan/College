
public class Trout extends Fish
{
    // instance variables - replace the example below with your own
    Boolean spikes;
    Boolean edible;
    Boolean swimsUpriverToLayEggs;

    /**
     * Constructor for objects of class Shark
     */
    public Trout(String name)
    {
        super(); // call the constructor of the superclass fish
        this.name = name;
        colour = "brown";
        spikes = true;
        edible = true;
        swimsUpriverToLayEggs = true;
    }

    public boolean spikes(){
        return spikes;
    }
    public boolean edible() {
        return edible;
    }
    public boolean swimsUpriverToLayEggs() {
        return swimsUpriverToLayEggs;
    }

    /**
     * toString method returns a String representation of the fish
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "Trout; ";
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
        strng+= "Swims upriver to lay eggs: ";
        strng+= swimsUpriverToLayEggs();
        strng+= "; ";
        strng+= "Edible: ";
        strng+= edible();
        strng+= "; ";
        strng+= "Has spikes: ";
        strng+= spikes();
        strng+= "\n\n";
        // TOD0 Your job is to include the fields and attributes inherited
        //from Fish and Animal in the String representation
        return strng;
    }


    /**
     * equals method defines how equality is defined between
     * the instances of the Trout class
     * param Object
     * return true or false depending on whether the input object is
     * equal to this Trout object
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
        if (object instanceof Trout) {
            // Casting the object and checking all the details are the same as the existing object
            Trout trout = (Trout) object;
            if (this.getName() == trout.getName() && this.getColour() == trout.getColour()) {
                return true;
            }
        }

        return false;
    }
}
