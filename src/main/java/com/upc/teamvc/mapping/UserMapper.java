package com.upc.teamvc.mapping;

import com.upc.teamvc.domain.models.User;
import com.upc.teamvc.resources.UserResource;
import com.upc.teamvc.resources.UserSaveResource;
import com.upc.teamvc.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model){return mapper.map(model, UserResource.class);}

    public List<UserResource> toResource(List<User> model){
        return mapper.mapList(model, UserResource.class);
    }

    public User toModel(UserSaveResource resource){
        return mapper.map(resource, User.class);
    }
}
