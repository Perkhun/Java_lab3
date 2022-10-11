package task1.model;

import task1.exceptions.StorageException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Seller {
    private String name;
    private List<Product> listProducts = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setPurchasedProduct(Product product) {
        listProducts.add(product);
    }

    public void showAllProducts() {
        for (Product product : getListProducts()) {
            System.out.println("PRODUCT:  (" + product.getId() + ")" + " name: " + product.getName() + " price: " + product.getPrice() + " customer: " + product.getName());
        }
    }

    public void showMostPopularProduct() throws StorageException {
        if (!listProducts.isEmpty()){
            Product product = listProducts.stream().max(Comparator.comparing(Product::getCount)).orElseThrow(() -> new StorageException("помилка"));
            System.out.println("Популярний продукт це : "+ product.getName() + " count : " + product.getCount());
        }else{
            System.out.println("Популярного продукту немає");
        }
    }

    public void showMostGreatestPriceProduct() {
        if (!listProducts.isEmpty()){
            Product mostGreatestProduct = null;
            double mostGreatestProductPrice = 0;

            for(Product product : listProducts){
                double price = product.getPrice() * product.getCount();
                if (price > mostGreatestProductPrice){
                    mostGreatestProductPrice = price;
                    mostGreatestProduct = product;
                }
            }
            System.out.println("Продукт з найбільшим доходом це : "+ mostGreatestProduct.getName() + " price : " + mostGreatestProduct.getPrice());
        }else{
            System.out.println("Список пустий");
        }
    }
}
