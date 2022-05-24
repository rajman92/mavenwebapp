package com.github.rajman92.lang;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LangService {
    private LangRepository repository;

    LangService()   {
        this(new LangRepository());
    }
    LangService(LangRepository repository)    {
        this.repository = repository;
    }

    List<LangDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(toList());
    }
}
