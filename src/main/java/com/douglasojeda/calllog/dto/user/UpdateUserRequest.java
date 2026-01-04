package com.douglasojeda.calllog.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequest(@NotBlank String displayName) {

}
