// int[] merge(int[] a, int[] b)
// int[] sort(int[] a)
// printArray - helper function, prints Array (Don't use Arrays.toString)
//
public class MergeSort{
    public static void main(String[] args){
        MergeSort m = new MergeSort();
        int[] test = {1,2,3,4,5};
        m.printArray(test);
    }
    
    public void printArray(int[] a){
        for (int i:a){
            System.out.print(i+",");
        }
        System.out.println();
    }

    public int[] merge(int[] a, int[] b){
        int sum = a.size + b.size;
        int[] toRtr = int[sum];
        int counterA = 0;
        int counterB = 0;
        int counterR = 0;
        while (counterA < a.size || counterB < b.size) {
           if (counterA < a.size && counterB < b.size) {
                 if (a[counterA] >= b[counterB]){
                      toRtr[counterR] = a[counterA];
                      counteraA++;
                    }
                 else {
                      toRtr[counterR] = b[counterB];
                      counterB++;
                   }
             counterR++;       
             }
           else if (counterA < a.size) {
                toRtr[counterR] = a[counterA];
                counteraA++;
           }
        }
    }
}
