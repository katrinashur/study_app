package tech.visdom.study_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.study_app.dao.RouteDao;
import tech.visdom.study_app.dto.RouteDto;

@Service
public class RouteService {

    private RouteDao routeDao;

    @Autowired
    public RouteService(RouteDao routeDao) {
        this.routeDao = routeDao;
    }

    public RouteDto getRoute(Integer routeId) {
        return new RouteDto(routeDao.findById(routeId).orElseThrow(()->new RuntimeException("Маршурт с id" + routeId + "не найден ")));
    }
}
