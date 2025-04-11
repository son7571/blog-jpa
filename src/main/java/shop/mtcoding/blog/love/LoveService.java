package shop.mtcoding.blog.love;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.error.ex.ExceptionApi403;
import shop.mtcoding.blog._core.error.ex.ExceptionApi404;

@RequiredArgsConstructor
@Service
public class LoveService {
    private final LoveRepository loveRepository;


    @Transactional
    public LoveResponse.SaveDTO 좋아요(LoveRequest.SaveDTO reqDTO, Integer sessionUserId) {
        Love lovePs = loveRepository.save(reqDTO.toEntity(sessionUserId));
        Long loveCount = loveRepository.findByBoardId(reqDTO.getBoardId());
        return new LoveResponse.SaveDTO(lovePs.getId(), loveCount.intValue());
    }

    @Transactional
    public LoveResponse.DeleteDTO 좋아요취소(Integer id, Integer sessionUserId) {
        Love lovePs = loveRepository.findById(id);
        if (lovePs == null) throw new ExceptionApi404("좋아요가 존재하지 않습니다");

        // 권한 체크(lovePs.getUser().getId() 비교 sessionUserId)
        if (!lovePs.getUser().getId().equals(sessionUserId)) {
            throw new ExceptionApi403("권한이 없습니다");
        }
        //Integer는 equal로 하기

        Integer boardId = lovePs.getBoard().getId();

        loveRepository.deleteById(id);

        Long loveCount = loveRepository.findByBoardId(boardId);

        return new LoveResponse.DeleteDTO(loveCount.intValue());
    }

}
