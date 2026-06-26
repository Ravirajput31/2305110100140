package com.affordmed.scheduler;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MaintenanceApplication {
    private static final int PORT = 8081;

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
            
            server.createContext("/depots", new DepotRouteHandler());
            server.createContext("/vehicles", new VehicleRouteHandler());
            
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("Scheduler core engine running smoothly on port " + PORT);
        } catch (IOException e) {
            System.err.println("Core engine initialization failure: " + e.getMessage());
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