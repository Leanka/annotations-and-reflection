package controller;

import annotations.WebRoute;
import model.User;

public class UserController implements Controller <User>{
    private final User user = new User("id1", "first user");

    @Override
    @WebRoute("GET")
    public User [] get() {
        System.out.printf("User controller, %s(), param: %s", "get", "NO PARAMS %n");
        User [] users = new User[2];
        users[0] = user;
        users[1] = new User("id2", "second user");

        return users;
    }

    @Override
    @WebRoute("GET")
    public User get(String id) {
        System.out.printf("User controller, %s(), param: %s %n", "get", id);
        return user;
    }

    @Override
    @WebRoute("POST")
    public void add(User resource) {
        System.out.printf("User controller, %s(), param: %s %n", "add", resource);

    }

    @Override
    @WebRoute("DELETE")
    public void remove(String id) {
        System.out.printf("User controller, %s(), param: %s %n", "remove", id);

    }

    @Override
    @WebRoute("PATCH")
    public void update(String id) {
        System.out.printf("User controller, %s(), param: %s %n", "update", id);

    }
}
