/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmsbenchmark;

import java.util.ArrayList;

/**
 * Basically wraps the comparison count for an algorithm of a permutation. It was this or deal with double the 
 * ArrayLists and then deal with the possibility of matching the wrong comparison count to the wrong permutation
 * since for the 10 best and worst algorithm it requires sorting the comp count arrays with no good way to ensure that 
 * the permutation arrays follow the same sorting pattern.
 * @author Ahren
 */
public class PermInstance implements Comparable<PermInstance> {
   
   // self explanatory fields
   ArrayList<Integer> perm;
   int comparisons;
   String name;
   
   /**
    * constructor takes and stores the values
    * @param perm
    * @param comparisons
    * @param name 
    */
   public PermInstance(ArrayList<Integer> perm, int comparisons, String name)
   { 
       this.perm = new ArrayList<>(perm);
       this.comparisons = comparisons;  
       this.name = name;
   }
   
   /**
    * get the comparison count linked to this permutation
    * @return 
    */
   public int getComps() {return comparisons;}
   
   /**
    * return a string representation of the permutation
    * @return 
    */
   public String getPermString() {return perm.toString();}
   
   
   /**
    * return a string representation of the comparison count
    * @return 
    */
   public String getCompString(){return "" + comparisons;}
   
   /**
    * return the name of the sorting algorithm used
    * @return 
    */
   public String getName() {return name;}
   
   /**
    * unused toSring(). Returns "<permutation>,<comparison count>"
    * @return 
    */
   @Override
   public String toString() {return perm.toString() + "," + comparisons;}
   
   /**
    * compare to another PermInstance, used to make automatic comparisons easy like when using ArrayList.sort()
    * needed since this class implements comparable
    * @param other
    * @return 
    */
   @Override 
   public int compareTo(PermInstance other) {return Integer.compare(comparisons, other.getComps());}
   
   
   
    
}
