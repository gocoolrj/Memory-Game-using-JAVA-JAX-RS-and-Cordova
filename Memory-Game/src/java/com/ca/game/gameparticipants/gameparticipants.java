/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.gameparticipants;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;

/**
 *
 * @author a0123055u
 */
 @ApplicationScoped
public class gameparticipants {
      
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private SseBroadcaster broadcaster = new SseBroadcaster();
    
    public void add(EventOutput player) {
        Lock l = lock.writeLock();
        l.lock();
        try {
            broadcaster.add(player);
        } finally {
            l.unlock();
        }
    }
    public void addcommonview(EventOutput gameid) {
        Lock l = lock.writeLock();
        l.lock();
        try {
            broadcaster.add(gameid);
        } finally {
            l.unlock();
        }
    }
    
    public void publish(String gameid,String result,int p1,int p2) {
       System.out.println("entering method publish in gameparticipants class"+gameid);
       String p11=Integer.toString(p1);
       String p12=Integer.toString(p2);
       System.out.println("Before outbound execution");
        OutboundEvent event = new OutboundEvent.Builder()
                .mediaType(MediaType.TEXT_PLAIN_TYPE)
                .data(String.class,gameid+":"+result+":"+p11+":"+ p12)
                .name(gameid)
                .build();
         
        Lock l = lock.readLock();
        l.lock();
        try {
            broadcaster.broadcast(event);
            System.out.println("after broadcasting  "+event.toString());
        } finally {
            l.unlock();
        }
     } 
     public void publishcommonview(int btn1, int btn2,String gameid,String result,int p1,int p2) {
       System.out.println("entering method publish in gameparticipants class"+gameid);
       String btn11=Integer.toString(btn1);
       String btn22=Integer.toString(btn2);
       String p11=Integer.toString(p1);
        String p12=Integer.toString(p2);
       System.out.println("Before outbound execution2");
        OutboundEvent event = new OutboundEvent.Builder()
                .mediaType(MediaType.TEXT_PLAIN_TYPE)
                .data(String.class,btn11+":"+btn22+":"+gameid+":"+result+":"+p11+":"+ p12)
                .name(btn11)
                .build();
        //System.out.println(event.toString());
        
        Lock l = lock.readLock();
        l.lock();
        try {
            broadcaster.broadcast(event);
            System.out.println("after broadcasting2  "+event.toString());
        } finally {
            l.unlock();
        }
    }
}
