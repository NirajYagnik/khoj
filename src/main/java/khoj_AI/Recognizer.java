package khoj_AI;

import tablelayout.Table;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.tensorflow.DataType;
import org.tensorflow.Graph;
import org.tensorflow.Output;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import java.util.*;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Recognizer extends JFrame implements ActionListener {

    private Table table;
    private JButton predict;
    public String classification="";
    public String product_color ="";
    private JButton scrape;
    private JButton incep;
    private JButton back;
    private JButton img;
    private JFileChooser incepch;
    private JFileChooser imgch;
    private JLabel viewer;
    private JTextField result;
    private JTextField imgpth;
    private JTextField modelpth;
    private FileNameExtensionFilter imgfilter = new FileNameExtensionFilter(
            "JPG & JPEG Images", "jpg", "jpeg");
    private String modelpath;
    private String imagepath;
    private boolean modelselected = false;
    private byte[] graphDef;
    private List<String> labels;

    public Recognizer() {
        setTitle("Object Recognition - Khoj");
        setSize(600, 700);
        setBackground(Color.green);
        table = new Table();
        JLabel image_holder = new JLabel();
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Niraj\\Desktop\\object-recognition-tensorflow-master\\object-recognition-tensorflow-master\\src\\main\\java\\image_s\\3df824df-82b8-4072-be29-211263aa2bd8_200x200.png");
        image_holder.setIcon(imageIcon);
        scrape = new JButton("Get Recommendation");
        back = new JButton("Go Back");
        //scrape.setEnabled(false);
        predict = new JButton("Predict");
        predict.setEnabled(false);
        incep = new JButton("Choose Inception");
        img = new JButton("Choose Image");
        incep.addActionListener(this);
        img.addActionListener(this);
        predict.addActionListener(this);
        scrape.addActionListener(this);
        back.addActionListener(this);

        incepch = new JFileChooser();
        imgch = new JFileChooser();
        imgch.setFileFilter(imgfilter);
        imgch.setFileSelectionMode(JFileChooser.FILES_ONLY);
        incepch.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        result = new JTextField();
        modelpth = new JTextField();
        imgpth = new JTextField();
        modelpth.setEditable(false);
        imgpth.setEditable(false);
        viewer = new JLabel();

        getContentPane().setBackground(new java.awt.Color(132, 66, 245));
        getContentPane().add(table);
        table.row();
        table.addCell(back).left().padTop(0).colspan(2).padLeft(0);
        table.row();
        table.row();
        table.addCell(image_holder);
        //table.row();
        JLabel ChatBot = new JLabel("Classifier");
        ChatBot.setFont(new java.awt.Font("Nirmala UI", 0, 34));
        
        table.addCell(ChatBot).center().padTop(0).colspan(100).padLeft(0);
        table.row();
        table.row();
        table.row();
        table.row();
        table.addCell(modelpth).width(250);
        table.addCell(incep);
        table.row();
        table.addCell(imgpth).width(250);
        table.addCell(img);

        table.row();
        table.row();
        table.addCell(viewer).size(200, 200).colspan(2);
        table.row();
        table.addCell(predict).colspan(2);
        table.row();
        table.addCell(result).width(300).colspan(2);
        table.row();
        table.row();
        table.addCell(scrape).colspan(2);
        table.row();
        table.addCell(new JLabel("Khoj")).center().padTop(30).colspan(2);
        table.row();
        table.addCell(new JLabel("Simplifying Search")).center().colspan(2);
        

        setLocationRelativeTo(null);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == incep) {
            int returnVal = incepch.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = incepch.getSelectedFile();
                modelpath = file.getAbsolutePath();
                modelpth.setText(modelpath);
                System.out.println("Opening: " + file.getAbsolutePath());
                modelselected = true;
                graphDef = readAllBytesOrExit(Paths.get(modelpath, "tensorflow_inception_graph.pb"));
                labels = readAllLinesOrExit(Paths.get(modelpath, "imagenet_comp_graph_label_strings.txt"));
            } else {
                System.out.println("Process was cancelled by user.");
            }

        } else if (e.getSource() == img) {
            int returnVal = imgch.showOpenDialog(Recognizer.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = imgch.getSelectedFile();
                    imagepath = file.getAbsolutePath();
                    imgpth.setText(imagepath);
                    BufferedImage image = ImageIO.read(new File(imagepath));
                    Color C = new Color(image.getRGB(image.getHeight() / 2, image.getWidth() / 2));
                    int r = C.getRed();
                    int g = C.getGreen();
                    int b = C.getBlue();
                    System.out.println("Red is " + r + " Green:" + g + " Blue:" + b);
                    if (r > 200 && g < 100 && b < 100) {
                        System.out.println("color is red");
                        product_color="red";
                    }
                    if (b > 150 && g < 100 && r < 100) {
                        System.out.println("color is blue");
                        product_color = "blue";
                    }
                    if (g > 75 && r < 140 && b < 140) {
                        System.out.println("color is green");
                        product_color = "green";
                    }
                    if (r > 215 && g < 190 && g > 100 && b < 70) {
                        System.out.println("color is orange");
                        product_color = "orange";
                    }
                    if (r > 200 && g > 200 && b > 200) {
                        System.out.println("color is white");
                        product_color = "white";
                    }
                    if (r < 60 && g < 60 && b < 60) {
                        System.out.println("color is black");
                        product_color ="black";
                    }
                    if (r > 200 && g > 200 && b < 100) {
                        System.out.println("color is yellow");
                        product_color = "yellow";
                    }
                    if (r < 220 && r > 60 && g < 220 && g > 60 && b < 220 && b > 60) {
                        System.out.println("color is gray");
                        product_color = "gray";
                    }
                    //System.out.println(product_image);
                    System.out.println("Image Path: " + imagepath);
                    Image img = ImageIO.read(file);

                    viewer.setIcon(new ImageIcon(img.getScaledInstance(200, 200, 200)));
                    if (modelselected) {
                        predict.setEnabled(true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Recognizer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Process was cancelled by user.");
            }
        } else if (e.getSource() == predict) {
            byte[] imageBytes = readAllBytesOrExit(Paths.get(imagepath));

            try (Tensor image = Tensor.create(imageBytes)) {
                float[] labelProbabilities = executeInceptionGraph(graphDef, image);
                int bestLabelIdx = maxIndex(labelProbabilities);
                result.setText("");
                result.setText(String.format(
                        "BEST MATCH: %s (%.2f%% likely) Color %s",
                        labels.get(bestLabelIdx), labelProbabilities[bestLabelIdx] * 100f,product_color));
                System.out.println(
                        String.format(
                                "BEST MATCH: %s (%.2f%% likely)",
                                labels.get(bestLabelIdx), labelProbabilities[bestLabelIdx] * 100f));
                classification = labels.get(bestLabelIdx);

            }

        }
        else if(e.getSource() == scrape)
        {
            Scraper a = new Scraper(product_color,classification);
            a.setVisible(true);
            dispose();
        }
         else if(e.getSource() == back)
        {
            selection s =  new selection();
            s.setVisible(true);
            dispose();
        }
    }

    ///
    public String fetch() {
        String a = result.getText();
        return a;
    }

    private static float[] executeInceptionGraph(byte[] graphDef, Tensor image) {
        try (Graph g = new Graph()) {
            g.importGraphDef(graphDef);
            try (Session s = new Session(g);
                    Tensor result = s.runner().feed("DecodeJpeg/contents", image).fetch("softmax").run().get(0)) {
                final long[] rshape = result.shape();
                if (result.numDimensions() != 2 || rshape[0] != 1) {
                    throw new RuntimeException(
                            String.format(
                                    "Expected model to produce a [1 N] shaped tensor where N is the number of labels, instead it produced one with shape %s",
                                    Arrays.toString(rshape)));
                }
                int nlabels = (int) rshape[1];
                return result.copyTo(new float[1][nlabels])[0];
            }
        }
    }

    private static int maxIndex(float[] probabilities) {
        int best = 0;
        for (int i = 1; i < probabilities.length; ++i) {
            if (probabilities[i] > probabilities[best]) {
                best = i;
            }
        }
        return best;
    }

    private static byte[] readAllBytesOrExit(Path path) {
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.err.println("Failed to read [" + path + "]: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    private static List<String> readAllLinesOrExit(Path path) {
        try {
            return Files.readAllLines(path, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.err.println("Failed to read [" + path + "]: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    // In the fullness of time, equivalents of the methods of this class should be auto-generated from
    // the OpDefs linked into libtensorflow_jni.so. That would match what is done in other languages
    // like Python, C++ and Go.
    static class GraphBuilder {

        GraphBuilder(Graph g) {
            this.g = g;
        }

        Output div(Output x, Output y) {
            return binaryOp("Div", x, y);
        }

        Output sub(Output x, Output y) {
            return binaryOp("Sub", x, y);
        }

        Output resizeBilinear(Output images, Output size) {
            return binaryOp("ResizeBilinear", images, size);
        }

        Output expandDims(Output input, Output dim) {
            return binaryOp("ExpandDims", input, dim);
        }

        Output cast(Output value, DataType dtype) {
            return g.opBuilder("Cast", "Cast").addInput(value).setAttr("DstT", dtype).build().output(0);
        }

        Output decodeJpeg(Output contents, long channels) {
            return g.opBuilder("DecodeJpeg", "DecodeJpeg")
                    .addInput(contents)
                    .setAttr("channels", channels)
                    .build()
                    .output(0);
        }

        Output constant(String name, Object value) {
            try (Tensor t = Tensor.create(value)) {
                return g.opBuilder("Const", name)
                        .setAttr("dtype", t.dataType())
                        .setAttr("value", t)
                        .build()
                        .output(0);
            }
        }

        private Output binaryOp(String type, Output in1, Output in2) {
            return g.opBuilder(type, type).addInput(in1).addInput(in2).build().output(0);
        }

        private Graph g;
    }
    ////////////

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Recognizer().setVisible(true);

            }
        });
    }

}
