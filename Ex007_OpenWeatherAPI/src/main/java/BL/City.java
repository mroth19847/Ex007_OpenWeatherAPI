package BL;

public class City {
 private float id;
 private String name;
 Coord CoordObject;
 private String country;
 private float population;
 private float timezone;
 private float sunrise;
 private float sunset;


 // Getter Methods 

 public float getId() {
  return id;
 }

 public String getName() {
  return name;
 }

 public Coord getCoord() {
  return CoordObject;
 }

 public String getCountry() {
  return country;
 }

 public float getPopulation() {
  return population;
 }

 public float getTimezone() {
  return timezone;
 }

 public float getSunrise() {
  return sunrise;
 }

 public float getSunset() {
  return sunset;
 }

 // Setter Methods 

 public void setId(float id) {
  this.id = id;
 }

 public void setName(String name) {
  this.name = name;
 }

 public void setCoord(Coord coordObject) {
  this.CoordObject = coordObject;
 }

 public void setCountry(String country) {
  this.country = country;
 }

 public void setPopulation(float population) {
  this.population = population;
 }

 public void setTimezone(float timezone) {
  this.timezone = timezone;
 }

 public void setSunrise(float sunrise) {
  this.sunrise = sunrise;
 }

 public void setSunset(float sunset) {
  this.sunset = sunset;
 }
}
