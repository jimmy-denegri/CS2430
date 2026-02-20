package sortingalgorithmsbenchmark;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * 
 * @author Ahren Bidlingmaier
 */
public class QuickSort {
    
        private ArrayList<Integer> numList;
        
        private int compCount;
        
        /**
         * QuickSort Constructor (memory safe). Takes one ArrayList, makes memory safe copy and sorts it.
         * @param originalList 
         */
        public QuickSort(ArrayList<Integer> originalList)
        {
            numList = new ArrayList<>();
            compCount = 0;
            
            for (int i = 0; i < originalList.size(); i++)
            {
                this.numList.add(originalList.get(i));
            }
            
            sort(numList, 0, numList.size() - 1);
        }
        /**
         * Called in constructor. Takes the copy of originalList and recursively sorts it. 
         * StartPoint and endPoint are used instead of making new arrays for every recursion and then concatenating at the return statement.
         * My choice of pivot location is the last array entry. ie endPoint - 1.
         * @param sortList
         * @param startPoint
         * @param endPoint 
         */
        private void sort(ArrayList<Integer> sortList, int startPoint, int endPoint)
        {
            
            
            //System.out.printf("Quick Sort | Current Recursion %d->%d\n", startPoint, endPoint);
            // base case. when there is only one element in the "array" at the last recursive layer return.
            if (startPoint >= endPoint)
            {
                return; 
            }
            
            // checking for a case that should never happen for testing purposes. Will comment out when testing testing has finished and I'm sure that my sort() calls at the bottom are correct
            /*
            if (startPoint > endPoint)
            {
                System.out.printf("QuickSort Error\nstartPoint: %d > endPoint: %d\nQuickSort Failed\n\n");
                return;
            }
            */
            
            
            // Stores the location of the most recent number greater than the pivot 
            // that will be swapped once a number less than the pivot is encountered
            int lastLessThan = startPoint - 1;
            
            // loop through all values from startPoint to endPoint
            for (int i = startPoint; i < endPoint; i++)
            {
                // if the current number is less than the pivot swap its location with the last number that was greater than the pivot
                compCount++; // increment the comparison count by one since two number entries are compared in the previous statement
                if (sortList.get(i) < sortList.get(endPoint))
                {
                    /*
                    System.out.print("Quick Sort | Current List: ");
                    for (int j = 0; j < sortList.size(); j++)
                    {
                        System.out.print(sortList.get(j) + " ");
                    }
                    System.out.println();
                    
                    System.out.print("Last less than " + lastLessThan);
                    
                    */
                    
                    //System.out.print("->" + lastLessThan);
                    //System.out.println("");
                    //System.out.printf("Quick Sort | Swapping sortList[%d] = %d with sortList[%d] = %d\n", i, sortList.get(i), lastLessThan, sortList.get(lastLessThan));
                    
                    // increment the index of the last number less than the pivot
                    lastLessThan++;
                    // swap the number at i with the last number less than the pivot
                    swap(sortList, i, lastLessThan);
                    
                    
                    /*System.out.print("Quick Sort | After Swap: ");
                    for (int j = 0; j < sortList.size(); j++)
                    {
                        System.out.print(sortList.get(j) + " ");
                    }
                    System.out.println(""); 
                    */
                }
                
            }
            
            // at the end swap the pivot with the last number greater than it that had been swapped 
            
            
                //System.out.println("Quick Sort | Pivot Swap ");
                
                
                //System.out.print("Quick Sort | Current List: ");
                /*
                for (int j = 0; j < sortList.size(); j++) 
                {
                    System.out.print(sortList.get(j) + " ");
                }
                System.out.println();
                */
                
                
                
                //System.out.print("Last less than " + lastLessThan);
                
                //increment last less than to the final position of the pivot
                lastLessThan++;
                
                //System.out.print("->" + lastLessThan);
                //System.out.println("");
                
                //System.out.printf("Quick Sort | Swapping sortList[%d] = %d with sortList[%d] = %d\n", endPoint, sortList.get(endPoint), lastLessThan, sortList.get(lastLessThan));
                
                // swap the pivot into the place to the right of the last number less than it
                swap(sortList, endPoint, lastLessThan);
                
                /*
                System.out.print("Quick Sort | After Swap: ");
                for (int j = 0; j < sortList.size(); j++) 
                {
                    System.out.print(sortList.get(j) + " ");
                }
                System.out.println();
                */
            
            
                // recursive calls + debugging statements to keep track of what is happening at the start/end points
                //System.out.printf("LH Call %d->%d\n", startPoint, startPoint + ( (endPoint - startPoint) / 2) );
                //System.out.printf("RH Call %d->%d\n", startPoint + ( (endPoint - startPoint) / 2) + 1, endPoint );
                sort(sortList, startPoint, lastLessThan - 1);
                sort(sortList, lastLessThan + 1, endPoint);   
                  
        }
        
        /**
         * swap swapList[pos1] with swapList[pos2].
         * @param swapList
         * @param pos1
         * @param pos2 
         */
        private void swap(ArrayList<Integer> swapList, int pos1, int pos2)
        {
            int buffer = swapList.get(pos1);
            swapList.set(pos1, swapList.get(pos2));
            swapList.set(pos2, buffer);
        }
        
        /**
         * return the comparison count to measure the speed of this sorting method.
         * @return 
         */
        public int getCompCount()
        {
            return compCount;  
        }
        /**
         * return a memory safe copy of the newly sorted list.
         * @return 
         */
        public ArrayList<Integer> getSortedList()
        {
            return new ArrayList<Integer>(numList);
        }
    
}
