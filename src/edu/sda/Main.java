package edu.sda;

import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Main {

    public static void main(String args[]) {

        BarService barService = new BarService();
        barService.initBars();

        System.out.println("To see the name of all bars, type 1");
        System.out.println("To sort bars based on highest protein content, type 2 ");
        System.out.println("To sort bars based on highest fat content, type 3");
        System.out.println("To filter bars which has less than X fiber and sort them from highest to lowest, type 4 and X");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String command = null;
        String inputX = null;

        Scanner tokenizer = new Scanner(input);
        if (tokenizer.hasNext()) {
            command = tokenizer.next();
            if (tokenizer.hasNext()) {
                inputX = (String) tokenizer.next();
            }
        }

        if (command.equals("1")) {
            barService.fetchNames();
        } else if (command.equals("2")) {
            barService.sortByHighProtein();
        } else if (command.equals("3")) {
            barService.sortByHighFett();
        } else if (command.equals("4")) {
            barService.filterByLowFiberSort(parseDouble(inputX));
        }
    }
}
