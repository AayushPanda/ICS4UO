package QuickEasyLoans;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int ADD_PURCHASE = 1;
    private static final int CLEAR_PURCHASE = 2;
    private static final int ADVANCE_DAYS = 3;
    private static final int VIEW_OWING = 4;
    private static final int EXIT = 5;

    public static void main(String[] args) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        Client client = new Client(firstName, lastName, firstName + lastName);

        boolean run = true;
        while (run) {
            printMenu();
            int choice = getChoice();

            try {
                switch (choice) {
                    case ADD_PURCHASE:
                        handleAddPurchase(client);
                        break;

                    case CLEAR_PURCHASE:
                        handleClearPurchase(client);
                        break;

                    case ADVANCE_DAYS:
                        handleAdvanceDays(client);
                        break;

                    case VIEW_OWING:
                        handleViewOwing(client);
                        break;

                    case EXIT:
                        run = false;
                        System.out.println("The next time I see ya you better have my money...");
                        break;

                    default:
                        System.out.println("Invalid choice\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input or parsing error\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("");
        System.out.println("1. Add Purchase");
        System.out.println("2. Clear Purchase");
        System.out.println("3. Advance Days");
        System.out.println("4. View Owing");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice\n");
            printMenu();
            return getChoice();
        }
    }

    private static void handleAddPurchase(Client client) {
        System.out.print("Enter purchase name: ");
        String purchaseName = scanner.nextLine();
        System.out.print("Enter principal: ");
        double principal = Double.parseDouble(scanner.nextLine());

        LocalDate date = LocalDate.now();
        String formattedDate = date.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Enter purchase date, or [N]ow for today's date: ");
        String datetimeChoice = scanner.nextLine();
        String purchaseDate = (datetimeChoice.toLowerCase().equals("n")) ? formattedDate : datetimeChoice;

        client.addPurchase(purchaseName, principal, purchaseDate);
        System.out.println("Purchase added\n");
    }

    private static void handleClearPurchase(Client client) {
        System.out.print("Enter amount being paid: ");
        double amt = Double.parseDouble(scanner.nextLine());

        if (Math.round(amt * 100.0) / 100.0 == amt) {
            if (Math.round(client.getDebt() * 100.0) / 100.0 == amt) {
                client.clearPurchase();
                System.out.println("Purchase cleared\n");
            } else {
                System.out.println("Amount does not match debt\n");
            }
        } else {
            System.out.println("Amount must be in format %.2f\n");
        }
    }

    private static void handleAdvanceDays(Client client) {
        System.out.print("Enter number of days: ");
        int days = Integer.parseInt(scanner.nextLine());
        client.advanceDays(days, 0.20/365);
        System.out.println("Advanced " + days + " days\n");
    }

    private static void handleViewOwing(Client client) {
        try {
            System.out.println(client.getCurrentPurchase().toString());
        } catch (NullPointerException e) {
            System.out.println("No debts... for now\n");
        }
    }
}
