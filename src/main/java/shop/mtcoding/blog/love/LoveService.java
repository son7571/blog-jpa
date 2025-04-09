package shop.mtcoding.blog.love;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public LoveResponse.DeleteDTO 좋아요취소(Integer id) {
        Love lovePs = loveRepository.findById(id);
        if (lovePs == null) throw new RuntimeException("좋아요 없는데 굳이");

        Integer boardId = lovePs.getBoard().getId();

        loveRepository.deleteById(id);

        Long loveCount = loveRepository.findByBoardId(boardId);

        return new LoveResponse.DeleteDTO(loveCount.intValue());
    }

}
