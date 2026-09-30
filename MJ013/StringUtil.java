package MJ013;

public class StringUtil {
	public static int stringUtil(String name,String password,String nickname){
        if(name == null || password == null || nickname == null){
            return 1;
        }
        if(name.isBlank()){
            return 2;
        }else if(password.isBlank()){
			return 3;
		}else if(nickname.isEmpty()){
            return 4;
        }
        return 0;
    }
	public static void printContext(int n){
		switch (n) {//1:null,2:illegal name,3:illgal password,4:illgal nickname 
			case 1:
				System.out.println("输入不合法,请再次分行依次输入您的账号、密码与昵称");
				break;
			case 2:
				System.out.println("账号名不得为空,请再次输入您的账号名");
				break;
			case 3:
				System.out.println("密码不得为空,请再次输入您的密码");
				break;
			case 4:
				System.out.println("昵称不得为无,请再次输入您的昵称");
				break;
		}
	}
}
