import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Geronimo Stilton", "Books", 150.00));
        products.add(new Product(2, "Biberon", "Baby", 15.00));
        products.add(new Product(3, "iPhone 16", "Electronics", 1000.00));
        products.add(new Product(4, "Hotwheels", "Boys", 10.00));
        products.add(new Product(6, "Tea Stilton", "Books", 30.00));

        Customer customer1 = new Customer(1, "Mario Bros", 1);
        Customer customer2 = new Customer(2, "Luigi Bros", 2);

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Spedito", LocalDate.now().minusDays(2), LocalDate.now(), List.of(products.get(1)), customer1));



        List<Product> expensiveBooks = products.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100)
                .toList();


        System.out.println("Prodotti nella categoria Books con prezzo > 100:");
        expensiveBooks.forEach(product -> System.out.println(product));


        List<Order> ordersWithBabyProducts = orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Baby")))
                .toList();


        System.out.println("Ordini contenenti prodotti nella categoria Baby:");
        ordersWithBabyProducts.forEach(order -> System.out.println(order));


        List<Product> BoysProducts = products.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {
            product.setPrice(product.getPrice() * 0.90);
            return product;})
                .toList();

        System.out.println("Prodotti nella categoria Boys:");
        BoysProducts.forEach(product -> System.out.println(product));
    }

}
