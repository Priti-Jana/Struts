/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import struts2.test.beans.Product;
import struts2.test.core.ConnectionManager;
public class Products {
    
    public int addProduct(int productId, String productName, Double price,
            int availability) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO products VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setString(2, productName);
            ps.setDouble(3, price);
            ps.setInt(4, availability);
            ps.setInt(5, 1);
            System.out.println("SQL for insert="+ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        
    }
    
    public List report() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT productId, productName, price, availability FROM products;";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailability(rs.getInt("availability"));
                

                productList.add(product);
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    public Product fetchProductDetails(int productId) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        Product product = new Product();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT products.productId,\n"
                    + "    products.productName,\n"
                    + "    products.price,\n"
                    + "    products.availability\n"
                    + "FROM orderinventories.products where productId=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("productId = " + productId);
            ps.setInt(1, productId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailability(rs.getInt("availability"));

                
            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    public int updateProductDetails(int productId, String productName, double price, 
            int availability) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE orderinventories.products\n"
                    + "SET\n"
                    + "productName = ?,\n"
                    + "price = ?,\n"
                    + "availability = ?\n"
                    + "WHERE productId = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, productName);
            ps.setDouble(2, price);
            ps.setInt(3, availability);
            
            ps.setInt(4, productId);
            
            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
        public int deleteProductDetails(int productId) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE products SET status = 0 WHERE productId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    }
