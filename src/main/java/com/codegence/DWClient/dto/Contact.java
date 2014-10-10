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
