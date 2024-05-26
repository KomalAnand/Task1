import java.util.Scanner;

public class Grade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSubjects;
        do {
            System.out.print("Enter the number of subjects (or 0 to stop): ");
            try {
                numSubjects = scanner.nextInt();
                if (numSubjects < 0) {
                    System.out.println("Invalid number of subjects. Please enter a non-negative number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine(); // Clear the buffer for next input
            }
        } while (numSubjects < 0);

        if (numSubjects > 0) {
            int[] marks = new int[numSubjects];
            for (int i = 0; i < numSubjects; i++) {
                do {
                    System.out.printf("Enter marks for subject %d (out of 100): ", i + 1);
                    try {
                        marks[i] = scanner.nextInt();
                        if (marks[i] < 0 || marks[i] > 100) {
                            System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a whole number.");
                        scanner.nextLine(); // Clear the buffer for next input
                    }
                } while (marks[i] < 0 || marks[i] > 100);
            }

            calculateAndDisplayResults(marks);
        }

        scanner.close();
    }

    public static void calculateAndDisplayResults(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = (double) totalMarks / marks.length * 100;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}

