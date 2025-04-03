package shop.mtcoding.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String t1() {
        return "board/list";
    }

    @GetMapping("/board/1")
    public String t2() {
        return "board/detail";
    }

    @GetMapping("/board/save-form")
    public String t3() {
        return "board/save-form";
    }

    @GetMapping("/board/1/update-form")
    public String t4() {
        return "board/update-form";
    }

    @GetMapping("/join-form")
    public String t5() {
        return "user/join-form";
    }

    @GetMapping("/login-form")
    public String t6() {
        return "user/login-form";
    }

    @GetMapping("/user/update-form")
    public String t7() {
        return "user/update-form";
    }


}
