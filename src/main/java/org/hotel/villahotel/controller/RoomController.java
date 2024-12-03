package org.hotel.villahotel.controller;

import lombok.RequiredArgsConstructor;
import org.hotel.villahotel.model.Room;
import org.hotel.villahotel.response.RoomResponse;
import org.hotel.villahotel.service.IRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class RoomController {
    private final IRoomService roomService;

    public ResponseEntity<RoomResponse> addNewRoom (
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType")String roomType,
            @RequestParam("roomPrice")BigDecimal roomPrice){

        Room savedRoom = roomService.addNewRoom(photo , roomType , roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getId(),savedRoom.getRoomType(),savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }

}
