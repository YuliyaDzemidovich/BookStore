package org.example.controller;

import org.example.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping(path = "/hello", produces = {MediaType.TEXT_PLAIN_VALUE})
    @ResponseBody
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello spring", HttpStatus.OK);
    }

    @GetMapping(path = "/books", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getAllBooks() {
        return new ResponseEntity<String>(bookDao.getBooks().toString(), HttpStatus.OK);
    }

    @RequestMapping(path = "/*", produces = {MediaType.TEXT_PLAIN_VALUE})
    @ResponseBody
    public ResponseEntity<String> notFound(){
        return new ResponseEntity<>("404 Page not found, but spring is here", HttpStatus.OK);
    }

}
