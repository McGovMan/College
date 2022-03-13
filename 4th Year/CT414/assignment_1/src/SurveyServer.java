import java.rmi.*;
import java.util.ArrayList;


/* Server Interface
 * getQuestionnaireSummaryList: Provides a list of all available QuestionnaireSummary objects for download
 * getQuestionnaire: Returns a Questionnaire object for a given questionnaire ID
 * submitQuestionnaire: Lets the client submit a Questionnaire object to the server
 */
public interface SurveyServer extends Remote
{
    ArrayList<QuestionnaireSummary> getQuestionnaireSummaryList() throws RemoteException;

    Questionnaire getQuestionnaire(int id) throws RemoteException;

    void submitQuestionnaire(Questionnaire questionnaire) throws RemoteException;
}
