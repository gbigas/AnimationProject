import java.util.ArrayList;

public class Shapes {

   private ArrayList<Poly> shapes; 
   private int cursor =0;

    public Shapes(){

       shapes = new ArrayList<Poly>();

       Cir c1 = new Cir(50, 100, 100, 255, 0, 255, 50, 255, 100, 0);


       c1.addAction('s', 10);
       c1.addAction('j', 20, 3, 100);
       c1.addAction('c',90,255,0,0);

       Cir c2 = new Cir(100, 78, 0, 255, 255, 2, 0, 0, 0, 0);

       c2.addAction('s', 10);
       c2.addAction('j', 25, 100, 100);
       c2.addAction('c',100,255,255,0);
       c2.addAction('h',1000);

       



       shapes.add(c2);
       shapes.add(c1);

       Rect r1 = new Rect(100, 100, 500, 500, 255, 0, 0,60 , 255, 255, 255);

       r1.addAction('s', 60);
       shapes.add(r1);

       Line l = new Line(60, 60, 100, 120, 50);

       l.addAction('s', 10);

       shapes.add(l);
    }

    public void addAction(char c, int a){

        shapes.get(cursor).addAction(c, a);
    }

    public void add(Poly s){

        shapes.add(s);
        cursor++;
    }

    public ArrayList<Poly> getShapes(){
        this.update();

        ArrayList<Poly> temp = new ArrayList<Poly>();

        for(int i = 0; i < shapes.size();i++){

            if(shapes.get(i).isShown()){

                temp.add(shapes.get(i));
            }
        }

        return temp;
    }  

    public ArrayList<Poly> getAllShapes(){

        return shapes;
    }

    public void update(){
        cursor =0;

        for(int i = 0; i < shapes.size(); i++){

            shapes.get(i).update();
        }
    }

    public int size(){

        return shapes.size();
    }

    public Poly getNext(){

      
        return shapes.get(cursor++);
    }

}
