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
		int r_spot = 0, w_spot = 0, b_spot = 0; 
		for (color some_color : colors) {
			switch(some_color) {
				case red: 
					color temp = some_color; 
					some_color = colors[b_spot]; 
					colors[b_spot] = colors[w_spot]; 
					colors[r_spot] = temp; 
					r_spot++; w_spot++; b_spot++; 
					break; 
				case white: 
					color temp_w = some_color; 
					some_color = colors[b_spot]; 
					colors[w_spot] = temp_w; 
					w_spot++; b_spot++; 
					break; 
				case blue: 
					b_spot++; 
					break; 
			}
		}
	}
	
	public void InvariantD(color [] colors) {
		int size_color = colors.length - 1; 
		
		int r_spot = size_color, w_spot = size_color, b_spot = size_color; 
		for (int i = size_color; i <= 0; i--) {
			color some_color = colors[i]; 
			switch(some_color) {
				case blue: 
					b_spot--; w_spot--; 
					color temp = some_color; 
					some_color = colors[w_spot]; 
					colors[w_spot] = colors[b_spot]; 
					colors[b_spot] = temp; 
					r_spot--;
					break; 
				case white: 
					w_spot--; 
					color temp_w = some_color; 
					some_color = colors[w_spot]; 
					colors[w_spot] = temp_w; 
					r_spot--; 
					break; 
				case red: 
					r_spot--; 
					break; 
			}
		}
	}
	
	public static void main (String [] args) {
		Flag flag = new Flag(); 
		color [] colors = {color.red, color.red, color.blue, color.white, color.white, color.red, 
							color.white, color.blue, color.red, color.blue, color.red}; 
		
		flag.InvariantA(colors);
		flag.printColor(colors);
	}
}
