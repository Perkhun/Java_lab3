package task1.model;

import task1.exceptions.StorageException;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Product> listProducts = new ArrayList<>();

    public Storage(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public Storage() {
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public void addProduct(Product product) throws StorageException {
        if (listProducts.size() <= 2) {
            listProducts.add(product);
        } else {
            throw new StorageException("склад переповнений");
        }


    }
    public void showAllProducts() {
        for (Product product : getListProducts()) {
            System.out.println("PRODUCT: name: " + product.getNameOfProduct() + " price: " + product.getPriceOfProduct());
        }

    }

}
