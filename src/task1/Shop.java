package task1;

import task1.exceptions.StorageException;
import task1.model.Product;
import task1.model.Storage;

import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Product> products;

    public static Storage storage;

    public static void main(String[] args) {
        storage = new Storage();
        Scanner sc= new Scanner(System.in);
        System.out.println("оберіть одну з функцій: ");
        System.out.println("внести товар(1)");

        System.out.println("купти товар(2)");
        System.out.println("введіть значення: ");
        String tryOne = sc.nextLine();
        if (tryOne.equals("1")) {
            System.out.println("введіть назву товару: ");
            String nameProduct = sc.nextLine();
            System.out.println("введіть ціну товару: ");
            String priceProduct = sc.nextLine();


            try {
                storage.addProduct(new Product(nameProduct, priceProduct));
            } catch (StorageException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Продовжити і ввсети ще +1 товар(1) ");
            System.out.println("Завершити(2): ");
            String tryTwo = sc.nextLine();
            if (tryTwo.equals("1")) {
                System.out.println("введіть назву товару: ");
                String nameProduct1 = sc.nextLine();
                System.out.println("введіть ціну товару: ");
                String priceProduct1 = sc.nextLine();
                try {
                    storage.addProduct(new Product(nameProduct1, priceProduct1));
                } catch (StorageException e) {
                    System.out.println(e.getMessage());
                }
            } else if (tryTwo.equals("2")) {
                System.out.println("STOP");
            } else {
                System.out.println("ERROR");
            }
            System.out.println("Продовжити і ввсети ще +1 товар(1) ");
            System.out.println("Завершити(2): ");
            String tryThree = sc.nextLine();
            if(tryThree.equals("1")) {
                System.out.println("введіть назву товару: ");
                String nameProduct2 = sc.nextLine();
                System.out.println("введіть ціну товару: ");
                String priceProduct2 = sc.nextLine();
                try {
                    storage.addProduct(new Product(nameProduct2, priceProduct2));
                } catch (StorageException e) {
                    System.out.println(e.getMessage());
                }
            } else if (tryThree.equals("2")) {
                System.out.println("STOP");
            } else {
                System.out.println("ERROR");
            }
            System.out.println("Продовжити і ввсети ще +1 товар(1) ");
            System.out.println("Завершити(2): ");
            String tryFour = sc.nextLine();
            if (tryFour.equals("1")) {
                System.out.println("введіть назву товару: ");
                String nameProduct3 = sc.nextLine();
                System.out.println("введіть ціну товару: ");
                String priceProduct3 = sc.nextLine();
                try {
                    storage.addProduct(new Product(nameProduct3, priceProduct3));
                } catch (StorageException e) {
                    System.out.println(e.getMessage());
                }
            } else if (tryFour.equals("2")) {
                System.out.println("STOP");
            } else {
                System.out.println("ERROR");
            }
            }

        storage.showAllProducts();
    }



}
