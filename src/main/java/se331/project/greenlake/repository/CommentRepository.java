package se331.project.greenlake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
