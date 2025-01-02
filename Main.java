import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // (A. If Users want to get their Balance information)//

        // 1. We need to first greet the customers //
        System.out.println("Welcome to Our Online Banking System");
        Scanner scanner = new Scanner(System.in);
        // This welcome the users on Board

        List<String> transactionType = Arrays.asList("Balance".toLowerCase(), "Debit".toLowerCase());
        System.out.println("Enter transaction type:" + " Balance / Debit");
        String userTransactionType = scanner.nextLine().toLowerCase();
        Boolean balanceCheck = false;
        Boolean debitTranscation = false;

        if (transactionType.contains(userTransactionType)) {
            if (userTransactionType.equals(transactionType.get(0))) {
                balanceCheck = true;
                System.out.println("Balance Transcation type selected");
            } else if (userTransactionType.equals(transactionType.get(1))) {
                debitTranscation = true;
                System.out.println("Debit Transcation type selected");
            }else{
                System.out.println("Transaction type does not exist");
            }

        }

        // 2. We need to store the customeers Details using map //
        Map<String, Double> customers = new HashMap<>();

        // 3. We need to assign each customers with their respective balance//
        customers.put("Abdullahi".toLowerCase(), 34.78);
        customers.put("Abdulbasit".toLowerCase(), 45.67);
        customers.put("Abdulsamad".toLowerCase(), 10009.78);

        // customers.containsKey("Abdusamad");
        // 4. We ask the user to input their name so we compare them with what we have//
        String userName;
        if (balanceCheck) {
        
            // 5.We need to excute our logic in try and catch lock//
            try {
                System.out.println("Please enter your name to get Balance");
                // 6. Check if input has value//
                if (scanner.hasNextLine()) {

                    // 7 Save the user info to a variable//
                    userName = scanner.nextLine().toLowerCase();

                    // 8 Check if the uer details exits in our database//
                    if (customers.containsKey(userName)) {
                        System.out.println(
                                "Dear " + userName.toUpperCase() + " Your account Balance is: "
                                        + customers.get(userName));
                    } else {
                        System.out.println("We dont have your details in our database");
                    }
                } else {
                    System.out.println("input cannot be empty / We need your name");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }
          
        }else {
            System.out.println("Please Enter Your name to Proceed");
            try {
                if(scanner.hasNextLine()){
                    userName = scanner.nextLine();
                    if(customers.containsKey(userName)){
                        System.out.println("Dear " + userName + " Please Enter the amount to debit");
                        double availableBalance = customers.get(userName);
                        double amount = scanner.nextDouble();
                        double newAmount = amount + 10.00 ;
                        if(newAmount < availableBalance){
                            double customerBalance = availableBalance - amount;
                            System.out.println("Transaction Successful");
                            System.out.println("Dear " + userName.toUpperCase() + " Your Available Balance is : #" + String.format("%.2f", +  customerBalance));
                        }else{
                            System.out.println("Insufficient Funds: Transaction Failed");
                        }
                    }else{
                        System.out.println("Account does not exist");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
        // 9 Exit the Program of get Balance //
    }
}