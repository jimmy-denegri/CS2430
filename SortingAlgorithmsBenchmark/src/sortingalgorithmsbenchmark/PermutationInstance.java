/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmsbenchmark;

import java.util.ArrayList;

/**
 *
 * @author Ahren
 */
public class PermutationInstance {
    
   ArrayList perm;
   int comparisons;
   
   
   public PermutationInstance(ArrayList perm, int comparisons)
   { 
       this.perm = new ArrayList(perm);
       this.comparisons = comparisons;  
   }
   
   @Override
   public String toString()
   {
       return perm.toString() + "," + comparisons;
   }
           
   
    
}
