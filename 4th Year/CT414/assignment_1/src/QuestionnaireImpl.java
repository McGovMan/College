
public class QuestionnaireImpl implements Questionnaire {
    Question[] questions;
    String description;
    QuestionnaireSummary questionnaireSummary;

    public QuestionnaireImpl(Question[] questions, String description, QuestionnaireSummary questionnaireSummary) {
        this.questions = questions;
        this.description = description;
        this.questionnaireSummary = questionnaireSummary;
    }

    public Question[] getQuestions() {
        return this.questions;
    }

    public String getDescription() {
        return this.description;
    }

    public void answerQuestion(Question question, int answer) {
        question.submitAnswer(answer);
    }

    public QuestionnaireSummary getQuestionnaireSummary() {
        return this.questionnaireSummary;
    }
}
