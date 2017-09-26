import sun.swing.WindowsPlacesBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame{
    private Button btnadd = new Button("Add");
    private Button btnexit = new Button("Exit");
    private Button btnstop = new Button("Stop");
    private Label lab = new Label("????");
    int count = 0 ,labX=200,labY=200;
    private Timer t1;
    private boolean a =true;
    public MainFrame(){
        init();
    }
        private void init(){
        this.setLocale(null);
        this.setBounds(100,100,600,500);
        lab.setBounds(labX,labY,100,100);
        lab.setFont(new Font(null,Font.BOLD,34));
        btnadd.setBounds(50,250,50,50);
        btnexit.setBounds(50,450,50,50);
        btnstop.setBounds(50,350,50,50);
        this.add(btnadd);
        this.add(btnexit);
        this.add(btnstop);
        this.add(lab);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           //     count++;
           // lab.setText(Integer.toString(count));
            t1.start();
            }
        });
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

            btnstop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t1.stop();
                }
            });
        t1 = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            lab.setLocation(labX,labY);

            if(labX<500&&a){
                labX+=1;
                if(labX==500){
                    a=false;
                }
            lab.setLocation(labX,labY);
            }else{
                labX-=1;
                if(labX==0){
                    a=true;
                }
                lab.setLocation(labX,labY);
            }

            }
        });
        }
}
