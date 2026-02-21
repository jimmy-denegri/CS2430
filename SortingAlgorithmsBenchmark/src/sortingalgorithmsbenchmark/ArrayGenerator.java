package sortingalgorithmsbenchmark;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class ArrayGenerator {
        
        // Generates array permutations recursively, taken from Geeks for Geeks
	public static ArrayList<Integer> generateArray(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        
        //generate a random list
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(rand.nextInt(n));
        }
        return list;
        }
	
        // Generates array permutations recursively, taken from Geeks for Geeks
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
	
        // Generates array permutations recursively, taken from Geeks for Geeks
	public static List<List<Integer>> permute(int[] nums1) {
		List<List<Integer>> result1 = new ArrayList<>();
		List<Integer> current1 = new ArrayList<>();
		boolean[] used1 = new boolean[nums1.length];

		backtrack(nums1, used1, current1, result1);
		return result1;
	}
        
    // update an ArrayList keeping track of the best permutations    
    public static void updateBest(ArrayList<PermInstance> best, PermInstance current)
    {
        if (best.size() < 10)
                {
                    best.add(current);
                    best.sort(Comparator.reverseOrder());
                }
                
                else if (current.compareTo(best.get(0)) < 0)
                {
                   best.set(0, current);
                   best.sort(Comparator.reverseOrder());
                }
    }
    
    // update an ArrayList keeping track of the worst permutations
    public static void updateWorst(ArrayList<PermInstance> worst, PermInstance current)
    {           
                if (worst.size() < 10)
                {
                    worst.add(current);
                    worst.sort(Comparator.naturalOrder());
                }
                
                else if (current.compareTo(worst.get(0)) > 0)
                {
                   worst.set(0, current);
                   worst.sort(Comparator.naturalOrder());
                }  
    }
    
    // write the results the top 10 best and worst permutations to csv files
    public static void writeCsv(String filename, ArrayList<PermInstance> data) {
        try (PrintWriter writer = new PrintWriter("results/"+filename)) {

            // Header row
            writer.println(data.get(0).getName() + ",Comparisons,Permutation");

            // Data rows
            for (PermInstance p : data) {
                writer.println(
                    "" + "," +
                    p.getComps() + "," +
                    "\"" + p.getPermString() + "\"");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    
    public static void main(String[] args) 
    {
    	// n arrays used by permute and by extension backtrack
        int[] n4 = {1, 2, 3, 4};
        int[] n6 = {1, 2, 3, 4, 5, 6};
        int[] n8 = {1, 2, 3, 4, 5, 6, 7, 8};
        
        // create the lists of permutations
        List<List<Integer>> perm4 = permute(n4);
        List<List<Integer>> perm6 = permute(n6);
        
        // best, worst, and avg will only use the n = 8 arrays, since the best averages and best overall will just always occur
        // in the smallest arrays, and testing on the larger array is more indicative of true performance
        List<List<Integer>> perm8 = permute(n8);
        
        // ArrayLists to hold the best and worst comparison counts for each algorithm
        ArrayList<PermInstance> quickBest  = new ArrayList<>();
        ArrayList<PermInstance> quickWorst  = new ArrayList<>();
        
        ArrayList<PermInstance> heapBest  = new ArrayList<>();
        ArrayList<PermInstance> heapWorst  = new ArrayList<>();
        
        ArrayList<PermInstance> mergeBest  = new ArrayList<>();
        ArrayList<PermInstance> mergeWorst  = new ArrayList<>();
        
        ArrayList<PermInstance> shakerBest  = new ArrayList<>();
        ArrayList<PermInstance> shakerWorst  = new ArrayList<>();
        
       
        
        // 2D array for the comparison counts for each algorithm & N# layed out as below
        /*           n4    n6    n8  
        QuickSort
        MergeSort
        HeapSort
        ShakerSort
        */
        double[][] avgComps = new double[4][3];
        
        
        // loops to populate all arrays for the above lists (averages, bests, and worsts)
        for (int i = 0; i < perm4.size(); i++) 
        {        
            // create new sorting objects for each permutation
            QuickSort quick = new QuickSort(new ArrayList<>(perm4.get(i)));
            HeapSort heap = new HeapSort(new ArrayList<>(perm4.get(i)));
            MergeSort merge = new MergeSort(new ArrayList<>(perm4.get(i)));
            ShakerSort shaker = new ShakerSort(new ArrayList<>(perm4.get(i)));
            
            // running counter for average calculations
            avgComps[0][0] += quick.getCompCount();
            avgComps[1][0] += merge.getCompCount();
            avgComps[2][0] += heap.getCompCount();
            avgComps[3][0] += shaker.getCompCount();
            
            // on the last execution divide by the number of permutations to get the true averages
            if (i == perm4.size() - 1) 
            {
                avgComps[0][0] /= (i + 1);
                avgComps[1][0] /= (i + 1);
                avgComps[2][0] /= (i + 1);
                avgComps[3][0] /= (i + 1);
            }

        }
        
        // same as for n = 4 above
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
        
        // same as for n = 4 and n = 6, but also keeping track of the 10 best and worst permutations for each algorithm 
        for (int i = 0; i < perm8.size(); i++) 
        {
            QuickSort quick = new QuickSort(new ArrayList<>(perm8.get(i)));
            HeapSort heap = new HeapSort(new ArrayList<>(perm8.get(i)));
            MergeSort merge = new MergeSort(new ArrayList<>(perm8.get(i)));
            ShakerSort shaker = new ShakerSort(new ArrayList<>(perm8.get(i)));
            
            // PermInstance links a number of comparisons with a permutation done by one of the sorting algorithms
            // it implements comparable since it is basicallt just a wrapper for the comparison counts for each permutation
            // and comparisons need to easily be made
            // the name it takes is only used for writing out to the csv at the end
            PermInstance quickPerm = new PermInstance(new ArrayList<>(perm8.get(i)), quick.getCompCount(), "QuickSort");
            PermInstance heapPerm = new PermInstance(new ArrayList<>(perm8.get(i)), heap.getCompCount(), "HeapSort");
            PermInstance mergePerm = new PermInstance(new ArrayList<>(perm8.get(i)), merge.getCompCount(), "MergeSort");
            PermInstance shakerPerm = new PermInstance(new ArrayList<>(perm8.get(i)), shaker.getCompCount(), "ShakerSort");
            
            // call the methods to update the ArrayLists containing the best and worst 10
            // permutations of each algorithm
            updateBest(quickBest, quickPerm);
            updateBest(heapBest, heapPerm);
            updateBest(mergeBest, mergePerm);
            updateBest(shakerBest, shakerPerm);
            
            updateWorst(quickWorst, quickPerm);
            updateWorst(heapWorst, heapPerm);
            updateWorst(mergeWorst, mergePerm);
            updateWorst(shakerWorst, shakerPerm);
            
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
        
        // print the averages out in a table (I manually copied the values to an excel spreadsheet for the graph)
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
        
        // automatically print the best and worst arrays to csv files 
        // since manual copying would take far too long for 80 entries in 8 files
        
        writeCsv("Quick Best.csv", quickBest);
        writeCsv("Quick Worst.csv", quickWorst);
        
        
        writeCsv("Merge Best.csv", mergeBest);
        writeCsv("Merge Worst.csv", mergeWorst);
        
        
        writeCsv("Heap Best.csv", heapBest);
        writeCsv("Heap Worst.csv", heapWorst);
        
        
        writeCsv("Shaker Best.csv", shakerBest);
        writeCsv("Shaker Worst.csv", shakerWorst);
        
        
    }
}
    
