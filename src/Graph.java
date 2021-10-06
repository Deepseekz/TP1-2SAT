import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Graph {
    private int cardinal;
    private LinkedList<Integer> adjascents[];

    Graph(int size) {
        cardinal = size;
        adjascents = new LinkedList[size];
        for (int i = 0; i < cardinal; ++i)
            adjascents[i] = new LinkedList();
    }

    void addEdge(int source, int destination) {
        adjascents[source].add(destination);
    }

    void DeepFirstSearch(int cardinal, boolean visitedVertices[]) {
        visitedVertices[cardinal] = true;
        System.out.print(cardinal + " ");
        int n;

        Iterator<Integer> i = adjascents[cardinal].iterator();
        while (i.hasNext()) {
            n = i.next();
            if (!visitedVertices[n])
                DeepFirstSearch(n, visitedVertices);
        }
    }

    Graph Transpose() {
        Graph graph = new Graph(cardinal);
        for (int s = 0; s < cardinal; s++) {
            Iterator<Integer> i = adjascents[s].listIterator();
            while (i.hasNext())
                graph.adjascents[i.next()].add(s);
        }
        return graph;
    }

    void fillOrder(int s, boolean visitedVertices[], Stack stack) {
        visitedVertices[cardinal] = true;
        s=cardinal;
        Iterator<Integer> i = adjascents[s].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visitedVertices[n])
                fillOrder(n, visitedVertices, stack);
        }
        stack.push(s);
    }

    // Print strongly connected component
    void printSCC() {
        Stack stack = new Stack();

        boolean visitedVertices[] = new boolean[cardinal];
        for (int i = 0; i < cardinal; i++)
            visitedVertices[i] = false;

        for (int i = 0; i < cardinal; i++)
            if (visitedVertices[i] == false)
                fillOrder(i, visitedVertices, stack);

        Graph gr = Transpose();

        for (int i = 0; i < cardinal; i++)
            visitedVertices[i] = false;

        while (stack.empty() == false) {
            int s = (int) stack.pop();

            if (visitedVertices[s] == false) {
                gr.DeepFirstSearch(s, visitedVertices);
                System.out.println();
            }
        }
    }
}
