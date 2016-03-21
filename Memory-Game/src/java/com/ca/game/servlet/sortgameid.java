/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import com.ca.game.model.gamerecord;
import com.ca.game.model.memorygame;
import java.util.Comparator;

/**
 *
 * @author a0123055u
 */
public class sortgameid implements Comparator<gamerecord>{
    @Override
    public int compare(gamerecord g1, gamerecord g2) {
        // write comparison logic here like below , it's just a sample
       return g1.getGameid().compareTo(g2.getGameid());
    } 

    
    
}
