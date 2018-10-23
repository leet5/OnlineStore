import entities.Item;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import services.ItemService;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import utils.HibernateUtil;

import java.util.logging.Logger;

public class Main
{
    public static void main(String[] args) throws Exception
    {
//        startServer();
        ItemService itemService = new ItemService();
        Item item = new Item();
        item.setName("iPhone 6S");
        item.setAmount(127);
        item.setAvailable(false);
        item.setPrice(24000F);
        item.setDescription("Brand new iPhone 6S with retina display");
        itemService.add(item);
        HibernateUtil.shutdown();
    }

    public static void startServer() throws Exception{
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new SignUpServlet()), "/signup");
        contextHandler.addServlet(new ServletHolder(new SignInServlet()), "/signin");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("src/main/resources/public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, contextHandler});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        Logger.getGlobal().info("Server Started");
        server.join();
    }
}
