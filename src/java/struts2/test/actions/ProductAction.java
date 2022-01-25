/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.actions;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import struts2.test.beans.Product;
import struts2.test.dao.Products;

public class ProductAction extends ActionSupport{
    private int productId;
    private String productName;
    private Double price;
    private int availability;
    
    private String msg = "";
    private Products products = null;
    private int ctr = 0;
    
    private ResultSet rs = null;
    private Product product = null;
    private List<Product> productList = null;
    Products dao = new Products();
    private boolean noData = false;
    private String submitType;
    
    public String executeProduct() throws Exception {
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
    
    public String reportProduct() throws Exception {
        try {
            setProductList(new ArrayList<>());
            setProductList(dao.report());
            

            if (!productList.isEmpty() ) {
                setNoData(false);
                System.out.println("Users retrieve = "+getProductList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORT";
    }

    public String updateProduct() throws Exception {
        Products product1 = new Products();
        try {
            if (getSubmitType().equals("updatedata")) {
                Product pro = product1.fetchProductDetails(productId);
                if (pro!= null) {
                    productId = pro.getProductId();
                    productName = pro.getProductName();
                    price = pro.getPrice();
                    availability = pro.getAvailability();
                    
                }
            } else {
                int i = product1.updateProductDetails(productId, productName,
                        price, availability);
                if (i > 0) {
                    msg = "Record Updated Successfuly!!!!";
                } else {
                    msg = "Error!!!!";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATE";
    }
    
    public String deleteProduct() throws Exception {
        try {
            int isDeleted = dao.deleteProductDetails(productId);
            if (isDeleted > 0) {
                msg = "Record deleted successfully";
            } else {
                msg = "Some error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETE";
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

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
    
    
    
}
