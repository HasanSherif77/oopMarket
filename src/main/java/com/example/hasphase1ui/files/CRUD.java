package com.example.hasphase1ui.files;

public interface CRUD {
    void add(Object object);
    void remove(Object object);
    void update(Object object,String oldObjectName);
    Object read(String objectName);
}
