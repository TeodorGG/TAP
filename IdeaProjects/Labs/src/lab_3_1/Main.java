package lab_3_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class Pagina extends Text{

    private int page;

    public Pagina(String text, int page) {
        super(text);
        this.page = page;
    }


}

class Text extends Object{

    private String text;

    public Text(String text) {
        this.text = text;
    }


    public int nr_de_cuvinte(){
        return text.split("\\s+").length;
    }

    public int nr_de_cuvinte(int limit){
        return text.substring(0, limit).split("\\s+").length;
    }

    public int nr_de_cuvinte(int start, int end){
        return text.substring(start, end).split("\\s+").length;
    }

    public String getWord(int index){

        return text.split("\\s+")[index];
    }

    public String getWord(int indexStart, int indexEnd){

        String [] list = text.split("\\s+");
        StringBuilder a = new StringBuilder();
        for(int i = indexStart ; i <= indexEnd ; i++){
            a.append(list[i]).append(" ");
        }
        return a.toString();
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Text text1 = (Text) o;
        return Objects.equals(text, text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}

public class Main {

    private static JFrame frame;
    private static JLabel l_text_1, l_text_2, l_result, l_start;
    private static JTextField tf_text_1, tf_text_2, tf_start;
    private static JButton b_create, b_compare, b_getword, b_getnr;

    private static Text t1, t2;




    public static void main(String[] args) {
        createGUI();
        setLogic();
    }

    private static void setLogic() {
        b_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    t1 = new Pagina(tf_text_1.getText(), 1);
                    t2 = new Text(tf_text_2.getText());
                    l_result.setText("Object created");
                } catch (Exception ex){
                    l_result.setText("Error : " + ex.getMessage());
                }
            }
        });

        b_compare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    l_result.setText("t1 = t2 -> " + t2.equals(t1));
                } catch (Exception ex){
                    l_result.setText("Error : " + ex.getMessage());
                }
            }
        });

        b_getword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    l_result.setText(t1.getWord(Integer.parseInt(tf_start.getText())));
                } catch (Exception ex){
                    l_result.setText("Error : " + ex.getMessage());
                }
            }
        });

        b_getnr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    if(tf_start.getText().equals("1")) {
                        l_result.setText(t1.nr_de_cuvinte() + "");
                    } else if(tf_start.getText().equals("2")) {
                        l_result.setText(t2.nr_de_cuvinte()+"");
                    }
                } catch (Exception ex){
                    l_result.setText("Error : " + ex.getMessage());
                }
            }
        });


    }

    private static void createGUI() {
        frame = new JFrame("Lab 3");
        frame.setLayout(null);
        l_text_1 = new JLabel("Text 1 :");
        l_text_1.setBounds(25,25, 50,25);
        frame.add(l_text_1);

        tf_text_1 = new JTextField();
        tf_text_1.setBounds(100,25, 100,25);
        frame.add(tf_text_1);


        l_text_2 = new JLabel("Text 2 :");
        l_text_2.setBounds(25,50, 50,25);
        frame.add(l_text_2);

        tf_text_2 = new JTextField();
        tf_text_2.setBounds(100,50, 100,25);
        frame.add(tf_text_2);

        b_create = new JButton("Create");
        b_create.setBounds(250, 25, 100,25);
        frame.add(b_create);

        l_result = new JLabel("");
        l_result.setBounds(25, 250, 150, 30);
        frame.add(l_result);

        l_start = new JLabel("Value : ");
        l_start.setBounds(25, 150, 50, 30);
        frame.add(l_start);

        tf_start = new JTextField();
        tf_start.setBounds(80, 150, 50, 30);
        frame.add(tf_start);

        b_compare = new JButton("Compare");
        b_compare.setBounds(250, 50, 100,25);
        frame.add(b_compare);


        b_getword = new JButton("GetWord");
        b_getword.setBounds(200, 150, 150, 30);
        frame.add(b_getword);

        b_getnr = new JButton("GetNrOfWord");
        b_getnr.setBounds(200, 180, 150, 30);
        frame.add(b_getnr);

        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
