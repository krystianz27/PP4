package pl.krystian.ecommerce.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class HelloController {
//
//    @GetMapping("/hello-world")
//    String hello(){
////        var name ="Krystian";
////        return String.format("Hello %s", name);
//        return "hello-world";
//    }
//}


@Controller
public class HelloController {
    @GetMapping("/hello")
    public String helloPage() {
        return "helloPage";
    }
}