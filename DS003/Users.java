package DS003;

public class Users {
    private String name;
    private String userType;//0:普通用户，1：大会员
    public Users(String name, String userType) {
        this.name = name;
        this.userType = userType;
    }
    public String getName() {
        return name;
    }
    public void watch(){
        if("0".equals(userType)){
            System.out.println(name + " 正在观看普通视频");
        }else if("1".equals(userType)){
            System.out.println(name + " 正在观看VIP视频");
        }
    }
}
