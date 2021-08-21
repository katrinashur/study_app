package tech.visdom.study_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.visdom.study_app.dao.FileDao;
import tech.visdom.study_app.exception.InternalErrorException;
import tech.visdom.study_app.model.File;

import java.io.IOException;

@Service
public class FileService {

    private FileDao fileDao;

    @Autowired
    public FileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public Integer uploadFile(MultipartFile file) throws InternalErrorException{
        File newFile = new File();
        try {
            newFile.setName(file.getOriginalFilename());
            newFile.setFile(file.getBytes());
        } catch (IOException e) {
            throw new InternalErrorException("Ошибка при сохранении файла в бд");
        }

        fileDao.save(newFile);
        return newFile.getFileId();
    }

    public File getFile(Integer fileId) {
        return fileDao.findById(fileId).orElseThrow(()->new RuntimeException("Не найден файл с id" + fileId));
    }

    public byte[] getFileBytes(Integer fileId) {
        File file = fileDao.findById(fileId).orElseThrow(()->new RuntimeException("Не найден файл с id" + fileId));
        return file.getFile();
    }
}
