/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author a0123055u
 */
@SessionScoped
public class ListMaintain implements Serializable{
    
    
     public Map<String, List> getRandom_pick() {
         if(random_pick == null)
             random_pick = new HashMap<>();
        return random_pick;
    }

    public void setRandom_pick(Map<String, List> random_pick) {
        this.random_pick = random_pick;
    }
    //Game gamecheck;
    private Map<String,List> random_pick;
   
}
