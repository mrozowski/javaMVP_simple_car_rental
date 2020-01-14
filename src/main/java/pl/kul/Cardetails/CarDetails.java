package pl.kul.Cardetails;

class CarDetails {
    private final String marka;
    private final String model;
    private final String color;
    private final String fueltype;
    private final float capacity;
    private final int hp;
    private final int year;
    private final float price; // cena za godzine

    public CarDetails(String marka, String model, String color, String fueltype, float capacity, int hp, int year, float price) {
        this.marka = marka;
        this.model = model;
        this.color = color;
        this.fueltype = fueltype;
        this.capacity = capacity;
        this.hp = hp;
        this.year = year;
        this.price = price;
    }



    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getFueltype() {
        return fueltype;
    }

    public float getCapacity() {
        return capacity;
    }

    public int getHp() {
        return hp;
    }

    public float getDayPrice() {
        return (float) (getPrice() * 24 * 0.80);
    }  // - 20%
}

