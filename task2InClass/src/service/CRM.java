package service;

import model.Deal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CRM {
    private List<Deal> allDeals = new ArrayList<>();
    public void addDeal(Deal n){
        n.addObserver(n.getClient());
        n.addObserver(n.getEmployee());
        allDeals.add(n);
    }
    public void sortStatuses(){
        allDeals.sort(Comparator.comparing(Deal::getStatus));
    }
    public void printDeals(){
        for (Deal deal : allDeals) {
            System.out.println(deal);
            System.out.println("Комиссия менеджера: " + deal.calculateCommission());
            System.out.println("\n");
        }
    }
}
