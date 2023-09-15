import java.io.*;
import java.util.ArrayList;

public class Serialization {
    public void  Serialize(ArrayList<Email> sentMail) {
        try {


            FileOutputStream fileout = new FileOutputStream("charFile.ser");


            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(sentMail);



            //System.out.println("serialization");
            out.close();
            fileout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
