/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import com.ca.game.model.memorygame;
import java.util.Comparator;

/**
 *
 * @author A0129075A
 */
public class Sort implements Comparator<memorygame>{
      @Override
    public int compare(memorygame o1, memorygame o2) {
        // write comparison logic here like below , it's just a sample
       return o1.getPlayerid().compareTo(o2.getPlayerid());  
    }
}

