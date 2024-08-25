package com.example.facebookclone.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args) {

       //
        System.out.println(LocalDate.parse("2020-02-02"));

//        UserPostCommentDto userPostCommentDto = new UserPostCommentDto();
//        ArrayList<UserDTO>  userDto = new ArrayList<>();
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(1L);
//        userDTO.setName("Nasir");
//        userDto.add(userDTO);
//
//        List<PostDto> postDtoList = new ArrayList<>();
//
//        PostDto postDto = new PostDto();
//        postDto.setId(1L);
//        postDto.setUserId(1L);
//        postDto.setContent("Nasir Post");
//        postDtoList.add(postDto);
//        PostDto postDto1 = new PostDto();
//        postDto1.setId(2L);
//        postDto1.setUserId(1L);
//        postDto1.setContent("Nasir Postc02");
//        postDtoList.add(postDto1);
//        /////////////////////////////////////////
//        ArrayList<CommentDto> commentDtos = new ArrayList<>();
//        CommentDto commentDto = new CommentDto();
//        commentDto.setId(1L);
//        commentDto.setUserId(1L);
//        commentDto.setContent("Nasir POst1 comment 1");
//        commentDto.setPostId(1L);
//        commentDtos.add(commentDto);
//        CommentDto commentDto2   = new CommentDto();
//        commentDto2.setId(2L);
//        commentDto2.setUserId(1L);
//        commentDto2.setContent("Nasir POst1 comment 2");
//        commentDto2.setPostId(1L);
//        commentDtos.add(commentDto2);
//        CommentDto commentDto3 = new CommentDto();
//        commentDto3.setId(3L);
//        commentDto3.setUserId(1L);
//        commentDto3.setContent("Nasir POst2 comment 1");
//        commentDto3.setPostId(2L);
//        commentDtos.add(commentDto3);
//        CommentDto commentDto4   = new CommentDto();
//        commentDto4.setId(4L);
//        commentDto4.setUserId(1L);
//        commentDto4.setContent("Nasir POst2 comment 2");
//        commentDto4.setPostId(2L);
//        commentDtos.add(commentDto4);
//
//        // postDtoList.add(postDto);
//       // userDTO.setPostDtoList(postDtoList);
/////////////////////////////////////////////////////////////////////////////////////////////
//        UserDTO userDTO2 = new UserDTO();
//        userDTO2.setId(2L);
//        userDTO2.setName("AAmir");
//        userDto.add(userDTO2);
//
//        PostDto postDto3 = new PostDto();
//        postDto3.setId(3L);
//        postDto3.setUserId(2L);
//        postDto3.setContent("Aamir Post");
//        postDtoList.add(postDto3);
//        PostDto postDto4 = new PostDto();
//        postDto4.setId(4L);
//        postDto4.setUserId(2L);
//        postDto4.setContent("Aamir Postc02");
//        postDtoList.add(postDto4);
//        /////////////////////////////////////////
//
//        CommentDto commentDto5 = new CommentDto();
//        commentDto5.setId(5L);
//        commentDto5.setUserId(2L);
//        commentDto5.setContent("AAmir POst1 comment 1");
//        commentDto5.setPostId(3L);
//        commentDtos.add(commentDto5);
//        CommentDto commentDto6   = new CommentDto();
//        commentDto6.setId(6L);
//        commentDto6.setUserId(2L);
//        commentDto6.setContent("AAmir POst1 comment 2");
//        commentDto6.setPostId(3L);
//        commentDtos.add(commentDto6);
//        CommentDto commentDto7 = new CommentDto();
//        commentDto7.setId(7L);
//        commentDto7.setUserId(2L);
//        commentDto7.setContent("Aamir POst2 comment 1");
//        commentDto7.setPostId(4L);
//        commentDtos.add(commentDto7);
//        CommentDto commentDto8   = new CommentDto();
//        commentDto8.setId(8L);
//        commentDto8.setUserId(2L);
//        commentDto8.setContent("aamir POst2 comment 2");
//        commentDto8.setPostId(4L);
//        commentDtos.add(commentDto8);
//        addPostComment(   commentDtos  ,
//                 postDtoList );
//        addPost(    userDto,
//                 postDtoList ,userPostCommentDto);

//        print(userPostCommentDto);

    }

    private static void addPostComment(  ArrayList<CommentDto> commentDtos  ,
                                  List<PostDto> postDtoList )
    {


        ArrayList<CommentDto> postDtoListLOcal = new ArrayList<>();

        for(int a = 0;a<postDtoList.size();a++)
        {
            for(int a1 = 0;a1<commentDtos.size();a1++)
            {
                if(postDtoList.get(a).getId() ==commentDtos.get(a1).getPostId())
                {


                    postDtoListLOcal.add(commentDtos.get(a1));
                }

            }
            postDtoList.get(a).setComment (postDtoListLOcal);

            postDtoListLOcal = new ArrayList<>();
//            postDtoListLOcal.clear();
//            System.out.println(" === 02  " + postDtoListLOcal.size() );
        }
        for(int a = 0;a<postDtoList.size();a++)
        {
       ///     System.out.println("  " + postDtoList.get(a).getContent() );
            List<CommentDto> postDtoListLOcal2 = postDtoList.get(a).getComment();

            for(int a1 = 0;a1<postDtoListLOcal2 .size();a1++)
            {
           ///     System.out.println("  " +postDtoListLOcal2.get(a1).getContent());

            }
        }

    }



    private static void addPost(  ArrayList<UserDTO>  userDto,
    List<PostDto> postDtoList ,  UserPostCommentDto userPostCommentDto )
    {

        userPostCommentDto.setUserDtoList(userDto);


        List<PostDto> postDtoListLOcal = new ArrayList<>();

        for(int a = 0;a<userDto.size();a++)
        {
            for(int a1 = 0;a1<postDtoList.size();a1++)
            {
                if(postDtoList.get(a1).getUserId() ==userDto.get(a).getId())
                {


                    postDtoListLOcal.add(postDtoList.get(a1));
                }

            }
            userDto.get(a).setPostDtoList(postDtoListLOcal);

            postDtoListLOcal = new ArrayList<>();
//            postDtoListLOcal.clear();
//            System.out.println(" === 02  " + postDtoListLOcal.size() );
        }
        for(int a = 0;a<userDto.size();a++)
        {
        ///    System.out.println("  " + userDto.get(a).getName());
            List<PostDto> postDtoListLOcal2 = userDto.get(a).getPostDtoList();

            for(int a1 = 0;a1<postDtoListLOcal2 .size();a1++)
            {
           ////     System.out.println("  " +postDtoListLOcal2.get(a1).getContent());

            }
        }

    }
    private static void print(   UserPostCommentDto userPostCommentDto )
    {

        for(int a = 0;a<userPostCommentDto.getUserDtoList().size();a++)
        {
            System.out.println(userPostCommentDto.getUserDtoList().get(a).getName());
            for(int a1 = 0;a1<userPostCommentDto.getUserDtoList().get(a).getPostDtoList() .size();a1++)
            {
                System.out.println(userPostCommentDto.getUserDtoList().get(a).getPostDtoList().get(a1).getContent());


                for(int a2 = 0;a2<userPostCommentDto.getUserDtoList().get(a).getPostDtoList().get(a1).getComment().size();a2++)
                {
                    System.out.println(userPostCommentDto.getUserDtoList().get(a).getPostDtoList().get(a1).getComment().get(a2).getContent());

                }


            }
            System.out.println("/////////////////////////////////////////////////////////////////////");
        }



    }
}
