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
        System.out.println(data_list);
        if (data_list.size() == 1) {
            data_list.add(data);
            System.out.println(data_list);
            calculate(data_list);
            data_list.clear();
            return new Click("Hello, " + HtmlUtils.htmlEscape(data.getX() + " " + data.getY()) + "!");
        }
        data_list.add(data);
        return new Click("Hello, " + HtmlUtils.htmlEscape(data.getX() + " " + data.getY()) + "!");
    }

    public int calculate(List<Data> data_list) {
        int x1 = data_list.get(0).getX();
        int y1 = data_list.get(0).getY();

        int x2 = data_list.get(1).getX();
        int y2 = data_list.get(1).getY();

        int x = x1 - x2;
        int y = y1 - y2;

        float distance = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        float angle = (float) Math.atan2(y, x);

        System.out.println("Distance: " + distance);
        System.out.println("Angle: " + angle);
        return 0;
    }
}