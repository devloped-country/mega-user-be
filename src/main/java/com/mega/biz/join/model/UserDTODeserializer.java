package com.mega.biz.join.model;

import com.google.gson.*;
import com.mega.biz.join.model.dto.UserDTO;

import java.lang.reflect.Type;

public class UserDTODeserializer implements JsonDeserializer<UserDTO> {
    @Override
    public UserDTO deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String email = jsonObject.get("email").getAsString();
        String password = jsonObject.get("password").getAsString();
        String name = jsonObject.get("name").getAsString();
        String phone = jsonObject.get("phone").getAsString();

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setName(name);
        userDTO.setPhone(phone);

        return userDTO;
    }
}
