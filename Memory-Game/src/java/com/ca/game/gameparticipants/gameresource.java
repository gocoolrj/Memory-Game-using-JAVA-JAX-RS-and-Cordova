/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.gameparticipants;


import com.ca.game.servlet.Game;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.SseFeature;

/**
 *
 * @author a0123055u
 */ @RequestScoped
@Path("/game/{gameid}")

public class gameresource {
      
   
    @Inject GameRoom mulitiplerooms;   
    @Inject Game g1;
  
    
    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public Response get(@PathParam("gameid") String gameid,@PathParam("playerid") String plid) {
        EventOutput eo = new EventOutput();
        EventOutput eo1= new EventOutput();
        System.out.println(">>> new particpants"+ gameid);
        g1.setGameid(gameid);
        g1.setPlayerid(plid);
        System.out.println("gameid"+plid);
        // list of games , player id save partivular romm irka 
        mulitiplerooms.add(eo, gameid);
        mulitiplerooms.addcommonview(eo1,gameid);
        return (Response.ok(eo).build());
        
    }
 }
  
  

