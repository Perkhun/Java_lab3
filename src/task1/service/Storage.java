package task1.service;

import task1.exceptions.StorageException;
import task1.model.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class Storage {
    private static final int FULL_STORAGE = 10;
    private static final int filterCount = 7;
    private ArrayList<Product> listProducts = new ArrayList<>();

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public void addProduct(Product product) throws StorageException {
        if (listProducts.size() <= FULL_STORAGE) {
            product.setId(listProducts.size() + 1);
            listProducts.add(product);
        } else {
            throw new StorageException("Склад переповнений");
        }
    }

    public void addDefaultProduct() {
        listProducts.add(new Product(1, "Молоко", "10"));
        listProducts.add(new Product(2, "Хліб", "8"));
        listProducts.add(new Product(3, "Морозиво", "15"));
        listProducts.add(new Product(4, "Вода", "11"));
        listProducts.add(new Product(5, "Сіль", "4"));
        listProducts.add(new Product(6, "Цукор", "5"));
    }

    public void showAllProducts() {
        for (Product product : getListProducts()) {
            System.out.println("PRODUCT:  (" + product.getId() + ")" + " name: " + product.getName() + " price: " + product.getName());
        }
    }

    public Product getProductByPosition(String position) {
        return listProducts.get(Integer.parseInt(position) - 1);
    }

    public void filterByPriceList() {
        if (!listProducts.isEmpty()) {
            listProducts.stream().filter(x -> x.getPrice() >= filterCount).forEach(x -> System.out.println("name = " + x.getName() + " price = " + x.getPrice()));
        } else {
            System.out.println("Список пустий");
        }
    }

    public void sortedByPriceList() {
        if (!listProducts.isEmpty()) {
            listProducts.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(x -> System.out.println("name = " + x.getName() + " price = " + x.getPrice()));
        } else {
            System.out.println("Список пустий");
        }
    }

    public void middlePriceList() throws StorageException {
        if (!listProducts.isEmpty()) {
            listProducts.stream().mapToDouble(Product::getPrice).average().orElseThrow(() -> new StorageException("Помилка визначення"));
        }
    }

}
