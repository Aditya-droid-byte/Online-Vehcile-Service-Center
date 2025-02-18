package com.ovsc.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "min_distance")
    private int minDistance;

    @Column(name = "max_distance")
    private int maxDistance;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "service_description")
    private String serviceDescription;

    public Service() {

    }

    public Service(int minDistance, int maxDistance, String serviceName, String serviceDescription) {
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}



