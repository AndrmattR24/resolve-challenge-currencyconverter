package com.andrmatt.currencyconverter.model;

public class ExchangeRates{
        String result;
        String documentation;
        String terms_of_use;
        Integer time_last_update_unix;
        String time_last_update_utc;
        Integer time_next_update_unix;
        String time_next_update_utC;
        String base_code;
        String target_code;
        double conversion_rate;
        double conversion_result;

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }
}
