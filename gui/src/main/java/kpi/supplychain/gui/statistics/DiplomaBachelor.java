/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kpi.supplychain.gui.statistics;


import kpi.supplychain.dao.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.WindowConstants;

/**
 * @author I
 */
public class DiplomaBachelor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        MainFrame mainFrame = ctx.getBean(MainFrame.class);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.initComponents();
    }

}
