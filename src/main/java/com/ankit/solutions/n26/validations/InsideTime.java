package com.ankit.solutions.n26.validations;

	import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
	import static java.lang.annotation.ElementType.CONSTRUCTOR;
	import static java.lang.annotation.ElementType.FIELD;
	import static java.lang.annotation.ElementType.METHOD;
	import static java.lang.annotation.ElementType.PARAMETER;
	import static java.lang.annotation.RetentionPolicy.RUNTIME;

	import java.lang.annotation.Documented;
	import java.lang.annotation.Repeatable;
	import java.lang.annotation.Retention;
	import java.lang.annotation.Target;
	import java.time.temporal.ChronoUnit;

	import javax.validation.Constraint;
	import javax.validation.Payload;

	@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
	@Retention(RUNTIME)
	@Documented
	@Repeatable(InsideTime.List.class)
	@Constraint(validatedBy = {InsideTimeValidator.class})
	public @interface InsideTime {

	    int duration();

	    ChronoUnit unit();

	    String message() default "{javax.validation.constraints.InsideTime.message}";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};

	    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
	    @Retention(RUNTIME)
	    @Documented
	    @interface List {
	    	InsideTime[] value();
	    }
	}

	

