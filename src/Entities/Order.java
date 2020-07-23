package Entities;

import Entities.Enum.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

    /*
     * An order has multiple OrderItems
     * */
    private final List<OrderItem> items = new ArrayList<>();
    private Date moment;
    private OrderStatus status;
    /*
     * An order has one client
     * */
    private Client client;

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addOrderItems(OrderItem orderItems) {
        this.items.add(orderItems);
    }

    public void removeOrderItems(OrderItem orderItems) {
        this.items.remove(orderItems);
    }

    public Double getTotal() {
        double total = 0;

        for (OrderItem item :
                items) {
            total += item.subTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order moment: ").append(simpleDateFormat.format(moment));
        stringBuilder.append("\nOrder status: ").append(status);
        stringBuilder.append("\n").append(client).append("\n");

        stringBuilder.append("Order items:\n");
        for (OrderItem item : items) {
            stringBuilder.append(item).append("\n");
        }

        stringBuilder.append("Total price: $").append(getTotal());

        return stringBuilder.toString();
    }
}

