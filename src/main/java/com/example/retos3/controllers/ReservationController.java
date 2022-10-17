package com.example.retos3.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retos3.entities.Client;
import com.example.retos3.entities.ReportClient;
import com.example.retos3.entities.Reservation;
import com.example.retos3.services.ReservationService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Reservation")
public class ReservationController {    

    @Autowired
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getReservations(){
        return new ResponseEntity<List<Reservation>>(this.reservationService.getListReservations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") int id){
        return new ResponseEntity<Reservation>(this.reservationService.getReservation(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearReservation(@RequestBody Reservation reservation){
        this.reservationService.crearReservation(reservation);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReservation(@PathVariable("id") int id){
        this.reservationService.eliminarReservation(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarReservation(@RequestBody Reservation reservation){
        this.reservationService.actualizarReservation(reservation.getIdReservation(), reservation);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @GetMapping("/report-dates/{start}/{end}")
    public ResponseEntity<List<Reservation>> getReservationsBetweenTime(@PathVariable("start") String start, @PathVariable("end") String end){
        return new ResponseEntity<List<Reservation>>(this.reservationService.getReservationsBetweenTime(start, end), HttpStatus.OK);
    }

    @GetMapping("/report-status")
    public ResponseEntity<String> getReservationsStatus(){
        return new ResponseEntity<String>(this.reservationService.getReservationsStatus(), HttpStatus.OK);
    }

    @GetMapping("/report-clients")
    public ResponseEntity<List<ReportClient>> getReservationsClients(){
        List<ReportClient> clientList = this.reservationService.getReservationsReportClients();
        return new ResponseEntity<List<ReportClient>>(clientList, HttpStatus.OK);
    }

}
