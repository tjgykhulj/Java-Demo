package demo;

/**
 * @author Tang JG
 * @version 1.0
 */

/**
 *  С������
 */
class С����  {
	private int ���� = 30;
	private float ��� = 160;
	
	public String ���ڵ�����() {
		return (����>0)? "�е㿪��" : "�е㲻����";
	}
}

/**
 * ����С����������
 */
public class Demo {
	
	static С���� ��ӫ = new С����();
	public static void main(String ��֪����ʲô��[]) {
		System.out.printf("С��������%s", ��ӫ.���ڵ�����());
	}
}
