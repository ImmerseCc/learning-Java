package study01;

import java.util.Scanner;

public class MJ005 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*
        账号名组1：user,freedom,projects,,沐Cc
        账号名组2：ssr,SoC,risk_user,readily,shell,doge
        */
       String namesGroup = sc.nextLine();
       String[] names = namesGroup.split(",");
       int num = 0;
        for(String name : names){
            if(name.equals("")){
                continue;
            }else if (name.equals("risk_user")) {
                System.out.println("发现异常用户，已停止处理");
                break;
            }else{
                ++num;
                System.out.println("正在创建账号" + name);
            }   
        }
        System.out.println("已成功创建了" + num + "个账号");
    }   
}
