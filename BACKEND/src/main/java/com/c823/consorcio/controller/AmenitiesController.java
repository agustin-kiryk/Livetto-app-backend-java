package com.c823.consorcio.controller;

import com.c823.consorcio.dto.ReservationBasicDto;
import com.c823.consorcio.dto.ReservationDto;
import com.c823.consorcio.service.IAmenitiesService;
import com.c823.consorcio.service.Impl.AmenitiesServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class AmenitiesController {
  @Autowired
  private IAmenitiesService amenitiesService;

  @PostMapping("/amenities")
  public ResponseEntity<ReservationDto> reservation(@RequestBody ReservationDto reservationDto){
    ReservationDto reservation = this.amenitiesService.saveReservation(reservationDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
  }
  @GetMapping("/list")
  public ResponseEntity<List<ReservationBasicDto>> listReservations(){
    List<ReservationBasicDto> list = this.amenitiesService.getReservations();
    return ResponseEntity.ok().body(list);

  }


}
