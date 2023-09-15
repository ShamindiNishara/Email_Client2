import java.io.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializeEmail {


    public ArrayList<Email> deserialized() throws IOException {

        ArrayList<Email> temp1 = null;
        try {
            FileInputStream file = new FileInputStream("charFile.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            Object object = in.readObject();
            temp1 = (ArrayList<Email>) object;

            in.close();
            file.close();
        } catch (
                ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }


        catch (
                Exception e) {
            temp1 = new ArrayList<>();
        } finally {
            return temp1;
        }
    }
}













