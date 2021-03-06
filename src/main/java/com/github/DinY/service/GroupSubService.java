package com.github.DinY.service;

import com.github.DinY.javarushclient.dto.GroupDiscussionInfo;
import com.github.DinY.repository.entity.GroupSub;

import java.util.Optional;
/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub groupSub);
    Optional<GroupSub> findById(Integer id);
}
