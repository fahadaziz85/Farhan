package com.farhan.hello;

import java.io.IOException;

public class HelloWorld {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!!!");
        // To kill the webdriver processes windows
        //Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

        // To kill the webdriver processes mac
        //Runtime.getRuntime().exec("killall chromedriver");
    }
}
