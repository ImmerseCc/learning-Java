import java.util.Scanner;

public class MJ012 {
    public static int stringUtil(String name,String password){
        if(name == null || password == null){
            return 1;
        }
        String realName = name.trim();
        if(realName.isBlank()){
            return 2;
        }else if(password.isBlank()){
			return 3;
		}else if(password.contains(realName)){
            return 4;
        }
        return 0;
    }
	public static void printContext(int n,String name){
		switch (n) {//0:normal,1:null,2:name illegal,3:password illgal,4:high-risk password 
			case 0:
				System.out.println("Hello World!欢迎" + name);
				break;
			case 1:
				System.out.println("输入不合法,请再次分行依次输入您的账号与密码");
				break;
			case 2:
				System.out.println("账号名不得为空,请再次输入您的账号名");
				break;
			case 3:
				System.out.println("密码不得为空,请再次输入您的密码");
				break;
			case 4:
				System.out.println("密码风险性高,请再次输入您的密码");
				break;
		}
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分行依次输入您的账号与密码");
		String name = sc.nextLine();
		String password = sc.nextLine();
		int m;
		do{
			m = stringUtil(name, password);
			if(m != 0){
				switch(m){
					case 1:
						printContext(m, name);
						name = sc.nextLine();
						password = sc.nextLine();
						break;
					case 2:
						printContext(m, name);
						name = sc.nextLine();
						break;
					case 3:
					case 4:
						printContext(m, name);
						password = sc.nextLine();
						break;
				}
			}
		}while(m != 0);
		String finalname = name.trim();
		if(finalname.contains("退款")){
			finalname = finalname.replace("退款", "***");
		}
		printContext(0, finalname);
		sc.close();
	}
}
