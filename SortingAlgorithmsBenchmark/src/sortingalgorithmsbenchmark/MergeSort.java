package sortingalgorithmsbenchmark;
import java.util.ArrayList;

public class MergeSort {

    private ArrayList<Integer> numList;
    private int comparisonCount;

    // Constructor
    public MergeSort(ArrayList<Integer> numList) {
        this.numList = new ArrayList<>(numList);
        this.comparisonCount = 0;
        sort();
    }

    // Returns how many comparisons were made
    public int getCompCount() {
        return comparisonCount;
    }

    // Returns the sorted list
    public ArrayList<Integer> getSortedList() {
        return numList;
    }

    // Public sort method - entry point
    public ArrayList<Integer> sort() {
        //comparisonCount = 0;
        mergeSort(numList);
        return numList;
    }

    // Private recursive method that splits the list
    private void mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return;
        }

        int middle = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(list.subList(middle, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    // Private method that merges two sorted halves back into result
    private void merge(ArrayList<Integer> result, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            comparisonCount++;
            if (left.get(i) <= right.get(j)) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }
    
    
    /*
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(4);
        numbers.add(3);
        numbers.add(6);
        numbers.add(2);
        numbers.add(8);
        numbers.add(7);
        numbers.add(10);
        numbers.add(9);

        System.out.println("Original list: " + numbers);

        MergeSort sorter = new MergeSort(numbers);
        sorter.sort();

        System.out.println("Sorted list:   " + sorter.getSortedList());
        System.out.println("Comparisons:   " + sorter.getCompCount());
        System.out.println("Original unchanged: " + numbers);
    }
*/
}