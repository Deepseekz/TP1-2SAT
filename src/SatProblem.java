import java.util.ArrayList;

public class SatProblem
{
    private int numberOfClauses;
    private int numberOfVars;
    private String comment = "";
    private final ArrayList<ArrayList<Integer>> clauses = new ArrayList<>();

    public void setNumberOfClauses(int numberOfClauses) {
        this.numberOfClauses = numberOfClauses;
    }

    public void setNumberOfVars(int numberOfVars) {
        this.numberOfVars = numberOfVars;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void appendComment(String comment) {
        this.comment += comment;
    }

    public void addClause(ArrayList<Integer> clause)
    {
        clauses.add(clause);
    }

    public SatProblem(String filePath)
    {
        DataReader.SatReader(filePath, this);
    }

    public Graph toGraph()
    {
        return null;
    }
}
