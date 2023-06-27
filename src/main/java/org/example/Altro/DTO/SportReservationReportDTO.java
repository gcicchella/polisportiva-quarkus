package org.example.Altro.DTO;

public class SportReservationReportDTO {
    private int totalReservations;
    private String sport;
    private double totalRevenue;
    private int rejectedReservations;
    private int acceptedReservations;
    private int pendingReservations;

    public SportReservationReportDTO(int totalReservations, String sport, double totalRevenue, int rejectedReservations, int acceptedReservations, int pendingReservations) {
        this.totalReservations = totalReservations;
        this.sport = sport;
        this.totalRevenue = totalRevenue;
        this.rejectedReservations = rejectedReservations;
        this.acceptedReservations = acceptedReservations;
        this.pendingReservations = pendingReservations;
    }

    public int getTotalReservations() {
        return totalReservations;
    }

    public void setTotalReservations(int totalReservations) {
        this.totalReservations = totalReservations;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getRejectedReservations() {
        return rejectedReservations;
    }

    public void setRejectedReservations(int rejectedReservations) {
        this.rejectedReservations = rejectedReservations;
    }

    public int getAcceptedReservations() {
        return acceptedReservations;
    }

    public void setAcceptedReservations(int acceptedReservations) {
        this.acceptedReservations = acceptedReservations;
    }

    public int getPendingReservations() {
        return pendingReservations;
    }

    public void setPendingReservations(int pendingReservations) {
        this.pendingReservations = pendingReservations;
    }
}