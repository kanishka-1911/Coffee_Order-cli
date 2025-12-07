import java.util.ArrayList;
import java.util.Scanner;

public class OrderingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] availCoffee = { "Latte", "Mocha", "Espresso", "Iced_coffee", "Americano", "Decaf" };
        ArrayList<String> yourOrders = new ArrayList<>();
        float bill = 0;

        System.out.println("\nHello! Here's today's menu");
        for (int i = 0; i < availCoffee.length; i++) {
            System.out.println((i + 1) + " : " + availCoffee[i]);
        }

        boolean continueOrder = true;
        while (continueOrder) {
            System.out.print("\nDo you want to add a coffee to your order? (yes/no)");
            String consent = sc.nextLine().toLowerCase();

            if (consent.equalsIgnoreCase("yes")) {

                boolean validSelect = false;
                while (!validSelect) {
                    System.out.print("Select a coffee number from the listed : ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Enter a valid number!");
                        sc.next(); 
                        continue;
                    }


                    int selected = sc.nextInt();
                    sc.nextLine();

                    if (selected >= 1 && selected <= availCoffee.length) {
                        yourOrders.add(availCoffee[selected - 1]);
                        System.out.println("Adding " + availCoffee[selected - 1] + " to your order");

                        bill += 120;
                        validSelect=true;

                    } else {
                        System.out.println("Select a valid number from the menu");
                    }
                 
                }
            } else
                continueOrder = false;
        }
        System.out.println("\nYou're done with your orders");
        System.out.println("Your orders: "+yourOrders);
        System.out.println("Your bill : ₹ " + bill);

        boolean valid_tip = false;
        while (!valid_tip) {
            System.out.print("\nWhat tip do you want to leave(0-25%)?");

            if (!sc.hasNextFloat()) {
                System.out.println("Enter a valid percentage!");
                sc.next();
                continue;
            }

            float tip = sc.nextFloat();
            if (tip >= 0 && tip <= 25) {
                bill += (bill * tip / 100);
                valid_tip = true;
            } else
                System.out.println("Enter a valid tip");
        }


        System.out.println("Thank you! The final bill is ₹" + bill + " . Enjoy your coffee!");
        sc.close();
    }
}
