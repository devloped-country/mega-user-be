package com.mega.biz.join.model;

import com.google.gson.*;
import com.mega.biz.join.model.dto.UserValidationDTO;

import java.lang.reflect.Type;

public class UserDTODeserializer implements JsonDeserializer<UserValidationDTO> {
    @Override
    public UserValidationDTO deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String email = jsonObject.get("email").getAsString();
        String password = jsonObject.get("password").getAsString();
        String name = jsonObject.get("name").getAsString();
        String phone = jsonObject.get("phone").getAsString();

        UserValidationDTO userValidationDTO = new UserValidationDTO();
        userValidationDTO.setEmail(email);
        userValidationDTO.setPassword(password);
        userValidationDTO.setName(name);
        userValidationDTO.setPhone(phone);

        return userValidationDTO;
    }
}
