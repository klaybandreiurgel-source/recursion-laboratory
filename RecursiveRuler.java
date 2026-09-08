import java.util.Scanner;

public class RecursiveRuler {

    /*
     * Description: Draws a ruler using recursion and displays
     * the equivalent measurement in inches.
     * Programmed by: Clive Andrei C. Urgel, BSIT, 48143,Data Structure
     * Last Modified: September 7, 2026
     * Version: 1.0
     * Acknowledgements: Generative AI used for explanation of function of code,
     * explnation of recursion, and how it works.
     */

    // Generates the smaller markings recursively
    static void drawSubdivisions(int level) {

        // Base case
        if (level <= 0) {
            return;
        }

        // Recursive call
        drawSubdivisions(level - 1);

        // Print the marking
        System.out.println("-".repeat(level + 1));

        // Recursive call
        drawSubdivisions(level - 1);
    }

    // Draws the ruler recursively
    static void drawRuler(int currentCm, int targetCm) {

        // Show the recursive trace
        System.out.println(
            "TRACE: drawRuler(" + currentCm + ", " + targetCm + ")"
        );

        // Base case
        if (currentCm > targetCm) {
            System.out.println(
                "TRACE: Base case reached (" + currentCm
                + " > " + targetCm + ")"
            );
            return;
        }

        // Print centimeter marking
        System.out.println(
            "-------- " + currentCm + " cm"
        );

        // Generate subdivisions
        if (currentCm < targetCm) {
            drawSubdivisions(3);
        }

        // Recursive call
        drawRuler(currentCm + 1, targetCm);

        // Show when the function returns
        System.out.println(
            "TRACE: Returning from drawRuler("
            + currentCm + ", " + targetCm + ")"
        );
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask the user for the ruler length
        System.out.print("Enter ruler length in centimeters: ");
        int length = input.nextInt();

        // Validate input
        if (length < 0) {
            System.out.println(
                "Please enter a non-negative number."
            );
            input.close();
            return;
        }

        System.out.println();
        System.out.println("===== RECURSIVE RULER =====");
        System.out.println();

        // Call the recursive ruler
        drawRuler(0, length);

        // Convert centimeters to inches
        double inches = length / 2.54;

        System.out.println();
        System.out.printf(
            "Equivalent measurement: %.2f inches%n",
            inches
        );

        input.close();
    }
}
