/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.dynamic.cast.utils;

import com.dsl.dynamic.cast.components.Component;

import java.util.List;
import java.util.stream.Collectors;

public final class CCastUtils
{
    private CCastUtils() {}

    public static <C extends Component, T> List<T> toType(List<C> objects, Class<T> clazz)
    {
        boolean castable = objects.stream().anyMatch(clazz::isInstance);
        if(castable) return toComponent(objects, clazz);
        return toNode(objects, clazz);
    }

    public static <C, T> List<T> toComponent(List<C> objects, Class<T> clazz)
    {
        return objects.stream().filter(clazz::isInstance).map(object -> toType(object, clazz)).collect(Collectors.toList());
    }

    public static <C extends Component, T> List<T> toNode(List<C> objects, Class<T> clazz)
    {
        return objects.stream().map(Component::getNode).filter(clazz::isInstance).map(object -> toType(object, clazz)).collect(Collectors.toList());
    }

    public static <C extends Component, T> T toType(C object, Class<T> clazz)
    {
        if(clazz.isInstance(object)) return clazz.cast(object);
        return toType(object.getNode(), clazz);
    }

    public static <C, T> T toType(C object, Class<T> clazz)
    {
        return clazz.cast(object);
    }
}
