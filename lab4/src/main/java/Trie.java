import java.util.Iterator;

public class Trie {

    Node root; //first root

    public Node get(Node x, String key, int i){

        if (x == null) return null;
        if (i == key.length()) return x;
        char c = key.charAt(i); // Use i:th key char to identify subtrie
        return get( x.children[c],  key, i + 1);

    }

/*
    public int get(String key){

        Node x = get(root, key, 0);
        if (x == null) return 0;
        return  x.value;

    } */

    public void put(String key){
        root = put(root, key, 0);
    }

    private Node put(Node x, String key, int i){
        if( x == null)
        {
            x = new Node();
        }
        if (i == key.length())
        {
            if(x.value==0) {
                x.value = 1;
            }else{
                x.value += 1;
            }
            return x;
        }

        char c = key.charAt(i); // use i:th key char to identify subtrie
        x.children[c] = put(x.children[c], key, i + 1);

        return x;

    }

    public int count(String prefix) {
        Node startingNode = get(root, prefix, 0);

        return count(startingNode);
    }

    private int count(Node keyNode) {
        // If the node is null there is no value
        if (keyNode == null) {
            return 0;
        }

        // Add value of current node
        int valueSum = keyNode.value;

        //sum values, 256 is the number of characters in ASCII
        for (char c = 0; c < 256; c++) {
            valueSum += count(keyNode.children[c]);
        }

        return valueSum;
    }


/*
    public int distinct(String prefix) {
        Node startingNode = get(root, prefix, 0);


        if(startingNode.value > 0)
            return distinct(startingNode) - 1;

        else
            return distinct(startingNode);

    }
*/

    private int distinct(Node keyNode) {
        // If the Node is null, there is no value
        if (keyNode == null) {
            return 0;
        }

        // If the node is larger than 0, there is a new key
        int valueSum = 0;
        if (keyNode.value > 0) {
            valueSum++;
        }

        // add all characters that have a value
        for (char c = 0; c < 256; c++) {
            valueSum += distinct(keyNode.children[c]);
        }

        return valueSum;
    }

    public Iterator iterator(String prefix)
    {
        return new TrieCount(get(root, prefix, 0), prefix);
    }

    public char mostDifferentKeyLetter() {
        char letter = 0;


        for (char c = 0; c < 256; c++) {
            if (distinct(root.children[c]) > distinct(root.children[letter])) {
                letter = c;
            }
        }

        return letter;
    }
}

