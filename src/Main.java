import java.util.Scanner;

public class Main {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        int input;
        while (flag) {
            System.out.println("\nEnter 1 to add a new branch:");
            System.out.println("Enter 2 to view the list of branches in the bank");
            System.out.println("Enter 3 to add customer with initial transaction to a branch");
            System.out.println("Enter 4 to view the list of customers of a particular branch");
            System.out.println("Enter 5 to view list of customers with transactions of a particular branch");
            System.out.println("Enter 6 to add transactions to an existing customer in branch");
            System.out.println("Enter 7 to exit");


            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    add_new_branch();
                    break;

                case 2:
                    bank.view_list_of_branches();
                    break;

                case 3:
                    add_cust_to_branch();
                    break;


                case 4:
                    view_customer_list();
                    break;

                case 5:
                    view_customer_list_with_trans();
                    break;

                case 6:
                    add_transactions_to_existing_customer();
                    break;

                case 7:
                    flag = false;
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }

    }


    public static void add_new_branch() {
        System.out.println("Enter the branch name:");
        String branch_name = scanner.nextLine();
        bank.add_new_branch(branch_name);
    }

    public static void add_cust_to_branch() {
        System.out.println("Enter Branch where you would like to add customer:");
        String branch_name = scanner.nextLine();
        if (bank.find_branch(branch_name) == -1) {
            System.out.println("Sorry! Branch doesn't exist!");
            return;
        } else {
            System.out.println("Enter New Customer to Add:");
            String cust = scanner.nextLine();
            if (bank.find_customer_in_branch(branch_name, cust) >= 0) {
                System.out.println("Sorry! Customer already exists!");
                return;
            } else {
                System.out.println("Enter Initial Transaction Amount:");
                double trans_amt = scanner.nextDouble();
                scanner.nextLine();
                bank.add_cust_to_branch(branch_name, cust, trans_amt);
            }
        }

    }


    public static void view_customer_list() {
        System.out.println("Enter Branch name:");
        String branch_name = scanner.nextLine();
        if (bank.find_branch(branch_name) == -1) {
            System.out.println("Sorry! Branch doesn't exist!");
            return;
        } else {
            bank.display_list_of_customers_in_branch(branch_name);

        }

    }

    public static void view_customer_list_with_trans() {
        System.out.println("Enter Branch name:");
        String branch_name = scanner.nextLine();
        if (bank.find_branch(branch_name) == -1) {
            System.out.println("Sorry! Branch doesn't exist");
            return;
        } else {
            bank.display_list_of_customers_in_branch_with_tansactions(branch_name);

        }

    }


    public static void add_transactions_to_existing_customer() {
        System.out.println("Enter Branch Name:");
        String branch_name = scanner.nextLine();
        if (bank.find_branch(branch_name) == -1) {
            System.out.println("Sorry! Branch doesn't exist!");
        } else {
            System.out.println("Enter customer name:");
            String cust = scanner.nextLine();
            if (bank.find_customer_in_branch(branch_name, cust) == -1) {
                System.out.println("Sorry! Customer Doesn't exist!");
            } else {
                bank.add_tansaction_for_existing_customer(branch_name, cust);
            }

        }
    }


}
