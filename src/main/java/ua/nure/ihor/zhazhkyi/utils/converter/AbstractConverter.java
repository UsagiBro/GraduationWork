package ua.nure.ihor.zhazhkyi.utils.converter;

import org.springframework.beans.BeanUtils;

public abstract class AbstractConverter {

    protected void convert(Object source, Object destination) {
        BeanUtils.copyProperties(source, destination);
    }
}
