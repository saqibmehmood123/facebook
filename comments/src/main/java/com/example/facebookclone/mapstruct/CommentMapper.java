package com.example.facebookclone.mapstruct;
import com.example.facebookclone.model.Comment;
import com.example.facebookclone.dtos.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import com.example.facebookclone.mapstruct.DateMapper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper
{

    @Mapping(target = "createdAt", source = "createdAt"
            , qualifiedByName = "localDateTostring"
    )
    CommentDto commentToCommentDtos(Comment comment);
    List<CommentDto> commentToCommentDto(List<Comment> comment);
    @Mapping(target = "createdAt", source = "createdAt",
             dateFormat = "yyyy-MM-dd"
          ///  qualifiedByName = "stringToLocalDate"
             )
    Comment commentDtoToComment(CommentDto comment);
//    List<CommentDto> postListToPostDtosList(List<Posts> user);

    //    User userDTOToUser(UserDTO userDTO);
//
//    @Mapping(target = "id", ignore = true)
//    UserDTO createUserDTOWithoutId(User user);

    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String date) {
        DateTimeFormatter MY_DATE_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate ldt = LocalDate.parse(date, MY_DATE_FORMAT);
        return ldt;

        //        String europeanDatePattern = "yyyy-MM-dd";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(europeanDatePattern);
//
//        return LocalDate.parse(date , formatter);
    }


//
//    public LocalDate stringToLocalDate(String in) {
//    DateTimeFormatter MY_DATE_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd");
//        var ldt = LocalDate.parse(in, MY_DATE_FORMAT);
//    return ldt.toLocalDate();
//}


    @Named("localDateTostring")
    default String localDateTostring(LocalDate date) {

        return date.toString();
    }



}