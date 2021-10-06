import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // SatProblem test = new SatProblem("C:\\Users\\Adam\\IdeaProjects\\TP1-2SAT\\samples\\formule-2-sat.txt");
        Graph graph = new Graph(6*2);

        graph.addEdge(2, 1);
        graph.addEdge(2, 6);

        graph.addEdge(5, 4);
        graph.addEdge(5, 0);

        graph.addEdge(4, 6);

        graph.addEdge(0, 6);
        graph.addEdge(0, 4);

        graph.addEdge(6, 1);

        System.out.println(graph.Transpose());
    }
}
