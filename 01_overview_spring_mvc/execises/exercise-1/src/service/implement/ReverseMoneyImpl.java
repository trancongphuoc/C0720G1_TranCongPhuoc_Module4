package service.implement;

import org.springframework.stereotype.Service;
import service.ReverseMoney;


@Service
public class ReverseMoneyImpl implements ReverseMoney {
    @Override
    public double vndToUSD(double vnd) {
        return vnd/22000;
    }

    @Override
    public double usdToVND(double usd) {
        return usd*22000;
    }
}
