package shop.mtcoding.blog.love;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LoveRepository {
    private final EntityManager em;

    public Love findByUserIdAndBoardId(int userId, int boardId) {
        Query query = em.createQuery("select lo from  Love lo where lo.user.id = :userId and lo.board.id = :boardId", Love.class);
        query.setParameter("userId", userId);
        query.setParameter("boardId", boardId);

        try {
            return (Love) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public Long findByBoardId(int boardId) {
        Query query = em.createQuery("select count(lo) from Love lo where lo.board.id = :boardId");
        query.setParameter("boardId", 5);

        Long count = (Long) query.getSingleResult();
        return count;
    }
}
