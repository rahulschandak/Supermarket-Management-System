package model;

import java.sql.Time;
import java.time.LocalDate;

public class EmployeeWorkingHours {

  private final int id;
  private final String name;
  private final LocalDate workDate;
  private final Time startTime;
  private final Time endTime;

  public EmployeeWorkingHours(int id, String name,LocalDate date,Time startTime, Time endTime) {
    this.id = id;
    this.name = name;
    this.workDate = date;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public int getID() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public LocalDate getWorkingDate() {
    return this.workDate;
  }

  public Time getStartTime() {
    return this.startTime;
  }

  public Time getEndTime() {
    return this.endTime;
  }

}
