public class RecipientFactory {
    public Recipient getRecipient(String s){
        String [] info=s.split(": ",-2);


        String person=info[0];


        String[] data=info[1].split(",",-2);
        if(person.equals("Official")){
            return new Official(data[0],data[1],data[2]);


        }
        else if(person.equals("Personal")){
            return new Personal(data[0],data[2],data[1],data[3]);

        }
        else if(person.equals("Office_friend")){

            return new OfficialFriend(data[0],data[1],data[2],data[3]);

        }
        else{
            return null;
        }
    }
}
