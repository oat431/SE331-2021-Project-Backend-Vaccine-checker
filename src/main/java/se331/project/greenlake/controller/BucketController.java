package se331.project.greenlake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import se331.project.greenlake.util.CloudStorageHelper;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class BucketController {
    @Autowired
    CloudStorageHelper cloudStorageHelper;
    private Object ResponseEntity;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(
            @RequestPart(value = "file") MultipartFile file
    ) throws IOException, ServletException {
        return org.springframework.http.ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"greenlakeimagestorage.appspot.com"));
    }
}