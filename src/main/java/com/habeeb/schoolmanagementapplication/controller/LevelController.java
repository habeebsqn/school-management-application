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
public class LevelController {

    LevelService levelService;

    @PostMapping("/level/add")
    public ResponseEntity<HttpStatus> addClass(@RequestBody Level level){
        levelService.addLevel(level);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/level/update/{levelId}")
    public ResponseEntity<Level> updateLevel(@PathVariable Long levelId,@RequestBody Level level){
        return new ResponseEntity<>(levelService.updateLevel(levelId,level),HttpStatus.ACCEPTED);
    }

    @GetMapping("/level/all")
    public ResponseEntity<List<Level>> getAllLevels(){
        return new ResponseEntity<>(levelService.getAllLevels(),HttpStatus.OK);
    }

    @DeleteMapping("/level/delete/{levelId}")
    public ResponseEntity<Level> deleteLevel(@PathVariable Long levelId){
        levelService.deleteLevel(levelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}