package com.ce.lab4validation01.dto;

import com.ce.lab4validation01.constants.GenderEnum;
import com.ce.lab4validation01.core.validator.InEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author c__e
 * @date Created in 2020/9/24 15:45
 */
@Data
public class UserUpdateGenderDTO {
    /**
     * 用户编号
     */
    @NotNull(message = "用户编号不能为空")
    private Integer id;

    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    @InEnum(value = GenderEnum.class, message = "性别必须是 {value}")
    private Integer gender;
}
