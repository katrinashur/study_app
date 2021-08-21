package tech.visdom.study_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.study_app.dao.PlaceDao;
import tech.visdom.study_app.exception.PlaceNotFoundException;
import tech.visdom.study_app.model.Place;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {

    private PlaceDao placeDao;

    @Autowired
    public PlaceService(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public Place findById(Integer placeId) {
        return placeDao.findById(placeId).orElseThrow(()->new PlaceNotFoundException("Место по " + placeId + "не найдено"));
    }

    public List<Place> getList() {
        List<Place> placeList = new ArrayList<>();
        placeDao.findAll().forEach(placeList::add);
        return placeList;
    }
}
