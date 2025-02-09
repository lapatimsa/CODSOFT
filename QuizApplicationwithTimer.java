import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class QuizApplicationwithTimer {



        static class Question {
            String questionText;
            String[] options;
            String correctAnswer;

            Question(String questionText, String[] options, String correctAnswer) {
                this.questionText = questionText;
                this.options = options;
                this.correctAnswer = correctAnswer;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Timer tr = new Timer();
            int score = 0;
            int totalQuestions = 5;
            boolean[] answeredCorrectly = new boolean[totalQuestions];

            // Quiz questions and options
            Question[] questions = new Question[] {
                    new Question("What is the capital of India?", new String[] {"New Delhi", "Kolkata", "Mumbai", "Patna"}, "New Delhi"),
                    new Question("What is 2 + 2?", new String[] {"3", "4", "5", "6"}, "4"),
                    new Question("Which planet is known as the Red Planet?", new String[] {"Earth", "Mars", "Jupiter", "Saturn"}, "Mars"),
                    new Question("Who wrote 'Romeo and Juliet'?", new String[] {"Shakespeare", "Dickens", "Austen", "Hemingway"}, "Shakespeare"),
                    new Question("What is the largest ocean on Earth?", new String[] {"Atlantic", "Indian", "Arctic", "Pacific"}, "Pacific")
            };

            // Timer setup for each question (30 seconds per question)
            for (int i = 0; i < totalQuestions; i++) {
                final int questionIndex = i;
                System.out.println("Question " + (i + 1) + ": " + questions[i].questionText);
                for (int j = 0; j < questions[i].options.length; j++) {
                    System.out.println((j + 1) + ". " + questions[i].options[j]);
                }

                // Timer to limit answer time to 30 seconds
                final boolean[] questionAnswered = new boolean[1];
                final long startTime = System.currentTimeMillis();

                tr.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (!questionAnswered[0]) {
                            System.out.println("Time's up! Moving to the next question.");
                            answeredCorrectly[questionIndex] = false;  // Mark as incorrect if time runs out
                        }
                    }
                }, 30000);  // 30 seconds

                // Wait for user input to select an answer
                String userAnswer = "";
                while (System.currentTimeMillis() - startTime < 30000) {
                    if (sc.hasNext()) {
                        userAnswer = sc.nextLine().trim();
                        questionAnswered[0] = true;
                        break;
                    }
                }

                // Check if the answer is correct
                if (userAnswer.equalsIgnoreCase(questions[i].correctAnswer)) {
                    System.out.println("Correct!\n");
                    answeredCorrectly[questionIndex] = true;
                    score++;
                } else if (!userAnswer.isEmpty()) {
                    System.out.println("Incorrect. The correct answer is: " + questions[i].correctAnswer + "\n");
                }

                // Check if the question timed out
                if (!questionAnswered[0]) {
                    System.out.println("The correct answer was: " + questions[i].correctAnswer + "\n");
                }
            }

            // Display result screen
            System.out.println("Quiz Completed!");
            System.out.println("Your final score is: " + score + "/" + totalQuestions);
            System.out.println("\nDetailed Results:");
            for (int i = 0; i < totalQuestions; i++) {
                System.out.println("Question " + (i + 1) + ": " + (answeredCorrectly[i] ? "Correct" : "Incorrect"));
            }

            sc.close();
            tr.cancel();
        }


}
