/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import com.ca.game.model.memorygame;
import java.util.Collections;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class GeneratorBean {

    @PersistenceContext
    private EntityManager em1;

    public List<String> generateid(String imei, String playername) {

        String pl_id;

        TypedQuery<memorygame> selectquery = em1.createQuery("select g from memorygame g ", memorygame.class);

        if (selectquery != null) {
            List<memorygame> r = selectquery.getResultList();
            Collections.sort(r, new Sort());
            String temp="";
            for (memorygame m : r) {
                temp = m.getPlayerid();
                System.out.println(m.getPlayerid());
            }

            int id = Integer.parseInt(temp.substring(2));

            pl_id = "pl" + (id + 1);
        } else {
            pl_id = "pl01";

        }
        TypedQuery<memorygame> insertquery = (TypedQuery<memorygame>) em1.createNativeQuery("update into memorygame (imei,playerid,playername,score,tries) VALUES(?,?,?,?,?)");

        insertquery.setParameter(1, imei);
        insertquery.setParameter(2, pl_id);
        insertquery.setParameter(3, playername);
        insertquery.setParameter(4,"0");
        insertquery.setParameter(5,"0");
        

    int x=    insertquery.executeUpdate();
    System.out.println(x);

        return null;
    }

}
