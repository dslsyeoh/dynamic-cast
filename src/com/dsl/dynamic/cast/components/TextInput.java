/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.dynamic.cast.components;

import javafx.scene.Node;
import javafx.scene.control.TextField;

public class TextInput implements Component
{
    TextField textField;

    public TextInput()
    {
        this.textField = new TextField();
    }

    @Override
    public Node getNode()
    {
        return textField;
    }
}
