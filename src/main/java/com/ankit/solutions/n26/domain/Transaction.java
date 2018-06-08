package com.ankit.solutions.n26.domain;

import static java.time.temporal.ChronoUnit.SECONDS;

import javax.validation.constraints.Min;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import com.ankit.solutions.n26.utils.Constants;
import com.ankit.solutions.n26.validations.InsideTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Immutable
@JsonSerialize(as = ImmutableTransaction.class)
@JsonDeserialize(as = ImmutableTransaction.class)
public interface Transaction {

	@Min(0)
	@Parameter
	double getAmount();

	@Parameter
	@InsideTime(duration = Constants.timeLimitInSeconds, unit = SECONDS)
	long getTimestamp();
}
