package server.handler;

import com.sun.net.httpserver.HttpExchange;
import controller.Controller;
import controller.UserController;

import java.io.IOException;

public class RootHandler extends AbstractHandler{
    Class <? extends Controller> ctrlClass = UserController.class;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "Welcome to the main page!";
        sendResponse(httpExchange, response);
    }
}
