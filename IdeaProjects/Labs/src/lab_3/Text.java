package lab_3;

import java.util.Objects;

public class Text{

    private String text;
    private String author;
    private int year;


    public Text(String text) {
        this.text = text;
    }

    public Text(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public Text(String text, String author, int year) {
        this.text = text;
        this.author = author;
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int nr_de_cuvinte(){
        return text.split("\\s+").length;
    }

    public int nr_de_cuvinte(int limit){
        return text.substring(0, limit).split("\\s+").length;
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
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        Text t = (Text) o;
        return this.text.equals(t.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, author, year);
    }

    @Override
    public String toString() {

        return "  Text{" +
                "\ntext='" + text + '\n' +
                "author='" + author + '\n' +
                "year=" + year +
                '}';
    }
}
