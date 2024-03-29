package com.hospital.api.service.RestTemplateTest;

import com.hospital.api.exception.NotFoundException;
import com.hospital.api.model.RestTemplateTest.Comment;
import com.hospital.api.payload.RestTemplateTest.CommentDto;
import com.hospital.api.repository.RestTemplateCommentRepo;
import com.hospital.api.util.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateCommentServiceImp implements RestTemplateCommentService {

    private final RestTemplateCommentRepo commentRepo;

    @Value("${spring.datasource.comments}")
    String COMMENT_URL;

    public RestTemplateCommentServiceImp(RestTemplateCommentRepo commentRepo) {

        this.commentRepo = commentRepo;
    }

    RestTemplate restTemplate= new RestTemplate();
    @Override
    public List<CommentDto> getAllCommentsFromExternal() {


        ResponseEntity<List> response = restTemplate.getForEntity(COMMENT_URL, List.class);

        return response.getBody();
    }

    @Override
    public Page<Comment> getAllPagination(int pageNumber,int size) {
        Pageable page = PageRequest.of(pageNumber,size);
        return commentRepo.findAll(page);
    }

    @Override
    public List<CommentDto> addComments() {

        List<Comment> comments = Mapper.mapAll(getAllCommentsFromExternal(), Comment.class);
        commentRepo.saveAll(comments);
        return Mapper.mapAll(comments, CommentDto.class);
    }

    @Override
    public CommentDto getById(Long id) {
        try{
            ResponseEntity<CommentDto> response = restTemplate.getForEntity(COMMENT_URL+"/"+id, CommentDto.class);

            response.getStatusCode();

            Boolean statusCode = response.getStatusCode().is2xxSuccessful();
            if (statusCode != true){
                throw new NotFoundException("resource not found with id : "+id);
            }else{
                return response.getBody();
            }
        }catch (Exception ex){
            throw new NotFoundException("Invalid Id : "+id);
        }


    }
}
