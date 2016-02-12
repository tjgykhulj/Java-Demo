package demo;

public class EnumTest extends BaseDemo{
	
	enum Date {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday 
	}
	
	private static String judge(Date d) {	//enum can work with switch
		switch (d) {
		case Saturday:
		case Sunday: return "Home";
		default: return "Work";
		}
	}
	public static void main(String args[]) {
		Date a = Date.Wednesday;
		println(a);	//print: "Wednesday"
		for (Date i : Date.values())			
			println(i+" : "+i.ordinal()+ " : " + judge(i)); 
		//example : "Monday : 0 : Work" 
	}
}
