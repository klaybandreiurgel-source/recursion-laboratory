import java.util.Scanner;

public class RecursiveRuler {

    // Recursively creates the smaller ruler markings
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

    // Recursively draws the ruler from 0 cm to the target length
    static void drawRuler(int currentCm, int targetCm) {

        // Base case
        if (currentCm > targetCm) {
            return;
        }

        // Print the main centimeter marking
        System.out.println(
            "-------- " + currentCm + " cm"
        );

        // Draw smaller markings between centimeters
        if (currentCm < targetCm) {
            drawSubdivisions(3);
        }

        // Recursive call for the next centimeter
        drawRuler(currentCm + 1, targetCm);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter ruler length in centimeters: ");
        int length = input.nextInt();

        // Validate input
        if (length < 0) {
            System.out.println("Please enter a non-negative number.");
            input.close();
            return;
        }

        System.out.println();
        System.out.println(length + "-cm recursive ruler");
        System.out.println("--------------------------------");

        // Start the recursive ruler
        drawRuler(0, length);

        // Convert centimeters to inches
        double inches = length / 2.54;

        System.out.printf(
            "%nEquivalent length: %.2f inches%n",
            inches
        );

        input.close();
    }
}