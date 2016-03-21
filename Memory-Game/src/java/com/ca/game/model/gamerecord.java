/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a0123055u
 */
//@Table(name = "gamerecord")
@Entity
@XmlRootElement
public class gamerecord {

    @Id
    private String gameid;
    private String playerid1;
    private String playerid2;
    private String winner;

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public String getPlayerid1() {
        return playerid1;
    }

    public void setPlayerid1(String playerid1) {
        this.playerid1 = playerid1;
    }

    public String getPlayerid2() {
        return playerid2;
    }

    public void setPlayerid2(String playerid2) {
        this.playerid2 = playerid2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getPlayerid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
