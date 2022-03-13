
public class QuestionnaireSummaryImpl implements QuestionnaireSummary {
    String name;
    String description;
    int timesCompleted;

    public QuestionnaireSummaryImpl(String name, String description) {
        super();
        this.name = name;
        this.description = description;
        this.timesCompleted = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void incrementTimesCompleted() {
        this.timesCompleted++;
    }
}
