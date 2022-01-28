package com.ozturkomerfaruk.hafta10uyg;

public class User {
    private String _name;
    private String _surname;
    private String _age;
    private String _job;
    private boolean _isWoman;

    public User(String _name, String _surname, String _age, String _job, boolean _isWoman) {
        this._name = _name;
        this._surname = _surname;
        this._age = _age;
        this._job = _job;
        this._isWoman = _isWoman;
    }


    public boolean get_isWoman() {
        return _isWoman;
    }

    public void set_isWoman(boolean _isWoman) {
        this._isWoman = _isWoman;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_surname() {
        return _surname;
    }

    public void set_surname(String _surname) {
        this._surname = _surname;
    }

    public String get_age() {
        return _age;
    }

    public void set_age(String _age) {
        this._age = _age;
    }

    public String get_job() {
        return _job;
    }

    public void set_job(String _job) {
        this._job = _job;
    }
}
