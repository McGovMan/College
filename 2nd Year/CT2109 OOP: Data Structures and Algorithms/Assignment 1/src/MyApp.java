import java.util.Scanner;

public class MyApp {
    public static void main(String [] args) {
        System.out.print("Type the alphabet in order (hit enter between letters)\n");
        System.out.print("Forwards or Backwards (f/b)?");

        /* Initialising array of chars and calling initAlphabet which will return
        *  an array of characters starting with a or z depending on the input from
        *  the user */
        char alphabet[] = initAlphabet(), in;
        int i;
        double startTime;

        System.out.printf("Type: %s\n", alphabet[0]);
        // Taking starting time of when "Type: a" is printed on the screen
        startTime = System.currentTimeMillis();

        /* In this for loop we are getting input from the user, comparing that
        *  against the current position in the array, if its not equal to the character
        *  in the array, we loop again on the same position until they get it right.
        *  I was going to use a for each loop or iterator but it proved to be unreadable
        *  and awkward as I need the position + 1 which is hard to achieve in a for each with
        *  an array instead of an ArrayList as you can't use .hasNext to tell if you're at
        *  the last character to instead display Correct! Well Done! so you don't get an out of
        *  bounds issue with the array trying to access i + 1 when i + 1 doesn't exist.*/
        for (i = 0; i < 26; i ++) {
            in = getInput();
            if (in == alphabet[i] && i != 25) System.out.printf("Correct! Now Type: %s\n", alphabet[i + 1]);
            else if (in == alphabet[i] && i == 25) System.out.print("Correct! Well Done!\n");
            else i--;
        }

        // Printing out the total time taken
        System.out.printf("Time Taken: %.2f seconds\n", (System.currentTimeMillis() - startTime)/1000);
    }

    private static char getInput() {
        // Taking input from the user
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        // Checking that input is only 1 characters, else call getInput again until 1 character is supplied.
        if (input.length() == 1) return input.toLowerCase().charAt(0);
        else {
            System.out.print("Error, input a single character\n");
            return getInput();
        }
    }

    private static char[] initAlphabet() {
        // Initialising a temp array to return
        char a[] = new char[26], in;
        int i, y = 0;

        // Asking user for input for forward or backward
        in = getInput();

        /* Checking if input is f or b and generating the array based on the direction the
        *  user wishes to type the array respectfully, else call function again until they
        *  give a f or b */
        if(in == 'f') {
            for(i = 97; i < 123; i++) a[i - 97] = (char)i;
        }
        else if(in == 'b') for(i = 122; i >= 97; i--) {
            a[y] = (char)i;
            y++;
        }
        else {
            return initAlphabet();
        }
        return a;
    }
}