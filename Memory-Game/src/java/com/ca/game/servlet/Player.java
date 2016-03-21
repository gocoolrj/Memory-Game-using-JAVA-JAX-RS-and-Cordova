/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;



/**
 *
 * @author a0123055u
 */
@SessionScoped
public class Player implements Serializable{
    
    
    private String imei;
    private String playername;
    private String playerid;
    private String score;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public Player createcopy()
    {
        Player p = new Player();
        p.setPlayerid(this.playerid);
        p.setImei(this.imei);
        p.setPlayername(this.playername);
        p.setScore(this.score);
        return p;
    }
}
