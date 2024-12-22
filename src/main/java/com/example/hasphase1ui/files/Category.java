package com.example.hasphase1ui.files;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryName;
    private String categoryImage ;

    public String getCategoryName() {
        return categoryName;
    }


    public Category(String categoryName,String categoryImage){
        this.categoryName=categoryName;
        this.categoryImage=categoryImage;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

}
