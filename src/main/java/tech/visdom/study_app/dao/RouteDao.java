package tech.visdom.study_app.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.visdom.study_app.model.Route;

@Repository
public interface RouteDao extends CrudRepository<Route, Integer> {
}
