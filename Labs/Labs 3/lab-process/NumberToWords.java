public class NumberToWords {
    public static void main(String[] args) {
        //Storage for numbers
        //numNames does not have a zero, so have to leave a empty space
        String[] numNames =  {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifthteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
        //tensNames leaves two empty space, one room for zero & ten. No such thing as "tenty"
        String[] tensNames = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "}; 
                
        System.out.print("Number: "); 
        int num = In.nextInt();         //ask for userinput
        
        while(num != -1){     
            //num = a(hundreds)b(tens)c(ones) -- extracts the digits
            int ones = num%10;      // c
            int hundreds = num/100; // a
            int rest = num%100;     // bc   
            int tens = rest/10;     // b
            String word = "";       // to store the variable
            
            if(num == 0) { // brackets may not be needed but good for organising
                word = "zero"; 
            }
            else if (num <= 19) {
                word = numNames[num];
            }
            else if (num <= 99) {
                word = tensNames[tens] + numNames[ones];
            }
            else if (num <= 999) {
                if (rest == 00){   
                    word = numNames[hundreds] + "hundred ";
                }
                else if(rest <=19){
                    word = numNames[hundreds] + "hundred and " +numNames[rest];
                }
                else {
                    word = numNames[hundreds] + "hundred and " + tensNames[tens] + numNames[ones];
                }
            }
            System.out.println(word); //output
            
            System.out.print("Number: "); //read
            num = In.nextInt();
        }
    }
}
