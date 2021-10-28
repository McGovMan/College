import java.util.*;

public class App {
    //Declare any global variables required (e.g. operation counts for each method)
    static long startTimeM1, endTimeM1, startTimeM2, endTimeM2, startTimeM3, endTimeM3, startTimeM4, endTimeM4;
    static int countM1 = 0, countM2 = 0, countM3 = 0, countM4 = 0;
    static List<Integer> myListM1 = new ArrayList<>(), myListM2 = new ArrayList<>(), myListM3 = new ArrayList<>(), myListM4 = new ArrayList<>();
    static int[] validPalindromes = {0, 1, 3, 5,7, 9, 33, 99, 313, 585, 717, 7447, 9009, 15351, 32223, 39993, 53235, 53835, 73737, 585585};

    // Main Method
    public static void main (String[] args) {
        //Declare any variables used (e.g. for timing etc.)

        //Test each method (looping over the binary/decimal numbers for each)
        //by calling your defined methods below
        testMethods();

        // Display results for each method
        System.out.print("\nMethod 1 errors (if any): \n");
        for (int i : myListM1) {
            if (existsInValidPalindromes(i)) System.out.printf("error i: %d", i);
        }

        System.out.print("\nMethod 2 errors (if any): \n");
        for (int i : myListM2) {
            if (existsInValidPalindromes(i)) System.out.printf("error i: %d", i);
        }

        System.out.print("\nMethod 3 errors (if any): \n");
        for (int i : myListM3) {
            if (existsInValidPalindromes(i)) System.out.printf("error i: %d", i);
        }

        System.out.print("\nMethod 4 errors (if any): \n");
        for (int i : myListM4) {
            if (existsInValidPalindromes(i)) System.out.printf("error i: %d", i);
        }

        // Note: Think carefully about the design of your main method
        //If designed correctly, you will be able to automate the running of
        //experiments over many number ranges instead of having to manually
        //change the values for each run. The data produced can then be used for
        // graphing in Excel.
    }

    static boolean existsInValidPalindromes(int i) {
        for (int y : validPalindromes) {
            if (i == y) return false;
        }
        return true;
    }

    static void testMethods() {
        startTimeM1 = System.currentTimeMillis(); // Init count
        countM1++;
        countM1++;
        System.out.print("Method1\nInterval\tNum Operations\n");
        for (int i = 0; i < 1000000; i++) {
            countM1++; // init i && i < num check
            countM1 += 5;
            if (loopString(String.valueOf(i)) && loopString(decToBin(String.valueOf(i)))) { // call 2 x loopString, 2 x convert to string, convert to binary
                myListM1.add(i); // add to array
                countM1++;
            }
            if (i % 50000 == 0) {
                System.out.printf("%d\t%d\n", i, countM1);
            }
            countM1++; // increment i
        }
        endTimeM1 = System.currentTimeMillis() - startTimeM1;
        System.out.printf("Time Taken: %d ms\n\n", endTimeM1);

        startTimeM2 = System.currentTimeMillis();
        countM2++;
        System.out.print("Method 2\nInterval\tNum Operations\n");
        for (int i = 0; i < 1000000; i++) {
            countM2 += 2; // init i && i < num check
            countM2 += 5;
            if (checkIndividually(String.valueOf(i)) && checkIndividually(decToBin(String.valueOf(i)))) {
                myListM2.add(i); // add to array
                countM2++; // add to array
            }
            if (i % 50000 == 0) {
                System.out.printf("%d\t%d\n", i, countM2);
            }
            countM2++; //increment i
        }
        endTimeM2 = System.currentTimeMillis() - startTimeM2;
        System.out.printf("Time Taken: %d ms\n\n", endTimeM2);

        startTimeM3 = System.currentTimeMillis();
        countM3++;
        System.out.print("Method 3\nInterval\tNum Operations\n");
        for (int i = 0; i < 1000000; i++) {
            countM3 += 2; // init i && i < num check
            countM3 += 5;
            if (stackCheck(String.valueOf(i)) && stackCheck(decToBin(String.valueOf(i)))) {
                myListM3.add(i);
                countM3++;
            }
            if (i % 50000 == 0) {
                System.out.printf("%d\t%d\n", i, countM3);
            }
            countM3++; // increment i
        }
        endTimeM3 = System.currentTimeMillis() - startTimeM3;
        System.out.printf("Time Taken: %d ms\n\n", endTimeM3);

        startTimeM4 = System.currentTimeMillis();
        countM4++;
        System.out.print("Method 4\nInterval\tNum Operations\n");
        for (int i = 0; i < 1000000; i++) {
            countM4 += 2; // init i && i < num check
            countM4 += 5;
            if (recursiveStringCheck(String.valueOf(i)) && recursiveStringCheck(decToBin(String.valueOf(i)))) {
                myListM4.add(i);
                countM4++;
            }
            if (i % 50000 == 0) {
                System.out.printf("%d\t%d\n", i, countM4);
            }
            countM4++; // increment i
        }
        endTimeM4 = System.currentTimeMillis() - startTimeM4;
        System.out.printf("Time Taken: %d ms\n\n", endTimeM4);
    }
    //Static method for: Palindrome Method 1 (give it a name based on how it works)
    //Takes a String as a parameter and return a Boolean value
    static Boolean loopString(String in) {
        StringBuilder out = new StringBuilder(); // init string builder
        countM1++;
        countM1++;
        for (int i = in.length() - 1; i >= 0; i--) { // init i, call in.length, check i,
            countM1 += 2;
            out.append(in.charAt(i)); // get character and append
            countM1 += 2;
            countM1++; // increment i
        }
        countM1 += 3; // check if equals, call toString, return true or false
        return in.equals(out.toString());
    }

    //Static method for: Palindrome Method 2 (give it a name based on how it works)
    //Takes a String as a parameter and return a Boolean value
    static Boolean checkIndividually(String in) {
        countM2++;
        for (int i = 0; i < in.length(); i++) { // init i, call in.length, check i,
            countM2 += 2;
            countM2 += 2;
            if (in.length() == 1) { // call in.length, check
                countM2++; // return true
                return true;
            }
            countM2 += 4;
            if (in.charAt(i) != in.charAt(in.length() - i - 1)) { // 2 x get chatAt i, get in.length, check if the same
                return false;
            }
        }
        countM2++;
        return true;
    }

    //Static method for: Palindrome Method 3 (give it a name based on how it works)
    //Takes a String as a parameter and return a Boolean value
    static Boolean stackCheck(String in) {
        Stack<Character> s = new Stack<>(); // init stack
        countM3++;
        countM3++;
        for (char x : in.toCharArray()) { // call toCharArray, get x
            countM3+=2;
            s.push(x);
        }
        for (char x : in.toCharArray()) {
            countM3 += 2;
            countM3+=4;
            if (!s.isEmpty() && x == s.peek()) { // check is not empty, call s.peek, call isempty, check is not equal to x
                countM3++;
                s.pop(); // check is not empty, check top of stack
            }
            else {
                countM3++;
                return false;
            }
        }
        countM3++;
        return s.isEmpty();
    }

    //Static method for: Palindrome Method 4 (give it a name based on how it works)
    //Takes a String as a parameter and return a Boolean value
    static Boolean recursiveStringCheck(String in) {
        countM4 += 3;
        return reverse(in).equals(in); // return, call reverse, check if equal
    }

    //Static method for: Recursively reversing a String (to be used by Method 4)
    //Takes a String and returns a String value of it reversed (must use recursion)
    static String reverse(String in) {
        countM4++; // if check
        if (in.isEmpty()) {
            countM4++;
            return in;
        }
        countM4 += 5;
        return reverse(in.substring(1)) + in.charAt(0);
    }

    //Static method for: Converting a decimal number into its equivalent binary representation
    //Takes a String representation of a number as a parameter and return a String value
    static String decToBin(String input) {
        Stack<Integer> s = new Stack<>();
        int in = Integer.parseInt(input);
        StringBuilder out = new StringBuilder();

        if (!input.equals("0")) {
            while (in != 0) {
                s.push(in % 2);
                in /= 2;
            }
            while (!s.isEmpty()) {
                out.append(s.peek());
                s.pop();
            }
        } else {
            out.append(input);
        }
        return out.toString();
    }
}