import java.util.Arrays;

public class Main {
    private static long bubbleTime;
    private static long selectionTime;
    private static long insertionTime;
    private static long mergeTime;
    private static long quickTime;

    public static void main(String[] args) {
        int[] original = new int[10000];

        for (int i = 0; i < original.length; i++) {
            original[i] = (int) (Math.random() * 10000);
        }
        testBubbleSort(original);
        testSelectionSort(original);
        testInsertionSort(original);
        testMergeSort(original);
        testQuickSort(original);
        testBinarySearch();
        printRankings();
    }

    private static void testBubbleSort(int[] original) {
        int[] arr = original.clone();
        long start = System.nanoTime();
        BubbleSort.bubbleSort(arr);
        long end = System.nanoTime();
        bubbleTime = end - start;
        System.out.println("Bubble Sort: " + Arrays.toString(arr) + " Time: " + bubbleTime + " ns");
    }

    private static void testSelectionSort(int[] original) {
        int[] arr = original.clone();
        long start = System.nanoTime();
        SelectionSort.selectionSort(arr);
        long end = System.nanoTime();
        selectionTime = end - start;
        System.out.println("Selection Sort: " + Arrays.toString(arr) + " Time: " + selectionTime + " ns");
    }

    private static void testInsertionSort(int[] original) {
        int[] arr = original.clone();
        long start = System.nanoTime();
        InsertionSort.insertionSort(arr);
        long end = System.nanoTime();
        insertionTime = end - start;
        System.out.println("Insertion Sort: " + Arrays.toString(arr) + " Time: " + insertionTime + " ns");
    }

    private static void testMergeSort(int[] original) {
        int[] arr = original.clone();
        long start = System.nanoTime();
        MergeSort.mergeSort(arr);
        long end = System.nanoTime();
        mergeTime = end - start;
        System.out.println("Merge Sort: " + Arrays.toString(arr) + " Time: " + mergeTime + " ns");
    }

    private static void testQuickSort(int[] original) {
        int[] arr = original.clone();
        long start = System.nanoTime();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        quickTime = end - start;
        System.out.println("Quick Sort: " + Arrays.toString(arr) + " Time: " + quickTime + " ns");
    }

    private static void testBinarySearch() {
        int[] arr = { 11, 12, 22, 25, 34, 64, 90 };
        int target = 25;
        long start = System.nanoTime();
        int index = BinarySearch.binarySearch(arr, target);
        long end = System.nanoTime();
        System.out.println("Binary Search: Found " + target + " at index " + index + " Time: " + (end - start) + " ns");
    }

    private static void printRankings() {
        String[] names = { "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort" };
        long[] times = { bubbleTime, selectionTime, insertionTime, mergeTime, quickTime };
        Integer[] order = { 0, 1, 2, 3, 4 };
        Arrays.sort(order, (a, b) -> Long.compare(times[a], times[b]));
        System.out.println("\nRanking (fastest to slowest):");
        for (int i = 0; i < order.length; i++) {
            System.out.println((i + 1) + ". " + names[order[i]] + " - " + times[order[i]] + " ns");
        }
    }
}