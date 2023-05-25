package com.example.demo;

import java.time.LocalDate;

public class DateForm {
    private LocalDate begin;
    private LocalDate end;
    
    

    public DateForm() {
		super();
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
}
