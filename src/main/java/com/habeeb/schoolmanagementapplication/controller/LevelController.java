package com.habeeb.schoolmanagementapplication.controller;


import com.habeeb.schoolmanagementapplication.entity.Level;
import com.habeeb.schoolmanagementapplication.service.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/level")
public class LevelController {

    LevelService levelService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addClass(@RequestBody Level level){
        levelService.addLevel(level);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/level/{levelId}")
    public ResponseEntity<Level> updateLevel(@PathVariable Long levelId,@RequestBody Level level){
        return new ResponseEntity<>(levelService.updateLevel(levelId,level),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Level>> getAllLevels(){
        return new ResponseEntity<>(levelService.getAllLevels(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/level/{levelId}")
    public ResponseEntity<Level> deleteLevel(@PathVariable Long levelId){
        levelService.deleteLevel(levelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}