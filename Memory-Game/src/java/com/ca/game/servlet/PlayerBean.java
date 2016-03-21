/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import com.ca.game.model.memorygame;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PlayerBean {
   @PersistenceContext private EntityManager em;
   // @Resource(mappedName="/jdbc/sample") DataSource ds;
    public List<memorygame> gameSearch(String imei)
    {
    TypedQuery<memorygame> query=em.createQuery("select g from memorygame g where g.imei=:imei", memorygame.class);
   
    query.setParameter("imei", imei);
    

    List<memorygame> r = query.getResultList();
        return (query.getResultList()); 
    }
    
     public List<memorygame> storename(String playername,String imei)
    {
    TypedQuery<memorygame> query=em.createNamedQuery("update g from memorygame g set g.playername=:playername where g.imei.imei=:imei", memorygame.class);
   
    query.setParameter("playername", playername);
    List<memorygame> r = query.getResultList();
        return (query.getResultList()); 
    }
     
      public String retrivePlayerid(String imei) 
{
        
        String pl_id;
        
     TypedQuery<String> selectquery1 = em.createQuery("select g.playerid from memorygame g where g.imei=:imei", String.class);
     selectquery1.setParameter("imei", imei);
       
        return selectquery1.getSingleResult();      
        
        
}

    
}
