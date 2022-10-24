package uz.ussd;

import androidx.annotation.NonNull;

public class Internet {
    private String packageName;
    private int mBAmount;
    private int price;
    private String ussdCode;
    private int validPeriod;

    @NonNull
    @Override
    public String toString() {

        String string = packageName+"\n"+
                ussdCode+"\n"+mBAmount+"\n"+
                price+"\n"+validPeriod;
        return string;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getmBAmount() {
        return mBAmount;
    }

    public void setmBAmount(int mBAmount) {
        this.mBAmount = mBAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUssdCode() {
        return ussdCode;
    }

    public void setUssdCode(String ussdCode) {
        this.ussdCode = ussdCode;
    }

    public int getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(int validPeriod) {
        this.validPeriod = validPeriod;
    }
}
