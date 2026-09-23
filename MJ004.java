package study01;

import java.util.Scanner;

public class MJ004 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请依次分行输入账号名、密码、账号状态与登录天数");
        String name = sc.nextLine(); 
        String password = sc.nextLine();              
        String accountStatus = sc.nextLine();
        String loginDays = sc.nextLine();
        if (name.equals("")) {
            System.out.println("账号名不得为空");
            return ;
        }else if (password.length() < 6) {
            System.out.println("密码长度不足");
            return ;
        }else if(accountStatus.equals("blocked")) {
            System.out.println("账号风险拦截");
            return ;
        }
        try {
            Integer.parseInt(loginDays);
        } catch (NumberFormatException e) {
            System.out.println("登录天数格式错误");
            return ;
        }
        System.out.println("账号校验通过");
        sc.close();
    }
    
}
