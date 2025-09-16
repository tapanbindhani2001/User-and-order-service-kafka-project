package com.tapan.Dto;

import com.tapan.entity.Order;
import com.tapan.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Order order;
    private User user;
}
