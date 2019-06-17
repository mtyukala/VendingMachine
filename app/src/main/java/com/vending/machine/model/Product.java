package com.vending.machine.model;


/**
 * Class to represent a product in the vending machine
 *
 * @author Mkhululi Tyukala
 */
public class Product extends Model {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
        private Long id;
        private String name;

    private float price;
    private float weight;
    private int items;
    private String pictureURL;

    public Product() {
        name = "";
        price = 0;
        weight = 0;
        items = 0;
        pictureURL = "";
    }

    public Product(Long id,
                   String name,
                   float price, float weight, int items, String pictureURL) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.items = items;
        this.pictureURL = pictureURL != null ? pictureURL : "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "(" + weight + ") x(" + items + ") @ " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product p = (Product) obj;
        return (p.getPrice() == getPrice() && p.getName().equals(getName()) && p.getPictureURL().equals(getPictureURL())
                && p.getWeight() == getWeight());

        // return true;
    }

    @Override
    public int hashCode() {
        int prime = 41;
        int result = 1;

        result = prime * result + (getId().hashCode());
        result = prime * result + Long.valueOf(Double.doubleToLongBits(getPrice())).hashCode();
        result = prime * result + getName().hashCode();
        result = prime * result + Long.valueOf(Double.doubleToLongBits(getWeight())).hashCode();
        //  result = prime * result + getPictureURL().hashCode();

        return result;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURLString) {
        pictureURL = pictureURLString;
    }

}