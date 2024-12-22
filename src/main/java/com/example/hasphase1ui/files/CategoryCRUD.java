package com.example.hasphase1ui.files;

import java.util.ArrayList;
import java.util.List;

public class CategoryCRUD implements CRUD{
    private static  ArrayList<Category> categories = Database.getCategories();

    @Override
    public void add(Object object) {
        Category newCategory = (Category) object;
        categories.add(newCategory);
    }

    @Override
    public void remove(Object object) {
        Category categoryToBeRemoved = (Category) object;
        categories.remove(categoryToBeRemoved);
    }
    @Override
    public void update(Object object, String oldObjectName) {
        Category updatedCategory = (Category) object;
        Category categoryToBeUpdated = read(oldObjectName);
        categoryToBeUpdated =updatedCategory;
    }
    @Override
    public Category read(String objectName) {
        for (Category category :categories){
            if (category.getCategoryName().equals(objectName)){
                return category;
            }
        }
        return null;
    }

}
