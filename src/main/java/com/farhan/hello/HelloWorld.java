package com.farhan.hello;

import java.io.IOException;

public class HelloWorld {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!!!");
        // To kill the webdriver processes
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}
