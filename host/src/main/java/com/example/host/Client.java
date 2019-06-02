package com.example.host;

public class Client {

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Client(){
        id = 1;
        name = "Ivan";
    }

    Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;
    private String greeting;

    public Client(int id, String name, String greeting) {
        this.id = id;
        this.name = name;
        this.greeting = greeting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "ID : " + this.id + "\nNAME : " + this.name + "\nGREETING : " + this.greeting;
    }

}
