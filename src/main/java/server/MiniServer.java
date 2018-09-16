package server;

import com.sun.net.httpserver.HttpServer;
import server.handler.RootHandler;
import server.handler.UsersHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MiniServer {
    public void launchServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8008), 0);
        server.createContext("/users", new UsersHandler());
        server.createContext("/", new RootHandler());
        server.setExecutor(null);
        server.start();
    }

}
