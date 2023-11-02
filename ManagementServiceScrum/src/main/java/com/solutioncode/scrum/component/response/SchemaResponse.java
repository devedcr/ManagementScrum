package com.solutioncode.scrum.component.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchemaResponse {
    public Boolean ok;
    public String message;
    public Object errors;
    public Object data;
}
