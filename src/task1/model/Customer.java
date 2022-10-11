package task1.model;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Product> listProducts = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setProductsToList(Product product) {
        if (!listProducts.isEmpty()) {
            for (Product productFromList : listProducts) {
                if (productFromList.getName().equals(product.getName())) {
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
            System.out.println("PRODUCT:  ("+ product.getId()+")" + " name: " + product.getName() + " price: " + product.getPrice() + " count: " + product.getCount());
        }
    }

    public void getAllCostsByTime(String localDate1, String localDate2) {
        long mils1 = convertToMilliseconds(localDate1);
        long mils2 = convertToMilliseconds(localDate2);

        List<Product> listProductsAtTime = new ArrayList<>();

        if (!listProducts.isEmpty()) {
            for (Product product : listProducts){
                long milsProduct = product.getLocalDate().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();

                if (milsProduct > mils1 && milsProduct < mils2){
                    listProductsAtTime.add(product);
                }
            }

            for (Product product : listProductsAtTime) {
                System.out.println("PRODUCT:  ("+ product.getId()+")" + " name: " + product.getName() + " price: " + product.getPrice() + " count: " + product.getCount() + " date: " + product.getLocalDate() );
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
