/*****************************************************************
 * Tran Le and Bojana Crnomarkovic                               *
 * 4098, 3267                                                    *
 * Program for CSC 207                                           *
 *   Pictorial Invariants Lab                                    *
 * Assignment for Friday, October 18th                           *
 *****************************************************************/


/* ***************************************************************
 * Academic honesty certification:                               *
 *   Written/online sources used:                                *
 *    -http://www.cs.grinnell.edu/~walker/courses/207.fa18/      *
 *     readings/reading-loop-invariants.shtml                    *
 *    -http://www.cs.grinnell.edu/~walker/courses/207.fa18/      *
 *     readings/reading-loop-inv-pic.shtml                       *
 *   Help obtained                                               *
 *    -none                                                      *
 *   My signature below confirms that the above list of sources  *
 *   is complete AND that I have not talked to anyone else       *
 *   [e.g., CSC 161 students] about the solution to this problem *
 *                                                               *
 *   Signature:                                                  *
 *****************************************************************/
package partitions;

/**
 * The Flag class provide methods sorting an array of colors in the order of the 
 * Dutch national flag - red, white, and blue. 
 * An instance of Flag has no fields. However, it supports declaring new type 
 * color which can be either red, white, or blue. 
 */
public class Flag {
	
	//define a new type color which can be either red, white, or blue
	enum color {
		red, white, blue
	}; 

	/**
	 * Pre-conditions: none
	 * Post-conditions: The array of colors is printed
	 * @param an array of elements type color
	 * @return nothing
	 * */
	public void printColor(color [] colors) {
		for (color some_color : colors) {
			System.out.println(some_color); //prints the colors in the array one by one
		}
		System.out.println(); 
	}

	/**
	 * Method rearranges the input array of elements in order of the Dutch national flag. 
	 * Pre-conditions: none
	 * Post-conditions: The array of colors is sorted in the order of the Dutch flag
	 * @param an array of elements type color
	 * @return nothing
	 * */
	public void InvariantA (color [] colors) {
		int r_spot = -1, w_spot = -1, b_spot = -1;  
		for (color some_color : colors) {
			switch(some_color) {
			case red: 
				r_spot++; 
				w_spot++; 
				b_spot++; 
				color temp = colors[r_spot]; 
				colors[r_spot] = colors[b_spot]; 
				colors[b_spot] = colors[w_spot]; 
				colors[w_spot] = temp; 
				break; 
			case white: 
				w_spot++; 
				b_spot++; 
				color temp_w = colors[w_spot]; 
				colors[w_spot] = colors[b_spot]; 
				colors[b_spot] = temp_w; 
				break; 
			case blue: 
				b_spot++; 
				break; 
			}
		}
	}

	/**
	 * Method rearranges the input array of elements in order of the Dutch national flag. 
	 * Pre-conditions: none
	 * Post-conditions: The array of colors is sorted in the order of the Dutch flag
	 * @param an array of elements type color
	 * @return nothing
	 * */
	public void InvariantD (color [] colors) {
		int size_color = colors.length; 
		int w_spot = size_color, b_spot = size_color, r_spot = size_color; 
		for (int i = size_color - 1; i >= 0; i--) {
			switch(colors[i]) {
			case blue: 
				b_spot--; 
				w_spot--; 
				r_spot--; 
				color temp = colors[r_spot]; 
				colors[r_spot] = colors[w_spot]; 
				colors[w_spot] = colors[b_spot]; 
				colors[b_spot] = temp; 
				break; 
			case white: 
				w_spot--; 
				r_spot--; 
				color temp_w = colors[r_spot]; 
				colors[r_spot] = colors[w_spot]; 
				colors[w_spot] = temp_w; 
				break; 
			case red: 
				r_spot--; 
				break; 
			}
		}
	}

	public static void main (String [] args) {
		Flag flag = new Flag(); 
		
		//declare some arrays
		//Case 1, no colors
		color [] colors = {};
		//Case 2, only blue
		color [] colors1 = {color.blue};
		//Case 3, only red
		color [] colors2 = {color.red};
		//Case 4, only white
		color [] colors3 = {color.white};
		//Case 5, blue and red
		color [] colors4 = {color.blue, color.blue, color.blue, color.red, color.blue, color.red};
		//Case 6, blue and white
		color [] colors5 = {color.white, color.white, color.white, color.blue, color.blue};
		//Case 7, white and red
		color [] colors6 = {color.white, color.red, color.white, color.red, color.white, color.red, color.white};
		//Case 8, all three colors
		color [] colors7 = {color.red, color.red, color.blue, color.white, color.white, color.red, 
				color.white, color.blue, color.red, color.blue, color.red}; 
		//Case 9, already sorted
		color [] colors8 = {color.red, color.red, color.white, color.white, color.white, color.blue, color.blue}; 
	
		//test each case with both invariants
		//Case 1
		flag.InvariantA(colors);
		System.out.println("Invariant A sort on empty array of colors: \n");
		flag.printColor(colors);
		
		flag.InvariantD(colors);
		System.out.println("Invariant D sort on empty array of colors: \n");
		flag.printColor(colors);
		
		//Case 2
		flag.InvariantA(colors1);
		System.out.println("Invariant A sort on colors1: \n");
		flag.printColor(colors1);

		flag.InvariantD(colors1);
		System.out.println("Invariant D sort on colors1: \n");
		flag.printColor(colors1);
		
		//Case 3
		flag.InvariantA(colors2);
		System.out.println("Invariant A sort on colors2: \n");
		flag.printColor(colors2);

		flag.InvariantD(colors2);
		System.out.println("Invariant D sort on colors2: \n");
		flag.printColor(colors2);
		
		//Case 4
		flag.InvariantA(colors3);
		System.out.println("Invariant A sort on colors3: \n");
		flag.printColor(colors3);

		flag.InvariantD(colors3);
		System.out.println("Invariant D sort on colors3: \n");
		flag.printColor(colors3);
		
		//Case 5
		flag.InvariantA(colors4);
		System.out.println("Invariant A sort on colors4: \n");
		flag.printColor(colors4);

		flag.InvariantD(colors4);
		System.out.println("Invariant D sort on colors4: \n");
		flag.printColor(colors4);
		
		//Case 6
		flag.InvariantA(colors5);
		System.out.println("Invariant A sort on colors5: \n");
		flag.printColor(colors5);

		flag.InvariantD(colors5);
		System.out.println("Invariant D sort on colors5: \n");
		flag.printColor(colors5);
		
		//Case 7
		flag.InvariantA(colors6);
		System.out.println("Invariant A sort on colors6: \n");
		flag.printColor(colors6);

		flag.InvariantD(colors6);
		System.out.println("Invariant D sort on colors6: \n");
		flag.printColor(colors6);
		
		//Case 8
		flag.InvariantA(colors7);
		System.out.println("Invariant A sort on colors7: \n");
		flag.printColor(colors7);

		flag.InvariantD(colors7);
		System.out.println("Invariant D sort on colors7: \n");
		flag.printColor(colors7);
		
		//Case 9
		flag.InvariantA(colors8);
		System.out.println("Invariant A sort on colors8: \n");
		flag.printColor(colors8);

		flag.InvariantD(colors8);
		System.out.println("Invariant D sort on colors8: \n");
		flag.printColor(colors8);
		
	}
}
