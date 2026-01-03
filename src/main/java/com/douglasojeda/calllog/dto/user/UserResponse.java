package com.douglasojeda.calllog.dto.user;

import java.util.List;

public record UserResponse(Long userId, String displayName, List<Long> contactIds) {
}
