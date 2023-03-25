package com.hospital.api.service.Imp.RestTemplateTest;

import com.hospital.api.payload.RestTemplateTest.CommentDto;

import java.util.List;

public interface RestTemplateCommentServive {

    public List<CommentDto> getAllComments();

    public List<CommentDto> addComments();
}
