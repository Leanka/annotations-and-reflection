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



    private Method getMethod(Class ctrlClass, String annotation, int parametersCount){

        Optional <Method> method =
                Arrays.stream(ctrlClass.getMethods())
                .filter(meth -> meth.getAnnotation(WebRoute.class).value().equals(annotation))
                .filter(meth -> meth.getParameterCount() == parametersCount)
                .findFirst();

        return method.orElse(null);
    }

    private String [] getParameter(HttpExchange exchange){
        String [] args = {};
        String [] urlParts = getUrlParts(exchange);
        if(urlParts.length >= 2){
            String temp = urlParts[1].trim();
            if(!temp.isEmpty()){
                args = Arrays.copyOfRange(urlParts,1, 2);
            }
        }
        return args;
    }

    private String [] getUrlParts(HttpExchange exchange){
        String fullPath = exchange.getRequestURI().getPath();
        String contextPath = exchange.getHttpContext().getPath();
        String urlData = fullPath.substring(contextPath.length());
        return urlData.split("/");
    }

    void sendResponse(HttpExchange exchange, String response) throws IOException {
        response = "<h1>"+response+"</h1>";
        byte [] responseInBytes = response.getBytes();
        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody()
                .write(responseInBytes);
//                .close();

    }

    String formatListForResponse(Object [] objects){
        return Arrays.stream(objects)
                .map(obj -> String.format("<p>%s</p>", obj))
                .collect(Collectors.joining("\n", "All users:", "The end!"));
    }

}
