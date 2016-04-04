package demo;

import java.util.EnumSet;

public class EnumTest2 {

	public interface Food {
		enum Appetizer implements Food {
			SALAD, SOUP, SPRING_ROLLS;
		}
		enum MainCourse implements Food {
			LASAGNE, HUMMOUS, BURRITO, LENTILS;
		}
		enum Dessert implements Food {
			FRUIT, GELATO;
		}
	}
	
	public static void main(String[] args) {
		Food a = Food.Appetizer.SALAD;
		System.out.println(a);
		for (Food i : Food.Dessert.values()) System.out.println(i);
		System.out.println("------------------------");
		EnumSet<Food.MainCourse> enums = EnumSet.noneOf(Food.MainCourse.class);
		enums.add(Food.MainCourse.LASAGNE);
		System.out.println(enums);
		enums = EnumSet.allOf(Food.MainCourse.class);
		System.out.println(enums); 
		enums.remove(Food.MainCourse.BURRITO);
		System.out.println(enums); 
	}

}
