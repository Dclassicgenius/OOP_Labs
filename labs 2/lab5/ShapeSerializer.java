package ru.labs.lab5;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ShapeSerializer implements JsonSerializer<ShapeHolder> {

    @Override
    public JsonElement serialize(ShapeHolder src, Type typeOfSrc, JsonSerializationContext context) {
        if (src.getShapes() == null || src.getShapes().isEmpty())
            return null;
        JsonArray elem = context.serialize(src.getShapes()).getAsJsonArray();
        if (elem == null) return null;
        for (int i = 0; i < elem.size(); i++) {
            JsonElement jsonElement = elem.get(i);
            jsonElement.getAsJsonObject().addProperty("type", src.getShapes().get(i).getClass().getSimpleName());
        }
        return elem;
    }
}
