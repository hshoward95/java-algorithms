import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] original = {64, 34, 25, 12, 22, 11, 90};
        testBubbleSort(original);
        testSelectionSort(original);
        testInsertionSort(original);
        testMergeSort(original);
        testQuickSort(original);
        testBinarySearch();
    }

    private static void testBubbleSort(int[] original) {
        int[] arr = original.clone();
        BubbleSort.bubbleSort(arr);
        System.out.println("Bubble Sort:");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void testSelectionSort(int[] original) {
        int[] arr = original.clone();
        SelectionSort.selectionSort(arr);
        System.out.println("Selection Sort:");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void testInsertionSort(int[] original) {
        int[] arr = original.clone();
        InsertionSort.insertionSort(arr);
        System.out.println("Insertion Sort:");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void testMergeSort(int[] original) {
        int[] arr = original.clone();
        MergeSort.mergeSort(arr);
        System.out.println("Merge Sort:");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void testQuickSort(int[] original) {
        int[] arr = original.clone();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println("Quick Sort:");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void testBinarySearch() {
        int[] arr = {11, 12, 22, 25, 34, 64, 90};
        int target = 25;
        int index = BinarySearch.binarySearch(arr, target);
        System.out.println("Binary Search:");
        System.out.println("Searching for " + target);
        System.out.println("Found at index: " + index);
    }
}