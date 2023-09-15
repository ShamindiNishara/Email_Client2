import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Scanner;

public class EmailBase {

    public ArrayList<Recipient> createMailList(){

        try {

            File txtfile = new File("C:\\Users\\Public\\Email_Client2\\clientList.txt");
            Scanner scr = new Scanner(txtfile);
            RecipientFactory recipientFactory=new RecipientFactory();
            while(scr.hasNextLine()){

                String s = scr.nextLine();

                Recipient r=recipientFactory.getRecipient(s);
                //Recipient r = generateRecipient(s);

                Email_Client.emailList.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }return Email_Client.emailList;

    }


    public void AddtoTxt(String newPerson)  {

        try {

            FileWriter f = new FileWriter("C:\\Users\\Public\\Email_Client2\\clientList.txt",true);
            BufferedWriter writer=new BufferedWriter(f);

            writer.write(newPerson+"\n");
            RecipientFactory recipientFactory1=new RecipientFactory();
            Recipient r=recipientFactory1.getRecipient(newPerson);
            //Recipient r = generateRecipient(newPerson);
            Email_Client.emailList.add(r);
            writer.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Recipient> findBday(String date){
        ArrayList<Recipient> temp=new ArrayList<>();
        for(Recipient s:Email_Client.emailList){
            if(s instanceof Personal){
                if(((Personal) s).getBirthday().substring(4,10).equals(date.substring(4,10))){
                    temp.add(s);
                    //System.out.println(s.getName());
                }
            } else if (s instanceof OfficialFriend) {
                if(((OfficialFriend) s).getBirthday().substring(4,10).equals(date.substring(4,10))){
                    // System.out.println(s.getName());
                    temp.add(s);

                }

            }


        }
        return temp;

    }


}

