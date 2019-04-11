package harpreet.programmer.quicksort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        // end is always 1+lastIndex

        quickSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void quickSort(int[] input, int start, int end) {
        // The base case for recursion, return when there is only one element
        if (end - start < 2) {
            return;
        }

        // This will return the new index(correct index) of the pivot
        // after partitioning the elements less than or greater than pivot in the left and right array respectively
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex); // for the left array to the pivot
        quickSort(input, pivotIndex + 1, end); // for the right array

    }

    public static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start]; // as we are using recursion and 0 won't be the first variable
        int i = start;
        int j = end;

        // cancel the loop when i becomes j as
        // it will be  the correct position of  "this" pivot element of this part of recursion
        while (i < j) {
            // we are using this "empty" loop to keep decrementing j
            // Also to find out an element that is less than pivot
            // as it will break the loop and this will help travers the array from right to left
            //noinspection StatementWithEmptyBody **INTELLIJ Comment***
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                // as we have found an element that is less than pivot
                input[i] = input[j];
            }
            // Now to traverse from left to right -> to look for an element greater than pivot
            // and keep running this empty loop and move forward
            while (i < j && input[++i] <= pivot) ;
            // This 'if' checks the case if we didn't break out of the loop because of i==j
            if (i < j) {
                // as we found an element greater than pivot
                input[j] = input[i];
            }
        }
        // now i must have crossed j, so we  found the correct position of the element and we need to return it
        // and also assign the pivot to the right index
        input[j] = pivot;
        return j;
    }


}
