package lab_3;

import java.util.Objects;

public class Pagina extends Text {
    private float height;
    private float width;

    public Pagina(String text, float height, float width) {
        super(text);
        this.height = height;
        this.width = width;
    }

    public Pagina(String text) {
        super(text);
    }

    public Pagina(String text, String author) {
        super(text, author);
    }

    public Pagina(String text, String author, int year) {
        super(text, author, year);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        Pagina pagina = (Pagina) o;
        return Float.compare(pagina.height, height) == 0 && Float.compare(pagina.width, width) == 0 && super.getText().equals(pagina.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public String toString() {
        return  super.toString() + "\n  Pagina{" +
                "\nheight=" + height + "\n" +
                "width=" + width + "\n" +

                '}';
    }
}
