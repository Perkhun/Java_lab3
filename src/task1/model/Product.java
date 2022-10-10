package task1.model;

import java.time.LocalDate;


public class Product {

    private int id;
    private double priceOfProduct;
    private String nameOfProduct;
    private String nameOfCustomer;
    private int count;
    private LocalDate localDate;


    public Product(String nameProduct, String priceProduct) {
        this.nameOfProduct = nameProduct;
        this.priceOfProduct = Double.parseDouble(priceProduct);
    }

    public Product(int id,String nameProduct, String priceProduct) {
        this.id = id;
        this.nameOfProduct = nameProduct;
        this.priceOfProduct = Double.parseDouble(priceProduct);
    }

    public Product(int id,String nameProduct, String priceProduct, LocalDate localDate) {
        this.id = id;
        this.nameOfProduct = nameProduct;
        this.priceOfProduct = Double.parseDouble(priceProduct);
        this.localDate = localDate;
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

    public Product() {
        super();
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public  int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
