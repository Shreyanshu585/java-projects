import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {

    Scanner menuInput = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer,Integer> data = new HashMap<>();

    public void getLogin(){
        int x = 1 ;
        do{
            try{
                data.put(983484,935955);
                data.put(935955,983484);

                System.out.println("welcome to ATM");
                System.out.println("enter your customer number ");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("enter your pin number ");
                setPinNumber(menuInput.nextInt());
            }
            catch (Exception e ){
                System.out.println("\nInvalid characters only number allowed\n"+e);
                x=2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();


            if (data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();
            }else{
                System.out.println("\nWrong Customer number or wrong PIN number \n\n");
            }

        }while(x==1);

    }

    public  void getAccountType(){
        System.out.println("select account type you want access");
        System.out.println("type 1 - checking account");
        System.out.println("type 2 - saving account ");
        System.out.println("type 3 - exit");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("thank you for using ATM ,Bye\n");
            default -> System.out.println("\n invalid choice \n");
        }
    }

public void getChecking(){
    System.out.println("checking account");
    System.out.println("type 1 - view balance");
    System.out.println("type 2 - withdraw money");
    System.out.println("type 3 - deposit funds");
    System.out.println("type 4 - exit");

    int selection = menuInput.nextInt();

    switch(selection){
        case 1 -> {
            System.out.println(String.format("checking account balance : " + moneyFormat.format(getCheckingBalance())));
        getAccountType();
        }
        case 2 -> {
            getCheckingWithdrawInput();
            getAccountType();
        }
        case 3 ->{
            getCheckDepositInput();
            getAccountType();
        }
        case 4 ->{
            System.out.println("thank you for using ATM , Bye");}
        default -> {
            System.out.println(" \ninvalid choice\n");
            getChecking();
        }
    }
}

public void getSaving(){
    System.out.println("saving account");
    System.out.println("type 1 - view balance ");
    System.out.println("type 2 - withdraw money");
    System.out.println("type 3 - deposit funds");
    System.out.println("type 4 - exit");
    System.out.println("choice : ");

    int selection =menuInput.nextInt();

    switch(selection){
        case 1 ->{
            System.out.println("saving account balance : "+moneyFormat.format(getSavingBalance()));
            getAccountType();
        }
        case 2 -> {
            getSavingWithdrawInput();
            getAccountType();
        }
        case 3 ->{
            getSavingDepositInput();
            getAccountType();
        }
        case 4 ->{
            System.out.println("thank you for using ATM , Bye\n");}
        default ->{
            System.out.println("\ninvalid choice\n");
        }

    }

}
}
