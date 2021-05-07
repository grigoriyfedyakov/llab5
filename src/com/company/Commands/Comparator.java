package com.company.Commands;

import com.company.Models.Ticket;

public class Comparator implements java.util.Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
