import java.rmi.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SurveyClient
{
    public static void main (String args[])
    {
        try {
            String uri = "//localhost/Questionnaires";
            SurveyServer surveyServer = (SurveyServer) Naming.lookup(uri);
            if (surveyServer == null)
            {
                System.out.println("DEBUG: Cannot connect to server");
                return;
            }

            System.out.println("Successfully connected to: " + uri + "\n");
            ArrayList<QuestionnaireSummary> questionnaireSummaryList = surveyServer.getQuestionnaireSummaryList();
            System.out.println("Available surveys: " + questionnaireSummaryList.size() + "\n");

            boolean repeat;
            do {
                System.out.println("List of surveys: ");
                for (QuestionnaireSummary qs : questionnaireSummaryList)
                {
                    System.out.println("  Survey name: " + qs.getName());
                    System.out.println("  Survey Description: " + qs.getDescription());
                    System.out.println("  --");
                }

                int id;
                Scanner scanner = new Scanner(System.in);
                // Keep looping until we get a valid ID from the user
                do {
                    System.out.print("\nPlease choose a survey from one of they following options:\n ( ");
                    for (int i = 0; i < questionnaireSummaryList.size(); i++)
                    {
                        System.out.print(i+1);
                        if (i < questionnaireSummaryList.size() - 1)
                            System.out.print(",");
                    }
                    System.out.print(" ): ");
                    id = Integer.parseInt(scanner.nextLine());
                } while (id > questionnaireSummaryList.size() || id < 1);

                Questionnaire q = surveyServer.getQuestionnaire(id - 1);
                Question[] questions = q.getQuestions();

                // Loop over each question and ask for input
                for (Question question : questions) {
                    System.out.println("\nQuestion: " + question.getQuestion());
                    String[] answers = question.getAnswers();
                    for(int i = 0; i < answers.length; i++) {
                        System.out.println(" " + (i+1) + ": " + answers[i]);
                    }

                    // Keep looping and asking for input until input is valid
                    do {
                        System.out.print("Enter answer: ");
                        id = Integer.parseInt(scanner.nextLine());
                    } while (id < 1 || id > answers.length);

                    q.answerQuestion(question, id - 1);
                }

                for (Question question : questions) {
                    String[] mcqs = question.getAnswers();
                    System.out.println("\nQuestion: " + question.getQuestion());
                    System.out.println("Answer: " + mcqs[question.getAnswer()]);
                }

                surveyServer.submitQuestionnaire(q);

                // Keep looping and asking for input until input is valid
                String s;
                do {
                    System.out.print("\nWould you like to complete another questionnaire (y/n): ");
                    s = scanner.nextLine();
                    System.out.println("");
                } while (!Objects.equals(s, "y") && !Objects.equals(s, "n"));

                repeat = !Objects.equals(s, "n");
            } while (repeat);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
