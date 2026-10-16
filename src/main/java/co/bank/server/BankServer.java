package co.bank.server;


import io.javalin.Javalin;
import  io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;          
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;



public class BankServer {

    private final Javalin bankServerApp ;


    public BankServer() {

        ClassLoaderTemplateResolver resolver = new  ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setCharacterEncoding("UTF-8");


        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        engine.addDialect(new LayoutDialect());

        this.bankServerApp = Javalin.create( config -> {
            config.staticFiles.add(staticFileConfig ->{
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/public";
                staticFileConfig.location = Location.CLASSPATH;
            });
        config.fileRenderer(new JavalinThymeleaf(engine));

        Routes.configure(this);

        });
    }

    public  void start(int port){
         this.bankServerApp.start(port);
    }

    public Javalin getServerinstence(){
        return this.bankServerApp;
    }

   

    public static void main(String[] args){
        BankServer server = new BankServer();
        server.start(7070);
    }
    


}