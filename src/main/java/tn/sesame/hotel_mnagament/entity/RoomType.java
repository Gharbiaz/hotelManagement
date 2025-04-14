package tn.sesame.hotel_mnagament.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomType {

    SINGLE(1),
    DOUBLE(2);

    private final int capacity;

}