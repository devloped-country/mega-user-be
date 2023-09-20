package com.mega.biz.join.model.dto;

import com.google.gson.*;

import java.lang.reflect.Type;

public class UserDTOvDeserializer implements JsonDeserializer<UserDTOv> {
    @Override
    public UserDTOv deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String email = jsonObject.get("email").getAsString();
        String password = jsonObject.get("password").getAsString();
        String name = jsonObject.get("name").getAsString();
        String phone = jsonObject.get("phone").getAsString();

        UserDTOv userDTO = new UserDTOv();
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setName(name);
        userDTO.setPhone(phone);

        return userDTO;
    }
}
