package attackanime;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * maeda
 */

public class Main extends Frame implements ActionListener{
    // Retrieved command code
    String command = "";
    List list ;
   
    //JPanel panel = new JPanel();
    int location;
    Timer tm;
    public static void main(String[] args) {
       Frame frame  = new Main();
        frame.setResizable(true);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public Main(){
        setVisible(true);
        setTitle("Attack Scene");
        // Create Menu Bar
        MenuBar mb = new MenuBar();
        setMenuBar(mb);

        Menu menu = new Menu("Start");
        mb.add(menu);

        MenuItem miColor = new MenuItem("Play");
        miColor.addActionListener(this);
        menu.add(miColor);

        MenuItem miLine = new MenuItem("Stop");
        miLine.addActionListener(this);
        menu.add(miLine);

        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        menu.add(miExit);

        WindowListener l = new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit(0);
            }
            public void windowActivated(WindowEvent ev){
                repaint();
            }
            public void windowStateChanged(WindowEvent ev){
                repaint();
            }
        };

        this.addWindowListener(l);


        ComponentListener k = new ComponentAdapter(){
            public void componentResized(ComponentEvent e){
            repaint();
        }
        };

        // register listeners
        this.addWindowListener(l);
        this.addComponentListener(k);

        //tm = new Timer(1000, this);
        //tm.start();
    }

    public void actionPerformed (ActionEvent ev){
        // figure out which command was issued
        command = ev.getActionCommand();
        // take action accordingly

        //repaint();

        if("Play".equals(command)){
            

            repaint();
        }else if("Stop".equals(command)){
           // repaint();
        }else if("Exit".equals(command)){
            System.exit(0);
        }

    }

    public void paint(Graphics g){
        prepare(g);
        redPunch(g);
        blueFallsInjureAndStands(g);
        blueDoesSuperAttak(g);
    }

    public void prepare(Graphics g){
        Toolkit toolkit = getToolkit();
        Image[] frames = new Image[5];
        // Load animation frames
        for(int k=1; k<=4; k++){
            frames[k-1] = toolkit.getImage("F:\\attackAnime\\prep"+k+".gif");
        }

        for(int i=0; i<5; i++){
            g.drawImage(frames[i],50,50,this);
            try{
                Thread.sleep(500); // do nothing for 1000 miliseconds (1 second)
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void redPunch(Graphics g){
        Toolkit toolkit = getToolkit();
        Image[] frames = new Image[5];
        // Load animation frames
        for(int k=1; k<=4; k++){
            frames[k-1] = toolkit.getImage("F:\\attackAnime\\red"+k+".gif");
        }

        for(int i=0; i<5; i++){
            g.drawImage(frames[i],50,50,this);
            try{
                Thread.sleep(500); // do nothing for 1000 miliseconds (1 second)
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void blueFallsInjureAndStands(Graphics g){
        Toolkit toolkit = getToolkit();
        Image[] frames = new Image[9];
        // Load animation frames
        for(int k=1; k<=frames.length; k++){
            frames[k-1] = toolkit.getImage("F:\\attackAnime\\injured"+k+".gif");
        }

        for(int i=0; i<frames.length; i++){
            g.drawImage(frames[i],50,50,this);
            try{
                Thread.sleep(500); // do nothing for 1000 miliseconds (1 second)
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void blueDoesSuperAttak(Graphics g){

    }

}
