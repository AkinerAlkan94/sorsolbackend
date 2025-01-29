package com.ozgoygoy.sorsolbackend.controller;

import com.ozgoygoy.sorsolbackend.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
public class SorController {
    private final ActionService actionService;

    @Autowired
    public SorController(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping(value = "/sor", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sor(@RequestBody String input) throws Exception {
        return ResponseEntity.ok(actionService.sor(input));
    }
}
