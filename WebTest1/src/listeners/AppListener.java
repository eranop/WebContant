package listeners;

import projectContant.DataBase;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        //application is being deployed
        //register the "global" object here
    	try {
        ServletContext sc = sce.getServletContext();
        DataBase db = new DataBase();
        sc.setAttribute("DataBase", db);
    	} catch (RuntimeException e){
    		System.out.println("exception in listener");
    	}
    }
    public void contextDestroyed(ServletContextEvent sce) {
        //application is being undeployed
    }
}