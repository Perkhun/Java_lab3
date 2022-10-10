package task1.model;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;

public class Customer {
    private String nameOfCustomer;
    private ArrayList<Product> listProducts = new ArrayList<>();


    public Customer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setProductsToList(Product product) {
        if (!listProducts.isEmpty()) {
            for (Product productFromList : listProducts) {
                if (productFromList.getNameOfProduct().equals(product.getNameOfProduct())) {
                    productFromList.setCount(productFromList.getCount() + 1);
                    return;
                }
            }
        }
        product.setCount(1);
        listProducts.add(product);
    }

    public void showAllProducts() {
        for (Product product : getListProducts()) {
            System.out.println("PRODUCT:  ("+ product.getId()+")" + " name: " + product.getNameOfProduct() + " price: " + product.getPriceOfProduct() + " count: " + product.getCount());
        }
    }

    public void getAllCostsByTime(String localDate1, String localDate2) {
        long mils1 = convertToMilliseconds(localDate1);
        long mils2 = convertToMilliseconds(localDate2);

        ArrayList<Product> listProductsAtTime = new ArrayList<>();

        if (!listProducts.isEmpty()) {
            for (Product product : listProducts){
                long milsProduct = product.getLocalDate().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();

                if (milsProduct > mils1 && milsProduct < mils2){
                    listProductsAtTime.add(product);
                }
            }

            for (Product product : listProductsAtTime) {
                System.out.println("PRODUCT:  ("+ product.getId()+")" + " name: " + product.getNameOfProduct() + " price: " + product.getPriceOfProduct() + " count: " + product.getCount() + " date: " + product.getLocalDate() );
            }

        }else{
            System.out.println("Список пустий");
        }
    }

    public long convertToMilliseconds(String localDate1){
        LocalDate data1 = LocalDate.parse(localDate1);
        return data1.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
    }


}
