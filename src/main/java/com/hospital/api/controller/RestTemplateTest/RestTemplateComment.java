package com.hospital.api.controller.RestTemplateTest;

import com.hospital.api.payload.RestTemplateTest.CommentDto;
import com.hospital.api.service.RestTemplateTest.RestTemplateCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("rt/")
public class RestTemplateComment {

    private final RestTemplateCommentService service;

    @GetMapping("all")
    public ResponseEntity<List<CommentDto>> getAllComments(){
        return ResponseEntity.ok(service.getAllComments());
    }


    @PostMapping("addAll")
    public ResponseEntity<List<CommentDto>> addComments(){
        return ResponseEntity.ok(service.addComments());
    }
    @GetMapping("{id}")
    public ResponseEntity<CommentDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
}
