package AJava;

public class MAdvanceENUM {

  enum Day {
    MONDAY("Start of week") {
      @Override
      public void activity() {
        System.out.println("Monday activity: Team meeting at 10 AM");
      }
    },
    TUESDAY("Second day") {
      @Override
      public void activity() {
        System.out.println("Tuesday activity: Code review session");
      }
    };

    private final String description;

    // Constructor
    Day(String description) {
      this.description = description;
      System.out.println("Constructor called for: " + this.name());
    }

    // Concrete methods
    public void printInfo() {
      System.out.println(this.name() + " has code: " + description);
    }

    public String getCode() {
      return description;
    }

    // Abstract method with no return type
    public abstract void activity();
  }

  public static void main(String[] args) {
    Day d1 = Day.MONDAY;
    System.out.println("Today is: " + d1);
    d1.printInfo();
    d1.activity();

    System.out.println();

    Day d2 = Day.TUESDAY;
    System.out.println("Today is: " + d2);
    d2.printInfo();
    d2.activity();

    String input = "MONDAY";        // Convert String to Enum
    Day dd = Day.valueOf(input);
    System.out.println("Today is: " + dd);

    for (Day d : Day.values()) {
      System.out.println(d+".......");
    }

    Day day = Day.TUESDAY;
    switch (day) {
      case MONDAY:
        System.out.println("Start of the week");
        break;
      case TUESDAY:
        System.out.println("Second day");
        break;
    }
  }
}