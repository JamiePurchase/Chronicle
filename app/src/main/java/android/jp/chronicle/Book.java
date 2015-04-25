package android.jp.chronicle;

public class Book
{
    private int bookID;
    private String title;
    private String colour;
    private Page[] pages = new Page[99];

    public Book(int bookID, String title, String colour)
    {
        this.bookID = bookID;
        this.title = title;
        this.colour = colour;
    }

    public void addPage(Page page)
    {
        int newID = pages.length;
        pages[newID] = page;
    }

}