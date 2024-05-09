package com.example;

import org.apache.log4j.Logger;

public class Update {

    private static Logger log = Logger.getLogger(Update.class);

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
