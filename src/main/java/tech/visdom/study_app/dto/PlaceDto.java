package tech.visdom.study_app.dto;


import lombok.Getter;
import lombok.Setter;
import tech.visdom.study_app.enums.PlaceTypeEnum;
import tech.visdom.study_app.model.Place;

public class PlaceDto {

    private Integer placeId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Double rate;

    @Getter
    @Setter
    private String audio;

    @Getter
    @Setter
    private PlaceTypeEnum placeType;

    @Getter
    @Setter
    private Double coordinateX;

    @Getter
    @Setter
    private Double coordinateY;

    public PlaceDto(Place place) {
        this.placeId = place.getPlaceId();
        this.name = place.getName();
        this.description = place.getDescription();
        this.rate = place.getRate();
        this.audio = place.getAudio();
        this.placeType = place.getPlaceType();
        this.coordinateX = place.getCoordinateX();
        this.coordinateY = place.getCoordinateY();
    }
}
