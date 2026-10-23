# Java Algorithms

This project contains several sorting and searching algorithms implemented in Java. I created it to practice common algorithms and compare their performance on different types of datasets.

## Algorithms Included

### Sorting
- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort
- Heap Sort

### Searching
- Linear Search
- Binary Search

## Features

- Implemented each algorithm from scratch
- Compared execution times using System.nanoTime()
- Tested algorithms on random, sorted, and reverse-sorted arrays
- Verified sorting results against Java's built-in Arrays.sort()

## Time Complexity

| Algorithm | Average Case | Worst Case |
|------------|------------|------------|
| Bubble Sort | O(n²) | O(n²) |
| Selection Sort | O(n²) | O(n²) |
| Insertion Sort | O(n²) | O(n²) |
| Merge Sort | O(n log n) | O(n log n) |
| Quick Sort | O(n log n) | O(n²) |
| Heap Sort | O(n log n) | O(n log n) |
| Linear Search | O(n) | O(n) |
| Binary Search | O(log n) | O(log n) |

## Running the Program

Compile and run Main.java:

```bash
javac *.java
java Main
```

The program benchmarks the sorting algorithms, displays timing results, and demonstrates the search algorithms.

## Why I Made This

I wanted to get more practice with algorithms and better understand how different sorting methods perform as dataset size and ordering change.

## Author

Hayden Howard