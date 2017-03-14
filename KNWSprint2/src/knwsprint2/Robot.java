package knwsprint2;
import rxtxrobot.ArduinoUno;
import rxtxrobot.RXTXRobot;
//2653
//343 is his room number
public class Robot 
{    
    RXTXRobot r;
    
    
    //robot overides////////////////////////////////////////////////////////////
    public Robot()
    {
     r = new ArduinoUno(); // Create RXTXRobot object 
     r.setPort("COM4");
    // r.setVerbose(true);
     r.connect();
       // System.out.println(r.getAnalogPin(2));
     r.attachMotor(RXTXRobot.MOTOR1, 5);
     r.attachMotor(RXTXRobot.MOTOR2, 6);
     r.attachMotor(RXTXRobot.MOTOR3, 8);
     r.attachServo(RXTXRobot.SERVO1, 7); //soil
     r.attachServo(RXTXRobot.SERVO2, 4); //boom2   
    }
    public void close()
    {
        r.close();
    }
    public void sleep(int time)
    {
        r.sleep(time);
    }   
    
    
    
    
    
    //movement//////////////////////////////////////////////////////////////////
    public void moveForward(int speed, int time)
    {
        r.runMotor(RXTXRobot.MOTOR1, (int)(speed), RXTXRobot.MOTOR2, (int)(-speed*(.83)), time); 
    }
    public void moveDForward(int distance)
    {
        //500-87
        //less room than whats planned
        
        
        r.resetEncodedMotorPosition(RXTXRobot.MOTOR1);
        r.resetEncodedMotorPosition(RXTXRobot.MOTOR2);

        r.runEncodedMotor(RXTXRobot.MOTOR1, 500, distance-30, RXTXRobot.MOTOR2, -480, distance);
        System.out.println(r.getEncodedMotorPosition(RXTXRobot.MOTOR1));
        System.out.println(r.getEncodedMotorPosition(RXTXRobot.MOTOR2));

        
    }
    public void moveDBackward(int distance)
    {
        //500-87
        //less room than whats planned
        
        
        r.resetEncodedMotorPosition(RXTXRobot.MOTOR1);
        r.resetEncodedMotorPosition(RXTXRobot.MOTOR2);

        r.runEncodedMotor(RXTXRobot.MOTOR1, -500, distance, RXTXRobot.MOTOR2, 500, distance-20);
        System.out.println(r.getEncodedMotorPosition(RXTXRobot.MOTOR1));
        System.out.println(r.getEncodedMotorPosition(RXTXRobot.MOTOR2));

        
    }
    public void turnDLeft()
    {
         r.runEncodedMotor(RXTXRobot.MOTOR1, -400,213, RXTXRobot.MOTOR2, -400, 213);
    }
    public void turnDRight()
    {
         r.runEncodedMotor(RXTXRobot.MOTOR1, 400, 218, RXTXRobot.MOTOR2, 400, 218);
    }
    public void moveBoomUp()
    {
        r.moveServo(RXTXRobot.SERVO2, 180);
        
        r.runMotor(RXTXRobot.MOTOR3, -500, 4000);//5500  
        for(int i=0;i<3;i++)
        {
        getTemp();
        getWind();
        }
        r.sleep(8000);
        r.moveServo(RXTXRobot.SERVO2, 90);
        
        // moveBoomDown();
    
    }
    public void moveBoomDown() 
    {   
       r.runMotor(RXTXRobot.MOTOR3, 500, 2500); //
    }
    
    
    
    
    
    
    //special moves/////////////////////////////////////////////////////////////
   
    public void moveUntilWall(int dis)
    {
        while(getForwardPing()>dis)
        {
            moveForward(500,0);

        }
        moveForward(0,0);
    }
    public void moveUntilSand()
    {
        r.resetEncodedMotorPosition(0);
        while(r.getEncodedMotorPosition(RXTXRobot.MOTOR1)<500)
        {
            if(getForwardPing()<40)
            {
                moveForward(0,0);
                sleep(1000);
                continue;
            }
            moveForward(500,0);
        }
        
        while(getForwardPing()>10)
        {
            moveForward(500,0);

        }
        moveForward(0,0);
 
    }
    public void moveRUntilWall(int distance)
    {
        
        r.resetEncodedMotorPosition(RXTXRobot.MOTOR1);
        
        //double d= getForwardPing();
       // moveForward(200,(int)(100*d)-700);//edit numbers
        
        
       // if(getForwardPing()<(87./500)*distance)
           // sleep(5000);
        
        while(r.getEncodedMotorPosition(RXTXRobot.MOTOR1)<distance-100)
        {
            if(getForwardPing()<40)
            {
                moveForward(0,0);
                sleep(7000);
                if(getForwardPing()<40)
                    evadeRBlocked();
                continue;
            }
            moveForward(500,0);
        }
        
        moveUntilWall(50);
    }
    public void moveLUntilWall(int distance)
    {
        
        r.resetEncodedMotorPosition(RXTXRobot.MOTOR1);
        
        //double d= getForwardPing();
       // moveForward(200,(int)(100*d)-700);//edit numbers
        
        
       // if(getForwardPing()<(87./500)*distance)
           // sleep(5000);
        
        while(r.getEncodedMotorPosition(RXTXRobot.MOTOR1)<distance-100)
        {
            if(getForwardPing()<40)
            {
                moveForward(0,0);
                sleep(7000);
                if(getForwardPing()<40)
                    evadeLBlocked();
                continue;
            }
            moveForward(500,0);
        }
        
        moveUntilWall(50);
    }
    public void evadeRBlocked()
    {
         turnDRight();
         moveDForward(350);
         turnDLeft();    
    }
    public void evadeLBlocked()
    {
         turnDLeft();
         moveDForward(350);
         turnDRight();
        
    }
    public void moveUnlessBlocked(int distance)
    {
        r.resetEncodedMotorPosition(0);
        while(r.getEncodedMotorPosition(RXTXRobot.MOTOR1)<distance)
        {
            if(getForwardPing()<40)
            {
                moveForward(0,0);
                sleep(1000);
                continue;
            }
            moveForward(500,0);
        }
        moveForward(0,0);
    }  
    public void moveUntilBump()//configure
     {
      
        while(getBumpSensor()==0)
        {
            moveForward(300,0);

        }
        moveForward(0,0);
    }
    public void moveUntilRaised()
    {
    while(getLeftPing()<40)
        {
            moveForward(500,0);

        }
        moveForward(0,0);
    }
    
    
    
    
    //sensors///////////////////////////////////////////////////////////////////
    public void getTemp() //returns thermistor adc prints temp
    {
        System.out.println("Inside C temperature:"+(-.1111*getITherm()+83.889));
        System.out.println("Outside C temperature:"+(-.12*getOTherm()+87.66));
    }
    public double getITherm()
    {
     double sum=0;
           double readingCount=20;
           
           for(int i=0; i<readingCount;i++)
           {
               r.refreshAnalogPins();
               int reading=r.getAnalogPin(2).getValue();//pin two is outside
               sum+=reading;
           }
           //2 is outside
           double thermistorreading= sum/readingCount;
           return thermistorreading;
    }
    public double getOTherm()
    {
     double sum=0;
           double readingCount=20;
           
           for(int i=0; i<readingCount;i++)
           {
               r.refreshAnalogPins();
               int reading=r.getAnalogPin(1).getValue();//pin two is outside
               sum+=reading;
           }
           //2 is outside
           double thermistorreading= sum/readingCount;
           return thermistorreading;
    }
    public void getWind()  //calibrate this
    {
        System.out.println("Wind speed(m/s):" + (1.107*(getITherm()-getOTherm())-23.568));//-23.568
    }
    public void getCond() //give up on this
    {
        r.moveServo(RXTXRobot.SERVO1, 0);
        
        for(int i=0;i<3;i++)
        {
        r.refreshAnalogPins();
        int reading=r.getConductivity();
        System.out.println("Water percentage:"+(-0.0004*reading+0.4128)*100);
        }
        r.moveServo(RXTXRobot.SERVO1, 90);
    }
    public int getBumpSensor() 
    {
        
        r.refreshAnalogPins();
        int reading=r.getAnalogPin(1).getValue();
              
        return reading;
    }
    public double getForwardPing()
    {
        System.out.println(r.getPing(9));
        return r.getPing(9);
    }
    
    
    
    
    
    
    //unused
    public void moveForwardDistance()
    {
        
        
//        r.resetEncodedMotorPosition(RXTXRobot.MOTOR1);
//        r.resetEncodedMotorPosition(RXTXRobot.MOTOR2);
//        
//       
//        System.out.println("Position:  "+r.getEncodedMotorPosition(RXTXRobot.MOTOR1));
//        System.out.println(r.getEncodedMotorPosition(RXTXRobot.MOTOR2));
        
      
         
     
       r.runEncodedMotor(RXTXRobot.MOTOR1, 200, 500, RXTXRobot.MOTOR2, -200, 500);
       
       
//        System.out.println("Position:  "+r.getEncodedMotorPosition(RXTXRobot.MOTOR1));
//        System.out.println(r.getEncodedMotorPosition(RXTXRobot.MOTOR2));
       
       // r.runEncodedMotor(RXTXRobot.MOTOR1, 200, 400); 
       // r.runMotor(RXTXRobot.MOTOR1, 250, 4000);
//        while(true)
//        {
//            moveForward(300,4000);
//            //r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 89, RXTXRobot.MOTOR2, -255, 89);
//        System.out.println("Position:  "+r.getEncodedMotorPosition(RXTXRobot.MOTOR1));//zero
//        System.out.println(r.getEncodedMotorPosition(RXTXRobot.MOTOR2));//becamenegative
//        }
        //motor2 right side
    } 
    public void moveRUnlessBlockedRamp()
    {
        r.resetEncodedMotorPosition(0);
        while(getRightPing()<70)
        {
            if(getForwardPing()<80)
            {
                moveForward(0,0);
                sleep(1000);
                continue;
            }
            moveForward(500,0);
        }
    }
    public double getRightPing()
    {
        return r.getPing(10);
    }
    public double getLeftPing()
    {
        return r.getPing(11);
    }
    public void turnLeft()
    {
        r.runMotor(RXTXRobot.MOTOR1, (int)(-500), RXTXRobot.MOTOR2, (int)(-500), 1100); 
    } 
    public void turnRight()
    {
        r.runMotor(RXTXRobot.MOTOR1, (int)(500), RXTXRobot.MOTOR2, (int)(500), 1050); 
    }
     public void forwardUntilBump(Robot hbot)
    {
        int bumpsensor=1;
        moveForward(200,0);
        
        while(bumpsensor!=0)
        {
            bumpsensor=getBumpSensor();
            System.out.println("The BumpSensor is: " +getBumpSensor());         
        }
        hbot.moveForward(0,0);
    }
    
}
