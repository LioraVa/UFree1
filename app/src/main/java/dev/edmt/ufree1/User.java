package dev.edmt.ufree1;


public class User {
    public String name, phone, mail, password, bussness, id;
//    public User(String id, String name, String phone, String mail, String password, String bussness) {
//        this.id = id;
//        this.name = name;
//        this.phone = phone;
//        this.mail = mail;
//        this.password = password;
//        this.bussness = bussness;
//    }

    public User(String name, String phone, String mail, String password, String bussness) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.password = password;
        this.bussness = bussness;
    }

    public User() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getBussness() {
        return bussness;
    }
    public void setBussness(String bussness) {
        this.bussness = bussness;
    }
}
