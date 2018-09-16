package server.handler;

import annotations.WebRoute;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import controller.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractHandler implements HttpHandler {


    private String [] getUrlParts(HttpExchange exchange){
        String fullPath = exchange.getRequestURI().getPath();
        String contextPath = exchange.getHttpContext().getPath();
        String urlData = fullPath.substring(contextPath.length());
        return urlData.split("/");
    }

}
