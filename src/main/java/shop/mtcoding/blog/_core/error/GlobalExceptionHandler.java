package shop.mtcoding.blog._core.error;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.mtcoding.blog._core.error.ex.*;
import shop.mtcoding.blog._core.util.Resp;
import shop.mtcoding.blog._core.util.Script;

@RestControllerAdvice //에러를 터졌을때 파일,에러를 리턴할지 결정, @ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception400.class)
    public String ex400(Exception400 e) {
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(ExceptionApi400.class)
    public Resp<?> exApi400(ExceptionApi400 e) {
        return Resp.fail(400, e.getMessage());
    }


    //인증 안됨

    @ExceptionHandler(Exception401.class)
    public String ex401(Exception401 e) {
        return Script.href(e.getMessage(), "/login-form");
    }

    @ExceptionHandler(ExceptionApi401.class)
    public Resp<?> exApi401(ExceptionApi401 e) {
        return Resp.fail(401, e.getMessage());
    }

    //권한 없음
    @ExceptionHandler(Exception403.class)
    public String ex403(Exception403 e) {
        return Script.alert(e.getMessage());
    }

    @ExceptionHandler(ExceptionApi403.class)
    public Resp<?> exApi403(ExceptionApi403 e) {
        return Resp.fail(403, e.getMessage());
    }

    // 자원을 찾을수없음
    @ExceptionHandler(Exception404.class)
    public String ex404(Exception404 e) {
        return Script.alert(e.getMessage());
    }

    @ExceptionHandler(ExceptionApi404.class)
    public Resp<?> exApi404(ExceptionApi404 e) {
        return Resp.fail(404, e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public String exUnKnown(Exception e) {
        System.out.println("관리자님 보세요 :" + e.getMessage());
        return Script.back("관리자에게 문의해주세요");
    }

}


