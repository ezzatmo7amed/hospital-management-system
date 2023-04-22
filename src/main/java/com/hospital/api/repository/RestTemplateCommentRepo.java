package com.hospital.api.repository;

import com.hospital.api.model.RestTemplateTest.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestTemplateCommentRepo extends JpaRepository<Comment,Long> {


    Page<Comment> findAll(Pageable pageable);
}
