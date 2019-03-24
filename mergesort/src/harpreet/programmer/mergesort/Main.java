package harpreet.programmer.mergesort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        // end is always 1+lastIndex

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        // This recursion will break when function is called with one element array
        if ((end - start) < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        // compares left and right arrays' last and first index before merging
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // Remember this
        // {{32, 34 }, { 33, 36} } ORRRR {{32, 36}, { 33, 34} }
        // after merging [ 32, 33, 34} as this is temporary array , and they won't be covered under 'while'
        // when we merge to main array 36 doesn't need to be overidden BUT IF 36 IS IN THE LEFT array IT NEED TO BE CHANGED
        // we can just take the large elements in the left array and replace it at the same indices of the right array but
        // in the main input array (Source)

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        // if the temp array length is not equal to full length then it means few elements
        // were already at the correct indecies, so we copy the tempIndex from 0 to the index that got changed
        System.arraycopy(temp, 0, input, start, tempIndex);
    }


}
