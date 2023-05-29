package com.example.flytoelephant.network;

import java.util.List;

public class Dictionary {
    private Object head;

    private List<Definition> def;

    public Object getHead() {
        return head;
    }

    public void setHead(Object head) {
        this.head = head;
    }

    public List<Definition> getDef() {
        return def;
    }

    public void setDef(List<Definition> def) {
        this.def = def;
    }
}
