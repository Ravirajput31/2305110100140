package com.affordmed.notifications;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class NotificationApplication {
    private static final int PORT = 8082;

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
            server.createContext("/notifications", new NotificationRouteHandler());
            
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("Notification system live on port " + PORT);
        } catch (IOException e) {
            System.err.println("Notification server boot crash: " + e.getMessage());
        }
    }

    public static void sendPayload(HttpExchange exchange, int statusCode, String responseText) throws IOException {
        byte[] payloadBytes = responseText.getBytes("UTF-8");
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, payloadBytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(payloadBytes);
        }
    }
}