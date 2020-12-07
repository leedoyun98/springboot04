package com.example.demo.impls;

import java.time.LocalDate;

import com.example.demo.Printer;
import com.example.demo.domains.ArticleDto;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired ArticleRepository repository;
    @Autowired Printer printer;
    @Override
    public int write(ArticleDto articleDto) {
        printer.accept("서비스로 전송된 데이터: "+articleDto.toString());
        LocalDate date = LocalDate.now();
        articleDto.setRegDate(date.toString());
        return repository.insert(articleDto);
       
    }
    
}
