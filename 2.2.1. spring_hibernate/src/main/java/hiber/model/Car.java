package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="cars")
public class Car {

    @Id @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "series")
    private int series;

    @Column(name="model")
    private String model;

    public Car() {

    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series, model);
    }
}
