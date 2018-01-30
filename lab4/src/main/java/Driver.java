import edu.princeton.cs.introcs.In;
import java.util.*;
import java.net.URL;

public class Driver {

    public static void main(String[] args) {

        Trie book = new Trie();

        URL url = ClassLoader.getSystemResource("ttc.txt");

        if (url != null) {
            System.out.println("Reading from: " + url);
        } else {
            System.out.println("Couldn't find file: ttc.txt");
        }

        In input= new In(url);

        while (!input.isEmpty()) {
            String line = input.readLine().trim();
            String[] words = line.split("(\\. )|:|,|;|!|\\?|( - )|--|(\' )| ");
            String lastOfLine = words[words.length - 1];

            if (lastOfLine.endsWith(".")) {
                words[words.length - 1] = lastOfLine.substring(0, lastOfLine.length() - 1);
            }

            for (String word : words) {
                String word2 = word.replaceAll("\"|\\(|\\)|-|’|“|”|'|\uFEFF|", "");

                if (word2.isEmpty()) {
                    continue;
                }

                word2 = word2.toLowerCase();

                book.put(word2);
            }
        }

        PriorityQueue<TrieCount.Entry> highestFreq = new PriorityQueue<TrieCount.Entry>(10);
        PriorityQueue<TrieCount.Entry> lowestFreq = new PriorityQueue<TrieCount.Entry>(10, Collections.reverseOrder());

        //use your iterator to find out the 10 words with highest freq
        Iterator<TrieCount.Entry> itr = book.iterator("");
        while (itr.hasNext()) {
            TrieCount.Entry freq = itr.next();
            if (freq.value > 0) {
                highestFreq.add(freq);
                lowestFreq.add(freq);

                if (highestFreq.size() > 10) { highestFreq.poll(); }
                if (lowestFreq.size() > 10) { lowestFreq.poll(); }
            }
        }
        while(highestFreq.peek() != null)
            System.out.println(highestFreq.poll());

        System.out.println();

        while(lowestFreq.peek() != null)
            System.out.println(lowestFreq.poll());



        //initiate max value and a temporary variable.
        //compare them after the loop and save the temporary in the max value
        //save the string so you can add it
        int val  = 0;
        int temp = 0;
        String b = null;

        for (char c = 0; c < 256; c++)
        {
            if(book.get(book.root,"" + c, 0) != null)
            {
                for(char d = 0; d < 256; d++)
                {
                    if(book.get(book.root,"" + c + d,0) != null)
                    {
                        temp = book.count("" + c + d);
                        if (temp > val)
                        {
                            val = temp;
                            b = "" + c + d;
                        }
                    }
                }
            }
        }

        System.out.println();
        System.out.println("Prefix with lenght 2: "+b);

        char mostDifferentWord = book.mostDifferentKeyLetter();
        System.out.println();
        System.out.println("Letter with the most different word start with: " + String.valueOf(mostDifferentWord));

    }
}
