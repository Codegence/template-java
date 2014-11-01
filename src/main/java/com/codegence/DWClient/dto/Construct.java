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

import java.util.List;

import com.codegence.DWClient.resources.ObjectTypes;
import com.codegence.DWClient.resources.Status;

public class Construct {
    private Integer id;
    private Integer factionId;
    private ObjectTypes type;
    private Status status;
    private Integer health;
    private float[] position;
    private float rotation;
    private List<Contact> dradisContacts;
    private List<Contact> minables; // if applicable
    private List<Contact> transferables; // if applicable
    private float resources; // if applicable

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFactionId() {
        return factionId;
    }

    public void setFactionId(Integer factionId) {
        this.factionId = factionId;
    }

    public ObjectTypes getType() {
        return type;
    }

    public void setType(ObjectTypes type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

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

    public List<Contact> getDradisContacts() {
        return dradisContacts;
    }

    public void setDradisContacts(List<Contact> dradisContacts) {
        this.dradisContacts = dradisContacts;
    }

    public List<Contact> getMinables() {
        return minables;
    }

    public void setMinables(List<Contact> minables) {
        this.minables = minables;
    }

    public List<Contact> getTransferables() {
        return transferables;
    }

    public void setTransferables(List<Contact> transferables) {
        this.transferables = transferables;
    }

    public float getResources() {
        return resources;
    }

    public void setResources(float resources) {
        this.resources = resources;
    }
}
