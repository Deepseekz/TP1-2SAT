import java.util.ArrayList;
import java.util.LinkedList;

public class SatProblem
{
    private int numberOfClauses;
    private int numberOfVars;
    private String comment = "";
    public final ArrayList<LinkedList<Integer>> clauses = new ArrayList<>();

    public void setNumberOfClauses(int numberOfClauses) {
        this.numberOfClauses = numberOfClauses;
    }

    public void setNumberOfVars(int numberOfVars) {
        this.numberOfVars = numberOfVars;
    }

    public void appendComment(String comment) {
        this.comment += comment;
    }

    public void addClause(LinkedList<Integer> clause)
    {
        clauses.add(clause);
    }

    public SatProblem(String filePath)
    {
        DataReader.SatReader(filePath, this);
    }

    public Graph toGraph()
    {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        for (LinkedList<Integer> clause : clauses){
        }

        return null;
    }

    @Override
    public String toString() {
        return "SatProblem{" +
                "numberOfClauses=" + numberOfClauses +
                ", numberOfVars=" + numberOfVars +
                ", comment='" + comment + '\'' +
                ", clauses=" + clauses +
                '}';
    }
}
