import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0 ;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public  double getSavingBalance(){
        return savingBalance;
    }

public void calcCheckingWithdrawal(double amount){
        checkingBalance -=amount;
}

    public void calcSavingWithdraw(double amount){
        savingBalance -=amount;
    }

    public void calcCheckingDeposit(double amount){
        checkingBalance +=amount;
    }

    public void calcSavingDeposit(double amount){
        savingBalance +=amount;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance : "+moneyFormat.format(checkingBalance));
        System.out.print("Amount to withdraw from checking account : ");
        double amount = input.nextDouble();

        if(amount <= 0){
            System.out.println("invalid amount . Please enter a positive number.");
        } else if (checkingBalance - amount >= 0) {
            calcCheckingWithdrawal(amount);
            System.out.println("new checking account balance : "+ moneyFormat.format(checkingBalance));
        }else {
            System.out.println("not enough funds.");
        }

    }
public void getSavingWithdrawInput(){
    System.out.println("saving account balance : "+moneyFormat.format(savingBalance));
    System.out.print("amount to withdraw from saving account : ");
    double amount = input.nextDouble();

    if(amount <= 0){
        System.out.println("invalid amount . please entera positive number.");
    } else if (savingBalance-amount >= 0) {
        calcSavingWithdraw(amount);
        System.out.println("new saving account balance : "+moneyFormat.format(savingBalance));
    }else {
        System.out.println("not enough funds.");
    }

}

public void getCheckDepositInput(){
    System.out.println("checking account balance : "+ moneyFormat.format(checkingBalance));
    System.out.println("amount to deposit to checking account : ");
double amount = input.nextDouble();
    if (amount <= 0) {
        System.out.println("Invalid amount");
    } else {
        calcCheckingDeposit(amount);
    }
    }
public void getSavingDepositInput(){
    System.out.println("Saving account balance : "+moneyFormat.format(savingBalance));
    System.out.println("amount to deposit to saving account : ");
    double amount = input.nextDouble();

    if(amount <=0){
        System.out.println("invalid amount. please enter a positive number.");
    }else{
        calcSavingDeposit(amount);
        System.out.println("new saving account balance : "+moneyFormat.format(savingBalance));
    }
}

}
