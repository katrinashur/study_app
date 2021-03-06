package tech.visdom.study_app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Image {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    @Getter
    @Setter
    @Column
    private String url;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id", nullable = true, foreignKey = @ForeignKey(name = "image_place_fkey"))
    private Place place;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", nullable = true, foreignKey = @ForeignKey(name = "image_route_fkey"))
    private Route route;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = true, foreignKey = @ForeignKey(name = "image_file_fkey"))
    protected File file;
}
