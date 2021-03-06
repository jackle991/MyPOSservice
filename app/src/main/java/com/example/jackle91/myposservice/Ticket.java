package com.example.jackle91.myposservice;

public class Ticket {
    public String ticketNumber;
    public String storeId;
    public String businessDate;
    public String totalPrice;

    public Ticket() { }

    public Ticket(String ticketNumber, String storeId, String businessDate, String totalPrice) {
        this.ticketNumber = ticketNumber;
        this.storeId = storeId;
        this.businessDate = businessDate;
        this.totalPrice = totalPrice;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String toString() {
        String s = "";
        s = s + "TicketNumber: " + ticketNumber + "\n";
        s = s + "StoreId: " + storeId + "\n";
        s = s + "BusinessDate: " + businessDate + "\n";
        s = s + "TotalPrice: " + totalPrice + "\n";

        return s;
    }
}
