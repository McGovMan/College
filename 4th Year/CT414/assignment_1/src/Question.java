import java.io.Serializable;

public interface Question extends Serializable {
    void setQuestion(String question);
    void setAnswers(String[] answers);
    String getQuestion();
    String[] getAnswers();
    void submitAnswer(int answer);
    int getAnswer();
}
