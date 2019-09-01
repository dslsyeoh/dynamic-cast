/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.dynamic.cast.components;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class ButtonInput implements Component
{
    private Button button;

    public ButtonInput()
    {
        button = new Button("Button");
    }

    @Override
    public Node getNode()
    {
        return button;
    }
}
