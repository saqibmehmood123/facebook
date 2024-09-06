package com.example.facebookclone.mapstruct;

import com.example.facebookclone.dtos.PostDto;
import com.example.facebookclone.dtos.UserDTO;

import com.example.facebookclone.dtos.UserDto;
import com.example.facebookclone.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Named;

import java.time.LocalDate  ;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper
{

   /// @Mapping(target = "createdAt", source = "postDtoList.PostDto.createdAt", qualifiedByName = "stringToLocalDate")
    UserDTO userAndPostsToUserDto(Users user , List<PostDto> postDtoList);
     Users userDtoToUser(UserDTO user );
    UserDTO userToUserDto(Users user );
    UserDto userToUsersDto(Users user );


     List<UserDTO>  userListToUserDtoList( List<Users>  user );
//    PostDto postToPostDtos(Posts user);

//    List<PostDto> postListToPostDtosList(List<Posts> user);

    //    User userDTOToUser(UserDTO userDTO);
//
//    @Mapping(target = "id", ignore = true)
//    UserDTO createUserDTOWithoutId(User user);

    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String date) {
        return LocalDate.parse(date);
    }

}
