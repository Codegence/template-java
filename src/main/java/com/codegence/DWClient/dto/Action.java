/*
    Copyright (C) 2014  Fernando Farias
    This file is part of Codegence.

    Codegence is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Codegence is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Codegence. If not, see <http://www.gnu.org/licenses/>.
*/

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
