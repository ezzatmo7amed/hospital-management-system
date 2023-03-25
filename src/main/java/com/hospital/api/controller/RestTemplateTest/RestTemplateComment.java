package com.hospital.api.controller.RestTemplateTest;

import com.hospital.api.payload.RestTemplateTest.CommentDto;
import com.hospital.api.service.Imp.RestTemplateTest.RestTemplateCommentServive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("rt/")
public class RestTemplateComment {

    private final RestTemplateCommentServive service;

    @GetMapping("all")
    public ResponseEntity<List<CommentDto>> getAllComments(){
        return ResponseEntity.ok(service.getAllComments());
    }


    @PostMapping("addAll")
    public ResponseEntity<List<CommentDto>> addComments(){
        return ResponseEntity.ok(service.addComments());
    }
}
