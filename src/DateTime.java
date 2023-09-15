import java.util.Date;
import java.text.SimpleDateFormat;

public  class DateTime {
    public static String getDate(){
        Date thisdate=new Date();
        SimpleDateFormat dateForm=new SimpleDateFormat("Y/MM/dd");
        return dateForm.format(thisdate);

    }
}
