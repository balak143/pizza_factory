//This program allows the user to order a createPizza

import java.util.Scanner;
//TASK #5 add an import statement to use the DecimalFormat class
import java.text.DecimalFormat;

public class TerminalPizzaOrderApplication
{/*
    public static void main (String [] args)
    {
        //TASK #5 Create a DecimalFormat object with 2 decimal places
        DecimalFormat money = new DecimalFormat ("#0.00");
        //Create a Scanner object to read input
        Scanner keyboard = new Scanner (System.in);

        //Create an instance of a Pizza
        Pizza order = new Pizza ();

        String firstName;		//user's first name
        boolean discount = false;//flag, true if user is eligible for discount
        int inches;				//size of the createPizza
        char crustType;			//type of crust
        double cost;			//cost of the createPizza
        final double TAX_RATE = .08;//sales tax rate
        double tax;				//amount of tax
        char choice;			//user's choice
        String input;			//user input
        String toppings = "Cheese ";//list of toppings
        int numberOfToppings = 0;	//number of toppings

        //prompt user and get first name
        System.out.println("Welcome to Mike and Diane's Pizza");
        System.out.print("Enter your first name:  ");
        firstName = keyboard.nextLine();

        //determine if user is eligible for discount by
        //having the same first name as one of the owners
        //ADD LINES HERE FOR TASK #1
        if (firstName.equalsIgnoreCase("Mike") || firstName.equalsIgnoreCase("Dianes"))
            discount= true;


        //prompt user and get createPizza size choice
        System.out.println("Pizza Size (inches)   Cost");
        System.out.println("        10            $10.99");
        System.out.println("        12            $12.99");
        System.out.println("        14            $14.99");
        System.out.println("        16            $16.99");
        System.out.println("What size createPizza would you like?");
        System.out.print("10, 12, 14, or 16 (enter the number only): ");
        inches = keyboard.nextInt();

        //set price and size of createPizza ordered
        //ADD LINES HER FOR TASK #2
        if (inches == 10)
        {
            order.ofSize(10);
            order.setCost(-2);
        }
        else if (inches ==12)
        {
            order.ofSize(12);
            order.setCost(0);
        }
        else if (inches == 14)
        {
            order.ofSize(14);
            order.setCost(2);
        }
        else if (inches == 16)
        {
            order.ofSize(16);
            order.setCost(4);
        }
        else
        {
            System.out.print("User input was not one of the choices, so a 12 inch createPizza will be made");
            order.ofSize(12);
            order.setCost(0);
        }
        //consume the remaining newline character
        keyboard.nextLine();

        //prompt user and get crust choice
        System.out.println("What type of crust do you want? ");
        System.out.print("(H)Hand-tossed, (T) Thin-crust, or " +
                "(D) Deep-dish (enter H, T, or D): ");
        input = keyboard.nextLine();
        crustType = input.charAt(0);

        //set user's crust choice on createPizza ordered
        //ADD LINES FOR TASK #3
        switch(crustType)
        {
            case 'H':
            case 'h':
                order.withCrust("Hand-Tossed");
                break;
            case 'T':
            case 't':
                order.withCrust("Thin-CRUST");
                break;
            case 'D':
            case 'd':
                order.withCrust("Deep Dish");
                break;
            default:
                System.out.print("User's input not one of the choices, so a hand tossed crust will be made");
                order.withCrust("Deep Dish");
        }

        //prompt user and get topping choices one at a time
        System.out.println("All pizzas come with cheese.");
        System.out.println("Additional toppings are $1.25 each,"
                + " choose from");
        System.out.println("Pepperoni, Sausage, Onion, Mushroom");

        //if topping is desired,
        //add to topping list and number of toppings
        System.out.print("Do you want Pepperoni?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y')
        {
            numberOfToppings += 1;
            toppings = toppings + "Pepperoni ";
        }
        System.out.print("Do you want Sausage?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y')
        {
            numberOfToppings += 1;
            toppings = toppings + "Sausage ";
        }
        System.out.print("Do you want Onion?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y')
        {
            numberOfToppings += 1;
            toppings = toppings + "Onion ";
        }
        System.out.print("Do you want Mushroom?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y')
        {
            numberOfToppings += 1;
            toppings = toppings + "Mushroom ";
        }

        //set number of toppings and topping list on createPizza ordered
        order.setNumToppings (numberOfToppings);
        order.setToppingList(toppings);

        //add additional toppings cost to cost of createPizza
        order.setCost(1.25*numberOfToppings);

        //display order confirmation
        System.out.println();
        System.out.println("Your order is as follows: ");
        System.out.println(order.getSize() + " inch createPizza");
        System.out.println(order.getCrustModel() + " crust");
        System.out.println(order.getToppingList());



        //apply discount if user is elibible
        //ADD LINES FOR TASK #4 HERE
        if (discount==true)
        {
            System.out.print("User is eligable for a $2.00 discount. ");
            order.setCost(-2);
        }

        //EDIT PROGRAM FOR TASK #5
        //SO ALL MONEY OUTPUT APPEARS WITH 2 DECIMAL PLACES
        //display cost of createPizza
        cost = order.getCost();
        System.out.println("The cost of your order is: $" + money.format(cost));

        //calculate and display tax and total cost
        tax = cost * TAX_RATE;
        System.out.println("The tax is:  $" + money.format(tax));
        System.out.println("The total due is:  $" + money.format(tax + cost));

        System.out.println("Your order will be ready" +
                " for pickup in 30 minutes.");
    }*/
}