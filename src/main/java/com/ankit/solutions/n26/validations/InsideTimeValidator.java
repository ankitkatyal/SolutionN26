package com.ankit.solutions.n26.validations;

import java.time.Duration;
import java.util.function.Supplier;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.annotations.VisibleForTesting;


public class InsideTimeValidator implements ConstraintValidator<InsideTime, Long> {

	
	@VisibleForTesting
	public static Supplier<Long> currentTime = System::currentTimeMillis;
	private InsideTime annotation;
	
	@Override
	public void initialize(InsideTime constraintAnnotation) {
		this.annotation = constraintAnnotation;		
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Duration time = Duration.of(annotation.duration(), annotation.unit());
        return value == null || currentTime.get() - value <= time.toMillis();
	}

}
