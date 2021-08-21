package tech.visdom.study_app.dto;

import lombok.Getter;
import lombok.Setter;
import tech.visdom.study_app.model.Place;
import tech.visdom.study_app.model.Route;
import tech.visdom.study_app.model.RoutePlace;

import java.util.List;
import java.util.stream.Collectors;

public class RouteDto {

    private Integer routeId;

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
    private List<PlaceDto> placeList;

    public RouteDto(Route route) {
        this.routeId = route.getRouteId();
        this.name = route.getName();
        this.rate = route.getRate();
        this.description = route.getDescription();
        this.audio = route.getAudio();
        this.placeList = route.getRoutePlaceList()
                .stream()
                .map(RoutePlace::getPlace)
                .map(PlaceDto::new)
                .collect(Collectors.toList());
    }
}
