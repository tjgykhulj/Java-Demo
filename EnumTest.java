package demo;

public class EnumTest extends BaseDemo{
	
	enum Date {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday 
	}
	public static void main(String args[]) {
		Date a = Date.Wednesday;
		println(a);	//print: "Wednesday"
		for (Date i : Date.values())
			println(i+" : "+i.ordinal()); //print example : "Monday : 0" 
	}
}
