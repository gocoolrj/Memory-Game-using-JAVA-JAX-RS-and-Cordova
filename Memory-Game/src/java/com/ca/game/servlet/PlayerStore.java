/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author a0123055u
 */
@ApplicationScoped
public class PlayerStore {
    //gameid // playerid // player
    private Map<String,List<Player>>playerstore = new HashMap<>();
    {
        
    }

    public Map<String, List<Player>> getPlayerstore() {
        return playerstore;
    }

    public void setPlayerstore(Map<String, List<Player>> playerstore) {
        this.playerstore = playerstore;
    }

    

   
}
