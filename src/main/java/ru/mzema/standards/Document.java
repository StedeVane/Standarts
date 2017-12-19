package ru.mzema.standards;

import java.io.InputStream;

public class Document {

    public int id;
    public String name;
    public InputStream file;

    public Document(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
