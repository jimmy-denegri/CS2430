package project1;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ArrayGenerator {

	public static ArrayList<Integer> generateArray(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        
        //generate a random list
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(rand.nextInt(n));
        }
        return list;
        
        
    }
	
	private static void backtrack(int[] nums, boolean[] used,
            List<Integer> current, List<List<Integer>> result) {
			// If current permutation is complete
			if (current.size() == nums.length) {
				result.add(new ArrayList<>(current));
				return;
			}

			// Iterate over all elements
			for (int i = 0; i < nums.length; i++) {
				// Skip already used elements
				if (used[i]) 
					continue;

				// Include this element
				used[i] = true;
				current.add(nums[i]);

				// Recurse for next element
				backtrack(nums, used, current, result);

				// Backtrack: remove element and mark unused
				current.remove(current.size() - 1);
				used[i] = false;
			}

	}
	
	public static List<List<Integer>> permute(int[] nums1) {
		List<List<Integer>> result1 = new ArrayList<>();
		List<Integer> current1 = new ArrayList<>();
		boolean[] used1 = new boolean[nums1.length];

		backtrack(nums1, used1, current1, result1);
		return result1;
	}
	
	 
	
    public static void main(String[] args) {
    	int[] nums = {1, 2, 3};

        // Get all permutations
        List<List<Integer>> permutations = permute(nums);

        // Print all permutations
        for (List<Integer> perm : permutations) {
            for (int num : perm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    	
        System.out.println("Look what I got: " + permutations);
    	
        ShakerSort shaker = new ShakerSort();
        shaker.ShakerSort(permutations);
        
        HeapSort heap = new HeapSort();
        heap.HeapSort(permutations);
        
        QuickSort quick = new QuickSort();
        quick.QuickSort(permutations);
        
        MergeSort merge = new MergeSort();
        merge.MergeSort(permutations);
        
    	
    	}
	}
    
