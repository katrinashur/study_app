package tech.visdom.study_app.dao;

import org.springframework.data.repository.CrudRepository;
import tech.visdom.study_app.model.Feedback;

public interface FeedbackDao extends CrudRepository<Feedback, Integer> {
}
