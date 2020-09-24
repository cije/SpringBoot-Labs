package com.ce.lab4validation01.constants;

import com.ce.lab4validation01.core.validator.IntArrayValuable;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author c__e
 * @date Created in 2020/9/24 15:19
 */
@Getter
public enum GenderEnum implements IntArrayValuable {
    /**
     * 性别枚举
     */
    MALE(1, "男"),
    FEMALE(2, "女");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(GenderEnum::getValue).toArray();

    /**
     * 性别值
     */
    private final Integer value;
    /**
     * 性别名
     */
    private final String name;

    GenderEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
