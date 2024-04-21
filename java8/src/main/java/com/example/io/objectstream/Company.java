package com.example.io.objectstream;

import java.util.List;

// 配列、その他のコレクションをシリアライズする場合、要素のそれぞれがシリアライズ可能であること
// シリアライズされたオブジェクトがオブジェクト参照変数によって参照するオブジェクトがシリアライズ可能であること
// static変数およびtransient変数はシリアライズ対象外
// スーパークラスがSerializableであればサブクラスは実装しなくてもシリアライズ可能
// サブクラスがSerializableを実装しているとスーパークラスはデシリアライズの際にインスタンス化される
public class Company extends Organization {
    private int[] zipCode;
    private String[] addressName;
    private Employee ceo;
    private List<Employee> members;

    public Company(int[] zipCode, String[] addressName, Employee ceo, List<Employee> members) {
        super(500L);
        this.zipCode = zipCode;
        this.addressName = addressName;
        this.ceo = ceo;
        this.members = members;
    }

    public int[] getZipCode() {
        return zipCode;
    }

    public void setZipCode(int[] zipCode) {
        this.zipCode = zipCode;
    }

    public String[] getAddressName() {
        return addressName;
    }

    public void setAddressName(String[] addressName) {
        this.addressName = addressName;
    }

    public Employee getCeo() {
        return ceo;
    }

    public void setCeo(Employee ceo) {
        this.ceo = ceo;
    }

    public List<Employee> getMembers() {
        return members;
    }

    public void setMembers(List<Employee> members) {
        this.members = members;
    }
}
