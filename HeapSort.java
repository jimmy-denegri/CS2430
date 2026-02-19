package programingProject1;

import java.util.ArrayList;

/**
 * HeapSort is a sorting algorithm that follows the Heap Sort
 * sorting algorithm.  
 * 
 * @author Benjamin Shaw
 */
public class HeapSort {
	@SuppressWarnings("unused")	// This is the original array list that is not being touched.
	private ArrayList<Integer> originalList = new ArrayList<Integer>();
	
	private ArrayList<Integer> sortedList = new ArrayList<Integer>();	// The sorted list.
	
	private int comparisonCount;	// The amount of comparisons.
	
	
	
	/**
	 * 
	 * 
	 * @param originalList is the original list.
	 */
	public HeapSort(ArrayList<Integer> originalList) {
		this.originalList = originalList;
		sortedList = sort(originalList);
	}


	/**
	 * Returns the amount of comparisons that the sorting algorithm does.
	 * 
	 * @return comparisonCount
	 */
	public int getCompCount() {
		return comparisonCount;
	}
	
	/**'
	 * returns the list as a sorted list.
	 * 
	 * @return sortedList
	 */
	public ArrayList<Integer> getSortedList() {
		return sortedList;
	}
	
	/**
	 * Returns the sorted array.
	 * 
	 * @param unsorted
	 * @return sorted
	 */
	private ArrayList<Integer> sort(ArrayList<Integer> unsorted) {
		// This is going to be used so we don't modify the array that is passed in.
		ArrayList<Integer> sorted = new ArrayList<Integer>();	// This will be sorted in the end.
		
		// Making a copy of the unsorted original unsorted array so we don't modify the original.
		for (int el : unsorted) {
			sorted.add(el);
		}
		
		// Getting the size of the array.
		int sortedSize = sorted.size();
		
		
		for (int i = sortedSize / 2 - 1; i >= 0; i--) {
			heapify(sorted, sortedSize, i);
		}
		
		// One by one extract an element from heap
        for (int i = sortedSize - 1; i > 0; i--) {

            // Move current root to end
            int temp = sorted.get(0);
            sorted.set(0, sorted.get(i));
            sorted.set(i, temp);

            // Call max heapify on the reduced heap
            heapify(sorted, i, 0);
        }
		
		
		return sorted;
	}

	/**
	 * heapify rearranges the input array to be sorted.
	 * 
	 * @param arr: the input array to be sorted.
	 * @param n: the size of the array.
	 * @param index: the current index of the for loop.
	 */
	private void heapify(ArrayList<Integer> arr, int n, int index) {
		// The largest is the current index.
		int largest = index;
		
		// Finding the left index.
		int left = 2 * index + 1;
		
		// Finding the right index.
		int right = 2 * index + 2;
		
		comparisonCount++;
		// If left child is larger than root
        if (left < n && arr.get(left) > arr.get(largest)) {
            largest = left;
        }
        
        comparisonCount++;
        // If right child is larger than largest so far
        if (right < n && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        comparisonCount++;
        // If largest is not root
        if (largest != index) {
            int temp = arr.get(index);
            arr.set(index, arr.get(largest));
            arr.set(largest, temp);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
	}
	/*
 	// = = = = = = = = Test Main Method = = = = = = = = 
	
	public static void main(String[] args) {
	
		// Making an ArrayList and passing in values to get sorted.
		ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(9);
        arr.add(4);
        arr.add(3);
        arr.add(8);
        arr.add(10);
        arr.add(2);
        arr.add(5);
        
        
        // Passing in the ArrayList to be sorted.
        HeapSort sort = new HeapSort(arr);
        
        
        // Making sure that the sorting algorithm is doing it's job.
        System.out.println("Sorted: " + sort.getSortedList());
        System.out.println();

		// Making sure the array that is passed into the method stays the same.
        System.out.print("Unsorted: ");
        for (int i = 0; i < arr.size(); ++i) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("\n");
        
        
        // Getting the comparison count.
        System.out.println("Comp Count: " + sort.getCompCount());
    }
    */
}
