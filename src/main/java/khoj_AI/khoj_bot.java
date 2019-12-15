 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoj_AI;

import java.util.*;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyListener;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import opennlp.tools.doccat.BagOfWordsFeatureGenerator;
import opennlp.tools.doccat.DoccatFactory;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.doccat.FeatureGenerator;
import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;
//import static test1.yag_bot.prod_inputs;
//import static test1.yag_bot.vals;

/**
 *
 * @author Niraj
 */
public class khoj_bot extends javax.swing.JFrame {

    public int feature_count = 0;
    public String category = "";
    public static ArrayList<String> prod_inputs ;
    public String brand = "";
    public String product = "";
    public String color = "";
    public String price = "";
    public String[] allWords;
    //public String 
    private static Map<String, String> questionAnswer = new HashMap<>();
    public DoccatModel model;
    public static String vals[] = {"Good Choice ! what material of the product are you looking for ?", "What is the max price you are looking for?", "Any additional specification you would like us to take as input?"};

    /*
     * Define answers for each given category.
     */
    static {
        questionAnswer.put("greeting", "Hello, how can I help you?");
        questionAnswer.put("product-inquiry", "We will recommend you a compiled list of products based on your input ");
        questionAnswer.put("price-inquiry", "Price of the products is subject to the filters you provide");
        questionAnswer.put("conversation-continue", "What else can I help you with?");
        questionAnswer.put("conversation-complete", "Nice chatting with you. Bye.");
        questionAnswer.put("process-inquiry", "Khoj is a smart Web scraper and search optimizer");
        questionAnswer.put("input-initiate", "Great! Please enter the name of your product");
        questionAnswer.put("product-input", "Please be more specific regarding the product's characteristics such as color of the product to start of it");
        questionAnswer.put("color-input", "Any specific brand of interest ? ");
        questionAnswer.put("contant-input", "Thank you for your interest, You can contact us at 9022064477! ");
        questionAnswer.put("accuracy-input", "Image classifier has an accuracy of 78.1% on test dataset, while the chatbot has 87% classification acc");
        questionAnswer.put("about-bot", "KhojBot uses core NLP technologies like POS tagging, tokenization and Classification to get it's tast done");
        questionAnswer.put("about-classifier", "The Classifier uses Pretrained Inception V3 Model which is trained on over 14 million images for over 1000 categories");
        
        //questionAnswer.put("brand","Give the color");

    }
    //public String stopwords[] = {"want", "I", "like", "has", "with"};
    String[] stopword = {"want", "i", "like", "has", "with", "a","would","one"};

    ArrayList<String> stopwords = new ArrayList<String>(Arrays.asList("want", "i", "like", "has", "with", "a","the","an","with","and","one"));

    /**
     * Creates new form khoj_bot
     */
    public khoj_bot() throws IOException {
        initComponents();
         prod_inputs = new ArrayList<String>();

        JScrollPane scroll;

        model = trainCategorizerModel();

        dialog.setEditable(false);
        dialog.getCaretPosition();

        //input.addKeyListener((KeyListener) this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dialog = new java.awt.TextArea();
        input = new java.awt.TextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(95, 176, 51));

        jPanel3.setBackground(new java.awt.Color(59, 235, 47));

        dialog.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dialog.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 13)); // NOI18N
        dialog.setForeground(new java.awt.Color(0,0,0));

        input.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 18)); // NOI18N
        input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputKeyPressed(evt);
            }
        });
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\image_s\\question.png");
        jLabel4.setIcon(imageIcon);

        //jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_s/question.png"))); // NOI18N
        //jLabel4.setText("jLabel4");
        imageIcon = new ImageIcon("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\image_s\\users.png");
        jLabel5.setIcon(imageIcon);

        jButton1.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        jButton1.setText("Terminate");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();
            }

        });

        //jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/users.png"))); // NOI18N
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                                .addComponent(dialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(dialog, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialog.getAccessibleContext().setAccessibleDescription("");

        imageIcon = new ImageIcon("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\image_s\\bot.png");
        jLabel3.setIcon(imageIcon);
        imageIcon = new ImageIcon("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\image_s\\3df824df-82b8-4072-be29-211263aa2bd8_200x200.png");

        jLabel2.setIcon(imageIcon); // NOI18N

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 48)); // NOI18N
        jLabel1.setText("CHatBot");

        //jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/submit.png"))); // NOI18N
        //jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/round-left-button.png"))); // NOI18N
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(468, 468, 468)
                                                        .addComponent(jLabel6)))
                                        .addGap(0, 341, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(57, 57, 57))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel7))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel6)
                        .addGap(617, 617, 617))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputKeyPressed
        // TODO add your handling code here:
        dialog.setEditable(false);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            //input.setEditable(false);
            String quote = input.getText();
            String quote1 = "";
            String answer = "Your Filters have been saved";
            input.setText("");
            quote1 = quote.replace("\n", "");
            addText("-->You:\t" + quote1);
            System.out.println("##### You:");
            // Break users chat input into sentences using sentence detection.
            String[] sentences;
            //String[] allWords = original.toLowerCase().split(" ");

            if (category.contains("product-input")) {
                StringBuilder builder = new StringBuilder();
                String[] allWords = quote.toLowerCase().split(" ");
                for (String word : allWords) {
                    if (!stopwords.contains(word)) {
                        builder.append(word);
                        builder.append(' ');
                    }
                }
                prod_inputs.add(builder.toString().trim());
            }
            if (category.contains("color-input")) {
                /*if(feature_count == 0)
                 {
                 prod_inputs.add(quote.trim());
                 }*/
                if (feature_count == 3) {
                    category = "conversation-continue";
                    // answer = answer + " " + questionAnswer.get(category);
                    answer = questionAnswer.get(category);
                } else {
                    prod_inputs.add(quote.trim());
                    category = "color-input";
                    answer = vals[feature_count];
                    feature_count++;
                }

            } else {
                try {
                    if (feature_count == 3) {
                        feature_count = 0;
                        category = "conversation-continue";

                    } else {
                        sentences = breakSentences(quote);
                        boolean conversationComplete = false;
                        // Loop through sentences.
                        for (String sentence : sentences) {
                            // Separate words from each sentence using tokenizer.
                            String[] tokens = tokenizeSentence(sentence);
                            // Tag separate d words with POS tags to understand their gramatical structure.
                            String[] posTags = detectPOSTags(tokens);
                            // Lemmatize each word so that its easy to categorize.
                            String[] lemmas = lemmatizeTokens(tokens, posTags);// Determine BEST category using lemmatized tokens used a mode that we trained
                            // at start.
                            category = detectCategory(model, lemmas);
                //System.out.println("category: "+ category);

                        // Get predefined answer from given category & add to answer.
                /*addText("##### Chat Bot: " + answer);
                             input.setEditable(true);
                             for(int i = 0; i< 3;i++)
                             {
                             System.out.println("##### You:");
                             prod_inputs.add(userInput_1);
                             System.out.println("##### Chat Bot: " + vals[i]);
                             }
                             String userInput_1 = scanner.nextLine();
                             prod_inputs.add(userInput_1);
                             answer = "What else can I help you with?";
                             */
                            //answer = answer + " " + questionAnswer.get(category);
                            if (category.contains("color-input")) {
                                StringBuilder builder = new StringBuilder();
                                String[] allWords = quote.toLowerCase().split(" ");
                                for (String word : allWords) {
                                    if (!stopwords.contains(word)) {
                                        builder.append(word);
                                        builder.append(' ');
                                    }
                                }
                                prod_inputs.add(builder.toString().trim());
                                //prod_inputs.add(quote.trim());
                            }
                            if (category.contains("product-input")) {
                                StringBuilder builder = new StringBuilder();
                                String[] allWords = quote.toLowerCase().split(" ");
                                for (String word : allWords) {
                                    if (!stopwords.contains(word)) {
                                        builder.append(word);
                                        builder.append(' ');
                                    }
                                }
                                prod_inputs.add(builder.toString().trim());
                                //prod_inputs.add(quote.trim());
                                //prod_inputs.add(quote.trim());
                            }

                            answer = questionAnswer.get(category);

                            if ("conversation-complete".equals(category)) {
                                conversationComplete = true;

                            }
                        }

                        // Print answer back to user. If conversation is marked as complete, then end
                        // loop & program.
                        if (conversationComplete) {
                            scraper_chatbot cal = new scraper_chatbot(prod_inputs);
                            cal.setVisible(true);
                            dispose();

                        }
                        //addText("\n");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(khoj_bot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            addText("\n");
            addText("-->ChatBot: " + answer);
            addText("\n");
            System.out.println("##### Chat Bot: " + answer);
            System.out.println(prod_inputs);

            //quote.trim();
        }
    }//GEN-LAST:event_inputKeyPressed

    /**
     * @param args the command line arguments
     */
    public void addText(String str) {
        dialog.setText(dialog.getText() + str);
        scrollDown();
    }

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
            java.util.logging.Logger.getLogger(khoj_bot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(khoj_bot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(khoj_bot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(khoj_bot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new khoj_bot().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(khoj_bot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * Train categorizer model as per the category sample training data we
     * created.
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static DoccatModel trainCategorizerModel() throws FileNotFoundException, IOException {
        // faq-categorizer.txt is a custom training data with categories as per our chat
        // requirements.
        InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\khoj_AI\\faq-cat-enhanced.txt"));
        ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

        DoccatFactory factory = new DoccatFactory(new FeatureGenerator[]{new BagOfWordsFeatureGenerator()});

        TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
        params.put(TrainingParameters.CUTOFF_PARAM, 0);

        // Train a model with classifications from above file.
        DoccatModel model = DocumentCategorizerME.train("en", sampleStream, params, factory);
        return model;
    }

    /**
     * Detect category using given token. Use categorizer feature of Apache
     * OpenNLP.
     *
     * @param model
     * @param finalTokens
     * @return
     * @throws IOException
     */
    private static String detectCategory(DoccatModel model, String[] finalTokens) throws IOException {

        // Initialize document categorizer tool
        DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);

        // Get best possible category.
        double[] probabilitiesOfOutcomes = myCategorizer.categorize(finalTokens);
        String category = myCategorizer.getBestCategory(probabilitiesOfOutcomes);
        System.out.println("Category: " + category);

        return category;

    }

    /**
     * Break data into sentences using sentence detection feature of Apache
     * OpenNLP.
     *
     * @param data
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static String[] breakSentences(String data) throws FileNotFoundException, IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\khoj_AI\\en-sent.bin")) {

            SentenceDetectorME myCategorizer = new SentenceDetectorME(new SentenceModel(modelIn));

            String[] sentences = myCategorizer.sentDetect(data);
            System.out.println("Sentence Detection: " + Arrays.stream(sentences).collect(Collectors.joining(" | ")));

            return sentences;
        }
    }

    /**
     * Break sentence into words & punctuation marks using tokenizer feature of
     * Apache OpenNLP.
     *
     * @param sentence
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static String[] tokenizeSentence(String sentence) throws FileNotFoundException, IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\khoj_AI\\en-token.bin")) {

            // Initialize tokenizer tool
            TokenizerME myCategorizer = new TokenizerME(new TokenizerModel(modelIn));

            // Tokenize sentence.
            String[] tokens = myCategorizer.tokenize(sentence);
            System.out.println("Tokenizer : " + Arrays.stream(tokens).collect(Collectors.joining(" | ")));

            return tokens;

        }
    }

    /**
     * Find part-of-speech or POS tags of all tokens using POS tagger feature of
     * Apache OpenNLP.
     *
     * @param tokens
     * @return
     * @throws IOException
     */
    private static String[] detectPOSTags(String[] tokens) throws IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\khoj_AI\\en-pos-maxent.bin")) {

            // Initialize POS tagger tool
            POSTaggerME myCategorizer = new POSTaggerME(new POSModel(modelIn));

            // Tag sentence.
            String[] posTokens = myCategorizer.tag(tokens);
            System.out.println("POS Tags : " + Arrays.stream(posTokens).collect(Collectors.joining(" | ")));

            return posTokens;

        }

    }

    /**
     * Find lemma of tokens using lemmatizer feature of Apache OpenNLP.
     *
     * @param tokens
     * @param posTags
     * @return
     * @throws InvalidFormatException
     * @throws IOException
     */
    private static String[] lemmatizeTokens(String[] tokens, String[] posTags)
            throws InvalidFormatException, IOException {
        // Better to read file once at start of program & store model in instance
        // variable. but keeping here for simplicity in understanding.
        try (InputStream modelIn = new FileInputStream("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\khoj_AI\\en-lemmatizer.bin")) {

            // Tag sentence.
            LemmatizerME myCategorizer = new LemmatizerME(new LemmatizerModel(modelIn));
            String[] lemmaTokens = myCategorizer.lemmatize(tokens, posTags);
            System.out.println("Lemmatizer : " + Arrays.stream(lemmaTokens).collect(Collectors.joining(" | ")));

            return lemmaTokens;

        }
    }

    public void scrollDown() {
        dialog.setCaretPosition(dialog.getText().length());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea dialog;
    private java.awt.TextArea input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
