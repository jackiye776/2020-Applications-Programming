public class StretchWith2Vowels {
    // Level 1: top
    public static void main(String [] args) {
        String input;
        while(!(input = readSentence()).equals("*")){
           System.out.println("Matching words = " + matchCount(input.toLowerCase()));
        }
    }
    public static String readSentence() {
        System.out.print("Sentence: ");
        return In.nextLine();
    }
    // Level 2: sentence
    public static int matchCount(String sentence){
        int count = 0;
        for(String i : sentence.split(" +")){
            if(matches(i)){
                count++;
            }
        }
        return count;
    }
    // Level 3: word
    public static boolean matches(String word){
        for(String item : word.split("z")){
            if(vowelCount(item) == 2){
                return true;
            }
        }
        return false;
    }
    // Level 4: part
    public static int vowelCount(String part){
        int count = 0;
        for (int i = 0; i < part.length(); i++){
            if (vowelCheck(part.charAt(i))){
                count++;
            }
        }
        return count;
    }
    // Level 5: character
    public static boolean vowelCheck(char c) {
        /*char[] vowels = {'a','e','i','o','u'};
        for (char vowel : vowels)
            if (vowel == c)
                return truxe;
        return false;*/
        return "aeiou".contains(""+c);
    }
}

