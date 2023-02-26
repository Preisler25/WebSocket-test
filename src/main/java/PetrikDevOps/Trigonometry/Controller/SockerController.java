package PetrikDevOps.Trigonometry.Controller;

import PetrikDevOps.Trigonometry.Modul.Click;
import PetrikDevOps.Trigonometry.Modul.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class SockerController {

    @MessageMapping("/click")
    @SendTo("/topic/greetings")
    public Click click(User message) throws InterruptedException {
        return new Click("Hello, " +
                HtmlUtils.htmlEscape(message.getName()));
    }
}