package com.fang.demo.model;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 用于测试验证器
 */
public class Product {

    @Size(min = 6, max = 20)
    private String name;

    private String description;

    private float price;
    @Past
    private Date productionDate;


    public Product(String name, String description, float price, Date productionDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productionDate = productionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Product() {
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productionDate=" + productionDate +
                '}';
    }
}
