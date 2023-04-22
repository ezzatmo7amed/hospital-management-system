package com.hospital.api.service.RestTemplateTest;

import com.hospital.api.payload.RestTemplateTest.CommentDto;

import java.util.List;

public interface RestTemplateCommentService {

     List<CommentDto> getAllComments();

     List<CommentDto> addComments();
     CommentDto getById(Long id);

}
