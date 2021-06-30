package myjava.entity;

import java.io.Serializable;

/**
 * @author l
 * @date 2021/6/16 17:41
 * @description
营业执照识别/OCR文字识别
 *
 *
 */
public class BusinessLicense implements Serializable {
    private String config_str;
    private float angle;
    private String reg_num;
    private String name;
    private String type;
    private String person;
    private String establish_date;
    private String valid_period;
    private String address;
    private String capital;
    private String business;
    private boolean is_fake;
    private boolean success;

    public String getConfig_str() {
        return config_str;
    }

    public void setConfig_str(String config_str) {
        this.config_str = config_str;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getEstablish_date() {
        return establish_date;
    }

    public void setEstablish_date(String establish_date) {
        this.establish_date = establish_date;
    }

    public String getValid_period() {
        return valid_period;
    }

    public void setValid_period(String valid_period) {
        this.valid_period = valid_period;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public boolean isIs_fake() {
        return is_fake;
    }

    public void setIs_fake(boolean is_fake) {
        this.is_fake = is_fake;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
