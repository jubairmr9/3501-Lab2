public class main {

    // Wrote the quicksort method following the pseudocode from the book.

    public static void quickSort(TestInteger[] newArray, int firstValue, int lastValue){

        if (firstValue < lastValue) {

            int anyValue = partition(newArray, firstValue, lastValue);

            quickSort(newArray, firstValue, anyValue - 1);

            quickSort(newArray, anyValue + 1, lastValue);

        }

    }

    public static int partition(TestInteger[] pAarray, int firstValue, int lastValue){

        TestInteger x = pAarray[lastValue];
        int i = firstValue - 1;

        // The next line is basically what the book's pseudocode meant.
        for (int m = firstValue; m < lastValue; m++){

            if(pAarray[m].compareTo(x) <= 0){
                i++;
                exchange(i, m, pAarray);
            }

        }

    }

}
