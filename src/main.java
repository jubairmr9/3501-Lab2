public class main {

    public static void quickSort(TestInteger[] newArray, int firstValue, int lastValue){

        if (firstValue < lastValue) {

            int anyValue = partition(newArray, firstValue, lastValue);

            quickSort(newArray, firstValue, anyValue - 1);

            quickSort(newArray, anyValue + 1, lastValue);

        }

    }

    public static int partition(){



    }

}
