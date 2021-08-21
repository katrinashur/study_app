package tech.visdom.study_app.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
public class Route {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeId;

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
    private Double rate;

    @Getter
    @Setter
    private String audio;

    @Getter
    @Setter
    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    @JacksonXmlElementWrapper(localName = "routePlaceList")
    @JacksonXmlProperty(localName = "routePlace")
    private List<RoutePlace> routePlaceList;

}
