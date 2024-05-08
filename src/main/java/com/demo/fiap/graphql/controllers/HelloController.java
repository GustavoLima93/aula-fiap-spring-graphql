package com.demo.fiap.graphql.controllers;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @QueryMapping
    public String hello() {
        return "Hello Graphql";
    }

    // shop

    //clients  //shop  //products
}
