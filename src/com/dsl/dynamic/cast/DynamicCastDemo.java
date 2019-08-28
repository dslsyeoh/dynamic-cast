/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.dynamic.cast;

import com.dsl.dynamic.cast.components.Component;
import com.dsl.dynamic.cast.components.NumericInput;
import com.dsl.dynamic.cast.components.TextInput;
import com.dsl.dynamic.cast.utils.CastUtils;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DynamicCastDemo extends Application
{
    public static void main(String[] args)
    {
        List<Component> components = new ArrayList<>();
        TextInput textInput = new TextInput();
        NumericInput numericInput1 = new NumericInput();
        NumericInput numericInput2 = new NumericInput();

        components.add(textInput);
        components.add(numericInput1);
        components.add(numericInput2);

        List<NumericInput> numericInputs = CastUtils.toComponents(components, NumericInput.class);
        List<TextField> textFields = CastUtils.toNodes(numericInputs, TextField.class);
        numericInputs.forEach(System.out::println);
        textFields.forEach(System.out::println);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
