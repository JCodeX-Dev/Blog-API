package dev.jcodex.blog_api_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class Controller {

    @RequestMapping(method = RequestMethod.GET, path = "/**")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleUnknownRequest() {
        // Handle unknown requests here
        return new ResponseEntity<>("Unknown request", HttpStatus.NOT_FOUND);
    }

}
