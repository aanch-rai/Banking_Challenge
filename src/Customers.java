import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

class Customers {
    private String Name;
    ArrayList<Double> transaction = new ArrayList<Double>();
    Scanner scanner = new Scanner(System.in);

    public String getName() {
        return Name;
    }

    public void add_new_customer(String name, double initial_transaction) {
        this.Name = name;
        this.transaction.add(initial_transaction);
    }

    public void add_additional_transactions(ArrayList<Double> add_transactions) {
        for (int i = 0; i < add_transactions.size(); i++) {
            transaction.add(add_transactions.get(i));
        }

    }

    public void add_additional_transaction() {
        System.out.println("Enter the number of transactions you wish to add:");
        int count = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<count;i++){
            System.out.println("Enter Transaction "+(i+1)+": ");
            double trans = scanner.nextDouble();
            transaction.add(trans);
        }
    }

    public void display_tansaction_list(){
        System.out.println("Transactions of "+this.Name+":");
        System.out.println(transaction.toString());
    }


}