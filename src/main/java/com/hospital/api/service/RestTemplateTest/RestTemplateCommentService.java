package com.hospital.api.service.RestTemplateTest;

import com.hospital.api.model.RestTemplateTest.Comment;
import com.hospital.api.payload.RestTemplateTest.CommentDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RestTemplateCommentService {

     List<CommentDto> getAllCommentsFromExternal();
     Page<Comment> getAllPagination(int pageNumber,int size);

     List<CommentDto> addComments();
     CommentDto getById(Long id);

}
