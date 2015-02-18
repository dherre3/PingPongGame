public class Ball{
    //variables for the x and y position
    private int xPos,yPos;
    public int dx = 5, dy = -5;
    
   public Ball(){
        //sets the initial ball position to near the center of the
        //screen
        setPos(250, 140);
    }
     
    public void setPos(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }
     
    public int getX(){
        return xPos;
    }
     
    public int getY(){
        return yPos;
    }
    //this is the method used to move the ball
    public void move(){
        setPos(this.getX() + dx, this.getY() + dy);
    }  
    //reset method for when the computer scores
    public void reset(){
        //the same initial setup as before
        setPos(250,140);
        dx = 5;
        dy = -5;
    }
}