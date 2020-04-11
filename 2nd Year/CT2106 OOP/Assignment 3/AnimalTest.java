public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();

        // Calling for test 1 & 2 to run
        test.test1();
        test.test2();
    }

    public void test1() {
        System.out.print("Test 1 - Uses an array and prints out all details on the animals\n\n");

        // Initalising array of animal objects
        Animal[] animals = new Animal[4];
        animals[0] = new Canary("Harry");
        animals[1] = new Ostrich("Albert");
        animals[2] = new Shark("David");
        animals[3] = new Trout("Seamus");

        // Java searches for toString function and prints out the information on the animal
        for (int i = 0; i < animals.length; i++) {
            System.out.print(animals[i]);
        }
    }

    public void test2() {
        System.out.print("Test 2 - Uses an array and compares all of the animal objects\n\n");

        // Initalising array of animal objects
        Animal[] animals = new Animal[10];
        animals[0] = new Canary("Albert");
        animals[1] = new Ostrich("Seamus");
        animals[2] = new Shark("Noel");
        animals[3] = new Trout("Eamon");
        animals[4] = new Trout("Conor");
        animals[5] = new Canary("Laura");
        animals[6] = new Canary("Ciara");
        animals[7] = new Ostrich("Cian");
        animals[8] = new Shark("Noel");
        animals[9] = new Ostrich("Seamus");

        for (int i = 0; i < animals.length; i++) { // Runs through all the animal objects to compare them
            int y = i; // Sets y = i as there is no point comparing any previous objects as they have already been checked
            for (y = 0; y < animals.length; y++) {
                if (animals[i].equals(animals[y]) && i != y && !(y < i)) { // Compares animal in position i to all animals between the position i + 1 and 9
                    System.out.printf("%s the %s in position %d in the array matched %s the %s in position %d in the array\n", animals[i].getName(), animals[i].getClassName(), i, animals[y].getName(), animals[y].getClassName(), y); // Prints out the match
                } /*
                  ** In case you want to print out all the ones that don't match
                  ** else {
                  ** System.out.printf("%s the %s in position %d doesn't match %s the %s in position %d\n", animals[i].getName(), animals[i].getClassName(), i, animals[y].getName(), animals[y].getClassName(), y);
                } */
            }
        }
    }
}
