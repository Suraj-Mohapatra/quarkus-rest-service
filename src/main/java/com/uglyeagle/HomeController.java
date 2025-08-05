package com.uglyeagle;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;

@Path("/hello")
public class HomeController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST in plain text";
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloJson() {
        return "{\"message\": \"Hello from Quarkus REST in JSON\"}";
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public String helloXml() {
        return "<message>Hello from Quarkus REST in XML</message>";
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String helloHtml() {
        return "<html><body><h1>Hello from Quarkus REST in HTML</h1></body></html>";
    }

    @GET
    @Path("/json-map")
    @Produces(MediaType.APPLICATION_JSON)
    // this method shows improper behaviour in response which needs to be fixed
    public java.util.Map<String, Object> helloJsonObject() {
        var response = new HashMap<String, Object>();
        response.put("message", "Hello from Quarkus REST using HashMap");
        response.put("status", "success");
        System.out.println(response);
        return response;
    }


}
