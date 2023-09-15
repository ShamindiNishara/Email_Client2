

public class Personal extends Recipient{
    private String nickname;
    private String birthday;
    //public  static  String bdayWish="hugs and love on your birthday";
    public Personal(String name,String email,String nickname,String birthday){

        super(name,email);
        this.birthday=birthday;
        this.nickname=nickname;

    }

    public String getBirthday(){

        return birthday;
    }
    public String getNickname(){
        return nickname;
    }

    @Override
    public String bdayWish() {
        return "Hugs and love on your birthday ~Shamindi~";
    }
}
