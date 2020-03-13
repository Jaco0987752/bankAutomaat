#include <Arduino.h>


void setup() {
  Serial.begin(9600);
  Serial.println("hello world");
}

void loop() {
  delay(1000);
  Serial.println("s");

}
