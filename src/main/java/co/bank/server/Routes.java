package co.bank.server;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import io.javalin.Javalin.*;

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

        server.getServerinstence().post(LOG_IN_PAGE, ctx -> {
            String username = ctx.formParam("Username");
            
        });

        
    }
    
}
