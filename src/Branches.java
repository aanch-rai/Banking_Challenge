import java.sql.SQLOutput;
import java.util.ArrayList;

public class Branches {
    String branch_name;
    ArrayList<Customers> customer = new ArrayList<Customers>();

    public Branches(String branch_name) {
        this.branch_name = branch_name;
    }

    public void add_customer_to_branch(Customers customers){
        this.customer.add(customers);
    }

    public String getBranch_name() {
        return branch_name;
    }


    public int find_customer(String cust_name){
        for(int i=0;i<customer.size();i++){

            if(customer.get(i).getName().equals(cust_name)) {
                return i;
            }
        }

        return -1;
    }

    public Customers get_customer(int position){
        return customer.get(position);
    }
}
