/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author a0123055u
 */
@ApplicationScoped
public class Game {
    String gameid;
    String playerid;
//    private List<playeridlist> playerlist = new ArrayList<playeridlist>(); 
//    Map<gameid[],List<playerid>>pp= new HashMap
    public String getPlayertries() {
        return playertries;
    }

    public void setPlayertries(String playertries) {
        this.playertries = playertries;
    }

    public String getPlayerscore() {
        return playerscore;
    }

    public void setPlayerscore(String playerscore) {
        this.playerscore = playerscore;
    }
    String playertries;
    String playerscore;

   
    
    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }

    public String getListno() {
        return listno;
    }

    public void setListno(String listno) {
        this.listno = listno;
    }
    String listno;
}
