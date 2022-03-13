import java.io.Serializable;

public interface QuestionnaireSummary extends Serializable {
    String getName();
    String getDescription();
    void incrementTimesCompleted();
}
