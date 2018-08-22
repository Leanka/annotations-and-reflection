# annotations-and-reflection

### Task

Your task is to create a mini-webserver that uses annotations to route browser requests to specific handler methods, basically a simpler version of routing mechanism.

### Details

Use Java 8's built-in webserver:

 - see the [documentation](http://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/package-summary.html#package.description) of its features;
 - use [this](http://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/HttpExchange.html) ancient Java class `HttpExchange` which encapsulates an HTTP requests and response as well;
 - [here's](https://stackoverflow.com/a/3732328) a quick start. guide.

Your task is to create a custom annotation called `@WebRoute` which can be used to annotate methods. Methods annotated with `@WebRoute("path")` will be your HTTP request handlers. They are called whenever a request accepted by the webserver matches the `"path"` value in a `@WebRoute` annotation. Use reflection to find the right method for an incoming request.

Here is an example:

```java
@WebRoute("/test")
void onTest(HttpExchange requestData) {
    // Here goes the code to handle all requests going to myserver.com/test
    // and to return something
}
```

---

### Extra features

Support GET, POST, etc. as well. You will need to name the parameters in your annotation, for example:

```java
@WebRoute(method=POST, path = "/users")
void onTest(HttpExchange requestData) {
    // here goes the code to handle POST requests going to myserver.com/users
}
```

Another feature is to extract variables from the path itself:

```java
@WebRoute("/user/<userName>")
void onTest(HttpExchange requestData, String userName) {     
    // here goes the code to handle all requests going to myserver.com/user/joe
}
```
