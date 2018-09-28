import java.util.Random;
import java.lang.*;

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

        exchange(i+1, lastValue, pAarray);

        return i+1;

    }

    // The exchange method for int exchanging two elements in an array.

    public static void exchange(int posOne, int posTwo, TestInteger[] newArray){

        //Creating a temporary array to store the value so that I can swap the elements.

        TestInteger temp = newArray[posOne];
        newArray[posOne] = newArray[posTwo];
        newArray[posTwo] = temp;

    }

    public static boolean isSorted(TestInteger[] newArray){

        for(int i = 1; i < newArray.length; i++){

            if(newArray[i-1].compareTo(newArray[i]) ==1){

                return false;

            }

        }

        return true;

    }

    // Prints the contents of an array

    public static void printArr(TestInteger[] newArray){

        for(int i = 1; i < newArray.length; i++){
            System.out.print(newArray[i].value+"\t");
        }
        System.out.println("");
    }


    public static void main(String args[]){

        System.out.println("Hello");

        // Declaring TestInteger and assigning values to it.

        TestInteger t1, t2, t3;

        t1 = new TestInteger(1);
        t2 = new TestInteger(2);
        t3 = new TestInteger(2);


        System.out.println(t2.compareTo(t2));
        System.out.println(t1.compareTo(t2));
        System.out.println(t3.compareTo(t2));

        // Checking if counter works.

        System.out.println(TestInteger.counter);

        // Making an array and putting values in it.

        TestInteger[] testArr = new TestInteger[10];

        for (int val = 0; val < 10; val++) {
            testArr[val] = new TestInteger(val);
        }


        // Checking the isSorted method.

        System.out.println(isSorted(testArr));

        // Checking the printArr method.

        printArr(testArr);

        // Checking the exchange method

        exchange(2, 4, testArr);

        printArr(testArr);

        // Testing the way to use floor

        double testNum = 200.45;

        System.out.println(Math.floor(testNum));

        // Generating a random number to test

        int x = ((int)(100+(Math.random() * 500)));

        System.out.println(x);


        // Generating random integers and putting them inside two arrays

        // First array

        TestInteger[] firstRandArr = new TestInteger[10001];

        for (int ind = 1; ind <= 10000; ind++){

            firstRandArr[ind] = new TestInteger((int)(Math.random() * 1000000));

        }

        // Printing first array

        printArr(firstRandArr);

        TestInteger[] secRandArr = firstRandArr;






    }

}
