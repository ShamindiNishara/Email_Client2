// 200450G

//import libraries
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Email_Client {
    public static ArrayList<Recipient> emailList = new ArrayList<>();
    public static ArrayList<Email> sentEmail = new ArrayList<>();


    public static void main(String[] args) {

        String today = DateTime.getDate();

        EmailBase eb = new EmailBase();
        eb.createMailList();

        try {


        DeserializeEmail deserializeEmail = new DeserializeEmail();

        sentEmail = deserializeEmail.deserialized();

    }
        catch(Exception e){
            System.out.println("error");
        }


        ArrayList<Recipient> bdayList ;

        bdayList = eb.findBday(today);

        for (Recipient re : bdayList) {


            String ps = re.getEmail() + ", Birthday wish, " + re.bdayWish();
            GenerateEmail gg = new GenerateEmail(ps);
            boolean check = true;
            for (Email email : sentEmail) {
                String e = email.getGenerateEmail().getEmail();
                String sub = email.getGenerateEmail().getSubject();
                String d=email.getDateSent();
                if (e.equals(re.getEmail()) && sub.equals("Birthday wish") && (d.equals(today)) ) {
                    check = false;
                }

            }
            if (check) {
                SendEmailTLS.sendEmail(re.getEmail(), "Birthday wish ", re.bdayWish());
                ;
                Email sEmail = new Email(today, gg);

                sentEmail.add(sEmail);

            }
        }



            Scanner scanner = new Scanner(System.in);

                System.out.println("Enter option type: \n"
                        + "1 - Adding a new recipient\n"
                        + "2 - Sending an email\n"
                        + "3 - Printing out all the recipients who have birthdays\n"
                        + "4 - Printing out details of all the emails sent\n"
                        + "5 - Printing out the number of recipient objects in the application"

                );

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Add the recipients according to the following format. \n" +
                                "For official recipients -->  Official: <name>,<email>,<designation> \n"
                                + "For personal recipients -->  Personal: <name>,<nickname>,<email>,<birthday>\n"
                                + "For official_firend recipients -->  Office_friend: <name>,<email>,<designation>,<birthday>");

                        Scanner obj = new Scanner(System.in);
                        String newPerson = obj.nextLine();


                        eb.AddtoTxt(newPerson);


                        break;
                    case 2:
                        try {
                            System.out.println("Input correct  format\n"
                                    + "<email>, <subject>, <content>");

                            Scanner mailobj = new Scanner(System.in);
                            String mail = mailobj.nextLine();
                            GenerateEmail ge = new GenerateEmail(mail);
                            SendEmailTLS.sendEmail(ge.getEmail(), ge.getSubject(), ge.getContent());

                            String dt = DateTime.getDate();

                            Email seEmail = new Email(dt, ge);
                            sentEmail.add(seEmail);
                        } catch (Exception e) {
                            System.out.println("Invalid Input,Try Again");

                        }
                        // input format - email, subject, content
                        // code to send an email
                        break;
                    case 3:
                        try {
                            System.out.println("Input  birthday in YYYY/MM/DD format");
                            ArrayList<Recipient> bday;
                            Scanner dateObj = new Scanner(System.in);
                            String date = dateObj.nextLine();
                            //BdayPeople bdayPeople = new BdayPeople(date);

                            bday = eb.findBday(date);
                            for (Recipient bd : bday) {

                                System.out.println(bd.getName());


                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Input,Try again");
                        }
                        // input format - yyyy/MM/dd (ex: 2018/09/17)
                        // code to print recipients who have birthdays on the given date
                        break;
                    case 4:
                        try {
                            System.out.println("Input  date in YYYY/MM/DD format");
                            Scanner scr = new Scanner(System.in);
                            String dateIn = scr.nextLine();
                            for (Email email : sentEmail) {
                                if ((email.getDateSent()).equals(dateIn)) {
                                    GenerateEmail gmail = email.getGenerateEmail();
                                    System.out.println("Recipient: " + gmail.getEmail() + " ,Subject :" + gmail.getSubject() + " ,Content :" + gmail.getContent());
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input,Try again");
                        }
                        // input format - yyyy/MM/dd (ex: 2018/09/17)
                        // code to print the details of all the emails sent on the input date
                        break;
                    case 5:
                        // code to print the number of recipient objects in the application
                        System.out.println("the number of recipient objects in the application " + emailList.size());
                        break;

                }

                Serialization serialization = new Serialization();
                serialization.Serialize(sentEmail);
            }
        }





