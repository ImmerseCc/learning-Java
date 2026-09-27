public class MJ003 {
    public static void main(String[] args){
    int accountName = 123456;
    String nickName = "沐Cc";
    int password = 325799;
    int loginDays = 225;
    boolean isNewUser = true;//小点1完成

    int[] dailyLoginCountLast7Days = {5,3,4,1,0,2,2};
    System.out.println(dailyLoginCountLast7Days[0]);
    System.out.println(dailyLoginCountLast7Days[6]);
    int dailyLoginCountlength = dailyLoginCountLast7Days.length; 
    System.out.println(dailyLoginCountlength);//小点2完成
    
    dailyLoginCountLast7Days[2] = 6;
    System.out.println(dailyLoginCountLast7Days[2]);//小点3完成

    System.out.println("账号名:" + accountName
     + "\n昵称:" + nickName + 
     "\n登陆天数:" + loginDays +
    "\n是否为新用户:" + (isNewUser?"是":"否"));
    }
}
