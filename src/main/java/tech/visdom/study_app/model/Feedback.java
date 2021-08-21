package tech.visdom.study_app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Feedback {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String mail;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id", nullable = true, foreignKey = @ForeignKey(name = "feedback_place_fkey"))
    private Place place;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", nullable = true, foreignKey = @ForeignKey(name = "feedback_route_fkey"))
    private Route route;
}
