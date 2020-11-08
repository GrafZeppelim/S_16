
import java.util.Scanner;

/**
 *
 * @author thaycacac
 */
public class Main {

    int[] bills;
    int wallet;
    int total;

    private static Scanner in = new Scanner(System.in);

    //Check user in put a number type int
    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result > 0) {
                    return result;
                } else {
                    System.err.println("Value input need to be > 0");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number.");
                System.out.print("Enter again: ");
            }
        }
    }

    //Get array bills that user input
    public void inputBills() {
        System.out.print("Input number of bill: ");
        int size = checkInputInt();
        this.bills = new int[size];
        //allow user input bills
        for (int i = 0; i < bills.length; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = checkInputInt();
        }
    }

    //Get amount that user input
    public int inputWallet() {
        System.out.print("Input value of wallet: ");
        this.wallet = checkInputInt();
        return wallet;
    }

    //Calculate the total amount of the bills
    public int calcTotal() {
        int total = 0;
        for (int i = 0; i < bills.length; i++) {
            total += bills[i];
        }
        return total;
    }

    //Check whether the amount in the wallet is enough to pay. 
    public boolean payMoney() {
        if (total > wallet) {
            return false;
        } else {
            return true;
        }
    }

    //Print total of bill and result
    public void printTotalAndResult() {
        this.total = calcTotal();
        System.out.println("This is total of bill: " + total);
        if (payMoney()) {
            System.err.println("You can buy it");
        } else {
            System.err.println("You can't buy it.");
        }
    }

    //check user input y/Y or n/N
    public boolean CheckYN() {
        System.out.print("Do you want to continue (Y/N): ");
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y/y or N/n.");
            System.out.print("Enter again: ");
        }
    }

    //check user input string
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        while (true) {
            obj.inputBills();
            obj.inputWallet();
            obj.printTotalAndResult();
            if (!obj.CheckYN()) {
                return;
            }
        }
    }
}
