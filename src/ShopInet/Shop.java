package ShopInet;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

    public Shop() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // Добавление покупателя в магазин
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Добавление товара в магазин
    public void addProduct(Product product) {
        products.add(product);
    }

    // Создание заказа и добавление его в магазин
    public void makePurchase(Customer customer, Product product, int quantity) throws CustomerException, ProductException, AmountException{
        if (!customers.contains(customer)) {
            throw new CustomerException("Invalid customer: ");
        }

        if (!products.contains(product)) {
            throw new ProductException("Invalid product: " + product.getName());
        }

        if (quantity <= 0 || quantity > 100) {
            throw new AmountException("Invalid quantity: " + quantity);
        }



        Order order = new Order(customer, product, quantity);
        orders.add(order);
    }

    // Вывод информации о каждом заказе
    public void printOrders() {
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            Product product = order.getProduct();
            int quantity = order.getQuantity();
            double totalPrice = order.getTotalPrice();


            System.out.println("Order Information:");

            System.out.println("Product: " + product.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: $" + totalPrice);

            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();

        // Добавление покупателей
        Customer customer1 = new Customer("John ", "Smith", 123456789);
        Customer customer2 = new Customer("Alice Johnson", "Johnson", 987654321);
        shop.addCustomer(customer1);
        shop.addCustomer(customer2);

        // Добавление товаров
        Product product1 = new Product("Item 1", 10);
        Product product2 = new Product("Item 2", 20);
        Product product3 = new Product("Item 3", 15);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        try {
            // Совершение покупок
            shop.makePurchase(customer1, product1, 2);
            shop.makePurchase(customer2, product2, 1);
            shop.makePurchase(customer1, product3, 3);
        } catch (CustomerException | ProductException | AmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Вывод информации о заказах
        shop.printOrders();
    }
}
