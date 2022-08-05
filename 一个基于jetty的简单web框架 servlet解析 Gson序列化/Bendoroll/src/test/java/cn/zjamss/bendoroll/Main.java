package cn.zjamss.bendoroll;

import com.sun.javafx.binding.StringFormatter;
import com.zjamss.bendoroll.Bendoroll;
import com.zjamss.bendoroll.exception.BaseException;
import com.zjamss.bendoroll.handler.HandlerType;
import org.eclipse.jetty.server.Authentication;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: cn.zjamss.bendoroll
 * @Description:
 * @Author: ZJamss
 * @Create: 2022-08-04 09:32
 **/
public class Main {
    /**
     * Start Programming
     * This example to build and run a simple web application
     */
    @Test
    public void helloWorldTest() {
        Bendoroll app = Bendoroll.create();
        app.get("/example", ctx -> {
            // 响应
            ctx.html("Hello World!");
        });
        app.start();
    }




    /**
     * Build an `ExceptionHandler` to handle some exceptions in the api
     *
     */
    @Test
    public  void exceptionHandlerTest() {
        Bendoroll app = Bendoroll.create(8080);

        app.post("/user", ctx -> {
            final User user = ctx.body(User.class);
            //....  do something in Dao
//            user.desc = "22";
//            user.name = "admin";
            if (user == null) {
                throw new RuntimeException("cant resolve the request body");
            }
            ctx.ok();
        });
        app.exception(RuntimeException.class, ((e, ctx) -> {
            //do something to process the exception, such as log...
            ctx.error(400);
        }));
        app.start();
    }

    /**
     * Examples
     * There exist some examples about how to use the framework
     * Build some restful api
     */
    @Test
    public  void restfulTest() {
        Bendoroll app = Bendoroll.create(8080);
        app.get("/user", ctx -> {
            ctx.json(new User("ZJamss", "Dont have delusion"));
        });
        app.post("/user", ctx -> {
            final User user = ctx.body(User.class);
            //....  do something in Dao 
            ctx.ok();
        });
        app.put("/user", ctx -> {
            final User user = ctx.body(User.class);
            //.... do something in Dao 
            ctx.ok();
        });
        app.delete("/user", ctx -> {
            final User user = ctx.body(User.class);
            //....  do something in Dao 
            ctx.ok();
        });
        app.start();
    }

    
    static class User {
        private String name;
        private String desc;

        public User(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }
    }

    ;

}
