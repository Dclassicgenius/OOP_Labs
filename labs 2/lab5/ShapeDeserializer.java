package ru.labs.lab5;

import com.google.gson.*;

import java.lang.reflect.Type;

class ShapeDeserializer implements JsonDeserializer<Shape> {
    @Override
    public Shape deserialize(JsonElement json, Type typeOfT,
                             JsonDeserializationContext context)
                             throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement type = jsonObject.get("type");
        if (type != null) {
            switch (type.getAsString()) {
                case "Rectangle":
                    return context.deserialize(jsonObject, 
                        Rectangle.class);
                case "Circle":
                    return context.deserialize(jsonObject, 
                        Circle.class);
                case "Square":
                    return context.deserialize(jsonObject, 
                        Square.class);
                case "Triangle":
                    return context.deserialize(jsonObject,Triangle.class);
            }
        }
        return null;
    }
}