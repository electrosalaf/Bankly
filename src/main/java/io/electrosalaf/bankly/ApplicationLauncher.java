package io.electrosalaf.bankly;

import io.electrosalaf.bankly.web.TransactionServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context appContext = tomcat.addContext("", null);

        // Add Servlet to Tomcat
        Wrapper servlet = tomcat.addServlet(appContext, "transactionServlet", new TransactionServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        tomcat.start();
    }
}
