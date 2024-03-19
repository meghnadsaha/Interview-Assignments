//package com.codeing.epam.customannotation;
//
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.*;
//
//@Target({ElementType.PARAMETER , ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = PositiveNumberValidator.class)
//@Documented
//public @interface PositiveNumber {
//    String message () default "must be a positive number";
//
//    Class<?>[] groups () default {};
//
//    Class<? extends Payload>[] payload () default {};
//}
//
//
