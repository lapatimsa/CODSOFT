import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {



                Scanner sc = new Scanner(System.in);


                System.out.print("Enter the number of subjects: ");
                int numSubjects = sc.nextInt();


                int[] marks = new int[numSubjects];


                for (int i = 0; i < numSubjects; i++) {
                    System.out.print("Enter marks for subject " + (i + 1) + ": ");
                    marks[i] = sc.nextInt();
                }


                int totalMarks = 0;
                for (int i = 0; i < numSubjects; i++) {
                    totalMarks += marks[i];
                }


                double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;


                String grade = "";
                if (averagePercentage >= 90) {
                    grade = "A+";
                } else if (averagePercentage >= 80) {
                    grade = "A";
                } else if (averagePercentage >= 70) {
                    grade = "B+";
                } else if (averagePercentage >= 60) {
                    grade = "B";
                } else if (averagePercentage >= 50) {
                    grade = "C";
                } else {
                    grade = "F";
                }
                System.out.println("\nTotal Marks: " + totalMarks);
                System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
                System.out.println("Grade: " + grade);


                sc.close();



    }
}
