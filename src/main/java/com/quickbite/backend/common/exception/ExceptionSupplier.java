package com.quickbite.backend.common.exception;

import java.util.function.Supplier;
import javax.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ExceptionSupplier {

  public static Supplier<EntityNotFoundException> itemFeedbackExceptionSupplier() {
    return () -> new EntityNotFoundException("Item feedback not found");
  }

  public static Supplier<EntityNotFoundException> currencyExceptionSupplier() {
    return () -> new EntityNotFoundException("Currency not found");
  }

  public static Supplier<EntityNotFoundException> faqExceptionSupplier() {
    return () -> new EntityNotFoundException("Faq not found");
  }

  public static Supplier<EntityNotFoundException> visitFeedbackExceptionSupplier() {
    return () -> new EntityNotFoundException("Visit feedback not found");
  }

  public static Supplier<EntityNotFoundException> menuExceptionSupplier() {
    return () -> new EntityNotFoundException("Menu not found");
  }

  public static Supplier<EntityNotFoundException> orderExceptionSupplier() {
    return () -> new EntityNotFoundException("Order not found");
  }

  public static Supplier<EntityNotFoundException> userExceptionSupplier() {
    return () -> new EntityNotFoundException("User not found");
  }

  public static Supplier<EntityNotFoundException> adminExceptionSupplier() {
    return () -> new EntityNotFoundException("Admin not found");
  }

  public static Supplier<EntityNotFoundException> itemExceptionSupplier() {
    return () -> new EntityNotFoundException("Item not found");
  }

  public static Supplier<AccessDeniedException> accessDeniedExceptionSupplier() {
    return () -> new AccessDeniedException("Access denied");
  }

  public static Supplier<UsernameNotFoundException> usernameNotFoundExceptionSupplier() {
    return () -> new UsernameNotFoundException("Bad credentials");
  }

}
