/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gohar;

/**
 *
 * @author Ahmed Bahaa
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class stock extends JFrame{
    private Container c;
    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Dimension d = tk.getScreenSize();
    private JLabel sefylbl=new JLabel("صيفي");
    private JLabel shetwylbl=new JLabel("شتوي");
    private JLabel sefyS=new JLabel("S");
    private JLabel sefyM=new JLabel("M");
    private JLabel shetwyS=new JLabel("S");
    private JLabel shetwyM=new JLabel("M");
    private JTextField sefySTxt=new JTextField("50");
    private JTextField sefyMTxt=new JTextField("50");
    private JTextField shetwySTxt=new JTextField("50");
    private JTextField shetwyMTxt=new JTextField("50");
    private JButton refresh=new JButton("Refresh");
    private JButton save=new JButton("SAVE");
    public stock() 
    {
        init();
    }
    public void init()
    {
      c = this.getContentPane();
        this.setBounds(0, 0, d.width, d.height);
        this.setTitle("المخزن");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        refresh.setFont(new Font("Arial",Font.PLAIN,25));
        refresh.setBounds(300, 50, 200, 30);
        save.setFont(new Font("Arial",Font.PLAIN,25));
        save.setBounds(900, 50, 200, 30);
        sefylbl.setFont(new Font("Arial",Font.PLAIN,25));
        shetwylbl.setFont(sefylbl.getFont());
        sefylbl.setBounds(900, 100, 50, 50);
        shetwylbl.setBounds(300, 100, 50, 50);
        sefyS.setBounds(950, 150, 50, 50);
        sefyM.setBounds(950, 200, 50, 50);
        shetwyS.setBounds(350, 150, 50, 50);
        shetwyM.setBounds(350, 200, 50, 50);
        sefySTxt.setBounds(850, 150, 50, 50);
        sefyMTxt.setBounds(850, 200, 50, 50);
        shetwySTxt.setBounds(250, 150, 50, 50);
        shetwyMTxt.setBounds(250, 200, 50, 50);
        shetwyS.setFont(new Font("Arial",Font.PLAIN,25));
        shetwyM.setFont(new Font("Arial",Font.PLAIN,25));
        sefyS.setFont(new Font("Arial",Font.PLAIN,25));
        sefyM.setFont(new Font("Arial",Font.PLAIN,25));
        shetwySTxt.setFont(new Font("Arial",Font.PLAIN,25));
        shetwyMTxt.setFont(new Font("Arial",Font.PLAIN,25));
        sefySTxt.setFont(new Font("Arial",Font.PLAIN,25));
        sefyMTxt.setFont(new Font("Arial",Font.PLAIN,25));
        c.add(refresh);
        c.add(save);
        c.add(sefylbl);
        c.add(sefyM);
        c.add(sefyS);
        c.add(shetwyM);
        c.add(shetwyS);
        c.add(shetwylbl);
        c.add(sefyMTxt);
        c.add(sefySTxt);
        c.add(shetwyMTxt);
        c.add(shetwySTxt);
        
        refresh.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
              c.repaint();
          }
      });
        
        save.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
              
          }
      });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
       // g.drawLine(0, 100, 500, 100);
    }
    
}
