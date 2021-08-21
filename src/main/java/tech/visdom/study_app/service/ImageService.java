package tech.visdom.study_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.visdom.study_app.dao.ImageDao;
import tech.visdom.study_app.exception.ImageNotFoundException;
import tech.visdom.study_app.model.File;
import tech.visdom.study_app.model.Image;
import tech.visdom.study_app.model.Place;

import javax.persistence.Access;

@Service
public class ImageService {


    private ImageDao imageDao;


    @Autowired
    public ImageService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public Integer save(Image image) {
        imageDao.save(image);
        return image.getImageId();
    }

    public Image getImage(Integer imageId) {
        return imageDao.findById(imageId).orElseThrow(()-> new ImageNotFoundException("Картинка с id " + imageId + "не найдена"));
    }

    public Integer saveImageToPlace(Integer fileId, Place place) {
        Image image = new Image();
        image.setFile(new File(fileId));
        image.setPlace(place);
        return this.save(image);
    }
}
