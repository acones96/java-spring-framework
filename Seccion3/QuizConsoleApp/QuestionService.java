package Seccion3.QuizConsoleApp;

import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[5];
    String[] selection = new String[5];

    public QuestionService() {
        questions[0] = new Question(1, "Size of int", new String[] {"1", "2", "3", "4"}, "1");
        questions[1] = new Question(2, "Size of double", new String[] {"2", "3", "4", "5"}, "2");
        questions[2] = new Question(3, "Size of char", new String[] {"3", "4", "5", "1"}, "3");
        questions[3] = new Question(4, "Size of long", new String[] {"4", "5", "1", "2"}, "4");
        questions[4] = new Question(5, "Size of boolean", new String[] {"5", "1", "2", "3"}, "5");
    }


    public void playQuiz() {
        int j = 0;
        Scanner sc = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println("\nQuestion no. " + question.getId());
            System.out.println(question.getQuestion());

            for (int i = 0; i < question.getOpt().length; i++) {
                System.out.println("\t" + (char)('a' + i) + ". " + question.getOpt()[i]);
            }

            System.out.print("Your answer is: ");
            
            selection[j] = sc.nextLine();
            j++;
        }

        sc.close();
    }

    public void printScore() {
        int score = 0;
        
        for (int i = 0; i < questions.length; i++) {
            if (questions[i].getAnswer().equals(selection[i])) 
                score++;
        }

        System.out.println("\nYour score is: " + score + "/" + questions.length);
    }
}
