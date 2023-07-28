package org.example.Altro.DTO;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public class ReservationSummaryDTO {
    private Long sportsFacilityID;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private List<SportReservationReportDTO> sportsReservationReports;

    public ReservationSummaryDTO(Long sportsFacilityID, Date startDate, Date endDate, Date createdAt, List<SportReservationReportDTO> sportsReservationReports) {
        this.sportsFacilityID = sportsFacilityID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.sportsReservationReports = sportsReservationReports;
    }

    public Long getSportsFacilityID() {
        return sportsFacilityID;
    }

    public void setSportsFacilityID(Long sportsFacilityID) {
        this.sportsFacilityID = sportsFacilityID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<SportReservationReportDTO> getSportsReservationReports() {
        return sportsReservationReports;
    }

    public void setSportsReservationReports(List<SportReservationReportDTO> sportsReservationReports) {
        this.sportsReservationReports = sportsReservationReports;
    }
}
