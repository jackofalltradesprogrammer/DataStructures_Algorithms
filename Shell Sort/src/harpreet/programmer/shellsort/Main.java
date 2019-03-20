package harpreet.programmer.shellsort;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};


        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            int i;
            for (i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];

                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;

                }

                intArray[j] = newElement;
            }

        }
            for (int i = 0; i < intArray.length; i++) {
                System.out.println(intArray[i]);
            }
        }
    }
