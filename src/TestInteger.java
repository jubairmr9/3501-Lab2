public class TestInteger implements Comparable<TestInteger> {

    public int value;

    static long counter;

    // Takes in an integer newValue and sets it to value.

    TestInteger(int newValue){

        value = newValue;

    }

    // Compares the numbers to check if they are greater than, equal to or less than
    // each other and returns a value. Also it adds to the counter every time it loops
    // through and compares another number.

    public int compareTo(TestInteger that) {

        int less = -1;
        int eq = 0;
        int greater = 1;
        counter++;

        if (this.value < that.value){

            return less;

        }

        if (this.value == that.value){

            return eq;

        }

        else return greater;

        }
}
