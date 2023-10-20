package com.lcwd.hotel.controller;

import com.lcwd.hotel.HotelServiceApplication;
import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.entities.Room;
import com.lcwd.hotel.service.hotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class hotelController {

    @Autowired
    private hotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.addHotel(hotel));
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getHotelById(hotelId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> deleteHotelById(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.deleteHotelById(hotelId));
    }

    @PostMapping("/{hotelId}/rooms")
    public ResponseEntity<Room> addRoom(@PathVariable String hotelId, @RequestBody Room hotel) {
        return ResponseEntity.ok(hotelService.addRoom(hotelId, hotel));
    }

    @GetMapping("/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable String roomId) {
        return ResponseEntity.ok(hotelService.getRoomById(roomId));
    }

    @GetMapping("/{hotelId}/rooms/available")
    public ResponseEntity<List<Room>> getAllAvailableRoom(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getAllAvailableRoom(hotelId));
    }

    @GetMapping("/{hotelId}/rooms/booked")
    public ResponseEntity<List<Room>> getAllBookedRoom(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getAllBookedRoom(hotelId));
    }



}
