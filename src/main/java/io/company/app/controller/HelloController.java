package io.company.app.controller;

import io.company.app.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("hello")
public class HelloController extends AbstractController {

    @GetMapping("")
    public ResponseEntity hello() {
        return makeResponse();
    }

    @GetMapping("data")
    public ResponseEntity data() {
        return makeResponse(new HashMap<String, String>() {{
            this.put("gg","gg");
            this.put("gg2","gg2");
            this.put("gg3","gg3");
        }});
    }

    @GetMapping("exception")
    public ResponseEntity gg() throws Exception{
        throw new Exception("ddd");
    }

    @GetMapping("base-exception")
    public ResponseEntity base() {
        throw new BaseException(401, "무슨무슨 에러임");
    }

}
