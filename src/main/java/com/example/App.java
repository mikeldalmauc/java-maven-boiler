package com.example;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.example.model.Model;
import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App 
{
    // unique instance for fake data creation
    private static Faker fakerInstance; 
    
    public static void main( String[] args ){
        fakerInstance = Faker.instance();

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

    public static Faker getFaker(){
        return fakerInstance;
    }
}
