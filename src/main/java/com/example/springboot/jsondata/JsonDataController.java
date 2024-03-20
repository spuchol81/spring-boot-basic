package com.example.springboot.jsondata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/data")
public class JsonDataController {

    private final JsonDataRepository jsonDataRepository;

    @Autowired
    public JsonDataController(JsonDataRepository jsonDataRepository) {
        this.jsonDataRepository = jsonDataRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> createJsonData(@RequestBody String jsonData) {
        JsonData savedData = new JsonData();
        savedData.setJsonData(jsonData);

        JsonData createdData = jsonDataRepository.save(savedData);
        URI location = URI.create("/data/" + createdData.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping()
    public ResponseEntity<Iterable<JsonData>> findAll() {
        return ResponseEntity.ok(jsonDataRepository.findAll());
    }
    @GetMapping("/{id}")
    @ResponseBody
public ResponseEntity<String> getJsonDataById(@PathVariable Long id) {
    Optional<JsonData> jsonDataOptional = jsonDataRepository.findById(id);
    return jsonDataOptional.map(jsonData -> ResponseEntity.ok().body(jsonData.getJsonData()))
                            .orElse(ResponseEntity.notFound().build());
    }
}
