package PetrikDevOps.Trigonometry.Controller;

import PetrikDevOps.Trigonometry.Modul.HypotenRec;
import PetrikDevOps.Trigonometry.Modul.Hypotenuse;
import PetrikDevOps.Trigonometry.Modul.Data;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class SocketController {

    List<Data> data_list = new java.util.ArrayList<>();

    @MessageMapping("/click")
    @SendTo("/ws/trieng")
    public Hypotenuse click(Data data) throws InterruptedException {

        if (data_list.size() == 1) {
            data_list.add(data);
            System.out.println(data_list);
            HypotenRec rec = calculate(data_list);
            return new Hypotenuse(rec.getLength(), rec.getAngle(), data_list.get(0).getX(), data_list.get(0).getY()- ((data_list.get(0).getY() - data_list.get(1).getY())/2));
        }
        else{
            data_list.clear();
            data_list.add(data);
            return new Hypotenuse();
        }
    }

    public HypotenRec calculate(List<Data> data_list) {
        int x1 = data_list.get(0).getX();
        int y1 = data_list.get(0).getY();

        int x2 = data_list.get(1).getX();
        int y2 = data_list.get(1).getY();

        int x = x1 - x2;
        int y = y1 - y2;

        System.out.println(x + " " + y);

        float distance = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        float angle = (float) Math.toDegrees(Math.atan2(y, x));

        System.out.println("Distance: " + distance);
        System.out.println("Angle: " + angle);

        return new HypotenRec(distance, angle);
    }
}