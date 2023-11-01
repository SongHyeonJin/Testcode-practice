package sample.testpractice.unit.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sample.testpractice.unit.beverage.Beverage;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Order {

    private final LocalDateTime orderDatetime;
    private final List<Beverage> beverages;

}
