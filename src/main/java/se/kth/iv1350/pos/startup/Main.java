package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.view.View;

/**
  * Contains the main method. Does the startup of the application.
  * 
  */ 
public class Main {
    /**
      * Starts the application
      */
    
    public static void main (String[] args){
        //Printer printer = new Printer();
        Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeExecution();
        
    }
    
}
