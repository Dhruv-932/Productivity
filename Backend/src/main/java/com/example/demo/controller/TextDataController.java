package com.example.demo.controller;


import com.example.demo.model.TextData;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.TextDataService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class TextDataController {

    @Autowired
    private TextDataService service;

    @PostMapping("/save")
    public TextData save(@RequestBody Map<String, String> body){
        String content= body.get("text");
        if(content==null){
            throw new IllegalArgumentException("Property text is missing in request body");
        }
        return service.saveTextData(content);
    }

    @GetMapping("/data")
    public List<TextData> getAll(){
        return service.getAllTextData();
    }
}
