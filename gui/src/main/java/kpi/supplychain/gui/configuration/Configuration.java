package kpi.supplychain.gui.configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Stryzhov.
 */
public class Configuration {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        MainWindow window = ctx.getBean(MainWindow.class);
        window.initialize();
        window.getFrame().setVisible(true);
    }
}
