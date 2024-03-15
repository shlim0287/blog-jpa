package com.estsoft.blogjpa.repository;

import com.estsoft.blogjpa.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByArticleId(Long id);

    Reply findByArticleIdAndId(Long articleId, Long commentId);
}
