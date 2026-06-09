import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;
class Food implements Serializable
{
    int itemno;
    int quantity;
    float price;

    Food(int itemno,int quantity)
    {
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*50;
                break;
            case 2:price=quantity*60;
                break;
            case 3:price=quantity*70;
                break;
            case 4:price=quantity*30;
                break;
        }
    }
}
class Singleroom implements Serializable
{
    String name;
    String contact;
    String gender;
    ArrayList<Food> food =new ArrayList<>();


    Singleroom()
    {
        this.name="";
    }
    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}

class Doubleroom extends Singleroom implements Serializable
{
    String name2;
    String contact2;
    String gender2;

    Doubleroom()
    {
        this.name="";
        this.name2="";
    }
    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
}
class NotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return "Not Available !";
    }
}
class holder implements Serializable
{
    Doubleroom luxury_doubleroom[]=new Doubleroom[10]; //Luxury
    Doubleroom deluxe_doubleroom[]=new Doubleroom[20]; //Deluxe
    Singleroom luxury_singleroom[]=new Singleroom[10]; //Luxury
    Singleroom deluxe_singleroom[]=new Singleroom[20]; //Deluxe
}


class HotelSystem {
    static holder hotel_ob = new holder();
    static Scanner sc = new Scanner(System.in);

    static void CustDetails(int i, int rn) {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";
        System.out.println("\nenter customer name : ");
        name = sc.next();
        System.out.println("enter contact number : ");
        contact = sc.next();
        System.out.println("enter gender : ");
        gender = sc.next();

        if (i < 3) {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2 = sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1 -> {
                hotel_ob.luxury_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
            }
            case 2 -> {
                hotel_ob.deluxe_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
            }
            case 3 -> {
                hotel_ob.luxury_singleroom[rn] = new Singleroom(name, contact, gender);
            }
            case 4 -> {
                hotel_ob.deluxe_singleroom[rn] = new Singleroom(name, contact, gender);
            }
            default->{
                System.out.println("wrong option");
            }

        }
    }

    static void bookroom(int i) {
        int j;
        int rn;
        System.out.println("\nchoose room number from: ");

        switch (i) {

            case 1 -> {
                for (j = 0; j < hotel_ob.luxury_doubleroom.length; j++) {
                    if (hotel_ob.luxury_doubleroom[j] == null) {
                        System.out.println(j + 1 + ",");
                    }
                }
                System.out.println("\n enter room number : ");
                try {
                    rn = sc.nextInt();
                    rn--;
                    if (hotel_ob.luxury_doubleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("invalid option ");
                    return;
                }
            }
            case 2 -> {
                for (j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] == null) {
                        System.out.println(j + 11 + ",");
                    }
                }
                System.out.println("\nenter room number : ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 11;
                    if (hotel_ob.deluxe_doubleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("invalid option");
                    return;
                }
            }

            case 3 -> {
                for (j = 0; j < hotel_ob.luxury_singleroom.length; j++) {
                    if (hotel_ob.luxury_singleroom[j] == null) {
                        System.out.println(j + 31 + ",");
                    }
                }
                System.out.println("\nenter room number");
                try {
                    rn = sc.nextInt();
                    rn = rn - 31;
                    if (hotel_ob.luxury_singleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("invalid option ");
                    return;
                }
            }
            case 4 -> {

                for (j = 0; j < hotel_ob.deluxe_singleroom.length; j++) {
                    if (hotel_ob.deluxe_singleroom[j] == null) {
                        System.out.println(j + 41 + ",");
                    }
                }
                System.out.println("\nenter room number : ");

                try {
                    rn = sc.nextInt();
                    rn = rn - 41;
                    if (hotel_ob.deluxe_singleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);

                } catch (Exception e) {
                    System.out.println("invalid option");
                    return;
                }
            }

            default->{
                System.out.println("enter valid option");
            }
        }
        System.out.println("room booked");

    }



    static void feature(int i) {
        switch (i) {
            case 1 -> {
                System.out.println("number of double beds : 1\n AC : YES\n free breakfast : Yes\ncharge per day: 4000");
            }
            case 2 -> {
                System.out.println("number of double beds : 1\\n AC : No\\n free breakfast : Yes\\ncharge per day: 3000\"");
            }
            case 3 -> {
                System.out.println("number of single beds : 1\\n AC : Yes\\n free breakfast : Yes\\ncharge per day: 2200\"");
            }
            case 4 -> {
                System.out.println("number of single beds : 1\\n AC : No\\n free breakfast : Yes\\ncharge per day: 1200\"");
            }

            default -> {
                System.out.println("enter valid option");

            }

        }

    }
    static void availability(int i){
int j ,count = 0;
 switch(i){

     case 1 ->{
         for(j =0 ; j<10 ;j++){
             if(hotel_ob.luxury_doubleroom[j]==null)
                 count++;
         }
     }
     case 2->{
         for(j = 0 ; j< hotel_ob.deluxe_doubleroom.length;j++){
             if(hotel_ob.deluxe_doubleroom[j]==null)
                 count++;
         }
     }
     case 3->{
         for(j = 0 ; j < hotel_ob.luxury_singleroom.length;j++){
             if(hotel_ob.deluxe_singleroom[j]==null)
                 count++;
         }
     }

     case 4 ->{
         for(j=0;j<hotel_ob.deluxe_singleroom.length;j++)
         {
             if(hotel_ob.deluxe_singleroom[j]==null)
                 count++;
         }
     }
     default->
             {
         System.out.println("Enter valid option");
             }

 }
        System.out.println("Number of rooms available : "+count);
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        switch(rtype)
        {
            case 1:
                amount+=4000;
                System.out.println("\nRoom Charge - "+4000);
                System.out.println("\n===============");
                System.out.println("Food Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:hotel_ob.luxury_doubleroom[rn].food)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                }

                break;
            case 2:amount+=3000;
                System.out.println("Room Charge - "+3000);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:hotel_ob.deluxe_doubleroom[rn].food)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                }
                break;
            case 3:amount+=2200;
                System.out.println("Room Charge - "+2200);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:hotel_ob.luxury_singleroom[rn].food)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                }
                break;
            case 4:amount+=1200;
                System.out.println("Room Charge - "+1200);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb: hotel_ob.deluxe_singleroom[rn].food)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }


    static void deallocate(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) {
            case 1:
                if(hotel_ob.luxury_doubleroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_doubleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.luxury_doubleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 2:
                if(hotel_ob.deluxe_doubleroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_doubleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_doubleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 3:
                if(hotel_ob.luxury_singleroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_singleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.luxury_singleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 4:
                if(hotel_ob.deluxe_singleroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_singleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_singleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }

    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
        try{
            System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
            do
            {
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q=sc.nextInt();

                switch(rtype){
                    case 1: hotel_ob.luxury_doubleroom[rn].food.add(new Food(i,q));
                        break;
                    case 2: hotel_ob.deluxe_doubleroom[rn].food.add(new Food(i,q));
                        break;
                    case 3: hotel_ob.luxury_singleroom[rn].food.add(new Food(i,q));
                        break;
                    case 4: hotel_ob.deluxe_singleroom[rn].food.add(new Food(i,q));
                        break;
                }
                System.out.println("Do you want to order anything else ? (y/n)");
                wish=sc.next().charAt(0);
            }while(wish=='y'||wish=='Y');
        }
        catch(NullPointerException e)
        {
            System.out.println("\nRoom not booked");
        }
        catch(Exception e)
        {
            System.out.println("Cannot be done");
        }
    }
}

class write implements Runnable
{
    holder hotel_ob;
    write(holder hotel_ob)
    {
        this.hotel_ob=hotel_ob;
    }
    @Override
    public void run() {
        try{
            FileOutputStream fout=new FileOutputStream("backup");
            ObjectOutputStream oos=new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }

    }
}


public class Hotel {
    static void main() {
        try {
            File f = new File("backup");
            if (f.exists()) {

                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                HotelSystem.hotel_ob = (holder) ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch, ch2;
            char wish;
            x:
            do {
                System.out.println("\nenter your choice : \n1.display room details\n2.display room availability\n3.book\n4.order food \n5.checkout\n6.exit\n");
                ch = sc.nextInt();

                switch (ch) {
                    case 1 -> {
                        System.out.println("\nchoose room type : \n1.luxury double room \n2.deluxe double room \n3.luxury single room \n4.deluxe single room\n");
                        ch2 = sc.nextInt();
                        HotelSystem.feature(ch2);
                    }
                    case 2 -> {
                        System.out.println("\nchoose room type : \n1.luxury double room \n2.deluxe double room \n3.luxury single room \n4.deluxe single room\n");
                        ch2 = sc.nextInt();
                        HotelSystem.availability(ch);
                    }

                    case 3 -> {
                        System.out.println("\nchoose room type : \n1.luxury double room \n2.deluxe double room \n3.luxury single room \n4.deluxe single room\n");
                        ch2 = sc.nextInt();
                        HotelSystem.bookroom(ch2);
                    }
                    case 4 -> {
                        System.out.println("room number : ");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("room doesn't exist");
                        else if (ch2 > 40)
                            HotelSystem.order(ch2 - 41, 4);
                        else if(ch2>30)
                            HotelSystem.order(ch2-31,3);
                        else if(ch2>10)
                            HotelSystem.order(ch2-11,2);
                        else if(ch2>0)
                            HotelSystem.order(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                    }
                    case 5-> {
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();

                        if (ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if (ch2 > 40)
                            HotelSystem.deallocate(ch2 - 41, 4);
                        else if (ch2 > 30)
                            HotelSystem.deallocate(ch2 - 31, 3);
                        else if (ch2 > 10)
                            HotelSystem.deallocate(ch2 - 11, 2);
                        else if (ch2 > 0)
                            HotelSystem.deallocate(ch2 - 1, 1);
                        else
                            System.out.println("Room doesn't exist");
                    }
                    case 6->{
                        new Thread(new write(HotelSystem.hotel_ob)).start();
                        System.out.println("Exiting... Data saved.");
                        break x;
                    }

                }


                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0);
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0);
                }

            }while(wish=='y'||wish=='Y');

            Thread t=new Thread(new write(HotelSystem.hotel_ob));
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }
            }


        }


