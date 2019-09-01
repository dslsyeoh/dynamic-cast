/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.dynamic.cast.utils;

import com.dsl.dynamic.cast.components.Component;
import javafx.scene.Node;

import java.util.List;
import java.util.stream.Collectors;

public final class CCastUtils
{
    private CCastUtils() {}

    public static <T> List<T> toList(List<Component> components, Class<T> clazz)
    {
        return isCastable(components, clazz) ? toComponents(components, clazz) : toNodes(getNodes(components), clazz);
    }

    private static <T> List<T> toComponents(List<Component> objects, Class<T> clazz)
    {
        return objects.stream().filter(clazz::isInstance).map(object -> toType(object, clazz)).collect(Collectors.toList());
    }

    private static <T> List<T> toNodes(List<Node> nodes, Class<T> clazz)
    {
        return nodes.stream().filter(clazz::isInstance).map(object -> toType(object, clazz)).collect(Collectors.toList());
    }

    public static <T> T toType(Component component, Class<T> clazz)
    {
        return instanceOf(component, clazz) ? clazz.cast(component) : toType(component.getNode(), clazz);
    }

    public static <C, T> T toType(C object, Class<T> clazz)
    {
        return clazz.cast(object);
    }

    private static <T> boolean isCastable(List<Component> components, Class<T> clazz)
    {
        return components.stream().anyMatch(clazz::isInstance);
    }

    private static List<Node> getNodes(List<Component> components)
    {
        return components.stream().map(Component::getNode).collect(Collectors.toList());
    }

    public static <T> boolean instanceOf(Component component, Class<T> clazz)
    {
        return clazz.isInstance(component);
    }
}
