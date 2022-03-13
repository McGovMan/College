import java.io.Serializable;

public interface Questionnaire extends Serializable {
    Question[] getQuestions();
    String getDescription();
    void answerQuestion(Question question, int answer);
    QuestionnaireSummary getQuestionnaireSummary();
}
