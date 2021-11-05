package com.example.in100gramm.repository;

import com.example.in100gramm.entity.Comment;
import com.example.in100gramm.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
List<Comment> findAllByPost(Post post);
Comment findByIdAndUserId(Long postId, Long userId);

}
