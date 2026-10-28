package co.bank.server;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import io.javalin.Javalin.*;

import java.util.HashMap;
import java.util.Map;

public class Routes {
    public static final String LOG_IN_PAGE ="/";
    public static final String HOME_PAGE = "/home";

    public static void configure(BankServer server){

        server.getServerinstence().get(LOG_IN_PAGE , ctx -> {
            try(InputStream in = Routes.class.getResourceAsStream("/public/index.html")){
                if(in == null){
                    throw new IllegalStateException();
                
                }

                ctx.html(new String(in.readAllBytes(),StandardCharsets.UTF_8));
            }
        });

        server.getServerinstence().post(LOG_IN_PAGE, ctx ->{
            String username = ctx.formParam("username");
            String email = ctx.formParam("email");
            ctx.sessionAttribute("username",email);
            ctx.redirect(HOME_PAGE);
        });
        

        server.getServerinstence().get(HOME_PAGE, ctx ->{
            String username = ctx.sessionAttribute("username");
            ctx.render("home.html", Map.of(
                "username", username 
            ));
        });

        server.getServerinstence().get("/expenses", ctx ->{
            String username = ctx.sessionAttribute("username");

            java.util.HashMap<String, Object> model = new java.util.HashMap<>();
            model.put("username",username);
            model.put("startDate",null);
            model.put("endDate",null);
            ctx.render("expenses.html",model);
        });

        server.getServerinstence().post("/expenses" , ctx ->{
            String username = ctx.sessionAttribute("username");

            String startDate = ctx.formParam("startDate");
            String endDate = ctx.formParam("endDate");


            java.util.HashMap<String, Object> model = new java.util.HashMap<>();
            model.put("username",username);
            model.put("startDate",startDate);
            model.put("endDate",endDate);
            ctx.render("expenses.html",model);

        });
    }
    
}
