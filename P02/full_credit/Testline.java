public class Testline{
	public static void main(String [] args){
		Line first = new Line (9.360, 4.605, 6.226, 4.110, Color.Orange);
                Line second = new Line (0.752, 8.626, 5.670, 9.264, Color.Purple);
                Line third = new Line (9.070, 8.058, 3.194, 4.605, Color.Pink);
                Line fourth = new Line (5.561, 4.001, 9.962, 5.561, Color.Grey);
	
		String first_line = first.toString();
		double length1 = first.length();
		System.out.println(first_line + length1);
		
		String second_line = second.toString();
		double length2 = second.length();
		System.out.println(second_line + length2);
		
		String third_line = third.toString();
		double length3 = third.length();
		System.out.println(third_line + length3);
		
		String fourth_line = fourth.toString();
		double length4 = fourth.length();
		System.out.println(fourth_line + length4);
	}
}
