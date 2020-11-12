package cn.kgc.entity;

public class User {

    private Integer id;
    private String name;
    private String phone;
    private Integer pwd;
    private String bornDate;

    public User() {
    }

    public User(Integer id, String name, String phone, Integer pwd, String bornDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.pwd = pwd;
        this.bornDate = bornDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
        this.pwd = pwd;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }
}
