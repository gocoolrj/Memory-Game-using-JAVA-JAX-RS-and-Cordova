/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.gameparticipants;

import com.ca.game.model.memorygame;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author a0123055u
 */
@Stateless
public class UpdateScoreTriesBean {
        @PersistenceContext
    private EntityManager em2;
        
        
        public void updatescore(String score1,String plid)
        {
             TypedQuery<memorygame> updatequery1 = em2.createQuery("update memorygame set score=:score1 where playerid=:plid ", memorygame.class);
             updatequery1.setParameter("score1", score1);
             updatequery1.setParameter("plid",plid);
             updatequery1.executeUpdate();
             //UPDATE TASK SET done = :date WHERE id = :id");
//q.setParameter(/* set date and id */);
//q.executeUpdate();
             //update into memorygame (imei,playerid,playername) VALUES(?,?,?)"
        }
        public void updatetries(String tries ,String plid)
        {
            TypedQuery<memorygame> updatequery2 = em2.createQuery("update memorygame set tries=:tries where playerid=:plid ", memorygame.class);
            updatequery2.setParameter("tries", tries);
             updatequery2.setParameter("plid",plid);
             updatequery2.executeUpdate();
            
        }
    
}
