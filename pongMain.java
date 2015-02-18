import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;
 
//we need the Applet methods and the MouseMotionListener interface
//(used for the human controlled panel
public class pongMain extends Applet implements MouseMotionListener, ActionListener
{
	   //we declare an instance of our ball and two paddles
 Ball ball;
 PaddleLeft pLeft;
 PaddleRight pRight;
 //a font used to display the score
 Font newFont = new Font("sansserif", Font.BOLD, 20);
 //The image I am creating is goin to be double buffered
 //so that there is no flicker when the applet is repainted

 Graphics bufferGraphics;
 // The image that will contain everything that has been drawn on
 // bufferGraphics.
 Image offscreen;
 // variables used to set the width and height of the applet.
 final int WIDTH = 500, HEIGHT = 300;
 //variable used to record the time that the game has proceeded to
 //because we want to tell the person how long the lasted
 long currentTime;
  

 public void init() 
 {
      //sets the applet to be 500 * 300
      setSize(500, 300);
      //we now instantiate our ball and two paddles
      ball = new Ball();
      pLeft = new PaddleLeft();
      //this paddle is set to the current ball y positio
      //minus 35 so the ball will be lined up with the center
      //of our 70 pixel long paddle
      pRight = new PaddleRight(ball.getY() - 35);
      //we add our mouseMotionListener
      addMouseMotionListener(this);
      //I want the applet to look like a grass court =)
      setBackground(Color.green);
      // Create an offscreen image to draw on
      offscreen = createImage(WIDTH,HEIGHT);
      bufferGraphics = offscreen.getGraphics();
 }
  
 public void start(){
     //this sets the current time in milliseconds
     currentTime = System.currentTimeMillis();
      
     //I am going to use a timer to do a certain list of tasks

     //every 15 milliseconds, which is about 67 frames a second
     //(there are 1000 milliseconds in a second, so we divide that
     //by 15 to set up our game's frame rate
     Timer time = new Timer(15, this);    
     
     //this is the "game loop". It won't end until the
     //computer has scored 10 points on the board.
    //we begin our time so that the actionPerformed method will be called
     //every 15 milliseconds
     time.start();
     while(pRight.getScore() < 10){
         //nothing happens in here, but the timer is still running in the
         //background, executing our actionPerformed method and making
         //the wheels of this program turn
     }
     //after the game needs to end, we stop the timer and calculate
     //how long the user has been playing by subtracting the curren
     //time from the intitial currentTime
     time.stop();
     currentTime = System.currentTimeMillis() - currentTime;
     //we repaint one more time to display how long the player
     //lasted in this helpless cause =)
     repaint();
 }
  
 public void stop(){
      
 }

  public void paint(Graphics g) 
 {
      //instead of using the typical graphics, we are going to
      //use bufferGraphics (which we declared at the beginning
      //of the class) to draw onto our off-screen image
       
      //first, we clear off whatever was previously on the image
      bufferGraphics.clearRect(0,0,WIDTH,HEIGHT);
      
      //we now draw our two paddles in blue
      bufferGraphics.setColor(Color.blue);
      //the XPOS is a final int, so it neer changes, but the
      //yPos does. We make the paddles 10 * 70.          //Left side
      
      bufferGraphics.fillRect(pLeft.XPOS,pLeft.getPos(),10,70);
      //Right side

      bufferGraphics.fillRect(pRight.XPOS, pRight.getPos(), 10, 70);
       
      //this draws our mid-court line and our scores in white
      bufferGraphics.setColor(Color.white);
      bufferGraphics.setFont(newFont);
      //we show our player's hopeless circumstances
      bufferGraphics.drawString("Futile", 150, 15);
      //we get the score from our PaddleRight object
      bufferGraphics.drawString(""+ pRight.getScore(),300,15);
      //mid-court divider
      bufferGraphics.fillRect(240,0,20,300);
      if(pRight.getScore() == 10){
          bufferGraphics.drawString("You Lasted: " + (currentTime/ 1000) + "sec.", 40, 150);
      }
      bufferGraphics.setColor(Color.red);
      bufferGraphics.fillRect(ball.getX(),ball.getY(),10,10);
      g.drawImage(offscreen,0,0,this);
      Toolkit.getDefaultToolkit().sync();
 }
 public void update(Graphics g)
 {
      paint(g);
 }

 public void mouseMoved(MouseEvent evt){
      pLeft.setPos(evt.getY()- 35);
 }
 public void mouseDragged(MouseEvent evt) 
 {
	 
 }
  
 //this is where the program figures out if the ball has hit
 //a paddle, the top or bottom of the applet window, or if th     //computer scored

 public void checkCollision(){

    if(ball.getY() == 0 || ball.getY() == 290){
        ball.dy = (ball.dy * -1);
    }
     
    if((ball.getX() == 40) && hitPaddle()){
        ball.dx = (ball.dx * -1);
    }
    if(ball.getX() == 460){
        ball.dx = (ball.dx * -1);
    }
    if(ball.getX() == 0){
        pRight.setScore(pRight.getScore() + 1);
        ball.reset();
    }
 }
 public boolean hitPaddle(){
     boolean didHit = false;
     if((pLeft.getPos() - 10) <= ball.getY() && (pLeft.getPos() + 70) > ball.getY()){

         //sets didHit to true

         didHit = true;

     }
     return didHit;
 }


//actionPerformed method

   public void actionPerformed(ActionEvent arg0) {

        ball.move();

        //lines the computer paddle up with the ball

        pRight.setPos(ball.getY() - 35);
        //checks the ball for a collision
        checkCollision();
        //repaints the appl
       repaint();

   }
 }
