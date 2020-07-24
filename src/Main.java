import Entities.Client;
import Entities.Enum.OrderStatus;
import Entities.Order;
import Entities.OrderItem;
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
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = input.nextLine();

        System.out.print("Email: ");
        String clientEmail = input.next();

        input.nextLine();itory

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirthDate = simpleDateFormat.parse(input.next());

        Client client = new Client(
                clientName,
                clientEmail,
                clientBirthDate
        );

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(input.next());

        Order order1 = new Order(
                new Date(),
                OrderStatus.PROCESSING,
                client
        );

        System.out.print("How many items to this order? ");
        int numberOfItems = input.nextInt();

        for (int i = 0; i < numberOfItems; i++) {
            System.out.printf("Enter #%d item data:%n", i + 1);

            System.out.print("Product Name: ");
            String productName = input.next();

            System.out.print("Product Price: ");
            Double productPrice = input.nextDouble();

            Product product = new Product(
                    productName,
                    productPrice
            );

            System.out.print("Quantity: ");
            Integer quantity = input.nextInt();
            input.nextLine();

            OrderItem orderItem = new OrderItem(
                    quantity,
                    product.getPrice(),
                    product
            );

            order1.addOrderItems(orderItem);
        }

        System.out.println("\nORDER SUMMARY:");
        System.out.println(order1);

    }
}
