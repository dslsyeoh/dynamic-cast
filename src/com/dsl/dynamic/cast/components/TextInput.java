/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.dynamic.cast.components;

import javafx.scene.Node;
import javafx.scene.control.TextField;

public class TextInput implements Component
{
    private TextField textField;

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
