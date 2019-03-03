package com.tutorial.demo.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {
    String name;
    String greeting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting(String name, String greeting) {
        this.name = name;
        this.greeting = greeting;
    }

    public Greeting() {
        super();
    }

    static Greeting from(String name, String greeting) {
        return new Greeting(name, greeting);
    }
}
