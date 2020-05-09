package SetChallenge;

import Hamburger.HealthyBurger;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
//    private final String name;
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
//    private final BodyTypes bodyType;

    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key= new Key(name, bodyType);
//        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
//        this.bodyType = bodyType;
    }

//    public String getName() {
//        return name;
//    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

//    public BodyTypes getBodyType() {
//        return bodyType;
//    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObj = (HeavenlyBody) obj;
            // use the new key class to avoid same name but different body type
            return this.key.equals(theObj.getKey());
//            if(this.name.equals(theObj.getName())){
//                return this.bodyType == theObj.bodyType;
//            }
        }
//if only compared the name, same names will different obj will be viewed equal
//        String objName = ((HeavenlyBody) obj).getName();
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
        //return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        //return this.name + ":" + this.bodyType+"," + this.orbitalPeriod;
        return this.key.name+ ":" + this.key.bodyType + this.orbitalPeriod;
    }

    public static Key makeKey(String name, BodyTypes bodyTypes){
        return new Key(name,bodyTypes);
    }
    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())){
                return this.bodyType ==key.bodyType;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public String toString() {
            return this.getName()+":"+this.getBodyType();
        }
    }
}
