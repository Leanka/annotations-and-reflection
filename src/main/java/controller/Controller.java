package controller;

import annotations.WebRoute;

/**
 * Annotations are not inherited by overriding methods.
 * They need to be placed over each method as in interface, respectively,
 * either they won't be found by handlers
 */
public interface Controller <T>{

    @WebRoute("GET")
    T [] get();

    @WebRoute("GET")
    T get(String id);

    @WebRoute("POST")
    void add(T resource);

    @WebRoute("DELETE")
    void remove(String id);

    @WebRoute("PATCH")
    void update(String id); //pass data to update
}
