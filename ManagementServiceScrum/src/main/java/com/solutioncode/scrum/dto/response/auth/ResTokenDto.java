package com.solutioncode.scrum.dto.response.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResTokenDto {
    public String token;
}
