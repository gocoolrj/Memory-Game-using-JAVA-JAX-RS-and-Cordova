/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import com.ca.game.model.gamerecord;
import com.ca.game.model.memorygame;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author a0123055u
 */

@Stateless
public class GameIdGeneratorBean {

    

    @PersistenceContext
    private EntityManager em2;
    @Inject private Player player;
    @Inject PlayerStore playerstore;

    public List<gamerecord> searchgameid() {
        TypedQuery<gamerecord> selectquery = em2.createQuery("select g from gamerecord  g ", gamerecord.class);
        List<gamerecord> r = selectquery.getResultList();
        return r;
    }

    public int GameIdGenerator(String playerid1) {
        String g_id;
        String playerid2="";
        TypedQuery<gamerecord> selectquery = em2.createQuery("select g from gamerecord  g ", gamerecord.class);

        if (selectquery != null) {
            List<gamerecord> r = selectquery.getResultList();
            Collections.sort(r, new sortgameid());
            String temp = "";
            for (gamerecord m : r) {
                temp = m.getGameid();
            }

            int id = Integer.parseInt(temp.substring(3));

            g_id = "gid" + (id + 1);
             Map<String,List<Player>>listofplayers =playerstore.getPlayerstore();
            
            List<Player> pllist= listofplayers.get(g_id);
            if(pllist!=null)
            {
            int index;
            
            for(Player p : pllist )
            {
                if(p.getPlayerid()==playerid1)
                {}   
                else
                {
                   player.setPlayerid(playerid1);
                   
                   pllist.add(player.createcopy());
                   
                   
                }
                    
            }
            }
            else
            {
               player.setPlayerid(playerid1);
               pllist.add(player.createcopy());
            }
            
           
            
            
           
        } else {
            g_id = "gid1";
            

        }
        TypedQuery<memorygame> insertquery = (TypedQuery<memorygame>) em2.createNativeQuery("insert into gamerecord (gameid,playerid1,playerid2) VALUES(?,?,?)");

        insertquery.setParameter(1, g_id);
        insertquery.setParameter(2, playerid1);
         insertquery.setParameter(3, playerid2);

        insertquery.executeUpdate();
        
           
            
        
        return 1;
    }
}
