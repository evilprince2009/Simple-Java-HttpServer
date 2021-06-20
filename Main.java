import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        int port = 5700;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new RequestHandler());
        server.setExecutor(null);
        server.start();
    }

    static class RequestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpThtrad) throws IOException {
            String response = "Hello World from a Java Back End";
            httpThtrad.sendResponseHeaders(200, response.length());
            OutputStream responseBody = httpThtrad.getResponseBody();
            responseBody.write(response.getBytes());
            responseBody.close();
        }
    }
}
