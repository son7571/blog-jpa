package shop.mtcoding.blog.reply;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class ReplyRepository {
    private final EntityManager em;

    public List<Reply> findAllByBoardId(int boardId) {
        Query query = em.createQuery("select r from Reply r join fetch r.user where r.board.id = :boardId", Reply.class);
        query.setParameter("boardId", boardId);
        List<Reply> replies = query.getResultList();
        return replies;
    }


    public Reply findById(Integer id) {
        return em.find(Reply.class, id);
    }

    public Reply save(Reply reply) {
        em.persist(reply);
        return reply;

    }

    public void deleteById(Integer id) {
        em.createQuery("delete from Reply r where r.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
