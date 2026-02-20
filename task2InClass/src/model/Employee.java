package model;

import observer.Notifiable;

public class Employee implements Notifiable {
    private String fullName;
    private String position;
    private double coeff;

    public Employee(String fullName, String position, double coeff){
        this.fullName = fullName;
        this.position = position;
        this.coeff = coeff;
    }

    public String getFullName(){
        return fullName;
    }
    public String getPosition(){
        return position;
    }
    public double getCoeff(){
        return coeff;
    }

    @Override
    public String toString(){
        return fullName + " - " + position;
    }
    @Override
    public void notify(String message) {
        System.out.println("Система - Менеджеру " + fullName + ": " + message);
    }
}
