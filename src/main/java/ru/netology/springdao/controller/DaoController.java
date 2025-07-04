package ru.netology.springdao.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springdao.service.DaoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class DaoController {
    private final DaoService daoService;

    @GetMapping("/fetch-product")
    public List<String> getProductName(@RequestParam (value = "name", required = false) String name){
        return daoService.getProductName(name);
    }
}
