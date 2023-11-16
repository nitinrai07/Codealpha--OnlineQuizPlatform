package Npackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String text;
    private List<String> options;
    private int correctOption;

    public Question(String text, List<String> options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getText());

            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswer = sc.nextInt();

            if (userAnswer == currentQuestion.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getCorrectOption() + "\n");
            }
        }

        System.out.println("Quiz complete. Your score: " + score + "/" + questions.size());
        sc.close();
    }
}

public class OnlineQuizPlatform {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        List<String> options1 = new ArrayList<>();
        options1.add("Berlin");
        options1.add("Paris");
        options1.add("London");
        questions.add(new Question("What is the capital of France?", options1, 2));

        List<String> options2 = new ArrayList<>();
        options2.add("Mars");
        options2.add("Jupiter");
        options2.add("Venus");
        questions.add(new Question("Which planet is known as the Red Planet?", options2, 1));

        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}
