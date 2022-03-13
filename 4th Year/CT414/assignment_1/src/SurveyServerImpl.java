import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/* Server Implementation of SurveyServer interface
 * All methods in the SurveyServer interface have been defined here
 * We define three static fields:
 *  - questionnaireSummaryList: List of all questionnaires (summary)
 *  - questionnaireList: List of all questionnaires and their questions
 *  - completedQuestionnaires: Keeps track of the completed questionnaires
 */
public class SurveyServerImpl implements SurveyServer {
    public static ArrayList<QuestionnaireSummary> questionnaireSummaryList = new ArrayList<>();
    public static ArrayList<Questionnaire> questionnaireList = new ArrayList<>();
    public static ArrayList<Questionnaire> completedQuestionnaireList = new ArrayList<>();

    // Default Constructor
    SurveyServerImpl() throws RemoteException {
        super(); // No super constructor to call, but we might as well in case we add a constructor to the interface in future
    }

    public ArrayList<QuestionnaireSummary> getQuestionnaireSummaryList() throws RemoteException {
        System.out.println("DEBUG: Successfully sent Questionnaire Summaries to client.");
        return questionnaireSummaryList;
    }

    public Questionnaire getQuestionnaire(int id) throws RemoteException {
        Questionnaire questionnaire = questionnaireList.get(id);
        if (questionnaire == null)
            System.out.println("DEBUG: Questionnaire with ID: " + id + ", could not be found");
        else
            System.out.println("DEBUG: Questionnaire with ID: " + id + ", found");
        return questionnaire;
    }

    public void submitQuestionnaire(Questionnaire questionnaire) throws RemoteException {
        if (questionnaire != null)
        {
            completedQuestionnaireList.add(questionnaire);
            for (QuestionnaireSummary qs : questionnaireSummaryList) {
                if (qs.getName().equals(questionnaire.getQuestionnaireSummary().getName())) {
                    qs.incrementTimesCompleted();
                    break;
                }
            }
            System.out.println("DEBUG: Questionnaire received and accepted");
        }
        else
            System.out.println("DEBUG: Questionnaire received is invalid");
    }

    public static void main(String args[]) {
        try {
            /*
             * SETUP SERVER
             */
            // First reset our Security manager
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
                System.out.println("Security manager set");
            }

            // Create an instance of the local object
            SurveyServer surveyServer = new SurveyServerImpl();
            System.out.println("Instance of Survey Server created");
            SurveyServer stub = (SurveyServer) UnicastRemoteObject.exportObject(surveyServer, 0);

            // Put the server object into the Registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Questionnaires", stub);
            System.out.println("Name rebind completed");
            System.out.println("Server ready for requests!");

            /*
             * SETUP QUESTIONNAIRES
             */
            QuestionnaireSummary s1 = new QuestionnaireSummaryImpl("First Survey", "First Test Survey");
            String[] s1_q1_answers = {"Kings", "Taytos"};
            String[] s1_q2_answers = {"Mayo", "Dublin"};
            Question s1_q1 = new QuestionImpl("Do you prefer Kings or Taytos?", s1_q1_answers);
            Question s1_q2 = new QuestionImpl("Who will win the next All-Ireland GAA final?", s1_q2_answers);
            Question[] s1_qs = {s1_q1, s1_q2};

            QuestionnaireSummary s2 = new QuestionnaireSummaryImpl("Second Survey", "Second Test Survey");
            String[] s2_q1_answers = {"Barrys", "Lyons"};
            String[] s2_q2_answers = {"Yes", "No"};
            Question s2_q1 = new QuestionImpl("Do you prefer Barrys or Lyons?", s2_q1_answers);
            Question s2_q2 = new QuestionImpl("Should Galway be made the international 'Windy City' instead of Chicago?", s2_q2_answers);
            Question[] s2_qs = {s2_q1, s2_q2};

            questionnaireList.add(new QuestionnaireImpl(s1_qs, "First Test Survey", s1));
            questionnaireList.add(new QuestionnaireImpl(s2_qs, "Second Test Survey", s2));
            questionnaireSummaryList.add(s1);
            questionnaireSummaryList.add(s2);

            System.out.println("Surveys Created");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
