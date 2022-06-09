package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
@XmlRootElement(name = "Dancers")
public class DancersList {
    private ArrayList<Dancer> dancers;
    public ArrayList<Dancer> getDancers() {
        return dancers;
    }
    @XmlElement
    public void setDancers(ArrayList<Dancer> dancers) {
        this.dancers = dancers;
    }
    @Override
    public String toString() {
        return "DancersList{" + "dancers=" + dancers + '}';
    }
}
