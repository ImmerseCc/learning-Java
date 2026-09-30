import java.util.Scanner;

public class DS006 {
	public static boolean isValidInteger(String num) {
			if (num.trim() == null) return false;
			return num.trim().matches("0|[1-9]\\d*");
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		if(!isValidInteger(num)){
			System.out.println("输入格式非法");
			sc.close();
			return;
		}
		if (new StringBuilder(num).reverse().toString().equals(num)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		sc.close();
	}
}
