package tech.visdom.study_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.study_app.dao.PlaceDao;
import tech.visdom.study_app.dto.PlaceDto;
import tech.visdom.study_app.exception.PlaceNotFoundException;
import tech.visdom.study_app.model.Place;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {

    private PlaceDao placeDao;
    private ImageService imageService;

    @Autowired
    public PlaceService(PlaceDao placeDao, ImageService imageService) {
        this.placeDao = placeDao;
        this.imageService = imageService;
    }

    public Place findById(Integer placeId) {
        return placeDao.findById(placeId).orElseThrow(()->new PlaceNotFoundException("Место по " + placeId + "не найдено"));
    }

    public List<Place> getList() {
        List<Place> placeList = new ArrayList<>();
        placeDao.findAll().forEach(placeList::add);
        return placeList;
    }

    public Place save(PlaceDto placeDto) {
        return placeDao.save(new Place(placeDto));
    }

    @Transactional
    public Integer savePlace(PlaceDto placeDto) {
        Place place = this.save(placeDto);
        imageService.saveImagesToPlace(place, placeDto.getImageUrlList());
        return  place.getPlaceId();
    }
}
