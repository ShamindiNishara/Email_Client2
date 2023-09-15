import java.io.Serializable;
public class GenerateEmail implements Serializable  {
    private String email;
    private String content;
    private String subject;

    public GenerateEmail(String s){
        String[] mailStructure=s.split(", ");
        this.email=mailStructure[0];
        this.subject=mailStructure[1];
        this.content=mailStructure[2];


    }

    public String getEmail() {
        return email;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }
}

