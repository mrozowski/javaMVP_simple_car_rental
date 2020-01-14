package pl.kul.Cardetails;

public interface CarDetailsView {
    void setPresenter(CarDetailsPresenter presenter);

    void showItemDetails(CarDetails carDetails);
}
