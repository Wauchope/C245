package Classwork.DaySeven;

public class Person {
    String name;
    int column1;
    int column2;

    public final static int numColumns = 2;

    public Person(String name, int column1, int column2) {
        this.name = name;
        this.column1 = column1;
        this.column2 = column2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getData() {
        return new int[]{column1, column2};
    }

    public int getColumn1() {
        return column1;
    }

    public void setColumn1(int column1) {
        this.column1 = column1;
    }

    public int getColumn2() {
        return column2;
    }

    public void setColumn2(int column2) {
        this.column2 = column2;
    }

    public int SumColumns() {
        return column1 + column2;
    }
}
