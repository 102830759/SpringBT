package com.hyzx.features8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huyue
 * @date 2019/9/3 11:27
 */
public  class StreamUtils {

    /**
     * 去重
     * @author huy
     * @date 11:33 2019/9/3
     * @param list
     * @return java.util.List<T>
     */
    public static List<Object> distinct(List<Object> list) {
        Stream<Object> distinct = list.stream().distinct();
        return distinct.collect(Collectors.toList());
    }


}
