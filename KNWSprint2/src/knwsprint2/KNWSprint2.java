/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knwsprint2;
//ratio                                                        500ticks/130cm

public class KNWSprint2 
{
    public static void main(String[] args) 
    {
       Robot hbot = new Robot();
        // hbot.moveBoomUp();
        // hbot.moveBoomDown();
        //hbot.moveDBackward(200);
        //  hbot.turnDLeft();
        //hbot.turnDRight();
      //hbot.moveForward(300, 2000);
      // hbot.getTemp();
      //hbot.getWind();
      //hbot.getCond();
     
       
       leftCourse(hbot);
      // rightCourse(hbot);
       
       
       hbot.close();
    }         
    static void leftCourse(Robot hbot)
    {
        hbot.getForwardPing();
        hbot.moveUntilWall(40);
        hbot.turnDRight();  
        
        hbot.moveUnlessBlocked(400);        
        hbot.moveDForward(800);                   
        

        hbot.moveBoomUp();                 
        hbot.moveBoomDown();
        hbot.turnDLeft();
        
        hbot.moveDForward(500);//
        hbot.moveLUntilWall(670);//
        hbot.turnDLeft();//
        
        hbot.moveLUntilWall(400);//100
        hbot.turnDLeft();
        
        hbot.moveLUntilWall(400);
        hbot.turnDRight();
       
        hbot.moveUntilWall(10); 
        hbot.moveDBackward(200);
        hbot.turnDRight();

        hbot.moveDForward(1000);
        hbot.moveUntilWall(50);
        hbot.turnRight();
        
        
        hbot.moveUntilSand();
        hbot.getCond();
    }    
    static void rightCourse(Robot hbot)
    {
        hbot.getForwardPing();
        hbot.moveUntilWall(40);
        hbot.turnDLeft(); 
//
        hbot.moveUnlessBlocked(500);        
        hbot.moveDForward(800);
        hbot.getForwardPing();
       // hbot.sleep(3000);
                   //top of ramp


        hbot.moveBoomUp();
        hbot.moveBoomDown();
        hbot.turnDRight();

        hbot.moveDForward(500);//
        hbot.moveRUntilWall(670);//
        hbot.turnDRight();//

        hbot.moveRUntilWall(400);//100
        hbot.turnDRight(); 
//
        hbot.moveRUntilWall(400);
        hbot.turnDLeft();
//
        hbot.moveUntilWall(10);
        hbot.moveDBackward(200);
        hbot.turnDLeft();


        //did not test these yet
        hbot.moveDForward(1000);
        hbot.moveUntilWall(50);
        hbot.turnLeft();
        hbot.moveUntilSand();
        hbot.getCond();
        
        
        
    }
}


   