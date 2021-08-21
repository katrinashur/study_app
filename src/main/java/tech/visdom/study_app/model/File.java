package tech.visdom.study_app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class File {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId;

    @Getter
    @Setter
    @Column
    private byte file[];

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "file", cascade = CascadeType.ALL)
    private Image image;

    public File(Integer fileId) {
        this.fileId = fileId;
    }
}
