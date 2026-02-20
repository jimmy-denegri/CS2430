package sortingalgorithmsbenchmark;


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
    	//int[] n1 = {1};
        
        int[] n4 = {1, 2, 3, 4};
        int[] n6 = {1, 2, 3, 4, 5, 6};
        int[] n8 = {1, 2, 3, 4, 5, 6, 7, 8};
        
        //List<List<Integer>> perm1 = permute(n1);
        List<List<Integer>> perm4 = permute(n4);
        List<List<Integer>> perm6 = permute(n6);
        
        // best, worst, and avg will only use the n = 8 arrays
        List<List<Integer>> perm8 = permute(n8);
        
        
        ArrayList<PermutationInstance> quickBest  = new ArrayList<>();
        ArrayList<PermutationInstance> quickWorst  = new ArrayList<>();
        
        ArrayList<PermutationInstance> heapBest  = new ArrayList<>();
        ArrayList<PermutationInstance> heapWorst  = new ArrayList<>();
        
        ArrayList<PermutationInstance> mergeBest  = new ArrayList<>();
        ArrayList<PermutationInstance> mergeWorst  = new ArrayList<>();
        
        ArrayList<PermutationInstance> shakerBest  = new ArrayList<>();
        ArrayList<PermutationInstance> shakerWorst  = new ArrayList<>();
        
        /*           n4    n6    n8  
        QuickSort
        MergeSort
        HeapSort
        ShakerSort
        */
        double[][] avgComps = new double[4][3];
        
        
        
        for (int i = 0; i < perm4.size(); i++) 
        {        
            QuickSort quick = new QuickSort(new ArrayList<>(perm4.get(i)));
            HeapSort heap = new HeapSort(new ArrayList<>(perm4.get(i)));
            MergeSort merge = new MergeSort(new ArrayList<>(perm4.get(i)));
            ShakerSort shaker = new ShakerSort(new ArrayList<>(perm4.get(i)));

            avgComps[0][0] += quick.getCompCount();
            avgComps[1][0] += merge.getCompCount();
            avgComps[2][0] += heap.getCompCount();
            avgComps[3][0] += shaker.getCompCount();

            if (i == perm4.size() - 1) 
            {
                avgComps[0][0] /= (i + 1);
                avgComps[1][0] /= (i + 1);
                avgComps[2][0] /= (i + 1);
                avgComps[3][0] /= (i + 1);
            }

        }
        
        for (int i = 0; i < perm6.size(); i++) 
        {        
            QuickSort quick = new QuickSort(new ArrayList<>(perm6.get(i)));
            HeapSort heap = new HeapSort(new ArrayList<>(perm6.get(i)));
            MergeSort merge = new MergeSort(new ArrayList<>(perm6.get(i)));
            ShakerSort shaker = new ShakerSort(new ArrayList<>(perm6.get(i)));

            avgComps[0][1] += quick.getCompCount();
            avgComps[1][1] += merge.getCompCount();
            avgComps[2][1] += heap.getCompCount();
            avgComps[3][1] += shaker.getCompCount();

            if (i == perm6.size() - 1) 
            {
                avgComps[0][1] /= (i + 1);
                avgComps[1][1] /= (i + 1);
                avgComps[2][1] /= (i + 1);
                avgComps[3][1] /= (i + 1);
            }

        }
        
        
        for (int i = 0; i < perm8.size(); i++) 
        {        
            QuickSort quick = new QuickSort(new ArrayList<>(perm8.get(i)));
            HeapSort heap = new HeapSort(new ArrayList<>(perm8.get(i)));
            MergeSort merge = new MergeSort(new ArrayList<>(perm8.get(i)));
            ShakerSort shaker = new ShakerSort(new ArrayList<>(perm8.get(i)));

            avgComps[0][2] += quick.getCompCount();
            avgComps[1][2] += merge.getCompCount();
            avgComps[2][2] += heap.getCompCount();
            avgComps[3][2] += shaker.getCompCount();

            if (i == perm8.size() - 1) 
            {
                avgComps[0][2] /= (i + 1);
                avgComps[1][2] /= (i + 1);
                avgComps[2][2] /= (i + 1);
                avgComps[3][2] /= (i + 1);
            }

        }
        
        
        System.out.printf("Algorithm  |  %10s | %10s | %10s |\n", "N4", "N6", "N8");
        for(int i = 0; i < 4; i++)
        {
            if(i == 0)
            {
                System.out.print("QuickSort  | ");
            }
            
            else if(i == 1 )
            {
                System.out.print("MergeSort  | ");
            }
            
            else if(i == 2 )
            {
                System.out.print("HeapSort   | ");
            }
            
            else if(i == 3 )
            {
                System.out.print("ShakerSort | ");
            }
            
            for(int j = 0; j<3; j++)
            {
                
                System.out.printf(" %10.2f |", avgComps[i][j]);
            }
            
            System.out.println();
        }
        
        
        
        
        
        // Get all permutations
        
        
    	
       
    	
        
        
    	
    	}
	}
    
