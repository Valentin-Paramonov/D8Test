package paramonov.valentine.d8test.bean;

import org.hibernate.validator.constraints.Range;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@GroupSequence({User.class, NotNull.class, Size.class, Pattern.class, Range.class})
public class User {
    private long id;

    @NotNull(groups = NotNull.class)
    @Size(min = 1, groups = Size.class)
    @Pattern(regexp = "^[a-zA-z]+$", groups = Pattern.class)
    private String name;

    @NotNull(groups = NotNull.class)
    @Range(min = 1, groups = Range.class)
    private int age;

    private boolean active;

    private List<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
