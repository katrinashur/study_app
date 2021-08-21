package tech.visdom.study_app.dao;

import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;
import tech.visdom.study_app.model.Place;

public interface PlaceDao extends CrudRepository<Place, Integer> {
}
