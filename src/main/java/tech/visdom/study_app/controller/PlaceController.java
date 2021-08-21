package tech.visdom.study_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.visdom.study_app.model.Place;
import tech.visdom.study_app.service.PlaceService;

import java.util.List;

@RestController
public class PlaceController {

    private  PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/place/{placeId}")
    public Place get(@PathVariable Integer placeId) {
        return placeService.findById(placeId);
    }

    @GetMapping("/place")
    public List<Place> getList() {
        return placeService.getList();
    }
}
