package ru.kelcuprum.caffeinelib.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GsonUtils {
    public static String getStringInJSON(String path, JsonObject parse){
        return getStringInJSON(path, parse, null);
    }
    public static String getStringInJSON(String path, JsonObject parse, String defResp){
        if(!jsonElementIsNull(path, parse)) return defResp;
        String[] keys = path.split("\\.");
        JsonObject jsonObject = parse;
        for(String key : keys){
            if(jsonObject.has(key)){
                JsonElement json = jsonObject.get(key);
                if(json.isJsonObject()) jsonObject = (JsonObject) json;
                else if(json.isJsonPrimitive() && json.getAsJsonPrimitive().isString() && !json.getAsString().isBlank()) return json.getAsString();
            }
        }
        return defResp;
    }

    public static Number getNumberInJSON(String path, JsonObject parse){
        return getNumberInJSON(path, parse, null);
    }
    public static Number getNumberInJSON(String path, JsonObject parse, Number defResp){
        if(!jsonElementIsNull(path, parse)) return defResp;
        String[] keys = path.split("\\.");
        JsonObject jsonObject = parse;
        for(String key : keys){
            if(jsonObject.has(key)){
                JsonElement json = jsonObject.get(key);
                if(json.isJsonObject()) jsonObject = (JsonObject) json;
                else if(json.isJsonPrimitive() && json.getAsJsonPrimitive().isNumber()) return json.getAsNumber();
            }
        }
        return defResp;
    }

    public static JsonElement getJsonElementFromObject(String path, JsonObject parse){
        return getJsonElementFromObject(path, parse, null);
    }
    public static JsonElement getJsonElementFromObject(String path, JsonObject parse, JsonElement defResp){
        if(!jsonElementIsNull(path, parse)) return defResp;
        String[] keys = path.split("\\.");
        JsonObject jsonObject = parse;
        for(String key : keys){
            if(jsonObject.has(key)){
                JsonElement json = jsonObject.get(key);
                if(json.isJsonObject()) jsonObject = (JsonObject) json;
                else return json;
            }
        }
        return defResp;
    }

    public static boolean getBooleanInJSON(String path, JsonObject parse, boolean defResp){
        if(!jsonElementIsNull(path, parse)) return defResp;
        String[] keys = path.split("\\.");
        JsonObject jsonObject = parse;
        for(String key : keys){
            if(jsonObject.has(key)){
                JsonElement json = jsonObject.get(key);
                if(json.isJsonObject()) jsonObject = (JsonObject) json;
                else if(json.isJsonPrimitive() && json.getAsJsonPrimitive().isBoolean()) return json.getAsBoolean();
            }
        }
        return defResp;
    }

    public static boolean jsonElementIsNull(String path, JsonObject parse){
        String[] keys = path.split("\\.");
        JsonObject jsonObject = parse;
        for(String key : keys){
            if(jsonObject.has(key)){
                JsonElement json = jsonObject.get(key);
                if(json.isJsonObject() && !keys[keys.length-1].equals(key)) jsonObject = (JsonObject) json;
                else if(!json.isJsonNull()) return false;
            }
        }
        return true;
    }
}
