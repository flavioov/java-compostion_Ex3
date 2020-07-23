import Entities.Client;
import Entities.Enum.OrderStatus;
import Entities.Order;
import Entities.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = input.next();

        System.out.print("\nEmail: ");
        String clientEmail = input.next();

        System.out.print("\nBirth date (DD/MM/YYYY): ");
        Date clientBirthDate = simpleDateFormat.parse(input.next());

        Client client = new Client(
                clientName,
                clientEmail,
                clientBirthDate
                );

        System.out.println("Enter order data: ");


        Order order1 = new Order(
                new Date(),
                OrderStatus.PROCESSING,
                client
        );

        System.out.print("How many items to this order? ");
        int numberOfItems = input.nextInt();

        for (int i = 0; i < numberOfItems; i++) {
            System.out.printf("Enter #%d item data:%n", i + 1);

            Integer quantity;

            System.out.print("\nProduct Name: ");
            String productName = input.next();

            System.out.print("\nProduct Price: ");
            Double productPrice = input.nextDouble();

            Product product = new Product(
                    productName,
                    productPrice
            );

            order1.addOrderItems();
        }



    }
}
