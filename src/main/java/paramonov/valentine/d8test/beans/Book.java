package paramonov.valentine.d8test.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
    private long id;

    @NotNull
    @Size(min = 1)
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
