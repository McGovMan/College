
public class QuestionImpl implements Question {
    String question;
    String[] answers;
    int answer;

    // Constructor
    public QuestionImpl(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    /* Getters */
    public String getQuestion() {
        return this.question;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    public int getAnswer() {
        return answer;
    }

    /* Setters */
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public void submitAnswer(int answer) {
        this.answer = answer;
    }
}
