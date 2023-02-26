package PetrikDevOps.Trigonometry.Controller;

import PetrikDevOps.Trigonometry.Modul.Click;
import PetrikDevOps.Trigonometry.Modul.Data;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class SockerController {

    List<Data> data_list = new java.util.ArrayList<>();

    @MessageMapping("/click")
    @SendTo("/topic/greetings")
    public Click click(Data data) throws InterruptedException {
        if (data_list.size() == 1) {
            data_list.add(data);
            System.out.println(data_list);
            data_list.clear();
            return new Click("Hello, " + HtmlUtils.htmlEscape(data.getX() + " " + data.getY()) + "!");
        }
        data_list.add(data);
        return new Click("Hello, " + HtmlUtils.htmlEscape(data.getX() + " " + data.getY()) + "!");
    }
}