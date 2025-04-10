package shop.mtcoding.blog.reply;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Table(name = "Reply_tb")
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public Reply(Timestamp createdAt, Board board, User user, String content, Integer id) {
        this.createdAt = createdAt;
        this.board = board;
        this.user = user;
        this.content = content;
        this.id = id;
    }
}
