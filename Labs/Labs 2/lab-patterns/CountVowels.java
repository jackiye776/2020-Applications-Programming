public class CountVowels {
    public static void main(String[] args) {
        int count = 0;
        
        System.out.print("Character: ");
        char cha = In.nextChar();
        
        while (cha != '.'){
            if (cha == 'a' || cha == 'e' || cha == 'i' || cha == 'o' || cha == 'u'){
                count++;
            }
            System.out.print("Character: ");
            cha = In.nextChar();
        }
        System.out.print("Vowel count = " + count);
    }
}
