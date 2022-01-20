package ldts.controller;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import ldts.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InstructionsController {

    boolean on = true;
    private Screen screen;
    private Game game;
    List<Order> orderQueue;
    List<Order> undoOrderQueue = new ArrayList<>();

    public InstructionsController(Screen scr, Game gm){
        
    }

    public void run(){

    }

    public void draw(){

    }

    public void inputReceiver(){

    }

    public void processOrders(List<Order> ordersQueue){

    }
    public void setOn(){

    }
}