package dev.edmt.ufree1;

public class Profile {
    private String di;
    private String name;
    private String filed;
    private int profilePic;
    private String phone;
    private String city;
    private String address;

    public Profile(String di, String name, String filed, String phone, String city, String address) {
        this.di = di;
        this.name = name;
        this.filed = filed;
        this.phone = phone;
        this.city = city;
        this.address = address;
    }

    public Profile(String di, String name, String filed, int profilePic, String phone, String city, String address) {
        this.di = di;
        this.name = name;
        this.filed = filed;
        this.profilePic = profilePic;
        this.phone = phone;
        this.city = city;
        this.address = address;
    }
    public Profile() {
    }

    public String getDi() {
        return di;
    }
    public void setDi(String di) {
        this.di = di;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFiled() {
        return filed;
    }
    public void setFiled(String filed) {
        this.filed = filed;
    }
    public int getProfilePic() {
        return profilePic;
    }
    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }
//    public boolean getPermission() {
//        return permission;
//    }
//    public void setPermission(boolean permission) {
//        this.permission = permission;
//    }
}

//public class Profile {
//    private String di;
//    private String name;
//    private String filed;
//    private int profilePic;
//    private String phone;
//    private String city;
//    private String address;
//
//    public Profile(String di, String name, String filed, int profilePic, String phone, String city, String address) {
//        this.di = di;
//        this.name = name;
//        this.filed = filed;
//        this.profilePic = profilePic;
//        this.phone = phone;
//        this.city = city;
//        this.address = address;
//    }
//    public Profile() {
//    }
//
//    public String getDi() {
//        return di;
//    }
//    public void setDi(String di) {
//        this.di = di;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//    public String getCity() {
//        return city;
//    }
//    public void setCity(String city) {
//        this.city = city;
//    }
//    public String getAddress() {
//        return address;
//    }
//    public void setAddress(String address) {
//        this.address = address;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getFiled() {
//        return filed;
//    }
//    public void setFiled(String filed) {
//        this.filed = filed;
//    }
//    public int getProfilePic() {
//        return profilePic;
//    }
//    public void setProfilePic(int profilePic) {
//        this.profilePic = profilePic;
//    }
////    public boolean getPermission() {
////        return permission;
////    }
////    public void setPermission(boolean permission) {
////        this.permission = permission;
////    }
//}
