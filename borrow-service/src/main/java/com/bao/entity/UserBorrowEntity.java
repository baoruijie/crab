package com.bao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBorrowEntity {

    UserEntity userEntity;

    List<BookEntity> bookList;
}
