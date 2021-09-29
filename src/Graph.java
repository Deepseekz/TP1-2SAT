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

    public ArrayList<LinkedList<Integer>> implicationGraph()
    {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        for (LinkedList<Integer> clause : graph){
            LinkedList<Integer> firstProcessedClause = new LinkedList<>();
            firstProcessedClause.addLast(-clause.get(0));
            firstProcessedClause.addLast(clause.get(1));

            LinkedList<Integer> secondProcessedClause = new LinkedList<>();
            secondProcessedClause.addLast(-clause.get(1));
            secondProcessedClause.addLast(clause.get(0));

            result.add(firstProcessedClause);
            result.add(secondProcessedClause);
        }
        return result;
    }

    public ArrayList<LinkedList<Integer>> transpose()
    {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        for (LinkedList<Integer> clause : implicationGraph())
        {
            LinkedList<Integer> transposedClause = new LinkedList<>();
            transposedClause.add(clause.get(1));
            transposedClause.add(clause.get(0));

            result.add(transposedClause);
        }
        return result;
    }

    public void parcoursProfondeur(Integer start){

        Integer source = graph.get(start).get(0);
        Integer destination = graph.get(start).get(1);


        ArrayList<Integer> sawElements = new ArrayList<>();

        if (sawElements.contains(start)) {
            System.out.print("cfc discovered : ");
            System.out.print(sawElements);
        }
        else {
            sawElements.add(source);
            sawElements.add(destination);
            parcoursProfondeur(start+1);
        }


    }


}
