/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.gameparticipants;

import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.enterprise.context.ApplicationScoped;

import org.glassfish.jersey.media.sse.EventOutput;

@ApplicationScoped
public class GameRoom {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private Map<String, List<gameparticipants>> rooms = new HashMap<>();

                //GameRoom Id , Game Particpant object (Broadcaster)
      private List<String> gamelist = new ArrayList<String>();      
           //room as r1
    public void add(EventOutput eo, String gameid) {
        List <gameparticipants> p = rooms.get(gameid);
        if(p == null){
            p = new ArrayList();
            rooms.put(gameid,p);
        }
        gameparticipants player = new gameparticipants();
        player.add(eo);
        rooms.get(gameid).add(player);
    }
    public void addcommonview(EventOutput e1,String gameid)
    {
        if(gamelist.contains(gameid))
        {
            gameparticipants p =new  gameparticipants();
          p.addcommonview(e1);
        }
        else
        {
            gamelist.add(gameid);
            gameparticipants p =new  gameparticipants();
             p.addcommonview(e1);
        }
         
          
      
    }

    
    public void publish(String gameid, String result, int p1, int p2) {
        
        List<gameparticipants> players = rooms.get(gameid);
         System.out.println(players);
        System.out.println("Game ID in publish"+gameid);
        if (players != null && players.isEmpty()) {        
            System.out.println("gameroom publish gamepatricapant p is null ");
            return;
        }
        System.out.println("entering method publish in gameroom before call ");
        players.add(new gameparticipants());
        for(gameparticipants p : players){
            p.publish(gameid, result, p1, p2);
        }
    }
    public void publishcommonview(int btn1,int btn2,String gameid, String result, int p1, int p2) {
 
        gameparticipants pp= new gameparticipants();
        System.out.println("Game ID in common view "+gameid);
       
        System.out.println("entering method publishcommonview in gameroom before call ");
            pp.publishcommonview( btn1,btn2,gameid, result, p1, p2);
            System.out.println("entering method publishcommonview in gameroom after call ");
               
         System.out.println("entering method publishcommonview in gameroom class");
           
          //  System.out.println("executed publish ");
        }
    }

