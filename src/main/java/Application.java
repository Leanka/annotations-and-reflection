import server.MiniServer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) {
        MiniServer server = new MiniServer();
        try {
            server.launchServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
