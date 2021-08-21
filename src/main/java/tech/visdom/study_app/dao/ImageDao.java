package tech.visdom.study_app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.visdom.study_app.model.Image;

@Repository
public interface ImageDao extends CrudRepository<Image, Integer> {

}
