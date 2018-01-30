import se.kth.id1020.Edge;
import se.kth.id1020.Graph;

public class ConnectedComp {


    public boolean[] marked;
    public int count;
    public ConnectedComp(Graph G){

        marked = new boolean[G.numberOfVertices()];

        for(int s = 0; s < G.numberOfVertices(); s++)
            if (!marked[s])
            {
                dfs(G, s);
                count++;
            }
    }
    private void dfs(Graph G, int v){

        marked[v] = true;

        for (Edge w : G.adj(v))
            if (!marked[w.to])
                dfs(G, w.to);
    }




}
