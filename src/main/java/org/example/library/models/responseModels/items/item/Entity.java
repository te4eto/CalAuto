package org.example.library.models.responseModels.items.item;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Entity{
    public String _type;
    public Object category;
    public Object color;
    public int dictionaryId;
    public Object icon;
    public int id;
    public int listIndex;
    public String name;
    public int ownerId;
    public ArrayList<Translation> translations;
    public int translationsCount;
}