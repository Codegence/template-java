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

import com.codegence.DWClient.resources.ObjectTypes;

public class Contact {
    private int id;
	private float[] position;
	private float rotation;
	private ObjectTypes type;
	private String status;
	private float resources; // if applicable

	public float[] getPosition() {
		return position;
	}

	public void setPosition(float[] position) {
		this.position = position;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public ObjectTypes getType() {
		return type;
	}

	public void setType(ObjectTypes type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getResources() {
		return resources;
	}

	public void setResources(float resources) {
		this.resources = resources;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
