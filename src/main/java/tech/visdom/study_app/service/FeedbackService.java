package tech.visdom.study_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.study_app.dao.FeedbackDao;
import tech.visdom.study_app.model.Feedback;

@Service
public class FeedbackService {

    FeedbackDao feedbackDao;

    @Autowired
    public FeedbackService(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    public Integer save(Feedback feedback) {
        return feedbackDao.save(feedback).getFeedbackId();
    }
}
