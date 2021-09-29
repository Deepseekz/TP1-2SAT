import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private int numberOfClauses;
    private int numberOfVars;
    private String comment = "";
    private final ArrayList<LinkedList<Integer>> graph = new ArrayList<>();

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
        graph.add(clause);
    }

    public Graph(String filePath)
    {
        TwoSatReader.SatReader(filePath,this);
    }

    public ArrayList<LinkedList<Integer>> getImplicationGraph()
    {
        ArrayList<LinkedList<Integer>> result = graph;
        for (LinkedList<Integer> clause : graph){
            LinkedList<Integer> firstProcessedClause = new LinkedList<>();
            firstProcessedClause.addLast(-clause.get(0));
            firstProcessedClause.addLast(clause.get(1));

            LinkedList<Integer> secondProcessedClause = new LinkedList<>();
            secondProcessedClause.addLast(-clause.get(1));
            secondProcessedClause.addLast(clause.get(2));

            result.add(firstProcessedClause);
            result.add(secondProcessedClause);
        }
        return result;
    }

}
