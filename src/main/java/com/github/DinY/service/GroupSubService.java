package com.github.DinY.service;

import com.github.DinY.javarushclient.dto.GroupDiscussionInfo;
import com.github.DinY.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
