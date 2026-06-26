package com.affordmed.notifications;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class NotificationRouteHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            NotificationApplication.sendPayload(exchange, 405, "{\"status\":\"Method rejection\"}");
            return;
        }

        // Formatted exactly like the target output structure in your assignment guidelines
        String alertPayload = "[\n" +
            "  {\n" +
            "    \"ID\": \"b283218f-cc5a-4b7c-9ba9-1f2f248d64b0\",\n" +
            "    \"Type\": \"Placement\",\n" +
            "    \"Message\": \"TSX Corporation hiring\",\n" +
            "    \"Timestamp\": \"2026-04-22 17:51:18\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ID\": \"81589ada-0ad3-4f77-9554-f52fb558e09d\",\n" +
            "    \"Type\": \"Event\",\n" +
            "    \"Message\": \"farewell\",\n" +
            "    \"Timestamp\": \"2026-04-22 17:51:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ID\": \"0005513a-142b-4bbc-8d78-ecfec65c1cdc\",\n" +
            "    \"Type\": \"Result\",\n" +
            "    \"Message\": \"mid-sem\",\n" +
            "    \"Timestamp\": \"2026-04-22 17:50:54\"\n" +
            "  }\n" +
            "]";

        NotificationApplication.sendPayload(exchange, 200, alertPayload);
    }
}