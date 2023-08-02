package com.habeeb.schoolmanagementapplication.service;

import com.habeeb.schoolmanagementapplication.entity.Level;
import com.habeeb.schoolmanagementapplication.execption.EntityNotFoundException;
import com.habeeb.schoolmanagementapplication.repository.LevelRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LevelService {

    LevelRepo levelRepo;

    public void addLevel(Level level){
        levelRepo.save(level);
    }

    public Level getLevel(Long levelId){
        Optional<Level> level=levelRepo.findById(levelId);
        if(level.isPresent()){
            return level.get();
        }else throw new EntityNotFoundException(levelId,Level.class);
    }

    public List<Level> getAllLevels()
    {
        return (List<Level>) levelRepo.findAll();

    }

    public Level updateLevel(Long levelId,Level level){
        Level updateLevel=getLevel(levelId);
        updateLevel.setName(level.getName());
        updateLevel.setSchool(level.getSchool());
        return levelRepo.save(updateLevel);
    }

    public void deleteLevel(Long levelId){
         levelRepo.deleteById(levelId);
    }


}