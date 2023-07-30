package com.shocial.shocial.model;

import jakarta.persistence.*;

// POJOs or Model that represents the data in database
// TODO: Create a database and data table that matches the properties below.
// TODO: Create Data table name = "users" ,
// TODO: Column names should match properties. Column names: id, username, password, email
@Entity // This annotation is what binds the Object and DB. This is Spring Magic
@Table(name = "users") // "users" should match your database table name
public class UserModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        String username;
        String password;
        String email;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "UserModel{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
}

