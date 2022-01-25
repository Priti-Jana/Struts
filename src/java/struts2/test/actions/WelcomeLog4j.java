/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

/**
 *
 * @author PRITI
 */
public class WelcomeLog4j extends ActionSupport {
    private static final Logger logger = Logger.getLogger(UserAction.class);
    public String execute() throws Exception {

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("execute()!");
                        System.out.println("done");
		}

		// logs exception
		logger.error("This is Error message", new Exception("Testing"));

		return SUCCESS;
    }
    
}
