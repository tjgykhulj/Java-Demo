package demo;

/**
 * @author Tang JG
 * @version 1.0
 */

/**
 *  小坏蛋类
 */
class 小坏蛋  {
	private int 情绪 = 30;
	private float 身高 = 160;
	
	public String 现在的情绪() {
		return (情绪>0)? "有点开心" : "有点不高兴";
	}
}

/**
 * 创建小坏蛋并测试
 */
public class Demo {
	
	static 小坏蛋 章荧 = new 小坏蛋();
	public static void main(String 不知道是什么鬼[]) {
		System.out.printf("小坏蛋现在%s", 章荧.现在的情绪());
	}
}
