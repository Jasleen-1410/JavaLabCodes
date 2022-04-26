// Performed By: Jasleen Minhas
// UID: 20BCS6897

import java.util.Scanner;
import java.sql.*;

// Main Function
public class Jas_Cosmetics_Store {

        public static void bill(int id, String name, String brand, double price, int product_nums, double finalPrice) {
                // Bill statement
                System.out.println("\n* * * * * * * * FINAL BILL * * * * * * * * * *");
                System.out.println("\n\tID of the Cosmetics: " + id);
                System.out.println("\tName of the Cosmetics: " + name);
                System.out.println("\tBrand of the Cosmetics: " + brand);
                System.out.println("\tPrice of the Cosmetics: $ " + price);
                System.out.println("\n\tNumber of the products bought: " + product_nums);
                System.out.println("\tFinal bill to be paid: $ " + finalPrice);
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
        }

        public static void main(String[] args) {
                Statement st;
                ResultSet rs;

                try {

                        // Connecting with the MYSQL database
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jas_Cosmetics",
                                        "root", "12345");
                        st = con.createStatement();

                        Scanner input = new Scanner(System.in);
                        int choice;

                        System.out.println("\nPERFORMED BY: Jasleen Minhas, 20BCS6897");

                        do {
                                // Main Menu
                                System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                                System.out.println("JAS Cosmetics Store, Main Menu: (Jasleen Minhas)");
                                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");

                                System.out.println("\t1. Add a Cosmetic.");
                                System.out.println("\t2. Display all the Cosmetics details.");
                                System.out.println("\t3. Check the availability of the Cosmetic product.");
                                System.out.println("\t4. Buy the Cosmetics.");
                                System.out.println("\t5. Exit the Program!");

                                System.out.print("\nEnter your choice(1..5): ");
                                choice = input.nextInt();
                                System.out.println();

                                int id, numleft;
                                int availability;
                                String name, brand;
                                double price;

                                switch (choice) {
                                        case 1:
                                                // ADD a Cosmetic:
                                                System.out.print("Enter the Cosmetic's ID: ");
                                                id = input.nextInt();
                                                System.out.print("Enter the Cosmetic's Name: ");
                                                name = input.next();
                                                System.out.print("Enter the Cosmetic's Availability: ");
                                                availability = input.nextInt();
                                                System.out.print("Enter the Cosmetic's Brand: ");
                                                brand = input.next();
                                                System.out.print("Enter the Cosmetic's Price: ");
                                                price = input.nextFloat();
                                                System.out.print("Enter the Cosmetic product left in stock: ");
                                                numleft = input.nextInt();

                                                // Adding product
                                                String query = "INSERT INTO Cosmetics VALUES('" + id + "','" + name
                                                                + "','" + brand
                                                                + "','" + availability + "','" + price
                                                                + "','" + numleft
                                                                + "')";
                                                System.out.println(query);

                                                st.executeUpdate(query);
                                                System.out.println(
                                                                "............. Record is Inserted in the table successfully .............");

                                                break;

                                        case 2:
                                                // DISPLAY all the Cosmetics details.
                                                String queryDisplay = "SELECT * from Cosmetics";
                                                rs = st.executeQuery(queryDisplay);
                                                System.out.println("Record from the Cosmetic's Database");
                                                System.out.println(
                                                                "\n--------------------------------------------------------------------------------------------------------");
                                                System.out
                                                                .println(
                                                                                "ID.\t\tName.\t\t\tBrand.\t\tAvailability.\tPrice.\t\tItems Left.");
                                                System.out.println(
                                                                "-------------------------------------------------------------------------------------------------------");

                                                while (rs.next()) {
                                                        id = rs.getInt("Cosmetic_id");
                                                        name = rs.getString("Cosmetic_name");
                                                        brand = rs.getString("Cosmetic_brand");
                                                        availability = rs.getInt("Cosmetic_availability");
                                                        price = rs.getDouble("Cosmetic_price");
                                                        numleft = rs.getInt("Cosmetic_left");
                                                        System.out.println(
                                                                        id + "\t\t" + name + "\t\t" + brand + "\t\t"
                                                                                        + availability + "\t\t" + price
                                                                                        + "\t\t" + numleft);
                                                }

                                                System.out.println(
                                                                "--------------------------------------------------------------------------------------------------------");

                                                break;

                                        case 3:
                                                // CHECK the availability of the Cosmetic product.
                                                System.out.print(
                                                                "Enter the Cosmetic name for which you want to check the availability: ");
                                                String product = input.next();

                                                String queryCheck = "SELECT * from Cosmetics where Cosmetic_name like '%"
                                                                + product + "%'";
                                                rs = st.executeQuery(queryCheck);

                                                int count = 0;
                                                while (rs.next()) {
                                                        count = rs.getInt(1);
                                                }

                                                if (count == 0) {
                                                        System.out.println("\nSorry! No such Cosmetics Availabile!!!");
                                                        break;
                                                } else {

                                                        System.out.println(
                                                                        "\n--------------------------------------------------------------------------------------------------------");
                                                        System.out
                                                                        .println(
                                                                                        "ID.\t\tName.\t\t\tBrand.\t\tAvailability.\tPrice.\t\tItems Left.");
                                                        System.out.println(
                                                                        "--------------------------------------------------------------------------------------------------------");

                                                        rs = st.executeQuery(queryCheck);
                                                        while (rs.next()) {
                                                                id = rs.getInt("Cosmetic_id");
                                                                name = rs.getString("Cosmetic_name");
                                                                brand = rs.getString("Cosmetic_brand");
                                                                availability = rs.getInt("Cosmetic_availability");
                                                                price = rs.getDouble("Cosmetic_price");
                                                                numleft = rs.getInt("Cosmetic_left");
                                                                System.out.println(
                                                                                id + "\t\t" + name + "\t\t" + brand
                                                                                                + "\t\t"
                                                                                                + availability + "\t\t"
                                                                                                + price
                                                                                                + "\t\t" + numleft);
                                                        }

                                                        System.out.println(
                                                                        "--------------------------------------------------------------------------------------------------------");
                                                }
                                                break;

                                        case 4:
                                                // Buy the Cosmetics.
                                                System.out.print(
                                                                "\nEnter the Cosmetic ID you want to Buy from the availability list: ");
                                                int product_id = input.nextInt();
                                                System.out.print(
                                                                "Enter the how many products of this you want to Buy: ");
                                                int product_nums = input.nextInt();

                                                String queryChoose = "SELECT * from Cosmetics where Cosmetic_id = "
                                                                + product_id;
                                                ResultSet res = st.executeQuery(queryChoose);

                                                count = 0;
                                                double finalPrice = 0;

                                                while (res.next()) {
                                                        count = res.getInt(1);
                                                }

                                                if (count == 0) {
                                                        System.out.println("\nNo such Cosmetics Availabile!!!");
                                                        break;
                                                } else {
                                                        res = st.executeQuery(queryChoose);
                                                        while (res.next()) {

                                                                id = res.getInt("Cosmetic_id");
                                                                name = res.getString("Cosmetic_name");
                                                                brand = res.getString("Cosmetic_brand");
                                                                availability = res.getInt("Cosmetic_availability");
                                                                price = res.getDouble("Cosmetic_price");
                                                                numleft = res.getInt("Cosmetic_left");

                                                                if (availability == 1 && numleft > product_nums) {
                                                                        String queryUpdate = "Update Cosmetics set Cosmetic_left = "
                                                                                        + (numleft - product_nums)
                                                                                        + " where Cosmetic_id = "
                                                                                        + product_id;
                                                                        System.out.println("\nThe SQL statement is: "
                                                                                        + queryUpdate + "\n");
                                                                        st.executeUpdate(queryUpdate);

                                                                        res = st.executeQuery(queryChoose);
                                                                        while (res.next()) {
                                                                                numleft = res.getInt("Cosmetic_left");
                                                                        }

                                                                        if (numleft == 0) {
                                                                                String queryUpdateAval = "Update Cosmetics set Cosmetic_availability = "
                                                                                                + 0
                                                                                                + " where Cosmetic_id = "
                                                                                                + product_id;

                                                                                System.out.println(
                                                                                                "The SQL statement is: "
                                                                                                                + queryUpdateAval
                                                                                                                + "\n");
                                                                                st.executeUpdate(queryUpdateAval);

                                                                        }

                                                                        finalPrice = price * product_nums;
                                                                        bill(id, name, brand, price, product_nums,
                                                                                        finalPrice);

                                                                } else {
                                                                        System.out.println("\nSorry, Out of Stock!!!");

                                                                }

                                                        }
                                                }

                                                break;

                                        case 5:
                                                // Exit the Program!
                                                System.out.println(
                                                                "Thanks for using the Coming to Jas Cosmetics!! Hope you liked it:)");
                                                System.exit(1);
                                                break;
                                }

                        } while (!(choice == 5));
                        input.close();

                } catch (Exception ex) {
                        System.out.println("Error: " + ex);
                }
        }
}
