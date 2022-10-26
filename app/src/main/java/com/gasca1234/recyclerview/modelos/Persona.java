package com.gasca1234.recyclerview.modelos;

public class Persona {
    private String Name;
    private String Phone;


    public Persona(String name, String phone) {
        Name = name;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

}
