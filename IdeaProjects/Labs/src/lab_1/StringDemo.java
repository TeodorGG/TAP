package lab_1;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringDemo {

    private static final String ERROR_1 = "First plane is empty, please input text!";
    private static final String ERROR_2 = "Char is not input!";
    private static final String ERROR_3 = "Substring is not input!";


    private static JFrame base;
    private static JButton b_parse;
    private static JTextField  c_tf, r_tf;
    private static JTextPane tf_big, result_text;
    private static JLabel c_text, r_text, tf_text;

    public static void main(String[] args) {

        createFrame();
        logic();

    }

    private static void logic() {

        b_parse.addActionListener(new ActionListener() {
            String big_text, c, w;

            @Override
            public void actionPerformed(ActionEvent e) {

                big_text = tf_big.getText();
                c = c_tf.getText();
                w = r_tf.getText();
                if(big_text.isEmpty()){
                    result_text.setText(ERROR_1);
                    return;
                }

                if(c.isEmpty()){
                    result_text.setText(ERROR_2);
                    return;
                }

                if(w.isEmpty()){
                    result_text.setText(ERROR_3);
                    return;
                }

                result_text.setText(big_text.replaceAll(c, c+w));

            }
        });
    }

    private static void createFrame() {

        base = new JFrame("String demo");

        tf_big = new JTextPane();
        c_tf = new JTextField();
        r_tf = new JTextField();

        c_text = new JLabel("After");
        tf_text = new JLabel("Input text");
        r_text = new JLabel("add");

        result_text = new JTextPane();

        b_parse = new JButton("Refactor");

        tf_text.setBounds(50, 25, 300, 25);

        tf_big.setBounds(50, 50, 300, 100);

        c_text.setBounds(50, 175, 50,25);
        c_tf.setBounds(80, 175, 50,25);
        c_tf.setDocument(new JTextFieldLimit(1));
        r_text.setBounds(130, 175, 100,25);
        r_tf.setBounds(155, 175, 50,25);
        c_tf.setDocument(new JTextFieldLimit(10));

        b_parse.setBounds(50, 275, 125, 25);

        result_text.setBounds(50, 325, 300, 100);
        result_text.setEditable(false);

        base.add(tf_big);
        base.add(c_tf);
        base.add(r_tf);
        base.add(b_parse);
        base.add(c_text);
        base.add(r_text);
        base.add(tf_text);
        base.add(result_text);

        base.setSize(400,700);
        base.setLayout(null);
        base.setVisible(true);

    }
}

class JTextFieldLimit extends PlainDocument {
    private int limit;
    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    JTextFieldLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}