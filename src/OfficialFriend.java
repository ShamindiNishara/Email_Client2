public class OfficialFriend extends Recipient{
    private String designation;
    private String birthday;
    //public  static String bdayWish="hugs and love on your birthday";
    public OfficialFriend(String name,String email,String designation,String birthday){
        super(name,email);
        this.birthday=birthday;
        this.designation=designation;

    }




    public String getBirthday(){
        return birthday;
    }
    public String getDesignation(){
        return designation;
    }

    @Override
    public String bdayWish() {
        return "Wish you a Happy Birthday. ~Shamindi~";
    }
}
