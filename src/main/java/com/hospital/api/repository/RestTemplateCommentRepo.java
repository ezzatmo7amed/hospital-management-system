package com.hospital.api.repository;

import com.hospital.api.model.RestTemplateTest.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestTemplateCommentRepo extends JpaRepository<Comment,Long> {
}
