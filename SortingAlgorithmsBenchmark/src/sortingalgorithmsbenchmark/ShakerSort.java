package sortingalgorithmsbenchmark;

import java.util.ArrayList;

/**
 * The ShakerSort class implements the Shaker Sort algorithm
 * (also known as Cocktail Sort), which is a bidirectional
 * variation of Bubble Sort.
 * 
 * It sorts a list of integers while counting the number of
 * element comparisons performed during sorting.
 * 
 * The original list remains unchanged.
 * 
 * @author Jimmy Denegri
 * @version 1.0
 */
public class ShakerSort {

    /** The list being sorted */
    private ArrayList<Integer> numList;

    /** A copy of the original unsorted list */
    private ArrayList<Integer> originalList;

    /** Counts the number of element comparisons made during sorting */
    private int comparisonCount;

    /**
     * Constructs a ShakerSort object and immediately sorts
     * the provided list using the Shaker Sort algorithm.
     *
     * @param numList the list of integers to be sorted
     */
    public ShakerSort(ArrayList<Integer> numList) {
        this.originalList = new ArrayList<>(numList); // keep original
        this.numList = new ArrayList<>(numList);      // list to sort
        this.comparisonCount = 0;
        
        sort(this.numList);
    }

    /**
     * Returns the number of comparisons made during sorting.
     *
     * @return the total number of element comparisons
     */
    public int getCompCount() {
        return comparisonCount;
    }

    /**
     * Returns the sorted list.
     *
     * @return the sorted ArrayList of integers
     */
    public ArrayList<Integer> getSortedList() {
        return numList;
    }

    /**
     * Sorts the given list using the Shaker Sort algorithm.
     * 
     * The algorithm works by alternating between forward
     * and backward passes through the list, moving the largest
     * element to the end and the smallest element to the beginning
     * in each iteration.
     *
     * @param list the list to be sorted
     * @return the sorted list
     */
    private ArrayList<Integer> sort(ArrayList<Integer> list) {

        int left = 0;
        int right = list.size() - 1;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            // Forward pass
            for (int i = left; i < right; i++) {
                comparisonCount++;
                if (list.get(i) > list.get(i + 1)) {
                    swap(list, i, i + 1);
                    swapped = true;
                }
            }
            right--;

            if (!swapped) break;
            swapped = false;

            // Backward pass
            for (int i = right; i > left; i--) {
                comparisonCount++;
                if (list.get(i - 1) > list.get(i)) {
                    swap(list, i - 1, i);
                    swapped = true;
                }
            }
            left++;
        }

        return list;
    }

    /**
     * Swaps two elements in the given list.
     *
     * @param list the list containing the elements
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}






