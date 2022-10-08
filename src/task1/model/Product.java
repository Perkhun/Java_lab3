package task1.model;

import java.util.Map;

public class Product {
    //private String nameOfProduct;
    //private Map<String, Integer> mapNameProductPrice;
    private double priceOfProduct;
    private int id;


    private String nameOfProduct;

    public Product(String nameProduct, String priceProduct) {
        this.nameOfProduct = nameProduct;
        this.priceOfProduct = Double.parseDouble(priceProduct);
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product() {  //конструктор /стук до головногто класу
        super();  //
    }

    public Product(String nameOfProduct, double priceOfProduct, int id) {
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.id = id;
    }




}
