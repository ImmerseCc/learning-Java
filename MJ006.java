

import java.util.Scanner;

public class MJ006 {

    static boolean validateAccount(String name,String password){
        if (name.equals("")) {
            System.out.println("账号名不得为空");
            return false;
        }else if (name.length() < 6 || name.length() > 18) {
            System.out.println("账号名不得少于6或多于18个字符");
            return false;
        }else if (password.equals("")) {
            System.out.println("密码不得为空");
            return false;
        }
        try {
            Integer.parseInt(password);
        } catch (NumberFormatException e) {
            System.out.println("密码只能由数字组成");
            return false;
        }
        return true;       
    }

    static String encryptPassword(String password){
        String encryptedPassword = new StringBuilder(password).reverse().toString();
        return encryptedPassword;
    }

    static void buildWelcomeMessage(String name){
        System.out.println("Hello,World! 欢迎来到MJ! 新账号" + name +"诞生了!");
    }
    
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请依次分行输入账号名与密码。");
        String name = sc.nextLine();
        String password =sc.nextLine();
        boolean validate = validateAccount(name,password);
        if (validate) {
            System.out.println("账号校验通过");
        } else {
            sc.close();
            return ;
        }
        String encryptedPassword = encryptPassword(password);
        buildWelcomeMessage(name);
        sc.close();
        //军训好累(｡•́︿•̀｡)
     }
}
