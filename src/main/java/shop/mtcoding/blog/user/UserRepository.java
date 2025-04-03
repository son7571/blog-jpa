package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;


    public void save(String username, String password, String email) {
        Query query = em.createNativeQuery("insert into user_tb(username, password, email, created_at) values (?, ?, ?,now())");
        query.setParameter(1, username);
        query.setParameter(2, password);
        query.setParameter(3, email);
        query.executeUpdate();
    }


    public User findByUsername(String username) {
        Query query = em.createNativeQuery("select * from user_tb where username = ?", User.class);
        query.setParameter(1, username);
        return (User) query.getSingleResult();
    }
}
