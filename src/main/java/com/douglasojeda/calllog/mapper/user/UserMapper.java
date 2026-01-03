package com.douglasojeda.calllog.mapper.user;

import com.douglasojeda.calllog.dto.user.UserResponse;
import com.douglasojeda.calllog.model.user.User;

import java.util.List;

public class UserMapper {
    public static UserResponse toResponse(User user) {
        List<Long> contactIds = user.getContacts() == null
                ? List.of()
                : user.getContacts().stream()
                .map(User::getUserId)
                .toList();
        return new UserResponse(user.getUserId(), user.getDisplayName(), contactIds);
    }
}
