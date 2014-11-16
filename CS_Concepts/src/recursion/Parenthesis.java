package recursion;

public class Parenthesis {

	public static void main(String[] args) {
			Parenthesis p =new Parenthesis();
			p.printParenthesis(3);
	}

	public void printParenthesis(int l, int r, char[] str, int count){
		if(l<0||r<l) return;
		if(l==0 && r==0){
				System.out.println(str);
		}else{
				if(l>0){
					str[count] = '('; 
					printParenthesis(l-1, r, str, count+1);
				}
				
				if(r>l){
					str[count] = ')'; 
					printParenthesis(l, r-1, str, count+1);
				}
		}
	}
	
	public void printParenthesis(int n){
		char[] str = new char[2*n];
		printParenthesis(n, n, str, 0);
	}
}
