package com.solutioncode.scrum.component.response;



public class ApiResponse {
    public static SchemaResponse createSuccessResponse(String message,Object data){
        return SchemaResponse.builder()
                .ok(true)
                .message(message)
                .data(data)
                .build();
    }

    public static SchemaResponse createSuccessResponse(String message){
        return SchemaResponse.builder()
                .ok(true)
                .message(message)
                .build();
    }

    public static SchemaResponse createErrorResponse(String message,Object errors){
        return SchemaResponse.builder()
                .ok(false)
                .message(message)
                .errors(errors)
                .build();
    }

    public static SchemaResponse createErrorResponse(String message){
        return SchemaResponse.builder()
                .ok(false)
                .message(message)
                .build();
    }

}
