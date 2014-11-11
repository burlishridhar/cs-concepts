package bitmanipulation;

public class PrintBinary {

	public static void main(String[] args) {
			PrintBinary p = new PrintBinary();
			String dec = "1.125";
			String bin = p.printBinary(dec);
			
			System.out.println("Decimal Number : " + dec);
			System.out.println("Binary Number : " + bin);
	}

	public String printBinary(String number){
			int intPart = Integer.parseInt(number.substring(0, number.indexOf(".")));
			double decPart = Double.parseDouble(number.substring(number.indexOf(".")));
			StringBuffer result = new StringBuffer();
			
			while(intPart>0){
					result.append(intPart % 2); intPart >>= 1;
			}
			
			result.append(".");
			
			while(decPart>0){
					if(result.substring(result.indexOf(".")).length()>32) { result.append("ERROR"); break; }
//					if(decPart==1) { result.append(decPart); break; }
					double r = decPart * 2;
					if(r >=1 ){
							result.append("1"); decPart = r - 1;
					}else{
							result.append("0"); decPart = r;
					}
			}
			return result.toString();
			
	}
}
