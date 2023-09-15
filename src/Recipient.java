public abstract  class Recipient {
    private  String email;
    private  String name;
    //public static String bdayWish=null;

    public Recipient(String name,String email){
        this.email=email;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public abstract String bdayWish();



}
