
#include <LiquidCrystal.h>
#include <NewPing.h>
#include "DHT.h"
#define DHTPIN 2 
#define DHTTYPE DHT22 
#define TRIGGER_PIN  13  
#define ECHO_PIN     12 
#define MAX_DISTANCE 500
DHT dht(DHTPIN, DHTTYPE);
NewPing sonar(TRIGGER_PIN, ECHO_PIN, MAX_DISTANCE); 
LiquidCrystal lcd(8, 9, 4, 5, 6, 7);
unsigned long time =0;
unsigned long lcddelaytime =200;
int readkey;
int laser = 3;
int ping_sensor = 0;
int temp_sensor = 0;
int led_stat = 0;


void setup() {
  lcd.begin(16, 2);
  lcd.print("Welcome To");
  lcd.setCursor(0,1);
  lcd.print("Alderaan");

  pinMode(laser, OUTPUT);
}
void loop() {
   

  
  readkey=analogRead(0);
  
  if (readkey<50) {
  lcd.clear();
  right();
  }
  else if(readkey<195) {
 
  }
  else if(readkey<380) {
    lcd.clear();
    down();
  }
  else if(readkey<790) {
    lcd.clear();
    left();
  }
}

void down() {
  ping_sensor == 1;
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Distance :");
  lcd.setCursor(0,1);
  lcd.print("0cm");
  
  

  while (ping_sensor = 1) {
    digitalWrite(laser, HIGH);
    delay(50);                      
  unsigned int uS = sonar.ping(); 
  if(millis() > (time + lcddelaytime)){
    lcd.clear();
    lcd.print("Distance: ");
    lcd.print(String(uS / US_ROUNDTRIP_CM)+" cm"); 
    time= millis();
    }   
    
  }
 
}

void left() {
  led_stat == 1;
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Some Quotes :)");
  lcd.setCursor(0,1);
  lcd.print("Albert Einstein:");
  delay(4600);
  lcd.clear();
 lcd.setCursor(0,0);
  lcd.print("Two Things Are");
  lcd.setCursor(0,1);
  lcd.print("Infinite :");
  delay(4600);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Human Stupidity");
  lcd.setCursor(0,1);
  lcd.print("And Universe");
  delay(4600);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Im Not Sure");
  lcd.setCursor(0,1);
  lcd.print("About Universe");
  delay(4600);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Ernest");
  lcd.setCursor(0,1);
  lcd.print("Rutherford");
  delay(4600);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Science Is Either");
  lcd.setCursor(0,1);
  lcd.print("Physics Or Stamp");
  delay(4600);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Collecting!");
  lcd.setCursor(0,1);
  lcd.print("End--~--");
  delay(4600);
  
  readkey=analogRead(0);

 
  
  if (readkey<50) {
 right();
 
  }
  else if(readkey<195) {
 
    
   
  }
  else if(readkey<380) {
  
   down();
  }
  else if(readkey<790) {
 
  }
  
  
}

void right() {
  temp_sensor == 1;
    lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Connecting To");
  lcd.setCursor(0,1);
  lcd.print("Sensor...");
  readkey=analogRead(0);
  
  while (temp_sensor = 1){
	  digitalWrite(laser, HIGH);
     float temperature, humidity;

  humidity = dht.readHumidity();
  temperature = dht.readTemperature();
  delay(2000); 

 lcd.clear();

 char tempF[6]; 
 char humF[6];
 dtostrf(temperature, 5, 1, tempF);
 dtostrf(humidity, 2, 0, humF);

 lcd.print("T:"); 
 lcd.print(tempF);
 lcd.print((char)223);
 lcd.print("C ");
 lcd.print("H: ");
 lcd.print(humF);
 lcd.print("%");
  }
  
  if (readkey<50) {
 
 
  }
  else if(readkey<195) {
    
   
  }
  else if(readkey<380) {
  
   down();
  }
  else if(readkey<790) {
 left();
  }
  
}



