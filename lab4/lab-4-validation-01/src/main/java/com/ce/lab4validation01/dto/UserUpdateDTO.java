package com.ce.lab4validation01.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author c__e
 * @date Created in 2020/9/24 19:25
 */
@Data
public class UserUpdateDTO {
    /**
     * 用户编号
     */
    @NotNull(message = "{UserUpdateDTO.id.NotNull}")
    private Integer id;
}
