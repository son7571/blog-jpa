package shop.mtcoding.blog.reply;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog.user.User;


@AllArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    @Transactional
    public void 댓글쓰기(ReplyRequest.SaveDTO reqDTO, User sessionUser) {
        replyRepository.save(reqDTO.toEntity(sessionUser));
    }

    @Transactional
    public Integer 댓글삭제(Integer id, Integer sessionUserId) {
        Reply replyPS = replyRepository.findById(id);

        if (replyPS == null) {
            throw new RuntimeException("댓글이없습니다");
        }
        if (!replyPS.getUser().getId().equals(sessionUserId)) {
            throw new RuntimeException("아이디가 일치하지 않습니다.");
        }
        int boardId = replyPS.getBoard().getId();

        replyRepository.deleteById(id);

        return boardId;
    }
}

