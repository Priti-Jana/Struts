/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.dao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import struts2.test.beans.User;

public class AdminTest {
    
    
    public AdminTest() {
    }

    /**
     * Test of registerUser method, of class Admin.
     */
    @Test
    public void testRegisterUser() throws Exception {
        System.out.println("registerUser");
        String userName = "testUser";
        String password = "test123";
        String firstName = "test";
        String lastName = "user";
        String email = "test@gmail.com";
        String phoneNumber = "9051257853";
        Admin instance = new Admin();
        int expResult = 0;
        int result = instance.registerUser(userName, password, firstName, lastName, email, phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of report method, of class Admin.
     
    @Test
    public void testReport() throws Exception {
        System.out.println("report");
        Admin instance = new Admin();
        User user = new User();
        List expResult = null; ;
        List result = instance.report();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fetchUserDetails method, of class Admin.
     */
    @Test
    public void testFetchUserDetails() throws Exception {
        System.out.println("fetchUserDetails");
        
        String userName = "testUser";
        Admin instance = new Admin();
        User u = new User();
        User actResult = instance.fetchUserDetails(userName);
        User expResult = u;
        boolean result = expResult.equals(actResult);
        assertTrue(result);
        //User result = instance.fetchUserDetails(userName);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserDetails method, of class Admin.
    */ 
    @Test
    public void testUpdateUserDetails() throws Exception {
        System.out.println("updateUserDetails");
        String userName = "testUser";
        String password = "test123";
        String firstName = "test";
        String lastName = "user";
        String email = "user@gmail.com";
        String phoneNumber = "9051257853";
        Admin instance = new Admin();
        int expResult = 1;
        int result = instance.updateUserDetails(userName, password, firstName, lastName, email, phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUserDetails method, of class Admin.
     */
    @Test
    public void testDeleteUserDetails() throws Exception {
        System.out.println("deleteUserDetails");
        String userName = "test";
        Admin instance = new Admin();
        int expResult = 0;
        int result = instance.deleteUserDetails(userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
