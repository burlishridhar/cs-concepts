package recursion;

public class PaintFill {

	public static void main(String[] args) {
		Color [][]screen = { {Color.B, Color.B, Color.B, Color.B} ,
							 {Color.B, Color.B, Color.B, Color.B} ,
							 {Color.B, Color.A, Color.A, Color.B} ,
							 {Color.B, Color.A, Color.A, Color.B} ,
							 {Color.B, Color.B, Color.B, Color.B} ,
							 {Color.B, Color.B, Color.B, Color.B} ,
							 {Color.B, Color.B, Color.B, Color.B} };

		PaintFill p = new PaintFill();
		
		System.out.println("\nOld Screen");
		p.printScreen(screen, 7, 4);
		
		p.paintFill(screen, 2, 3, Color.C);
		
		System.out.println("\nNew Screen");
		p.printScreen(screen, 7, 4);
		
	}

	public void printScreen(Color[][] screen, int m, int n){
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++)
				System.out.print(screen[i][j]+" ");
			System.out.println();
		}
	}

	enum Color{A,B,C}
	
	public void paintFill(Color[][] screen, int x, int y, Color oColor, Color nColor){
			if(x<=0||x>=screen[0].length ||
			   y<=0||y>=screen.length) return;
			
			if(screen[y][x]==oColor){
				screen[y][x]=nColor;
				paintFill(screen, x+1, y, oColor, nColor);
				paintFill(screen, x-1, y, oColor, nColor);
				paintFill(screen, x, y+1, oColor, nColor);
				paintFill(screen, x, y-1, oColor, nColor);
			}
	}
	
	public void paintFill(Color[][] screen, int x, int y, Color nColor){
		paintFill(screen, x, y, screen[y][x], nColor);
	}

}

