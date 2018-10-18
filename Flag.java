package partitions;

public class Flag {
	enum color {
		red, white, blue
	}; 
	
	public void printColor(color [] colors) {
		for (color some_color : colors) {
			System.out.println(some_color);
		}
		System.out.println(); 
	}
	
	public void InvariantA(color [] colors) {
		int r_spot = -1, w_spot = -1, b_spot = -1;  
		for (color some_color : colors) {
			switch(some_color) {
				case red: 
					r_spot++; w_spot++; b_spot++; 
					color temp = colors[r_spot]; 
					colors[r_spot] = colors[b_spot]; 
					colors[b_spot] = colors[w_spot]; 
					colors[w_spot] = temp; 
					break; 
				case white: 
					w_spot++; b_spot++; 
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
	
	public void InvariantD(color [] colors) {
		int size_color = colors.length; 
		int w_spot = size_color, b_spot = size_color, r_spot = size_color; 
		for (int i = size_color - 1; i >= 0; i--) {
			switch(colors[i]) {
				case blue: 
					b_spot--; w_spot--; r_spot--; 
					color temp = colors[r_spot]; 
					colors[r_spot] = colors[w_spot]; 
					colors[w_spot] = colors[b_spot]; 
					colors[b_spot] = temp; 
					break; 
				case white: 
					w_spot--; r_spot--; 
					color temp_w = colors[r_spot]; 
					colors[r_spot] = colors[w_spot]; 
					colors[w_spot] = temp_w; 
					break; 
				case red: 
					r_spot--; 
					break; 
			}
		}
		for (color some_color2 : colors) {
			System.out.println(some_color2);
		}
		System.out.println(); 
	}
	
	public static void main (String [] args) {
		Flag flag = new Flag(); 
		color [] colors = {color.red, color.red, color.blue, color.white, color.white, color.red, 
							color.white, color.blue, color.red, color.blue, color.red}; 
		
		flag.InvariantD(colors);
		flag.printColor(colors);
	}
}
