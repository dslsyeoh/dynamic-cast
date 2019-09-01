/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved.
 */

package com.dsl.dynamic.cast;

import com.dsl.dynamic.cast.components.ButtonInput;
import com.dsl.dynamic.cast.components.Component;
import com.dsl.dynamic.cast.components.NumericInput;
import com.dsl.dynamic.cast.components.TextInput;
import com.dsl.dynamic.cast.utils.CCastUtils;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DynamicCastDemo extends Application
{
    private List<Component> initComponents(List<Component> components)
    {
        TextInput textInput = new TextInput();
        NumericInput numericInput1 = new NumericInput();
        NumericInput numericInput2 = new NumericInput();
        ButtonInput buttonInput1 = new ButtonInput();
        ButtonInput buttonInput2 = new ButtonInput();

        components.add(textInput);
        components.add(numericInput1);
        components.add(numericInput2);
        components.add(buttonInput1);
        components.add(buttonInput2);

        return components;
    }

    private void demo()
    {
        List<Component> components = initComponents(new ArrayList<>());

        NumericInput numericInput = CCastUtils.toType(components.get(1), NumericInput.class);
        System.out.println("Convert [Component] to [NumericInput]=" + numericInput);

        List<NumericInput> numericInputs = CCastUtils.toList(components, NumericInput.class);
        System.out.println("\nConvert [Component] list to [Numeric] list");
        numericInputs.forEach(System.out::println);

        TextField textField = CCastUtils.toType(components.get(0), TextField.class);
        System.out.println("\nConvert [TextInput] to [TextField]=" + textField);

        List<TextField> textFields = CCastUtils.toList(components, TextField.class);
        System.out.println("\nConvert [NumericInput] list to [TextField] list");
        textFields.forEach(System.out::println);

        List<TextField> textFieldList = CCastUtils.toList(components, TextField.class);
        System.out.println("\nConvert [Components] list to [TextField] list");
        textFieldList.forEach(System.out::println);

        Button button = CCastUtils.toType(components.get(4).getNode(), Button.class);
        System.out.println("\nConvert [ButtonInput] to [Button]=" + button);


        List<Button> buttons = CCastUtils.toList(components, Button.class);
        System.out.println("\nConvert [Components] list to [Button] list");
        buttons.forEach(System.out::println);

        List<Button> buttonList = CCastUtils.toList(components, Button.class);
        System.out.println("\nConvert [Component] list to [Button] list");
        buttonList.forEach(System.out::println);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        demo();
    }
}
