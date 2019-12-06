package day1;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {


        this.length = length;
        this.width = width;

        setLength(width);
        setWidth(length);

    }



    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0. (length = " + length + ") ");
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            IllegalArgumentException e = new IllegalArgumentException("Width must be greater than 0");
            throw e;
        }
        this.width = width;
    }


}
