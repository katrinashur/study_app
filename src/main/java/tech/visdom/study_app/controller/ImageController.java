package tech.visdom.study_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.visdom.study_app.model.Image;
import tech.visdom.study_app.model.Place;
import tech.visdom.study_app.service.FileService;
import tech.visdom.study_app.service.ImageService;
import tech.visdom.study_app.service.PlaceService;

@RestController
public class ImageController {

    private ImageService imageService;
    private FileService fileService;
    private PlaceService placeService;

    @Autowired
    public ImageController(ImageService imageService, FileService fileService, PlaceService placeService) {
        this.imageService = imageService;
        this.fileService = fileService;
        this.placeService = placeService;
    }

    @GetMapping("/image/{imageId}")
    public Image getImage(@PathVariable  Integer imageId) {
        return imageService.getImage(imageId);
    }

    @GetMapping(value = "/file/{fileId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getFileBytes(@PathVariable  Integer fileId) {
        return fileService.getFileBytes(fileId);
    }

    @PostMapping("/file/upload")
    public Integer saveImageToPlace(@RequestParam MultipartFile file, @RequestParam Integer placeId) {
        Integer fileId = fileService.uploadFile(file);
        Place place = placeService.findById(placeId);
        return imageService.saveImageToPlace(fileId, place);
    }
}

