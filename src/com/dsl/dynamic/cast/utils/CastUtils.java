/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.dynamic.cast.utils;

import com.dsl.dynamic.cast.components.Component;

import java.util.List;
import java.util.stream.Collectors;

public final class CastUtils
{
    public static <C, T> List<T> toComponents(List<C> objects, Class<T> clazz)
    {
        return objects.stream().filter(clazz::isInstance).map(object -> toType(object, clazz)).collect(Collectors.toList());
    }

    public static <C extends Component, T> List<T> toNodes(List<C> objects, Class<T> clazz)
    {
        return objects.stream().map(Component::getNode).filter(clazz::isInstance).map(object -> toType(object, clazz)).collect(Collectors.toList());
    }

    public static <C, T> T toType(C object, Class<T> clazz)
    {
        return clazz.cast(object);
    }
}
