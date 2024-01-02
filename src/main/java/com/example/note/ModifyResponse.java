package com.example.note;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
 public class ModifyResponse {

    private boolean success;
    private String message;

    public static ModifyResponse success(String message){
        return ModifyResponse.builder().success(true).message(message).build();
    }

    public static ModifyResponse failed( String message){
        return ModifyResponse.builder().success(false).message(message).build();
    }

}
