public class MiddleAverage {
    public static void main(String[] args) {
        
        System.out.print("Value: ");
        int value = In.nextInt();
        
        int sum = 0;
        int count = 0;
        int max = value;
        int min = value;
        
        while (value != -1){
            if(value > max){
                max = value;
                //System.out.println("max: " + max);
            }
            if(value < min){
                min = value;
                //System.out.println("min: " + min);
            }
            sum += value;
            count++;
            System.out.print("Value: ");
            value = In.nextInt();
        }
        
        if(count >= 2){
            int total = sum - max - min;
            //System.out.println("total: " + total);
            double average = (double)total / ((double)count-2);
            //double average = (double) (sum - min - max) / (count-2);
            System.out.print("Middle average = " + average);
        }
    }
}
