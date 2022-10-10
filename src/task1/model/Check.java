package task1.model;

import java.util.ArrayList;


public class Check {
    private int id;
    private String nameCustomer;
    private ArrayList<Product> listProducts = new ArrayList<>();

    public Check(int id, String nameCustomer, ArrayList<Product> listProducts) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.listProducts = listProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nameCustomer;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void showAllCheck() {
        System.out.println("------------------------");
        System.out.println("Назва користувача - " + getName());

        double totalPrice = 0;
        for (Product product : getListProducts()) {
            System.out.println("PRODUCT:  (" + product.getId() + ")" + " name: " + product.getNameOfProduct() + " price: " + product.getPriceOfProduct() + " count: " + product.getCount());
            if (product.getCount() > 0) {
                totalPrice += product.getPriceOfProduct() * product.getCount();
            } else {
                totalPrice += product.getPriceOfProduct();
            }
        }
        System.out.println("Загальна сума = " + totalPrice);
        System.out.println("------------------------");
    }

}
