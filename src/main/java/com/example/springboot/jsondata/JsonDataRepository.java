package com.example.springboot.jsondata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonDataRepository extends CrudRepository<JsonData, Long> {
}