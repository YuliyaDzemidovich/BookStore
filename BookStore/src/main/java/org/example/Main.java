package org.example;

import org.apache.log4j.Logger;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.getTestStr());
        log.info("logger test");
    }

    public String getTestStr(){
        return "Hello World!";
    }
}
