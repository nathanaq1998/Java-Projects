// Dice.java
// Nathan Quinn
// Roll three dice 33,000 times
// Calculate for each dice:
//    Number of times each face value appeared for each face value 1 through 6
//    The face value that appeared the most
//    The face value that appeared the least
//    Number of times the face value 1 appeared only in the first 1,000 rolls
// Output information across all three dice:
//    Number of times where the sum of all three face values is odd in the same roll
//    The face value that appeared the most
//    The number of times where the face values of all three dice were equal in the same roll
//    The number of times where the face values happened in ascending order
import java.util.Random;
import java.util.Arrays;


public class Dice
{
   public static void main(String[] args)
   {
      // array to hold dice #1 values
      int[] diceOne = new int [33000];
      // integer to hold number of 1's rolled for first 1,000 roles for dice #1
      int diceOneRollOne = 0;
      
      // array to hold dice #2 values
      int[] diceTwo = new int [33000];
      // integer to hold number of 1's rolled for first 1,000 roles for dice #2
      int diceTwoRollOne = 0;
      
      // array to hold dice #3 values
      int[] diceThree = new int [33000];
      // integer to hold number of 1's rolled for first 1,000 roles for dice #3
      int diceThreeRollOne = 0;
      
      // sum of all dice values for a roll
      int diceSum = 0;
      
      // Count times sum of dice is odd
      int oddSumCounter = 0;
      // Count times all dice values are equal
      int equalDiceCounter = 0;
      // Count times dice are in ascending order
      int ascendingDiceCounter = 0;
      
      // Set up random values for dice
      Random rand = new Random();
      
      for(int ctr = 0; ctr < 33000; ctr++)
      {
         // Roll dice randomly
         diceOne[ctr] = rand.nextInt(6) + 1;
         diceTwo[ctr] = rand.nextInt(6) + 1;
         diceThree[ctr] = rand.nextInt(6) + 1;
         
         // Dice have been rolled 1,000 times
         if(ctr == 1000)
         {
            // Count 1's rolled by dice
            diceOneRollOne = diceRollOneCounter(diceOne);
            diceTwoRollOne = diceRollOneCounter(diceTwo);
            diceThreeRollOne = diceRollOneCounter(diceThree);
         }
         
         // Sum up dice on roll
         diceSum = diceOne[ctr] + diceTwo[ctr] + diceThree[ctr];
         // Check if sum is odd
         if(diceSum % 2 != 0)
         {
            oddSumCounter++;
         }
         
         // Check if dice values are equal
         if((diceOne[ctr] == diceTwo[ctr]) && (diceOne[ctr] == diceThree[ctr]))
         {
            equalDiceCounter++;
         }
         
         // Check if dice values are ascending
         if((diceOne[ctr] < diceTwo[ctr]) && (diceTwo[ctr] < diceThree[ctr]))
         {
            ascendingDiceCounter++;
         }
      }
      
      //Print stats for dice #1
      // Count times each value was rolled
      int[] diceOneRollTotals = diceTotalsCounter(diceOne);
      System.out.println("Dice stats for dice #1:\n");
      // Print dice value totals
      printDiceTotals(diceOneRollTotals);
      // Print least common value
      printDiceValueMostCommon(diceOneRollTotals);
      // Print least common value
      printDiceValueLeastCommon(diceOneRollTotals);
      System.out.println("\n   Number of times the face value 1 appeared in the first 1000 rolls: " + diceOneRollOne);
      
      // Print stats for dice #2
      // Count times each value was rolled
      int[] diceTwoRollTotals = diceTotalsCounter(diceTwo);
      System.out.println("\n\nDice stats for dice #2:\n");
      // Print dice value totals
      printDiceTotals(diceTwoRollTotals);
      // Print most common value
      printDiceValueMostCommon(diceTwoRollTotals);
      // Print least common value
      printDiceValueLeastCommon(diceTwoRollTotals);
      System.out.println("\n   Number of times the face value 1 appeared in the first 1000 rolls: " + diceTwoRollOne);
      
      // Print stats for dice #3
      // Count times each value was rolled
      int[] diceThreeRollTotals = diceTotalsCounter(diceThree);
      System.out.println("\n\nDice stats for dice #3:\n");
      // Print dice value totals
      printDiceTotals(diceThreeRollTotals);
      // Print most common value
      printDiceValueMostCommon(diceThreeRollTotals);
      // Print least common value
      printDiceValueLeastCommon(diceThreeRollTotals);
      System.out.println("\n   Number of times the face value 1 appeared in the first 1000 rolls: " + diceThreeRollOne);
      
      // Print stats for all dice
      System.out.println("\n\n\nDice stats for all the dice:\n");
      System.out.print("   Number of times where the sum of all three face values is odd in the same roll: " + oddSumCounter + "\n");
      // Determine and print most common face value
      printMostCommonFaceValue(diceOneRollTotals, diceTwoRollTotals, diceThreeRollTotals);
      System.out.print("\n   The number of times where the face values of all three dice were equal in the same roll: " + equalDiceCounter + "\n");
      System.out.print("\n   The number of times where the face values happened in ascending order: " + ascendingDiceCounter + "\n");

   }
   
   // Count the 1's rolled by a dice in the first 1,000 roles
   static int diceRollOneCounter(int[] dice1)
   {
      int total = 0;
      
      for(int ctr = 0; ctr < 1000; ctr++)
      {
         if(dice1[ctr] == 1)
         {
            total++;
         }
      }
      
      return total;
   }
   
   // Count total of dice rolls for each value for a specific dice
   static int[] diceTotalsCounter(int[] dice2)
   {
      // Array to pass back dice value totals
      int[] diceRollTotals = new int [6];
      
      // Counters for dice value totals
      int diceRollOneTotal = 0;
      int diceRollTwoTotal = 0;
      int diceRollThreeTotal = 0;
      int diceRollFourTotal = 0;
      int diceRollFiveTotal = 0;
      int diceRollSixTotal = 0;
      
      for(int ctr = 0; ctr < 33000; ctr++)
      {
         switch(dice2[ctr])
         {
            case 1:
               diceRollOneTotal++;
               break;
            case 2:
               diceRollTwoTotal++;
               break;
            case 3:
               diceRollThreeTotal++;
               break;
            case 4:
               diceRollFourTotal++;
               break;
            case 5:
               diceRollFiveTotal++;
               break;
            case 6:
               diceRollSixTotal++;
               break;
         }
      }
      
      // Assign totals to diceRollTotals array
      diceRollTotals[0] = diceRollOneTotal;
      diceRollTotals[1] = diceRollTwoTotal;
      diceRollTotals[2] = diceRollThreeTotal;
      diceRollTotals[3] = diceRollFourTotal;
      diceRollTotals[4] = diceRollFiveTotal;
      diceRollTotals[5] = diceRollSixTotal;
      
      return diceRollTotals;
   }
   
   // Print dice value totals for a specific dice
   static void printDiceTotals(int[] dice3)
   {
      System.out.print("   Total for 1's rolled: " + dice3[0] + "\n");
      System.out.print("   Total for 2's rolled: " + dice3[1] + "\n");
      System.out.print("   Total for 3's rolled: " + dice3[2] + "\n");
      System.out.print("   Total for 4's rolled: " + dice3[3] + "\n");
      System.out.print("   Total for 5's rolled: " + dice3[4] + "\n");
      System.out.print("   Total for 6's rolled: " + dice3[5] + "\n");
   }
   
   // Determine and print most common value for a specific dice
   static void printDiceValueMostCommon(int[] dice4)
   {
      int largest = -1;
      int diceValue = -1;
      
      for(int ctr = 0; ctr < 6; ctr++)
      {
         if(largest < dice4[ctr])
         {
            largest = dice4[ctr];
            diceValue = ctr + 1;
         }
      }
      
      System.out.print("\n   The face value that appeared the most: " + diceValue + "\n");
   }
   
   // Determine and print least common value for a specific dice
   static void printDiceValueLeastCommon(int[] dice5)
   {
      int smallest = 33001;
      int diceValue = -1;
      
      for(int ctr = 0; ctr < 6; ctr++)
      {
         if(smallest > dice5[ctr])
         {
            smallest = dice5[ctr];
            diceValue = ctr + 1;
         }
      }
      
      System.out.print("\n   The face value that appeared the least: " + diceValue + "\n");

   }
   
   // Determine and print most common value for all dice
   static void printMostCommonFaceValue(int[] dice6, int[] dice7, int[] dice8)
   {
      int sum = -1;
      int largestSum = -1;
      int faceValue = -1;
      for(int ctr = 0; ctr < 6; ctr++)
      {
         sum = dice6[ctr] + dice7[ctr] + dice8[ctr];
         
         if(largestSum < sum)
         {
            largestSum = sum;
            faceValue = ctr + 1;
         }
      }
      
      System.out.print("\n   The face value that appeared the most: " + faceValue + "\n");
   }
}