package tech.visdom.study_app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.visdom.study_app.enums.PlaceTypeEnum;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Place {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
