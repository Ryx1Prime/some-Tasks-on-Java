package model;

import observer.Notifiable;

public class Client implements Notifiable {

    private String telephone;
    private String name;
    private String email;

    public Client(String telephone, String name, String email){
        this.telephone = telephone;
        this.email = email;
        this.name = name;
    }

    public String getTelephone(){
        return telephone;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return name + " (" + telephone + ")";
    }
    @Override
    public void notify(String message) {
        System.out.println("!!! SMS клиенту " + name + ": " + message);
    }
}
