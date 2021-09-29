public class Main
{
    public static void main(String[] args)
    {

        Graph graph = new Graph("samples/formule-2-sat.txt");
        System.out.print(graph.getImplicationGraph());
    }
}
