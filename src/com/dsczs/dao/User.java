package com.dsczs.dao;


public class User {
    
    private Integer id;
    
    private String password;
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    private String username;
    
    private Address address;
    
    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    private int age;
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    public User(String username, int age) {
        super();
        this.username = username;
        this.age = age;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", username="
                + username + ", age=" + age + "]";
    }
    public User() {
        super();
    }
    public User(Integer id, String password, String username, int age) {
        super();
        this.id = id;
        this.password = password;
        this.username = username;
        this.age = age;
    }
    
    
    
    
}
