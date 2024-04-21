package com.example.io.objectstream;

import java.io.Serializable;

public class Organization implements Serializable {
    private long id;

    Organization(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
