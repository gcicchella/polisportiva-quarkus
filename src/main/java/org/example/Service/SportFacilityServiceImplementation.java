package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;
import org.example.Altro.DTO.ReservationSummaryDTO;
import org.example.Altro.DTO.SportReservationReportDTO;
import org.example.Altro.Enumeration.ReservationStatus;
import org.example.Model.Reservation;
import org.example.Model.SportFacility;
import org.example.Model.SportField;
import org.example.Repository.SportFacilityRepository;
import org.example.Repository.SportFieldRepository;
import org.example.Repository.UserRepository;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class SportFacilityServiceImplementation implements SportFacilityService {

    @Inject
    private SportFacilityRepository sportFacilityRepository;

    @Inject
    private SportFieldRepository sportFieldRepository;

    @Inject
    private ReservationService reservationService;

    @Override
    public List<SportFacility> findAll() {
        return sportFacilityRepository.listAll();
    }

    @Transactional
    public SportFacility createSportsFacility(SportFacility sportFacility) {
        sportFacilityRepository.persist(sportFacility);
        SportFacility sportFacility1 = sportFacilityRepository.findById(sportFacility.getId());
        if(sportFacility1 != null){
            return sportFacility1;
        }
        else return null;
    }

    @Transactional
    @Override
    public SportField createSportsFieldBySportsFacility(SportFacility sportFacility, SportField sportField) {
         sportField.setUser(sportFacility.getUser());
         sportField.setSportsFacility(sportFacility);
         sportFieldRepository.persist(sportField);
         SportField sportField1 = sportFieldRepository.findById(sportField.getId());
         if(sportField1 != null) return sportField1;
         return null;
    }

    @Transactional
    @Override
    public boolean deleteSportsFacilityById(Long id_sports_facility) {
       return sportFacilityRepository.deleteById(id_sports_facility);
    }

    @Transactional
    @Override
    public List<SportFacility> getSportsFacilityByUserId(Long id_user) {
       return sportFacilityRepository.getSportsFacilityByUserId(id_user);
    }

    @Transactional
    public SportFacility getSportsFacilityById(Long id_sports_facility) {
        return sportFacilityRepository.findById(id_sports_facility);
    }

//    ToDo: metti ZonedDateTime
    @Override
    public ReservationSummaryDTO getReservationSummaries(Long id_sports_facility, Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("La data di inizio non può essere maggiore della data di fine.");
        }
        SportFacility sportFacility = sportFacilityRepository.findById(id_sports_facility);
        if(sportFacility != null){
            List<Reservation> reservationList = reservationService.getReservationByFacilityId(id_sports_facility, startDate, endDate);
            if(reservationList != null){
                SportReservationReportDTO volleyballReservationReportDTO = new SportReservationReportDTO();
                volleyballReservationReportDTO.setSport("volleyball");
                SportReservationReportDTO soccerReservationReportDTO = new SportReservationReportDTO();
                soccerReservationReportDTO.setSport("soccer");
                SportReservationReportDTO basketReservationReportDTO = new SportReservationReportDTO();
                basketReservationReportDTO.setSport("basket");
                SportReservationReportDTO tennisReservationReportDTO = new SportReservationReportDTO();
                tennisReservationReportDTO.setSport("tennis");

                for(Reservation reservation : reservationList){
                    if(reservation.getSportsField().getSport().equals("volleyball")){
                        chooseStatus(volleyballReservationReportDTO, reservation);
                    }
                    else if(reservation.getSportsField().getSport().equals("soccer")){
                        chooseStatus(soccerReservationReportDTO, reservation);
                    }
                    else if(reservation.getSportsField().getSport().equals("basket")){
                        chooseStatus(basketReservationReportDTO, reservation);
                    }
                    else if(reservation.getSportsField().getSport().equals("tennis")){
                        chooseStatus(tennisReservationReportDTO, reservation);
                    }
                }

                List<SportReservationReportDTO> sportsReservationReports = new LinkedList<>();
                sportsReservationReports.add(volleyballReservationReportDTO);
                sportsReservationReports.add(soccerReservationReportDTO);
                sportsReservationReports.add(basketReservationReportDTO);
                sportsReservationReports.add(tennisReservationReportDTO);
                return new ReservationSummaryDTO(id_sports_facility, startDate, endDate, new Date(), sportsReservationReports);
            }
            return null;
        }
        return null;
    }


    private static void chooseStatus(SportReservationReportDTO sportReservationReportDTO, Reservation reservation) {
        sportReservationReportDTO.setTotalReservations(sportReservationReportDTO.getTotalReservations() + 1);
        sportReservationReportDTO.setTotalRevenue(0);
        switch (reservation.getState()){
            case ACCEPTED: {
                sportReservationReportDTO.setAcceptedReservations(sportReservationReportDTO.getAcceptedReservations() + 1);
                break;
            }
            case PENDING: {
                sportReservationReportDTO.setPendingReservations(sportReservationReportDTO.getPendingReservations() + 1);
                break;
            }
            case REJECTED: {
                sportReservationReportDTO.setRejectedReservations(sportReservationReportDTO.getRejectedReservations() + 1);
                break;
            }
        }
    }

}
