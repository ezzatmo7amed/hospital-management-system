package com.hospital.api.service.Imp.RestTemplateTest;

import com.hospital.api.model.RestTemplateTest.Comment;
import com.hospital.api.payload.RestTemplateTest.CommentDto;
import com.hospital.api.repository.RestTemplateCommentRepo;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class RestTemplateTestImp implements RestTemplateCommentServive {

    private final RestTemplateCommentRepo commentRepo;

    //@Value("${spring.comment}")
     final String commentUrl = "https://jsonplaceholder.typicode.com/comments";
    @Override
    public List<CommentDto> getAllComments() {
        RestTemplate restTemplate= new RestTemplate();

        ResponseEntity<CommentDto[]> response = restTemplate.getForEntity(commentUrl, CommentDto[].class);

        return List.of(response.getBody());
    }

    @Override
    public List<CommentDto> addComments() {


        List<Comment> commnets = Mapper.mapAll(getAllComments(), Comment.class);

        commentRepo.saveAll(commnets);
        return Mapper.mapAll(commnets, CommentDto.class);
    }
}
