import java.util.Map;

public class TrieCount implements java.util.Iterator<Map.Entry<String, Integer>>
{

    private Node root;
    private String prefix;
    private int nodesLeft;
    private int nodesSeen;

    public TrieCount(Node root,String prefix){

        this.prefix = prefix;
        this.root = root;

    }

  // check if there is a next node
    public boolean hasNext() {

        Entry next = next();
        nodesLeft--;

        return next != null;

    }

    public Entry next(){

        nodesLeft++;
        nodesSeen = -1;

        return next(root, prefix);

    }

    @Override
    public void remove() {

    }

//go through next node, increment number of nodes that we have seen
    private Entry next(Node currentNode, String key){

        nodesSeen++;

        //if we have reached the end, return an entry with key and value to recursive
        if(nodesSeen == nodesLeft)
        {
            return new Entry(key, currentNode.value);
        }


        //iterate through
        for (char c = 0; c < 256; c++){
            if(currentNode.children[c] != null){
                Entry next = next(currentNode.children[c], key + c);
                if(next != null){
                    return next;
                }

            }



        }
        //no more nodes to visit
        return null;

    }


    public class Entry implements Map.Entry<String,Integer>, Comparable<Entry>{

        public String key;
        public Integer value;


        public Entry(String key, Integer value){

            this.key = key;
            this.value = value;

        }

        public Integer setValue(Integer value){

            this.value = value;
            return null;

        }

        public String getKey()
        {
            return key;
        }


        public Integer getValue()
        {
            return value;
        }


        public String toString()
        {
            return key + "=" + value;
        }

        public int compareTo(Entry etr) {
            if (this.value < etr.value) return -1;
            else if (this.value == etr.value) return 0;
            else return 1;
        }
    }

}