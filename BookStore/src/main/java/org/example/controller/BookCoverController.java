package org.example.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class BookCoverController {
    private final static String SERVER_FILE_STORAGE_URL = "C:/Dropbox/Java/server/BookStore";

    @RequestMapping(path = "/covers/{id}", produces = {MediaType.IMAGE_JPEG_VALUE})
    @ResponseBody
    public ResponseEntity<Resource> getImageAsResource(@PathVariable String id){
        HttpHeaders headers = new HttpHeaders();
        Resource resource = new FileSystemResource(SERVER_FILE_STORAGE_URL + "/covers/" +
                id + ".jpg");
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
