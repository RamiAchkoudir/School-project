import se.kth.id1020.Graph;
import se.kth.id1020.DataSource;


public class Paths {
    public static void main(String[] args) {
        Graph g = DataSource.load();
        // work on g

        ConnectedComp con = new ConnectedComp(g);
        System.out.println("number of subgraphs: " + con.count);
    }



}