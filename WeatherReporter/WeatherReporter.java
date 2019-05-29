import java.io.*;
import java.util.*;

/**
 * Gives weather on specific day based on weather log
 *
 *
 * @author Sarah Worley
 */
public class WeatherReporter {
    
    /** Number for string operations */
    public static final int NUMBER = 6;

    /**
     * Starts the program
     *
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        userInterface();


    }



    /**
     * Interface with the user
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInputScanner(console);
        getWeather(fileScanner);
    }
    /**
    * reads info from scanner and prints in a easier to read
    * format.
    * @param input gets info from scanner
    */
    public static void getWeather(Scanner input) {
        input.nextLine();
        while (input.hasNext()) {

            String year = input.next();
            String newDate = date(year);
            double avg = input.nextDouble();
            double high = input.nextDouble();
            double  low = input.nextDouble();
            String weather = input.next();
            boolean didRain = rain(weather);
            boolean didSnow = snow(weather);

            System.out.printf(" %s ", newDate );
            System.out.printf("Low: %5.1f " , low);

            System.out.printf("High: %5.1f " , high);



            System.out.print("Rain: ");
            if (didRain) {
                System.out.print("yes ");
            } else {
                System.out.print(" no ");
            }


            System.out.print("Snow: ");
            if (didSnow){
                System.out.print("yes ");
            } else {
                System.out.print(" no ");
            }
            System.out.println();
        }
    }



    /** determines if its rained
    * @param condition whether it rained or not
    * @return returns true if it rained
    */
    public static boolean rain (String condition) {
        return condition.charAt(1) == '1';

    }

    /** determines if it snowed
    * @param condition whether it snowed or not
    * @return returns true if it snowed
    */
    public static boolean snow (String condition) {
        return condition.charAt(2) == '1';

    }

    /** interprets dates
    * @param n reads info from txt file
    * @return returns date in month/day/year format
    */
    public static String date ( String n ) {
        String year = n.substring( 0,( NUMBER - 2));
        String month = n.substring (( NUMBER - 2), NUMBER);
        String day = n.substring ( NUMBER, (NUMBER + 2));
        return month + "/" + day + "/" + year;
    }

    /**
     * Reads filename from user until the file exists, then return a file
     * scanner
     *
     * @param console Scanner that reads from the console
     *
     * @return a scanner to read input from the file
     */
    public static Scanner getInputScanner(Scanner console) {
        System.out.print("Enter a file name to process: ");
        File file = new File(console.next());
        while (!file.exists()) {
            System.out.print("File doesn't exist. " + "Enter a file name to process: ");
            file = new File(console.next());
        }
        Scanner fileScanner = null;// null signifies NO object reference
                                   // while (result == null) {
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found. ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return fileScanner;
    }

}
