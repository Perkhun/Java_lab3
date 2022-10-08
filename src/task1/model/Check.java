package task1.model;

import java.util.ArrayList;


public class Check {
    private String name;
    private ArrayList<Product> listProducts = new ArrayList<>();

    public Check(String name, ArrayList<Product> listProducts, double price, int id) {
        this.name = name;
        this.listProducts = listProducts;
        this.price = price;
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
    public double totalPrice(double price) {
       //TODO логіка підрахунку суми
       return 0;
    }

}
