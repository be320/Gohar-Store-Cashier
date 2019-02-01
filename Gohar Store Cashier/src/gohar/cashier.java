package gohar;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.*;
import java.util.*;

public class cashier extends JFrame {

    private Thread checker;
    private ArrayList<JComboBox<String>> piece = new ArrayList<JComboBox<String>>();
    private ArrayList<JComboBox<String>> size = new ArrayList<JComboBox<String>>();
    private ArrayList<JComboBox<String>> amount = new ArrayList<JComboBox<String>>();
    private ArrayList<JCheckBox> kom = new ArrayList<JCheckBox>();
    private ArrayList<JButton> minuses = new ArrayList<JButton>();
    private ArrayList<JLabel> singlePrices = new ArrayList<JLabel>();
    private JButton plus = new JButton("+");
    private Container c;
    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Dimension d = tk.getScreenSize();
    private int pieceX = 50;
    private int sizeX = 250;
    private int amountX = 400;
    private int komX = 550;
    private int singlePriceX = 700;
    private int minusX = 900;
    private int y = 50;
    private JComboBox<String> sPiece1 = new JComboBox<String>();
    private JComboBox<String> sSize1 = new JComboBox<String>();
    private JComboBox<String> sAmount1 = new JComboBox<String>();
    private JLabel singlePrice1 = new JLabel("0");
    private JButton sMinus1 = new JButton("-");
    private JCheckBox sKom1 = new JCheckBox();
    private JLabel piecelbl = new JLabel("القطعة");
    private JLabel amountlbl = new JLabel("الكمية");
    private JLabel sizelbl = new JLabel("المقاس");
    private JLabel komlbl = new JLabel("كم");
    private JLabel pricelbl = new JLabel("الحساب");
    private JLabel pricetxt = new JLabel("0");
    private JButton print = new JButton("PRINT");
    private JLabel singlePriceLbl = new JLabel("الثمن");
    // private stock ma5zan=new stock();
    private JLabel tabi3yLbl = new JLabel("طبيعي");
    private JLabel rage3Lbl = new JLabel("راجع");
    private JCheckBox tabi3yCheck = new JCheckBox();
    private JCheckBox rage3Check = new JCheckBox();
    private JPanel tabi3yPnl = new JPanel();
    private JPanel rage3Pnl = new JPanel();
    private cashier old = this;
    int pr;
    int before;
    int after;
    private static int sum = 0;

    public cashier() {
        init();
        //    ma5zan.setVisible(true);
    }

    public void init() {
        c = this.getContentPane();
        this.setBounds(0, 0, d.width, d.height);
        this.setTitle("جوهار");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        tabi3yCheck.setSelected(true);
        tabi3yLbl.setBounds(1000, 10, 50, 30);
        tabi3yLbl.setFont(piecelbl.getFont().deriveFont(15.0f));
        rage3Lbl.setBounds(1150, 10, 50, 30);
        rage3Lbl.setFont(piecelbl.getFont().deriveFont(15.0f));
        tabi3yCheck.setBounds(1005, 50, 30, 30);
        rage3Check.setBounds(1155, 50, 30, 30);
        tabi3yPnl.setBounds(990, 100, 50, 200);
        tabi3yPnl.setBackground(Color.BLUE);
        rage3Pnl.setBounds(1140, 100, 50, 200);
        rage3Pnl.setBackground(Color.red);
        singlePrice1.setBounds(singlePriceX, y, 50, 30);
        singlePrice1.setFont(piecelbl.getFont().deriveFont(15.0f));
        singlePriceLbl.setFont(piecelbl.getFont().deriveFont(20.0f));
        singlePriceLbl.setBounds(singlePriceX - 10, 10, 100, 30);
        piecelbl.setFont(piecelbl.getFont().deriveFont(20.0f));
        piecelbl.setBounds(pieceX + 50, 10, 100, 30);
        amountlbl.setFont(piecelbl.getFont());
        amountlbl.setBounds(amountX + 30, 10, 100, 30);
        sizelbl.setFont(piecelbl.getFont());
        sizelbl.setBounds(sizeX + 30, 10, 100, 30);
        komlbl.setFont(piecelbl.getFont());
        komlbl.setBounds(komX + 5, 10, 100, 30);
        pricelbl.setBounds(1140, 400, 300, 50);
        pricelbl.setFont(pricelbl.getFont().deriveFont(40.0f));
        pricetxt.setFont(pricelbl.getFont());
        pricetxt.setBounds(1180, 470, 100, 30);
        pricetxt.setForeground(Color.red);
        print.setBounds(1090, 550, 200, 100);
        print.setBackground(Color.GREEN);
        print.setFont(pricelbl.getFont());
        c.add(tabi3yLbl);
        c.add(rage3Lbl);
        c.add(tabi3yCheck);
        c.add(rage3Check);
        c.add(tabi3yPnl);
        c.add(rage3Pnl);
        c.add(singlePriceLbl);
        c.add(singlePrice1);
        c.add(print);
        c.add(pricelbl);
        c.add(pricetxt);
        c.add(piecelbl);
        c.add(amountlbl);
        c.add(sizelbl);
        c.add(komlbl);
        c.add(sPiece1);
        c.add(sSize1);
        c.add(sAmount1);
        c.add(sKom1);
        c.add(sMinus1);
        sMinus1.setBounds(minusX, y, 40, 20);
        sPiece1.setBounds(pieceX, y, 150, 20);
        sPiece1.setFont(sPiece1.getFont().deriveFont(15.0f));
        sSize1.setBounds(sizeX, y, 100, 20);
        sAmount1.setBounds(amountX, y, 100, 20);
        sKom1.setBounds(komX, y, 20, 20);
        plus.setBounds(1250, 20, 50, 50);
        c.add(plus);
        sPiece1.addItem("شتوي");
        sPiece1.addItem("صيفي");
        sSize1.addItem("S");
        sSize1.addItem("M");
        sAmount1.addItem("1");
        sAmount1.addItem("2");
        sAmount1.addItem("3");
        sAmount1.addItem("4");
        singlePrices.add(singlePrice1);
        piece.add(sPiece1);
        size.add(sSize1);
        amount.add(sAmount1);
        kom.add(sKom1);
        minuses.add(sMinus1);
        checker = new Thread() {
            public void run() {
                while (true) {
                     if(rage3Check.isSelected())
                    {
                    tabi3yPnl.setVisible(false);
                    rage3Pnl.setVisible(true);
                    tabi3yCheck.setSelected(false);
                    tabi3yCheck.setEnabled(true);
                    rage3Check.setEnabled(false);
                    pricelbl.setText("المرجوعات");
                    }
                    if(tabi3yCheck.isSelected())
                    {
                    tabi3yPnl.setVisible(true);
                    rage3Pnl.setVisible(false);
                    rage3Check.setSelected(false);
                    tabi3yCheck.setEnabled(false);
                    rage3Check.setEnabled(true);
                    pricelbl.setText("الحساب");
                    }
                   
                    for (int i = 0; i < piece.size(); i++) {
                        JComboBox selectedPiece = piece.get(i);
                        JComboBox selectedSize = size.get(i);
                        JLabel selectedPrice = singlePrices.get(i);
                        JComboBox selectedAmount = amount.get(i);
                        JCheckBox selectedKom = kom.get(i);
                        JButton selectedMinus = minuses.get(i);
                        minuses.get(i).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                piece.remove(selectedPiece);
                                amount.remove(selectedAmount);
                                size.remove(selectedSize);
                                kom.remove(selectedKom);
                                singlePrices.remove(selectedPrice);
                                minuses.remove(selectedMinus);
                                c.remove(selectedPiece);
                                c.remove(selectedAmount);
                                c.remove(selectedSize);
                                c.remove(selectedKom);
                                c.remove(selectedPrice);
                                c.remove(selectedMinus);
                                sum = 0;
                                for (JLabel p : singlePrices) {
                                    sum += Integer.parseInt(p.getText());
                                }
                                pricetxt.setText(sum + "");
                                c.repaint();

                            }
                        });
                        piece.get(i).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                int am = Integer.parseInt((String) selectedAmount.getSelectedItem());
                                if (selectedPiece.getSelectedItem().equals("صيفي") && selectedSize.getSelectedItem().equals("S")) {
                                    pr = 50;
                                } else if (selectedPiece.getSelectedItem().equals("صيفي") && selectedSize.getSelectedItem().equals("M")) {
                                    pr = 60;
                                } else if (selectedPiece.getSelectedItem().equals("شتوي") && selectedSize.getSelectedItem().equals("S")) {
                                    pr = 100;
                                } else if (selectedPiece.getSelectedItem().equals("شتوي") && selectedSize.getSelectedItem().equals("M")) {
                                    pr = 110;
                                }
                                selectedPrice.setText((pr * am) + "");
                                sum = 0;
                                for (JLabel p : singlePrices) {
                                    sum += Integer.parseInt(p.getText());
                                }
                                pricetxt.setText(sum + "");
                                c.repaint();
                            }
                        });

                        size.get(i).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                int am = Integer.parseInt((String) selectedAmount.getSelectedItem());
                                if (selectedPiece.getSelectedItem().equals("صيفي") && selectedSize.getSelectedItem().equals("S")) {
                                    pr = 50;
                                } else if (selectedPiece.getSelectedItem().equals("صيفي") && selectedSize.getSelectedItem().equals("M")) {
                                    pr = 60;
                                } else if (selectedPiece.getSelectedItem().equals("شتوي") && selectedSize.getSelectedItem().equals("S")) {
                                    pr = 100;
                                } else if (selectedPiece.getSelectedItem().equals("شتوي") && selectedSize.getSelectedItem().equals("M")) {
                                    pr = 110;
                                }
                                selectedPrice.setText((pr * am) + "");
                                sum = 0;
                                for (JLabel p : singlePrices) {
                                    sum += Integer.parseInt(p.getText());
                                }
                                pricetxt.setText(sum + "");
                                c.repaint();
                            }
                        });
                        amount.get(i).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                int am = Integer.parseInt((String) selectedAmount.getSelectedItem());
                                if (selectedPiece.getSelectedItem().equals("صيفي") && selectedSize.getSelectedItem().equals("S")) {
                                    pr = 50;
                                } else if (selectedPiece.getSelectedItem().equals("صيفي") && selectedSize.getSelectedItem().equals("M")) {
                                    pr = 60;
                                } else if (selectedPiece.getSelectedItem().equals("شتوي") && selectedSize.getSelectedItem().equals("S")) {
                                    pr = 100;
                                } else if (selectedPiece.getSelectedItem().equals("شتوي") && selectedSize.getSelectedItem().equals("M")) {
                                    pr = 110;
                                }
                                selectedPrice.setText((pr * am) + "");
                                sum = 0;
                                for (JLabel p : singlePrices) {
                                    sum += Integer.parseInt(p.getText());
                                }
                                pricetxt.setText(sum + "");
                                c.repaint();
                            }
                        });
                    }
                }

            }
        };
        checker.start();

        tabi3yCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tabi3yCheck.setSelected(true);
                rage3Check.setSelected(false);
            }
        });
        
         rage3Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                rage3Check.setSelected(true);
                tabi3yCheck.setSelected(false);
            }
        });
         
         
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JComboBox<String> sPiece = new JComboBox<String>();
                JComboBox<String> sSize = new JComboBox<String>();
                JComboBox<String> sAmount = new JComboBox<String>();
                JCheckBox sKom = new JCheckBox();
                JButton sMinus = new JButton("-");
                JLabel singlePrice = new JLabel("0");
                c.add(singlePrice);
                c.add(sPiece);
                c.add(sAmount);
                c.add(sSize);
                c.add(sKom);
                c.add(sMinus);

                y += 30;
                singlePrice.setBounds(singlePriceX, y, 50, 30);
                singlePrice.setFont(singlePrice1.getFont());
                sMinus.setBounds(minusX, y, 40, 20);
                sKom.setBounds(komX, y, 20, 20);
                sPiece.setBounds(pieceX, y, 150, 20);
                sPiece.setFont(sPiece1.getFont());
                sPiece.addItem("شتوي");
                sPiece.addItem("صيفي");

                sSize.setBounds(sizeX, y, 100, 20);
                sSize.addItem("S");
                sSize.addItem("M");

                sAmount.setBounds(amountX, y, 100, 20);
                sAmount.addItem("1");
                sAmount.addItem("2");
                sAmount.addItem("3");
                sAmount.addItem("4");
                singlePrices.add(singlePrice);
                piece.add(sPiece);
                amount.add(sAmount);
                size.add(sSize);
                kom.add(sKom);
                minuses.add(sMinus);
            }
        });
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                PrinterJob pj = PrinterJob.getPrinterJob();
                pj.setPrintable(new BillPrintable(), getPageFormat(pj));
                try {
                    pj.print();

                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
                old.dispose();
                cashier newOne = new cashier();
                newOne.setVisible(true);
            }
        });
    }

    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double middleHeight = 8.0;
        double headerHeight = 2.0;
        double footerHeight = 2.0;
        double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
        double height = convert_CM_To_PPI(headerHeight + middleHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(
                0,
                10,
                width,
                height - convert_CM_To_PPI(1)
        );   //define boarder size    after that print area width is about 180 points

        pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
        pf.setPaper(paper);

        return pf;
    }

    protected static double convert_CM_To_PPI(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }

    public class BillPrintable implements Printable {

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {

            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {

                Graphics2D g2d = (Graphics2D) graphics;

                double width = pageFormat.getImageableWidth();

                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

                ////////// code by alqama//////////////
                FontMetrics metrics = g2d.getFontMetrics(new Font("Arial", Font.BOLD, 7));
                //    int idLength=metrics.stringWidth("000000");
                //int idLength=metrics.stringWidth("00");
                int idLength = metrics.stringWidth("000");
                int amtLength = metrics.stringWidth("000000");
                int qtyLength = metrics.stringWidth("00000");
                int priceLength = metrics.stringWidth("000000");
                int prodLength = (int) width - idLength - amtLength - qtyLength - priceLength - 17;

                //    int idPosition=0;
                //    int productPosition=idPosition + idLength + 2;
                //    int pricePosition=productPosition + prodLength +10;
                //    int qtyPosition=pricePosition + priceLength + 2;
                //    int amtPosition=qtyPosition + qtyLength + 2;
                int productPosition = 0;
                int discountPosition = prodLength + 5;
                int pricePosition = discountPosition + idLength + 10;
                int qtyPosition = pricePosition + priceLength + 4;
                int amtPosition = qtyPosition + qtyLength;

                try {
                    /*Draw Header*/
                    int y = 20;
                    int yShift = 10;
                    int headerRectHeight = 15;
                    int headerRectHeighta = 40;

                    ///////////////// Product names Get ///////////
                    String ket3a = (String) piece.get(0).getSelectedItem();
                    String ma2as = (String) size.get(0).getSelectedItem();
                    String kemeya = (String) amount.get(0).getSelectedItem();
                    String se3r = singlePrices.get(0).getText();
//                String pn2a=(String)piece.get(0).getSelectedItem();
//                String pn3a=(String)piece.get(0).getSelectedItem();
//                String pn4a=(String)piece.get(0).getSelectedItem();
                    ///////////////// Product names Get ///////////

                    ///////////////// Product price Get ///////////
//                int pp2a=Integer.parseInt(singlePrices.get(0).getText());
//                int pp3a=Integer.parseInt(singlePrices.get(0).getText());
//                int pp4a=Integer.parseInt(singlePrices.get(0).getText());
                    int sum = Integer.parseInt(pricetxt.getText());
                    ///////////////// Product price Get ///////////

                    g2d.setFont(new Font("Arial", Font.PLAIN, 7));
                    g2d.drawString("---------------------------------------------------", 12, y);
                    y += yShift;
                    g2d.drawString("         " + "         ملابس مدرسة جوهار " + "" + "                         ", 12, y);
                    y += yShift;
                    g2d.drawString("---------------------------------------------------", 12, y);
                    y += headerRectHeight;
                    if(rage3Check.isSelected())
                    g2d.drawString("--------------------المرجوعات--------------------",10,y);y+=yShift;
                    g2d.drawString("---------------------------------------------------", 10, y);
                    y += yShift;
                    g2d.drawString(" القطعة    المقاس    الكمية    سعر القطعة   الثمن ", 10, y);
                    y += yShift;
                    g2d.drawString("---------------------------------------------------", 10, y);
                    y += headerRectHeight;
                    for (int i = 0; i < piece.size(); i++) {
                        JComboBox selectedPiece = piece.get(i);
                        JComboBox selectedSize = size.get(i);
                        JLabel selectedPrice = singlePrices.get(i);
                        JComboBox selectedAmount = amount.get(i);
                        int per = Integer.parseInt(selectedPrice.getText()) / Integer.parseInt((String) selectedAmount.getSelectedItem());
                        if (per > 99) {
                            g2d.drawString(" " + selectedPrice.getText() + "        " + per + "        " + selectedAmount.getSelectedItem() + "         " + selectedSize.getSelectedItem() + "        " + selectedPiece.getSelectedItem(), 10, y);
                            y += yShift;
                        } else if (per < 100 && Integer.parseInt(selectedPrice.getText()) < 100) {
                            g2d.drawString(" " + selectedPrice.getText() + "           " + per + "         " + selectedAmount.getSelectedItem() + "         " + selectedSize.getSelectedItem() + "        " + selectedPiece.getSelectedItem(), 10, y);
                            y += yShift;
                        } else if (per < 100 && Integer.parseInt(selectedPrice.getText()) > 99) {
                            g2d.drawString(" " + selectedPrice.getText() + "          " + per + "         " + selectedAmount.getSelectedItem() + "         " + selectedSize.getSelectedItem() + "        " + selectedPiece.getSelectedItem(), 10, y);
                            y += yShift;
                        } else {
                            g2d.drawString(" " + selectedPrice.getText() + "       " + per + "        " + selectedAmount.getSelectedItem() + "         " + selectedSize.getSelectedItem() + "        " + selectedPiece.getSelectedItem(), 10, y);
                            y += yShift;
                        }
                    }

                    g2d.drawString("---------------------------------------------------", 10, y);
                    y += yShift;
                    g2d.drawString("                  " + sum + "     : الاجمالي", 10, y);
                    y += yShift;
                    g2d.drawString("---------------------------------------------------", 10, y);
                    y += yShift;

//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
                } catch (Exception r) {
                    r.printStackTrace();
                }

                result = PAGE_EXISTS;
            }
            return result;
        }
    }

}
