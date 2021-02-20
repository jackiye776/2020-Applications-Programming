public class ZWordCount {
    // Level 1: top 
    public static void main(String[] args) {
        String[] sentences = {
            "green ideas Zleep furiously",
            "a zebra graZed",
            "zorro WAZ zore",
            "I feel snoozy"
        };
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
        System.out.println("Words containing a 'z' = " + zWords(sentences));
    }
    // Level 2: sentences[]
    public static int zWords(String[] sentences) {
        int sum = 0;
        for (String sentence : sentences) {
            sum += zWords(sentence.toLowerCase()); // cycles through the array 1 by 1 of each sentence
        }
        return sum; // calculate total amount of 'z's found the entire array
    }
    // Level 3: sentence
    public static int zWords(String sentence) {
        int count = 0;
        for (String word : sentence.split(" +")) {
            if (containsZ(word)) {
                count++; // increments count when 'z' found'
            }
        }
        return count; // returns how many 'z's' were found
    }
    // Level 4: word
    public static boolean containsZ(String word) {
        return word.contains("z"); // checks the word contains the letter 'z'
    }
}
