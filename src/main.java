import java.util.Arrays;
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

        System.out.println("x = " + x);



        // Generating random integers and putting them inside two arrays

        // First array

        TestInteger[] firstRandArr = new TestInteger[10000];

        for (int ind = 0; ind < 10000; ind++){

            firstRandArr[ind] = new TestInteger((int)(Math.random() * 1000000));

        }

        // Printing first array

        printArr(firstRandArr);

        // Making the second random array same as the first

        TestInteger[] secRandArr = firstRandArr.clone();



        // Loop to run Tim Sort on a random array and time it.

        for(int j = 1; j < 6; j++) {

            printArr(firstRandArr);

            double tSortStartTime = new Double(System.currentTimeMillis());

            Arrays.sort(firstRandArr);

            double tSortEndTime = new Double(System.currentTimeMillis());

            double tSortTimeDifference = tSortEndTime - tSortStartTime;

            System.out.println("Sorting time using Tim Sort for time #" + j + " = " + tSortTimeDifference);

            printArr(firstRandArr);

            // Resetting the array

            firstRandArr = secRandArr.clone();

        }


        // Loop to run quicksort 5 times and record the time it takes

        for(int i = 1; i<6; i++){

            printArr(secRandArr);

            double qSortStartTime = new Double(System.currentTimeMillis());

            quickSort(secRandArr, 0, secRandArr.length - 1);

            double qSortEndTime = new Double(System.currentTimeMillis());

            double qSortTimeDifference = qSortEndTime - qSortStartTime;

            System.out.println("Sorting time using Quick Sort for time #" + i + " = "+ qSortTimeDifference);

            printArr(secRandArr);

            secRandArr = firstRandArr.clone();

        }


        // Creating a sorted array

        TestInteger[] sortedArray = firstRandArr.clone();

        Arrays.sort(sortedArray);

        printArr(sortedArray);

        // Loop to run Tim Sort on an ascending random array and time it.

        for(int j = 1; j < 6; j++) {

            double tSortStartTime = new Double(System.currentTimeMillis());

            Arrays.sort(sortedArray);

            double tSortEndTime = new Double(System.currentTimeMillis());

            double tSortTimeDifference = tSortEndTime - tSortStartTime;

            System.out.println("Sorting time on an ascending array using Tim Sort for time #" + j + " = " + tSortTimeDifference);

        }


        // Loop to run quicksort 5 times on an ascending array and record the time it takes

        for(int i = 1; i<6; i++){

            double qSortStartTime = new Double(System.currentTimeMillis());

            quickSort(sortedArray, 0, sortedArray.length - 1);

            double qSortEndTime = new Double(System.currentTimeMillis());

            double qSortTimeDifference = qSortEndTime - qSortStartTime;

            System.out.println("Sorting time on an ascending array using Quick Sort for time #" + (i) + " = "+ qSortTimeDifference);

        }

        // Creating arrays with 10 sorted sequences of 1000 elements each

        int tenSeqInd = 0;

        TestInteger[] tenSeqRandArr = new TestInteger[10000];

        for(int i = 0; i< 10; i++){

            int tenSeqFirValue = (int)(Math.random() * 1000000);

            for(int j = tenSeqFirValue; j < tenSeqFirValue + 1000; j++){

                tenSeqRandArr[tenSeqInd] = new TestInteger(j);
                tenSeqInd++;

            }

        }

        TestInteger[] secTenSeqRandArr = tenSeqRandArr.clone();

        printArr(tenSeqRandArr);


        // Sorting the array with Tim Sort and Quick Sort

        // Loop to run Tim Sort and time it.

        for(int j = 1; j < 6; j++) {

            double tSortStartTime = new Double(System.currentTimeMillis());

            Arrays.sort(tenSeqRandArr);

            double tSortEndTime = new Double(System.currentTimeMillis());

            double tSortTimeDifference = tSortEndTime - tSortStartTime;

            System.out.println("Sorting time of the 10 seq. of 1000 elements using Tim Sort for time #" + j + " = " + tSortTimeDifference);

            tenSeqRandArr = secTenSeqRandArr.clone();

        }


        // Loop to run quicksort 5 times and record the time it takes

        for(int i = 1; i<6; i++){

            double qSortStartTime = new Double(System.currentTimeMillis());

            quickSort(tenSeqRandArr, 0, tenSeqRandArr.length - 1);

            double qSortEndTime = new Double(System.currentTimeMillis());

            double qSortTimeDifference = qSortEndTime - qSortStartTime;

            System.out.println("Sorting time of the 10 seq. of 1000 elements using Quick Sort for time #" + i + " = "+ qSortTimeDifference);

            tenSeqRandArr = secTenSeqRandArr.clone();

        }


        // Creating arrays with 100 sorted sequences of 100 elements each

        int hundredSeqInd = 0;

        TestInteger[] hundredSeqRandArr = new TestInteger[10000];

        for(int i = 0; i< 100; i++){

            int hundredSeqFirValue = (int)(Math.random() * 1000000);

            for(int j = hundredSeqFirValue; j < hundredSeqFirValue + 100; j++){

                hundredSeqRandArr[hundredSeqInd] = new TestInteger(j);
                hundredSeqInd++;

            }

        }

        TestInteger[] secHundredSeqRandArr = hundredSeqRandArr.clone();

        // Loop to run Tim Sort and time it.

        for(int j = 1; j < 6; j++) {

            double tSortStartTime = new Double(System.currentTimeMillis());

            Arrays.sort(hundredSeqRandArr);

            double tSortEndTime = new Double(System.currentTimeMillis());

            double tSortTimeDifference = tSortEndTime - tSortStartTime;

            System.out.println("Sorting time of the 100 seq. of 100 elements using Tim Sort for time #" + j + " = " + tSortTimeDifference);

            hundredSeqRandArr = secHundredSeqRandArr.clone();

        }


        // Loop to run quicksort 5 times and record the time it takes

        for(int i = 1; i<6; i++){

            double qSortStartTime = new Double(System.currentTimeMillis());

            quickSort(hundredSeqRandArr, 0, hundredSeqRandArr.length - 1);

            double qSortEndTime = new Double(System.currentTimeMillis());

            double qSortTimeDifference = qSortEndTime - qSortStartTime;

            System.out.println("Sorting time of the 100 seq. of 100 elements using Quick Sort for time #" + i + " = "+ qSortTimeDifference);

            hundredSeqRandArr = secHundredSeqRandArr.clone();

        }

    }

}
