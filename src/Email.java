import java.io.Serializable;

public class Email implements Serializable {
    private String dateSent;
    private GenerateEmail generateEmail;

    public Email(String dateSent,GenerateEmail generateEmail){
        this.generateEmail=generateEmail;
        this.dateSent=dateSent;
    }
    public String getDateSent(){
        return dateSent;
    }
    public GenerateEmail getGenerateEmail(){
        return generateEmail;
    }
}
