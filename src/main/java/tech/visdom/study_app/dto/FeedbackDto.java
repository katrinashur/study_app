package tech.visdom.study_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.visdom.study_app.model.Feedback;

@NoArgsConstructor
public class FeedbackDto {

    @Getter
    @Setter
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

    public FeedbackDto(Feedback feedback) {
        this.feedbackId = feedback.getFeedbackId();
        this.message = feedback.getMessage();
        this.name = feedback.getName();
        this.mail = feedback.getMail();
    }
}
