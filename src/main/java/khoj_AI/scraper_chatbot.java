
package khoj_AI;

import org.jsoup.nodes.Document;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class scraper_chatbot extends javax.swing.JFrame {

    
    
   static ArrayList<String> arr;
    static ArrayList<String> arr_u = new ArrayList<String>();
    
    StringBuilder f_str = new StringBuilder("");
    StringBuilder j_str = new StringBuilder("");
    StringBuilder sp_str = new StringBuilder("");
    
    Document document;
    int j=0;
    String sortby = "";
    String sortby_sp = "";
    int pageno;
    int temp_page_no;
    int itemno;
    String allowable_product_price = "";
     

    
    public scraper_chatbot(ArrayList ip) {
        //Collections.copy(arr,ip); //Change this test to ip( ip is the array list returned by the chatbot)
        arr = new ArrayList<String>(ip);
        
        initComponents();
        this.setSize(1050, 700);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<String>();
        label3 = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        jTextField1 = new javax.swing.JTextField();
        button2 = new java.awt.Button();
        button1 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(68, 67, 74));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 60)); // NOI18N
        jLabel5.setText("Scraper");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Niraj\\Downloads\\scraper.png")); // NOI18N

        jLabel2.setBackground(new java.awt.Color(33, 32, 38));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Niraj\\Downloads\\drive-download-20191027T114244Z-001\\src\\webscraping\\3df824df-82b8-4072-be29-211263aa2bd8_200x200.png")); // NOI18N

        label2.setBackground(new java.awt.Color(68, 67, 74));
        label2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        label2.setText("You are searching for");

        jButton2.setBackground(new java.awt.Color(204, 0, 51));
        jButton2.setText("Back to Main");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 0, 51));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(71, 71, 71)))
                .addComponent(jLabel2)
                .addGap(187, 187, 187))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1040, 200);

        jPanel2.setBackground(new java.awt.Color(33, 32, 38));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "Relevance", "Popularity", "Price Ascending", "Price Descending" }));

        label3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Parameter For Optimisation");

        jPanel3.setBackground(new java.awt.Color(68, 67, 74));

        label4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        label4.setText("Copy The Link You Want To Redirect To");

        button2.setBackground(new java.awt.Color(51, 255, 0));
        button2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button2.setLabel("Redirect");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(463, 463, 463))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        button1.setBackground(new java.awt.Color(102, 255, 0));
        button1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        button1.setLabel("Get Results");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(369, 369, 369))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(457, 457, 457)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 200, 1040, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
     
        
        jTextArea1.setText("");
        
        sortby = String.valueOf(jComboBox1.getSelectedItem()).toLowerCase();
        sortby_sp = String.valueOf(jComboBox1.getSelectedItem()).toLowerCase();
        pageno = 1;
       
        
           if(sortby.equalsIgnoreCase("price ascending"))
            {
                sortby = "price_asc";
            }
            else if(sortby.equalsIgnoreCase("price descending"))
            {
                sortby = "price_desc";
            }
        
            if(sortby.equalsIgnoreCase("relevance") || sortby.equalsIgnoreCase("popularity") || sortby.equalsIgnoreCase("price_asc") || sortby.equalsIgnoreCase("price_desc"))
           
               {    
                    j=0;
                    for(pageno=1;pageno<=1;pageno++)
                    {
                        String url = "https://www.flipkart.com/search?q="+f_str+"&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&sort="+sortby+"&page="+pageno;
                        try {
                            document = Jsoup.connect(url).get();
                        } catch (IOException ex) {
                            Logger.getLogger(scraper_chatbot.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Elements f_price = document.select("div._1vC4OE");
                        Elements f_item = document.select("a._2mylT6[title]");
                        Elements f_company = document.select("div._2B_pmu");
                        Elements f_links = document.select("a._2mylT6");
                        JOptionPane.showMessageDialog(null,"Fetching Results from Page "+pageno+" from Flipkart");
                        
                      String product_price = "";
                      String final_product_price = "";
                        
                        for(int i=0;i<f_links.size();i++)
                        {
                            product_price = "";
                           final_product_price = "";
                           product_price = f_price.get(i).text().substring(1);
                           
                           for(int z=0;z<product_price.length();z++)
                           {
                               if(product_price.charAt(z) != ',')
                               {
                                  final_product_price += product_price.charAt(z);
                               }
                           }
                           
                           if (final_product_price.compareTo(allowable_product_price) <= 0)
                           {
                               jTextArea1.append((++j)+")  "+ " COMPANY : "+f_company.get(i).text()+"   "+" PRODUCT : "+f_item.get(i).text());
                           jTextArea1.append("\n PRICE : "+final_product_price+"\n"+" LINK : "+f_links.get(i).attr("abs:href")+"\n"+"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
                                   + "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n\n");
                               
                           }
                        }
                        
                        
                        
                        jTextArea1.append("\n\n\n\n");
                        JOptionPane.showMessageDialog(null,"Fetching Results from Page "+pageno+ " from Jabong");
                        url = "https://www.jabong.com/find/"+j_str+"?sort="+sortby;
                        try {
                            document = Jsoup.connect(url).userAgent("Opera").get();
                        } catch (IOException ex) {
                            Logger.getLogger(scraper_chatbot.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Elements j_price = document.select("div.col-xxs-6.col-xs-4.col-sm-4.col-md-3.col-lg-3.product-tile.img-responsive[data-discount-price]");
                        Elements j_item = document.select("div.col-xxs-6.col-xs-4.col-sm-4.col-md-3.col-lg-3.product-tile.img-responsive[data-name]");
                        Elements j_company = document.select("div.col-xxs-6.col-xs-4.col-sm-4.col-md-3.col-lg-3.product-tile.img-responsive[data-brand]");
                        Elements j_links = document.select("a.tile-cta.unadjusted");
                        
                        
                        
                        for(int i=0;i<j_links.size();i++)
                        {
                            if (j_price.get(i).attr("data-discount-price").compareTo(allowable_product_price) <= 0)
                           {
                               jTextArea1.append((++j)+")  "+ " COMPANY : "+j_company.get(i).attr("data-brand")+"   "+" PRODUCT : "+j_item.get(i).attr("data-name"));
                           jTextArea1.append("\n PRICE : Rs."+j_price.get(i).attr("data-discount-price")+"\n"+" LINK : "+j_links.get(i).attr("abs:href")+"\n"+"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
                                   + "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n\n");
                           }
                        }
                   }
                    
                    
                    if(sortby_sp.equalsIgnoreCase("relevance"))
                    {
                        sortby_sp = "rlvncy";
                    }
                    else if(sortby_sp.equalsIgnoreCase("popularity"))
                    {
                        sortby_sp = "plrty";
                    }
                    else if(sortby_sp.equalsIgnoreCase("price ascending"))
                    {
                        sortby_sp = "plth";
                    }
                    else if(sortby_sp.equalsIgnoreCase("price descending"))
                    {
                        sortby_sp = "phtl";
                    }
                    if(sortby_sp.equalsIgnoreCase("rlvncy") || sortby_sp.equalsIgnoreCase("plrty") || sortby_sp.equalsIgnoreCase("plth") || sortby_sp.equalsIgnoreCase("phtl"))
                    {
                        String url = "https://www.snapdeal.com/search?keyword="+sp_str+"&sort="+sortby_sp; //Logger.getLogger(scraper_chatbot.class.getName()).log(Level.SEVERE, null, ex);
                        try {
                            document = Jsoup.connect(url).get();
                        } catch (IOException ex) {
                            Logger.getLogger(scraper_chatbot.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Elements sp_price = document.select("span.lfloat.product-price[display-price]");
                        Elements sp_item = document.select("p.product-title[title]");
                        Elements sp_links = document.select("div.product-tuple-image a");
                        jTextArea1.append("\n\n\n\n");
                        JOptionPane.showMessageDialog(null,"Fetching Results from Page "+1+ " from SnapDeal");
                        for(int i=0;i<sp_item.size();i++)
                        {
                            
                            if(sp_price.get(i).attr("display-price").compareTo(allowable_product_price) <=0 )
                            {
                                if (sp_price.get(i).attr("data-discount-price").compareTo(allowable_product_price) <= 0)
                                    {
                                        jTextArea1.append((++j)+" "+" PRODUCT : "+sp_item.get(i).attr("title"));
                           jTextArea1.append("\n PRICE : Rs."+sp_price.get(i).attr("display-price")+"\n"+" LINK : "+sp_links.get(i).attr("abs:href")+"\n"+"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
                                   + "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n\n");
                                    }
                            }
                            
                            
                        }
                     }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Select Parameter For Optimization");
                    
                    }
                }
               
            else
                {
                  JOptionPane.showMessageDialog(null,"Select Parameter For Optimization");
                }
        
    }//GEN-LAST:event_button1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        for(String element : arr)
        {
            if(!arr_u.contains(element))
            {
                arr_u.add(element);
            }
        }
        
        
        for(int i=0;i<4;i++) 
        {
           f_str.append(arr_u.get(i)+" ");
           j_str.append(arr_u.get(i)+"-");
        }
         for(int i=0;i<3;i++) 
        {
           sp_str.append(arr_u.get(i)+"%20");
        }
        
        allowable_product_price = arr_u.get((arr_u.size()-1));
       
        
        
        label2.setText("Searching for "+f_str);
        
    }//GEN-LAST:event_formWindowOpened

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
       String my_url = jTextField1.getText();
        
        try
        {
            Desktop.getDesktop().browse(java.net.URI.create(my_url));
        }
        catch( java.io.IOException e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       selection s = new selection();
       s.setVisible(true);
       dispose();
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         khoj_bot r;
       try {
           r = new khoj_bot();
           r.setVisible(true);
        dispose();
       } catch (IOException ex) {
           Logger.getLogger(scraper_chatbot.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(scraper_chatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scraper_chatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scraper_chatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scraper_chatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scraper_chatbot(arr).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    // End of variables declaration//GEN-END:variables
}
