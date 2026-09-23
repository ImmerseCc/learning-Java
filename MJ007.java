package study01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MJ007 {
    static String[] reader(Scanner sc){
        String name = sc.nextLine();
        String password = sc.nextLine();
        String[] in = {name,password};
        return in;
    }

    static boolean validateAccount(String[] in){
        if (in[0].equals("")) {
            System.out.println("账号名不得为空");
            return false;
        }else if (in[0].length() < 6 || in[0].length() > 18) {
            System.out.println("账号名不得少于6或多于18个字符");
            return false;
        }else if(!in[0].matches("\\w+")){
            System.out.println("账号名格式错误，存在非法字符");
            return false;
        }else if (in[1].equals("")) {
            System.out.println("密码不得为空");
            return false;
        }else if (in[1].length() < 6 || in[1].length() > 18) {
            System.out.println("密码不得少于6或多于18个字符");
            return false;
        }else if(!in[1].matches("\\w+")){
            System.out.println("密码格式错误，存在非法字符");
            return false;}
        return true;
    }
     
    static String encryptPassword(String password){
        String encryptedPassword = new StringBuilder(password).reverse().toString();
        return encryptedPassword;
    }

    static void saver(String name,String encryptedPassword)throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("account.txt"))) {
            writer.write("accountName:" + name);
            writer.newLine();
            writer.write("encryptedPassword:" + encryptedPassword);
            writer.close();
        } catch (IOException e) {
            System.out.println("保存账号信息失败");
            throw e;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请依次换行输入您的账号名与密码。\n(账号名与密码均应仅由大、小写字母、数字与下划线组成,且均不得少于6个或多于18个字符。)");
       
        String[] account = reader(sc);
        boolean isLegal = validateAccount(account);
        if(!isLegal)return;
        String encryptedPassword =encryptPassword(account[1]);
        try{
            saver(account[0], encryptedPassword);
        }catch(IOException e){
            return ;
        }
        System.out.println("Hello World! 慢脚账号创建完成");
    }
}