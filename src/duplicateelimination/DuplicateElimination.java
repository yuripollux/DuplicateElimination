/**
*JHTP_Deitel&Deitel/7.12 (Duplicate Elimination) Use a one-dimensional array to 
* solve the following problem: Write an application that inputs five numbers, 
* each between 10 and 100, inclusive. As each number is read, display it only if
* it’s not a duplicate of a number already read. Provide for the worst-case,
* in which all five numbers are different. Use the smallest possible array to 
* solve this problem. Display the complete set of unique values input after the
* user enters each new value.
*/
package duplicateelimination;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author YuriPollux
 */
public class DuplicateElimination {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("%n\t\t%s", "__Duplicate Elimination__");
	System.out.printf("%n%s%n", "Input five numbers (one at a time),"
                        + " each between 10 and 100, inclusive:");
	int[] array = new int[5];	
	Scanner input = new Scanner(System.in);		
	int i = 0;
		
	for (i = 0; i < array.length; i++){	
            while (true){	//as each number is read
		System.out.printf("%n%s", "Enter number>>> ");		
		int value = input.nextInt();	
                int dupValIndex;	
		//is value outside specified interval (10 <= value <= 100)?			
		if ((value < 10) || (value > 100)){	
                    System.out.printf("\t%s%n", 
                            "Number has to be between 10 and 100, inclusive!"); 
                    try{
			i = i - 1; //to be sure we do not deplete length of 
                                    //array whenever an invalid entry is made
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        //(i = i - 1) will yield -1 at i = 0; so keep i = 0 
                        //to be sure we do not deplete length of array
                        // whenever an invalid entry is made as first entry
			i = 0; 
                    }
                    break;
		}
		else{
                    Arrays.sort(array);
                    dupValIndex = Arrays.binarySearch(array, value);
                    if (dupValIndex >= 0){
			System.out.printf("\t%s%n", "Value already exists!");
                        //does not need a 'try - catch' handler 
                        //as duplicate can only start at i = 1 i.e second entry
			i = i - 1;	
                    }
                    else{
			if (array[i] == 0)
                            array[i] = value;
			else{
                            Arrays.sort(array);
                            dupValIndex = Arrays.binarySearch(array, 0);
                 //great check to know after sorting 0 elem is always at 0 index
                            //System.out.printf("%d", dupValIndex); 
                            array[dupValIndex] = value;
			}
                    }
		}				
                break;
            }
            Arrays.sort(array);	
            System.out.printf("\t%s", "Current Value Set: {");
            for (int elem : array)
		if (elem > 0)
                    System.out.printf("%d ", elem);
            System.out.printf("%s", "}");
            System.out.printf("%n\tNo. of valid inputs left -> %d of %d",
                    (array.length - (i + 1)), array.length);
            System.out.println();
	}
	System.out.printf("%s%n%n", "No. of required inputs complete!");
    }
}
    
    
