package org.example.Altro.DTO;

import java.time.LocalDate;
import java.util.List;

public class ReservationSummaryDTO {
    private String sportsFacilityID;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate createdAt;
    private List<SportsReservationReportDTO> sportsReservationReports;

    public ReservationSummaryDTO(String sportsFacilityID, LocalDate startDate, LocalDate endDate, LocalDate createdAt, List<SportsReservationReportDTO> sportsReservationReports) {
        this.sportsFacilityID = sportsFacilityID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.sportsReservationReports = sportsReservationReports;
    }

    public String getSportsFacilityID() {
        return sportsFacilityID;
    }

    public void setSportsFacilityID(String sportsFacilityID) {
        this.sportsFacilityID = sportsFacilityID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<SportsReservationReportDTO> getSportsReservationReports() {
        return sportsReservationReports;
    }

    public void setSportsReservationReports(List<SportsReservationReportDTO> sportsReservationReports) {
        this.sportsReservationReports = sportsReservationReports;
    }
}
