package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.model.Model;

public class Update {

    private static Logger log = LogManager.getLogger();

    public static void update(Msg msg, Model model){

        log.info("Update Message issued: " + msg);

        switch (msg) {
        
            case UP:
                model.setCount(model.getCount() + 1);
                break;

            case DOWN:
                model.setCount(model.getCount() - 1);
                break;

            default:
                break;

        }
    }
}
