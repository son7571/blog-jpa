package shop.mtcoding.blog.board;

import lombok.Data;
import shop.mtcoding.blog.user.User;


public class BoardRequest {

    @Data
    public static class SaveDTO {
        public String title;
        public String content;
        public String isPublic;

        public Board toEntity(User user) {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .isPublic(isPublic == null ? true : false)
                    .user(user) // user객체 필요
                    .build();
        }

    }

    @Data
    public static class UpdateDTO {
        public String title;
        public String content;
        public String isPublic;

        public Board toEntity(User user) {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .isPublic(isPublic == null ? true : false)
                    .user(user) // user객체 필요
                    .build();
        }
    }
}
