package com.example;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        // Initialize log4J appenders
        BasicConfigurator.configure();

        counterProgram();
    }  

    public static void counterProgram(){

        Model model = new Model();
        final View view = new View(model);
        model.setListener(view);

        SwingUtilities.invokeLater(() -> {
            view.getJframe().setVisible(true);
            view.getJframe().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
    }
}
