package tech.visdom.study_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.visdom.study_app.model.Feedback;
import tech.visdom.study_app.service.FeedbackService;


@RestController
public class FeedbackController {

    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/feedback")
    public Integer saveFeedback(@RequestBody Feedback feedback) {
        return feedbackService.save(feedback);
    }
}
