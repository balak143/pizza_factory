package com.pizza.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PizzaDateTime {
  private static final PizzaDateTime INSTANCE = new PizzaDateTime();

  private static final String DEFAULT_FORMAT = "yyyyMMdd";
  private SimpleDateFormat dateTimeFormatter = new SimpleDateFormat(DEFAULT_FORMAT);

  private PizzaDateTime() {}

  public static PizzaDateTime getInstance() {
    return INSTANCE;
  }

  public Date convert(String dateString) {
    try {
      return dateTimeFormatter.parse(dateString);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Invalid Date format.");
    }
  }
}
