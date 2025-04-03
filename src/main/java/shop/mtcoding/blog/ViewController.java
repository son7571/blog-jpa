package shop.mtcoding.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String list() {
        return "board/list";
    }

    @GetMapping("/t2")
    public String t2() {
        return "board/detail";
    }

    @GetMapping("/t3")
    public String t3() {
        return "board/save-form";
    }

    @GetMapping("/t4")
    public String t4() {
        return "board/update-form";
    }


    @GetMapping("/t6")
    public String t6() {
        return "user/login-form";
    }

    @GetMapping("/t7")
    public String t7() {
        return "user/update-form";
    }


}
