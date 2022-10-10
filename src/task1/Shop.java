package task1;

import task1.exceptions.StorageException;
import task1.model.Check;
import task1.model.Customer;
import task1.model.Product;
import task1.model.Seller;
import task1.service.Storage;
import java.time.LocalDate;
import java.util.Scanner;

public class Shop {
    public final static Storage storage = new Storage();
    public static Customer customer;
    public static Seller seller = new Seller();
    public final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        storage.addDefaultProduct();

        initUser();
    }

    private static void initUser() {
        System.out.println("------------------------------");
        System.out.println("Введіть імя користувача: ");
        String nameUser = sc.nextLine();
        customer = new Customer(nameUser);

        showOptionsStorage();
    }

    private static void showOptionsStorage() {
        System.out.println("------------------------------");
        System.out.println("Оберіть одну з функцій: ");
        System.out.println("(1)Внести товар"); 
        System.out.println("(2)Магазин");
        System.out.println("(3)Користувач");
        System.out.println("(4)Напопулярніший  продукт");
        System.out.println("(5)Найбільший дохід за день");
        System.out.println("(6)Видача чека");
        System.out.println("Введіть значення: ");
        String input = sc.nextLine();

        switch (input) {
            case "1":
                addProduct();
                break;
            case "2":
                showOptionsShop();
                break;
            case "3":
                showOptionsUser();
                break;
            case "4":
                seller.showMostPopularProduct();
                break;
            case "5":
                seller.showMostGreatestPriceProduct();
                break;
            case "6":
                giveCheck();
                break;
            default:
                System.out.println("Out of number");
                showOptionsStorage();
        }
    }

    private static void showOptionsShop() {
        System.out.println("------------------------------");
        System.out.println("Оберіть одну з функцій: ");
        System.out.println("(1)Купити товар");
        System.out.println("(2)Фільтрування продуктів від 7");
        System.out.println("(3)Сортування продуктів по ціні");
        System.out.println("(4)Визначення середньої ціни продуктів");
        System.out.println("(5)Показати всі товари з магазину");
        System.out.println("(6)НАЗАД");
        System.out.println("Введіть значення: ");
        String input = sc.nextLine();

        switch (input) {
            case "1":
                buyProduct();
                break;
            case "2":
                storage.filterByPriceList();
                showOptionsShop();
                break;
            case "3":
                storage.sortedByPriceList();
                showOptionsShop();
                break;
            case "4":
                storage.middlePriceList();
                showOptionsShop();
                break;
            case "5":
                storage.showAllProducts();
                showOptionsShop();
                break;
            case "6":
                showOptionsStorage();
                break;
            default:
                System.out.println("Out of number");
                showOptionsShop();
        }
    }

    private static void showOptionsUser() {
        System.out.println("------------------------------");
        System.out.println("Оберіть одну з функцій: ");
        System.out.println("(1)Показати всі витрати користувача за певний період часу");
        System.out.println("(2)Показати сумарну кількість кожного купленого продукта");
        System.out.println("(3)НАЗАД");
        System.out.println("Введіть значення: ");
        String input = sc.nextLine();

        switch (input) {
            case "1":
                putTime();
                break;
            case "2":
                customer.showAllProducts();
                break;
            case "3":
                showOptionsStorage();
                break;
            default:
                System.out.println("Out of number");
                showOptionsUser();
        }
    }

    private static void addProduct() {
        System.out.println("Введіть назву товару: ");
        String nameProduct = sc.nextLine();
        if (nameProduct.isEmpty()) {
            System.out.println("ERROR : Назва товару пуста");
        }
        System.out.println("Введіть ціну товару: ");
        String priceProduct = sc.nextLine();

        if (priceProduct.isEmpty() || Double.parseDouble(priceProduct) < 0.0) {
            System.out.println("ERROR : Назва відсутня або число відємне");
        }

        try {
            if (!nameProduct.isEmpty() && !priceProduct.isEmpty() && Double.parseDouble(priceProduct) > 0.0) {
                storage.addProduct(new Product(nameProduct, priceProduct));
            }
        } catch (StorageException e) {
            System.out.println(e.getMessage());
        }

        showOptionsStorage();
    }

    private static void buyProduct() {
        storage.showAllProducts();

        System.out.println("Введіть номер товару :");
        String productPosition = sc.nextLine();

        Product product = storage.getProductByPosition(productPosition);

        LocalDate dtNow = LocalDate.now(); // format 2022-09-10 yyyy-mm-dd

        product.setLocalDate(dtNow);
        customer.setProductsToList(product);
        product.setNameOfCustomer(customer.getNameOfCustomer());
        seller.setPurchasedProduct(product);

        showOptionsShop();
    }

    private static void giveCheck() {
        Check check = new Check(1, customer.getNameOfCustomer(), customer.getListProducts());
        check.showAllCheck();
    }

    private static void putTime() {
        System.out.println("Введіть 2 часу у форматі yyyy-mm-dd: ");
        System.out.println("1 : ");
        String dateFirst = sc.nextLine();
        System.out.println("2 : ");
        String dateSecond = sc.nextLine();
        customer.getAllCostsByTime(dateFirst, dateSecond);
    }

}
