package server.handler;

import com.sun.net.httpserver.HttpExchange;
import controller.Controller;
import controller.UserController;
import java.io.IOException;

public class UsersHandler extends AbstractHandler {
    Class <? extends Controller> ctrlClass = UserController.class;

    @Override
    public void handle(HttpExchange httpExchange) {
        try {
            commonHandle(httpExchange, ctrlClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
