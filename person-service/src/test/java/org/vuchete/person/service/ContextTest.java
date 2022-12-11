package org.vuchete.person.service;

public class ContextTest {

  public void testContext() {
    Assertions.assertDoesNotThrow(() ->  () -> "Broken context for " + clazz);
  }
}
