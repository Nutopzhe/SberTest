package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

//аннотация для возможности избежать создания всех полей
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String email;
    private String name;
    private List<Integer> tasks;
    private List<Integer> companies;
    private String hobby;
    private String phone;
    private String inn;

    public User(String email, String name, List<Integer> tasks, List<Integer> companies, String hobby, String phone, String inn) {
        this.email = email;
        this.name = name;
        this.tasks = tasks;
        this.companies = companies;
        this.hobby = hobby;
        this.phone = phone;
        this.inn = inn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getTasks() {
        return tasks;
    }

    public void setTasks(List<Integer> tasks) {
        this.tasks = tasks;
    }

    public List<Integer> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Integer> companies) {
        this.companies = companies;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}
