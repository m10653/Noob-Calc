
public class Calculator {
	private static String displaystring = "";
	private static String currentint = "";
	private static String prevint = "";
	private static String operator= "";
	private static Window gui;
	private static String cacheop = "";
	private static String cachecurint = "";
	//private static String superscript[] = {"","","","","","","","","",""}; TODO: add support for exponents
	

	public static void main(String[] args) {
		
		gui = new Window();

	}
	
	
	public static void buildString(String str){
		if((str.equals(".")&& currentint.contains("."))){ //Checks for double . point
			System.out.println("Warning: invalid action \"" + str + "\" because Currentint = "+ currentint);
			
		}else if(currentint.contains("Infinity")||currentint.contains("NaN")){ //checks for Infinity
			System.out.println("Infinity cannot be modified");
			
		}else{ //else just number then add it to the screen
			currentint += str;
		}
		
		updatedisplay();
		
	}
	public static void addOperator(String str){
		clearCache();
		if(currentint.endsWith(".")){ //adds zero to trailing .
			currentint += "0";
		}
		if(displaystring.contains("+")||displaystring.contains("-")||displaystring.contains("*")||displaystring.contains("/")||displaystring.contains("%")){ //auto calculates if it has a operator 
			Calculator.calculate();
		}
		
		operator = str;
		if(!prevint.isEmpty() && currentint.isEmpty()){
			
		}else{
			prevint = currentint;
			currentint = "";
		}
		updatedisplay();
		}
	
	
	public static void instant(String str){

		if(!currentint.isEmpty() && !currentint.contains("Infinity")){
			
			if(currentint.endsWith(".")){
				currentint += "0";
			}
			double currentdouble = Double.parseDouble(currentint);
			
			if(str.equals("x²")){
				currentint = Math.pow(currentdouble,2) + "";
			}
			
			else if(str.equals("x³")){
				currentint = Math.pow(currentdouble,3) + "";
			}
			
			else if(str.equals("√")){
				currentint = Math.sqrt(currentdouble) +"";
				
			}else if(str.equals("±")){
				currentint = currentdouble *-1 + "";
			}
			
			if (currentint.endsWith(".0")){
				currentint = currentint.substring(0, currentint.length()-2);
			}
			updatedisplay();
		}
		
	}
	public static void calculate(){
		double int1;
		double int2;
		String sign;
		double ans =0;
		
		if(!currentint.isEmpty() && (!cacheop.isEmpty()|| !operator.isEmpty())){
			if(currentint.endsWith(".")){
				currentint += "0";
			}
			if(currentint.startsWith(".")){
				currentint = 0 + currentint;
			}
			
			if(cacheop.isEmpty() && cachecurint.isEmpty()){
				cacheop = operator;
				cachecurint = currentint;
				sign = operator;
				int1 = Double.parseDouble(currentint);
				int2 = Double.parseDouble(prevint);
			} else{
				if(cacheop.equals("-") ||cacheop.equals("/")){
					int1 = Double.parseDouble(cachecurint);
					int2 = Double.parseDouble(currentint);
				}else{
					int1 = Double.parseDouble(currentint);
					int2 = Double.parseDouble(cachecurint);
				}
				sign = cacheop;
				
			}
			if(sign.equals("+")){
				ans = int2+ int1 ;
			}else if(sign.equals("-")){
				ans = int2 - int1;
			}else if(sign.equals("*")){
				ans = int2 * int1 ;
			}else if(sign.equals("/")){
				ans = int2 / int1 ;
			}else if(sign.equals("%") && !currentint.equals("0")){
				ans = int2 % int1;
			}
			currentint = ans +"";
			
			if (currentint.endsWith(".0")){
				currentint = currentint.substring(0, currentint.length()-2);
			}
			
			operator = "";
			prevint = "";
			updatedisplay();
		}
	}
	
	public static void delete(){
		if(currentint.length() !=0){
			
			if(currentint.startsWith("-")&& currentint.length() == 2){
				currentint = "";
			}else if(currentint.contains("Infinity")||currentint.contains("NaN")){
				clear();
			}else if(currentint.lastIndexOf("E")!= -1 && currentint.lastIndexOf("E") == currentint.length() -2){
				currentint = currentint.substring(0,currentint.length()-2);
			}else{
				currentint = currentint.substring(0,currentint.length()-1);
			}
			updatedisplay();
		}else{
			System.out.println("Error Nothing to delete");
		}
	}
	private static void updatedisplay(){
		if(operator.isEmpty()){
			displaystring = currentint;
		}else if(!operator.isEmpty()&& !prevint.isEmpty()){
			displaystring = prevint + operator + currentint;
		}else{
			displaystring = currentint;
		}
		if(displaystring.length() <=10){
			gui.setDisplayFont(60);
		}else if(displaystring.length() <=15){
			gui.setDisplayFont(40);
		}else{
			gui.setDisplayFont(20);
		}
		gui.setDisplay(displaystring);	
		
	}
	
	
	
	public static void clear(){
		displaystring = "";
		currentint = "";
		prevint = "";
		operator = "";
		cachecurint = "";
		cacheop = "";
		updatedisplay();
		
	}
	private static void clearCache(){
		cachecurint = ""; // clear cache
		cacheop = "";
	}
	
	public static int getDisplayLength(){
		return displaystring.length();
	}




}
