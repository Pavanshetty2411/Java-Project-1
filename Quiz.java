import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Question {
    private String questionText;
    private List<String> options;
    private int correctOptionIndex;
    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
    public String getQuestionText() {
        return questionText;
    }
    public List<String> getOptions() {
        return options;
    }
    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}
class Quiz {
    private String quizName;
    private List<Question> questions;
    public Quiz() {
        this.questions = new ArrayList<>();
    }
    public void addQuestion(Question question) {
        questions.add(question);
    }
    public List<Question> getQuestions() {
        return questions;
    }
}
class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("Who was the first Prime Minister of India", List.of("A. Indira Gandhi", "B. Morarji Desai", "C. Jawaharlal Neharu", "D. Lal Bahadur Shastri"), 2));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?", List.of("A. Mars", "B. Jupiter", "C. Saturn", "D. Venus"), 0));
        quiz.addQuestion(new Question("Who discovered India?", List.of("A. Vasco da Gama", "B. Christopher columbus", "C. James Cook", "D. Willem Janszoonn"), 0));
         quiz.addQuestion(new Question("Where is Jog Falls Situated in?", List.of("A. Bengaluru", "B. Udupi", "C. Shimoga", "D. Gadag"), 2));
        System.out.println("Welcome to the General Knowledge Quiz!");
        System.out.println("----------------------------");
        int score = 0;
        List<Question> questions = quiz.getQuestions();
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Your answer (Enter A, B, C, or D): ");
            String userAnswer = scanner.nextLine().toUpperCase();
            int userChoice = -1;
            switch (userAnswer) {
                case "A":
                    userChoice = 0;
                    break;
                case "B":
                    userChoice = 1;
                    break;
                case "C":
                    userChoice = 2;
                    break;
                case "D":
                    userChoice = 3;
                    break;
                default:
                    System.out.println("Invalid choice. Skipping to next question.");
                    continue;
            }
            if (userChoice == question.getCorrectOptionIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.\n The correct answer is: " + question.getOptions().get(question.getCorrectOptionIndex()));
            }
            System.out.println("----------------------------");
        }

        System.out.println("Quiz ended.\n Your score: " + score + "/" + questions.size());
        if(score>=2)
        System.out.println("****Great Performance****");
        else if(score<2)
        System.out.println("****You want to improve your General Knowledge****");
        scanner.close();
    }
}
