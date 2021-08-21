package tech.visdom.study_app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.visdom.study_app.dto.PlaceDto;
import tech.visdom.study_app.enums.PlaceTypeEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Place {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer placeId;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Column
    private Double rate;

    @Getter
    @Setter
    @Column
    private String audio;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column
    private PlaceTypeEnum placeType;

    @Getter
    @Setter
    @Column(name="coordinate_x")
    private Double coordinateX;

    @Getter
    @Setter
    @Column(name="coordinate_y")
    private Double coordinateY;

    @Column
    @Getter
    @Setter
    private String textLegend;

    @Getter
    @Setter
    @OneToMany(mappedBy = "place", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Image> imageList;

    @Getter
    @Setter
    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Feedback> feedbackList;

    public Place(Integer placeId) {
        this.placeId = placeId;
    }

    public Place(PlaceDto placeDto) {
        this.name = placeDto.getName();
        this.placeType = placeDto.getPlaceType();
        this.audio = placeDto.getAudio();
        this.description = placeDto.getDescription();
        this.rate = placeDto.getRate();
        this.coordinateX = placeDto.getCoordinateX();
        this.coordinateY = placeDto.getCoordinateY();
    }
}
