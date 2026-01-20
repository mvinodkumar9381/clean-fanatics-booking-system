package com.cleanfanatics.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private Long id;
    private String customerName;
    private String serviceType;
    private String providerName;
    private BookingStatus status;
    private LocalDateTime createdAt;
    private List<String> eventLog = new ArrayList<>();

    public Booking(Long id, String customerName, String serviceType) {
        this.id = id;
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.status = BookingStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        log("Booking created");
    }

    public void log(String event) {
        eventLog.add(LocalDateTime.now() + " - " + event);
    }

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getServiceType() { return serviceType; }
    public String getProviderName() { return providerName; }
    public BookingStatus getStatus() { return status; }
    public List<String> getEventLog() { return eventLog; }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
        log("Provider assigned: " + providerName);
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
        log("Status changed to " + status);
    }
}
