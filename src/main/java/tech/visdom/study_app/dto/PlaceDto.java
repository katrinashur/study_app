package tech.visdom.study_app.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.visdom.study_app.enums.PlaceTypeEnum;
import tech.visdom.study_app.model.Image;
import tech.visdom.study_app.model.Place;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
public class PlaceDto {

    @Getter
    @Setter
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

    @Getter
    @Setter
    private String textLegend;

    @Getter
    @Setter
    private List<String> imageUrlList;

    @Getter
    @Setter
    private List<FeedbackDto> feedbackList;

    public PlaceDto(Place place) {
        this.placeId = place.getPlaceId();
        this.name = place.getName();
        this.description = place.getDescription();
        this.rate = place.getRate();
        this.audio = place.getAudio();
        this.placeType = place.getPlaceType();
        this.coordinateX = place.getCoordinateX();
        this.coordinateY = place.getCoordinateY();
        this.textLegend = place.getTextLegend();
        this.imageUrlList = place.getImageList()
                .stream()
                .map(Image::getUrl)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        this.feedbackList = place
                .getFeedbackList()
                .stream()
                .map(FeedbackDto::new)
                .collect(Collectors.toList());
    }
}
