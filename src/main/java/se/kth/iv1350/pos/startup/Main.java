package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.view.View;

/**
  * Contains the main method. Does the startup of the application.
  * 
  */ 
public class Main {
    
    /**
      * Starts the program. Creates instances.
      * 
      * @Param args Command line arg is not used.
      */
    public static void main (String[] args){
        //Printer printer = new Printer();
        Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeExecution();
    }
    
}
