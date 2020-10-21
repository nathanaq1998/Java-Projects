// Search.java
// Nathan Quinn
// Search array with a linear
// or binary search
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.lang.*; 


public class Search
{
   public static void main(String[] args)
   {  
      // Set up keyboard for user input
      Scanner keyboard = new Scanner(System.in);
      
      // Create randomIntegers array
      int [] randomIntegers = new int [400];
      
      // Call fillRandomArray Method
      fillRandomArray(randomIntegers);
      
      // User picks an int between 1 and 100 to search for in randomIntegers array
      System.out.print("Pick a value between 1 and 100 to search the array for: ");
      int target = keyboard.nextInt();
      
      // User picks search method
      System.out.print("\nPick a search method: \n[1] Linear Search\n[2] Binary Search\n");
      int choice = keyboard.nextInt();
      
      // Index of target in randomIntegers array
      // -1 if target was not found
      int found = -1;
      
      // Start time of search for target
      double startTime = System.currentTimeMillis();
      
      if(choice == 1)
      {
         // Call linearSearch method and returns index
         found = linearSearch(randomIntegers, target);
      }
      
      else if(choice == 2)
      {  
         // Call binarySearch method and returns index
         found = binarySearch(randomIntegers, target);
      }
      
      else
      {  
         // User chose an invalid option
         System.out.print("Invalid Choice");
      }
      
      // End time of search for target
      double endTime = System.currentTimeMillis();
      
      // Target was found in array
      if(found != -1)
      {
         System.out.println("\nThe value: " + target + ", was found at index: " + found + ", of the array.");
         // Time it took to find target
         System.out.println("Time took to perform search: " + (endTime - startTime) + " milliseconds.");
      }
      
      // Target was not found in array
      else
      {
         System.out.println("\nThe value: " + target + ", was not found in the array.");
         // Time it took to find target
         System.out.println("Time took to perform search: " + (endTime - startTime) + " milliseconds.");
      }
   }
   
   
   // Fill array with random integers between 1 and 100
   public static void fillRandomArray(int[] array)
   {
      Random rand = new Random();
      
      for(int ctr = 0; ctr < 400; ctr++)
      {
         array[ctr] = rand.nextInt(100) + 1;
      }
      
      return;
   }
   
   
   // Linear search of array
   public static int linearSearch(int[] array, int target)
   {  
      // Loop through array
      for(int ctr = 0; ctr < 400; ctr++)
      {
         // If current array index equals target, return index
         if(array[ctr] == target)
         {
            return ctr;
         }
      }
      
      // Target not found in array
      return -1;
   }
   
   
   // Binary search of array
   public static int binarySearch(int[] array, int target)
   {  
      // Sort array smallest to largest
      Arrays.sort(array);
      
      // starting index of array
      int start = 0;
      // ending index of array
      int end = array.length - 1; 
      while (start <= end) 
      {
         // middle index of array
         int middle = start + (end - start) / 2; 
  
         // Check if target is present at middle 
         if (array[middle] == target)
         {
           return middle;
         } 
  
         // If target greater, ignore left half 
         if (array[middle] < target)
         {
           start = middle + 1;
         }   
  
         // If target is smaller, ignore right half 
         else
         {
           end = middle - 1;
         }
      }
      
      // Target not found in array
      return -1;
   }
}
