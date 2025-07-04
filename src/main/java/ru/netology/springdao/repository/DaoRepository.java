package ru.netology.springdao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.InputStreamReader;

@Repository
public class DaoRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String scriptSelectFileName = "select_product_name.sql";
    private String script;

    public DaoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.script = read(scriptSelectFileName);
    }

    public List<String> getProductName(String name) {
        List<String> products = namedParameterJdbcTemplate.queryForList(script
                , Map.of("name", name)
                , String.class);
        System.out.println(products);
        return products;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}