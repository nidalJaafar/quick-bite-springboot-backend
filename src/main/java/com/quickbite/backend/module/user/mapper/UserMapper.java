package com.quickbite.backend.module.user.mapper;

import com.quickbite.backend.common.entity.User;
import com.quickbite.backend.common.entity.VisitFeedback;
import com.quickbite.backend.module.user.dto.UserDto;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

  User userDtoToUser(UserDto userDto);

  UserDto userToUserDto(User user);

  List<UserDto> userListToUserDtoList(List<User> userList);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateUserFromUserDto(
      UserDto userDto, @MappingTarget User user);

  @AfterMapping
  default void linkVisitFeedback(@MappingTarget User user) {
    VisitFeedback visitFeedback = user.getVisitFeedback();
    if (visitFeedback != null) {
      visitFeedback.setUser(user);
    }
  }

  @AfterMapping
  default void linkItemFeedbacks(@MappingTarget User user) {
    user.getItemFeedbacks().forEach(itemFeedback -> itemFeedback.setUser(user));
  }
}
