import java.util.ArrayList;

public class Bank {
    ArrayList<Branches> branches = new ArrayList<Branches>();

    public void add_new_branch(String branch_name) {
        if (find_branch(branch_name) == -1) {
            Branches new_branch = new Branches(branch_name);
            this.branches.add(new_branch);
        } else {
            System.out.println("Sorry! Branch already exists!");
        }
    }

    public void add_cust_to_branch(String branch_name, String cust, Double init_transaction) {
        int branch_position = find_branch(branch_name);
        Customers customers = new Customers();
        customers.add_new_customer(cust, init_transaction);
        branches.get(branch_position).add_customer_to_branch(customers);


    }

    public void add_tansaction_for_existing_customer(String branch_name, String customer_name) {
        int branch_position = find_branch(branch_name);
        int position_of_customer = branches.get(branch_position).find_customer(customer_name);
        Customers customers = branches.get(branch_position).get_customer(position_of_customer);
        customers.add_additional_transaction();
    }


    public void display_list_of_customers_in_branch(String branch_name) {
        int branch_position = find_branch(branch_name);
        for (int i = 0; i < branches.get(branch_position).customer.size(); i++) {
            System.out.println("Customer " + (i + 1) + ":" + branches.get(branch_position).customer.get(i).getName());
        }

    }


    public void display_list_of_customers_in_branch_with_tansactions(String branch_name) {
        int branch_position = find_branch(branch_name);
        for (int i = 0; i < branches.get(branch_position).customer.size(); i++) {
            System.out.println("\nCustomer " + (i + 1) + ":" + branches.get(branch_position).customer.get(i).getName());
            branches.get(branch_position).customer.get(i).display_tansaction_list();
        }
    }


    private int find_customer_in_branch(int branch_position, String customer_name) {
        return branches.get(branch_position).find_customer(customer_name);
    }

    public int find_customer_in_branch(String branch_name, String customer_name) {
        int branch_position = find_branch(branch_name);
        return branches.get(branch_position).find_customer(customer_name);
    }

    public int find_branch(String branch_name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranch_name().equals(branch_name)) {
                return i;
            }
        }
        return -1;
    }

    public void view_list_of_branches() {
        for (int i = 0; i < branches.size(); i++) {
            System.out.println("Branch " + (i + 1) + ": " + branches.get(i).getBranch_name());
        }
    }

}
