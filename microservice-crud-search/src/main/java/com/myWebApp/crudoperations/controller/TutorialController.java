package com.myWebApp.crudoperations.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myWebApp.crudoperations.model.Tutorial;
import com.myWebApp.crudoperations.repository.TutorialRepository;



@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialRepository tutorialRepository;

  @GetMapping("/tutorials/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
    try {
      List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping ("/tutorials/getbytitle")
  public ResponseEntity<List<Tutorial>> findByTitle(@RequestParam("title") String title) {
	  try {
		  List<Tutorial> tutorials = tutorialRepository.findByTitleContaining(title);
		  
		  if (tutorials.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  } catch (Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }

}
