//Durgasri S
//2117240070081
program title:class car with methods
  Tc:1
  public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car1= new Car("Tesla","Red");
    car1.start();
    }
}
output:car started
    Tc:2
  public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car2= new Car("BMW","Black");
    car2.start();
    }
}
output:car started
    Tc:3
  public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car3= new Car("","blue");
    car3.start();
    }
}
output:car started(but model not shown)
    Tc:4
  public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car4= new Car("Audi","white");
    car4.start();
    }
}

  Tc:5
  public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car5= new Car("Ford","Grey");
    car5.start();
    }
}
output:car stopped
