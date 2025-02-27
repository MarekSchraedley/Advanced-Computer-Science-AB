package Q3.prog505a;

public class Cl505a implements Comparable<Cl505a> {
    @Override
    public int compareTo(Cl505a thing) {return this.name.compareTo(thing.name);}
    private String name;
    private Integer books;
    public Cl505a(String myName, int myBooks) {
        name = myName;
        books = myBooks;
    }
    public String getName() {return name;}
    public Integer getBooks() {return books;}


}
