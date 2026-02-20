package model;

import observer.Notifiable;
import java.util.ArrayList;
import java.util.List;

public class Deal{
    private Client client;
    private Employee employee;
    private double amount;
    private DealStatus dealStatus;
    private String description;

    private List<Notifiable> observers = new ArrayList<>();

    public Deal(Client client, Employee employee, double amount, String description) {
        this.client = client;
        this.employee = employee;
        this.amount = amount;
        this.dealStatus = DealStatus.NEW;
        this.description = description;
    }
    //TODO добавить геттеры
    public Client getClient(){
        return client;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void addObserver(Notifiable observer){
        observers.add(observer);
    }

    public void removeObserver(Notifiable Robserver){
        observers.remove(Robserver);
    }

    public void setStatus(DealStatus newStatus) {
        this.dealStatus = newStatus;
        sendNotify("Статус сделки '" + description + "' изменен на: " + newStatus.getRussianName());
    }

    private void sendNotify(String message) {
        for (Notifiable observer : observers) {
            observer.notify(message);// динамическое связывание
        }
    }
    public double calculateCommission() {
        return amount * employee.getCoeff();
    }

    public DealStatus getStatus() { return dealStatus; }
    public double getAmount() { return amount; }

    @Override
    public String toString(){
        return "Сделка: " + description + "\nСтатус: " + dealStatus + "\nСумма: " + amount;
    }


}
