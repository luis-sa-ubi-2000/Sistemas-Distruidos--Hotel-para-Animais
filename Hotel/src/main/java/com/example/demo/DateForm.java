package com.example.demo;

import java.time.LocalDate;

public class DateForm {
    private LocalDate begin;
    private LocalDate end;
    
    public DateForm(LocalDate begin, LocalDate end) {
        this.begin = begin;
        this.end = end;
    }

    public DateForm() {
    	this.begin = LocalDate.of(0, 1, 1);
        this.end = LocalDate.of(0, 1, 1);
	}

	public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
    
    public boolean insertedAInterval(DateForm dateForm) {
    	if (dateForm.getBegin().isEqual(LocalDate.of(0, 1, 1))) {
    	    return true;
    	} else {
    		return false;
    	}
    }
}
