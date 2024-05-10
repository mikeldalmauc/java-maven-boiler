package com.example;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

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
