package com.example.backend.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository  extends JpaRepository <Comment, UUID> {
    
}
