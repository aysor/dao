package ru.netology.springdao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.springdao.repository.DaoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DaoService {
    private final DaoRepository daoRepository;

    public List<String> getProductName(String name){
        return daoRepository.getProductName(name);
    }
}
