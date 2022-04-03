public class Line implements Poly{


    private int borderThickness;
    private int[] bColour= new int[3];
    private int[] colour = new int[3];
    private int x;
    private int y;
    private int frame =0;
    private boolean shown;

    private ActionHandler actions = new ActionHandler();
    public Line(){

    }

    @Override
    public int getBC(int a){

        return bColour[a];
    }

    @Override
    public int getX(){
        
        return x;        
    }
   
    @Override
    public int getY(){

        return y;
    }
   
    @Override
    public int getBorderThickness(){

        return borderThickness;
    }
  
    @Override
    public boolean isShown(){

        return shown;
    }
   
    @Override
    public int getColour(int a){

        return colour[a];
    }
   
    @Override
    public void update(){

        frame++;

        while(actions.isAction(frame)){

            char type = actions.getType();

            switch(type){

                case 'j': //jump
                x = actions.getJumpX();
                y = actions.getJumpY();
                break;

                case 'h'://hide
                shown= false;
                break;

                case 's'://show
                shown = true;
                break;

                case 'c'://change colour
                colour[0] = actions.getColour(0);
                colour[1] = actions.getColour(1);
                colour[2] = actions.getColour(2);

                break;
            }
        }    
    }

    @Override
    public void addAction(char c, int a){

        actions.addAction(c, a);
    }

    @Override
    public void addAction(char c, int a, int c1, int c2, int c3){

        actions.addAction(c, a, c1, c2, c3);
    }

    @Override
    public void addAction(char c, int a, int x, int y){

        actions.addAction(c, a, x, y);
    
    }


    
}