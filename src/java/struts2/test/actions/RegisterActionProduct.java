/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.actions;

import com.opensymphony.xwork2.ActionSupport;
import struts2.test.dao.Products;
/**
 *
 * @author PRITI
 */
public class RegisterActionProduct extends ActionSupport {
    private int productId;
    private String productName;
    private Double price;
    private int availability;
    
    private String msg = "";
    private Products products = null;
    private int ctr = 0;
    
    @Override
    public String execute() throws Exception {
        setProducts(new Products());

        try {
            setCtr(getProducts().addProduct(getProductId(), getProductName(), getPrice(), getAvailability()));
            if (getCtr() > 0) {
                setMsg("Product Added Successfull");
            } else {
                setMsg("Some Error occured!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REGISTER";
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the products
     */
    public Products getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Products products) {
        this.products = products;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }
    
}
