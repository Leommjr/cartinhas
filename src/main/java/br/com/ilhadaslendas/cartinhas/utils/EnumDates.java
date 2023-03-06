package br.com.ilhadaslendas.cartinhas.utils;

import java.time.LocalDate;
import java.util.Objects;

public enum EnumDates {
	WEEK1(LocalDate.of(2023, 1, 22)),
	WEEK2(LocalDate.of(2023, 1, 29)),
	WEEK3(LocalDate.of(2023, 2, 5)),
	WEEK4(LocalDate.of(2023, 2, 12));
	
	private LocalDate localDate;

	EnumDates(LocalDate ld) {
		Objects.requireNonNull(ld);
		this.localDate = ld;
	}
	public LocalDate getLocalDate() {
        return this.localDate ;
    }
}
