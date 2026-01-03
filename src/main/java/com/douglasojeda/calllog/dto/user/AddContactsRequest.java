package com.douglasojeda.calllog.dto.user;

import java.util.List;

public record AddContactsRequest(List<Long> contactIds) {
}
