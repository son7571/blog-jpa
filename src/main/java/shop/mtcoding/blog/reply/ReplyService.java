package shop.mtcoding.blog.reply;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

}
