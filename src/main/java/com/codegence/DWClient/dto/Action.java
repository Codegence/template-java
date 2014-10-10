package com.codegence.DWClient.dto;

import com.codegence.DWClient.resources.Commands;

public class Action {
    private Commands command;
    private float value = 0f;

    public Commands getCommand() {
        return command;
    }

    public void setCommand(Commands command) {
        this.command = command;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
