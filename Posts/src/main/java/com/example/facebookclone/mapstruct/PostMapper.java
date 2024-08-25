package com.example.facebookclone.mapstruct;

import com.example.facebookclone.dtos.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.facebookclone.model.Posts;
import org.mapstruct.Named;

import java.time.LocalDate  ;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper
{

    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "stringToLocalDate")

    Posts postDtosToPost(PostDto user);

    PostDto postToPostDtos(Posts user);

    List<PostDto> postListToPostDtosList(List<Posts> user);

    //    User userDTOToUser(UserDTO userDTO);
//
//    @Mapping(target = "id", ignore = true)
//    UserDTO createUserDTOWithoutId(User user);

    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String date) {
        return LocalDate.parse(date);
    }
}