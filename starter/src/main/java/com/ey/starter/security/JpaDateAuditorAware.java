package com.ey.starter.security;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

import org.springframework.data.auditing.DateTimeProvider;

public class JpaDateAuditorAware implements DateTimeProvider{

	@Override
	public Optional<TemporalAccessor> getNow() {

		return Optional.of(LocalDate.now());
	}

}
