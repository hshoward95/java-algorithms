import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class Main {

    private static long bubbleTime;
    private static long selectionTime;
    private static long insertionTime;
    private static long mergeTime;
    private static long quickTime;
    private static long heapTime;

    public static void main(String[] args) {

        System.out.println("===== Part 1: All algorithms on one random array =====");

        int[] original = new int[10000];

        for (int i = 0; i < original.length; i++) {
            original[i] = (int) (Math.random() * 100000);
        }

        System.out.println("Sorting " + original.length + " random integers\n");

        testBubbleSort(original);
        testSelectionSort(original);
        testInsertionSort(original);
        testMergeSort(original);
        testQuickSort(original);
        testHeapSort(original);

        System.out.println();

        testLinearSearch();
        testBinarySearch();

        printRankings();

        System.out.println("\n===== Part 2: Comparative analysis across multiple datasets =====");

        runDatasetAnalysis();
    }

    private static void testBubbleSort(int[] original) {
        int[] arr = original.clone();

        long start = System.nanoTime();
        BubbleSort.bubbleSort(arr);
        long end = System.nanoTime();

        bubbleTime = end - start;

        System.out.println("Bubble Sort Time: " + bubbleTime + " ns");
    }

    private static void testSelectionSort(int[] original) {
        int[] arr = original.clone();

        long start = System.nanoTime();
        SelectionSort.selectionSort(arr);
        long end = System.nanoTime();

        selectionTime = end - start;

        System.out.println("Selection Sort Time: " + selectionTime + " ns");
    }

    private static void testInsertionSort(int[] original) {
        int[] arr = original.clone();

        long start = System.nanoTime();
        InsertionSort.insertionSort(arr);
        long end = System.nanoTime();

        insertionTime = end - start;

        System.out.println("Insertion Sort Time: " + insertionTime + " ns");
    }

    private static void testMergeSort(int[] original) {
        int[] arr = original.clone();

        long start = System.nanoTime();
        MergeSort.mergeSort(arr);
        long end = System.nanoTime();

        mergeTime = end - start;

        System.out.println("Merge Sort Time: " + mergeTime + " ns");
    }

    private static void testQuickSort(int[] original) {
        int[] arr = original.clone();

        long start = System.nanoTime();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();

        quickTime = end - start;

        System.out.println("Quick Sort Time: " + quickTime + " ns");
    }

    private static void testHeapSort(int[] original) {
        int[] arr = original.clone();

        long start = System.nanoTime();
        HeapSort.heapSort(arr);
        long end = System.nanoTime();

        heapTime = end - start;

        System.out.println("Heap Sort Time: " + heapTime + " ns");
    }

    private static void testLinearSearch() {

        int[] arr = {11, 12, 22, 25, 34, 64, 90};

        int target = 25;

        int index = LinearSearch.linearSearch(arr, target);

        System.out.println(
                "Linear Search: Found " +
                        target +
                        " at index " +
                        index
        );
    }

    private static void testBinarySearch() {

        int[] arr = {11, 12, 22, 25, 34, 64, 90};

        int target = 25;

        int index = BinarySearch.binarySearch(arr, target);

        System.out.println(
                "Binary Search: Found " +
                        target +
                        " at index " +
                        index
        );
    }

    private static void printRankings() {

        String[] names = {
                "Bubble Sort",
                "Selection Sort",
                "Insertion Sort",
                "Merge Sort",
                "Quick Sort",
                "Heap Sort"
        };

        long[] times = {
                bubbleTime,
                selectionTime,
                insertionTime,
                mergeTime,
                quickTime,
                heapTime
        };

        Integer[] order = {0, 1, 2, 3, 4, 5};

        Arrays.sort(order,
                (a, b) -> Long.compare(times[a], times[b]));

        System.out.println("\nRanking (fastest to slowest):");

        for (int i = 0; i < order.length; i++) {
            System.out.println(
                    (i + 1) + ". " +
                            names[order[i]] +
                            " - " +
                            times[order[i]] +
                            " ns"
            );
        }
    }

    private static void runDatasetAnalysis() {

        int[] sizes = {5000, 10000, 20000};

        String[] datasets = {
                "Random",
                "Already sorted",
                "Reversed"
        };

        for (String dataset : datasets) {

            System.out.println("\n--- " + dataset + " data ---");

            for (int size : sizes) {

                int[] data = createData(dataset, size);

                int[] expected = data.clone();
                Arrays.sort(expected);

                double bubble =
                        timeSort(
                                "Bubble Sort",
                                data,
                                expected,
                                BubbleSort::bubbleSort
                        );

                double merge =
                        timeSort(
                                "Merge Sort",
                                data,
                                expected,
                                MergeSort::mergeSort
                        );

                double quick =
                        timeSort(
                                "Quick Sort",
                                data,
                                expected,
                                arr -> QuickSort.quickSort(
                                        arr,
                                        0,
                                        arr.length - 1
                                )
                        );

                double heap =
                        timeSort(
                                "Heap Sort",
                                data,
                                expected,
                                HeapSort::heapSort
                        );

                System.out.println(
                        String.format(
                                "n = %6d | Bubble: %9.2f ms | Merge: %7.2f ms | Quick: %7.2f ms | Heap: %7.2f ms",
                                size,
                                bubble,
                                merge,
                                quick,
                                heap
                        )
                );
            }
        }
    }

    private static int[] createData(String dataset, int size) {

        int[] data = new int[size];

        Random random = new Random(42);

        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(100000);
        }

        if (dataset.equals("Already sorted")) {
            Arrays.sort(data);
        } else if (dataset.equals("Reversed")) {
            Arrays.sort(data);
            reverse(data);
        }

        return data;
    }

    private static void reverse(int[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {

            int temp = arr[i];

            arr[i] = arr[arr.length - 1 - i];

            arr[arr.length - 1 - i] = temp;
        }
    }

    private static double timeSort(
            String name,
            int[] data,
            int[] expected,
            Consumer<int[]> sorter
    ) {

        int[] arr = data.clone();

        long start = System.nanoTime();

        sorter.accept(arr);

        long end = System.nanoTime();

        if (!Arrays.equals(arr, expected)) {
            throw new IllegalStateException(
                    name + " did not sort correctly"
            );
        }

        return (end - start) / 1_000_000.0;
    }
}