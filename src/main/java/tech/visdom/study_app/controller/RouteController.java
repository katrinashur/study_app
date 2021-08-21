package tech.visdom.study_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.visdom.study_app.dto.RouteDto;
import tech.visdom.study_app.service.RouteService;


@RestController
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/route/{routeId}")
    public RouteDto get(@PathVariable Integer routeId) {
        return routeService.getRoute(routeId);
    }
}
