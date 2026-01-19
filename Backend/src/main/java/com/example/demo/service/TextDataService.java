package com.example.demo.service;

import com.example.demo.model.TextData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.TextDataRepository;

@Service
public class TextDataService {

    @Autowired
    private TextDataRepository repository;

    public TextData saveTextData(String text){
         TextData data = new TextData();
         data.setText(text);
         return repository.save(data);
    }

    public List<TextData> getAllTextData(){
        return repository.findAll();
    }



}
