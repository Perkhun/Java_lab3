package task1.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Seller {
    private String nameOfSeller;
    private ArrayList<Product> listProducts = new ArrayList<>();


    public String getNameOfSeller() {
        return nameOfSeller;
    }

    public void setNameOfSeller(String nameOfSeller) {
        this.nameOfSeller = nameOfSeller;
    }
    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setPurchasedProduct(Product product) {
        listProducts.add(product);
    }

    public void showAllProducts() {
        for (Product product : getListProducts()) {
            System.out.println("PRODUCT:  (" + product.getId() + ")" + " name: " + product.getNameOfProduct() + " price: " + product.getPriceOfProduct() + " customer: " + product.getNameOfCustomer());
        }
    }

    public void showMostPopularProduct() {
        if (!listProducts.isEmpty()){
            Product product = listProducts.stream().max(Comparator.comparing(Product::getCount)).orElseThrow(NoSuchElementException::new);
            System.out.println("Популярний продукт це : "+ product.getNameOfProduct() + " count : " + product.getCount());
        }else{
            System.out.println("Популярного продукту немає");
        }
    }

    public void showMostGreatestPriceProduct() {
        if (!listProducts.isEmpty()){
            Product mostGreatestProduct = null;
            double mostGreatestProductPrice = 0;

            for(Product product : listProducts){
                double price = product.getPriceOfProduct() * product.getCount();
                if (price > mostGreatestProductPrice){
                    mostGreatestProductPrice = price;
                    mostGreatestProduct = product;
                }
            }
            System.out.println("Продукт з найбільшим доходом це : "+ mostGreatestProduct.getNameOfProduct() + " price : " + mostGreatestProduct.getPriceOfProduct());
        }else{
            System.out.println("Список пустий");
        }
    }
}
