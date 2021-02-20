public class ZCount {
    // The Main function
    // Level 1: Top
    public static void main(String[] args) {
        System.out.println("z count = " + zCount(readString())); // includes the merged read loop 
    } //.toLowerCase() <-- can be used to convert input string into all lowercase 
    // Can declare it as either private / public
    public static String readString() {
        System.out.print("String: ");
        return In.nextLine();
    }
    // Level 2: String
    public static int zCount(String s) { // s = sentence 
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'z') {
                count++;
            }
        }
        return count;
    }
}
