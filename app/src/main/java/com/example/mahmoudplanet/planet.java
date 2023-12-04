package com.example.mahmoudplanet;

public class planet {


    public class Planet {
        private String Name;
        private String Size;
        private String Orbit;
        private String Number;

        public Planet() {
        }

        public Planet(String name, String size, String orbit, String number) {
            this.Name = name;
            this.Size = size;
            this.Orbit = orbit;
            this.Number = number;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getSize() {
            return Size;
        }

        public void setSize(String Size) {
            this.Size = Size;
        }

        public String getOrbit() {
            return Orbit;
        }

        public void setOrbit(String Orbit) {
            this.Orbit = Orbit;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String Number) {
            this.Number = Number;
        }

        @Override
        public String toString() {
            return "Planet{" +
                    "name='" + Name + '\'' +
                    ",size='" + Size + '\'' +
                    ", Orbit='" + Orbit + '\'' +
                    ", number='" + Number + '\'' +
                    '}';



        }
    }
}
