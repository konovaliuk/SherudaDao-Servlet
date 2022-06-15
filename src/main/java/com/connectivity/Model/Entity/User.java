package com.connectivity.Model.Entity;

import com.connectivity.Model.Dao.Markers.Column;
import com.connectivity.Model.Dao.Markers.Entity;
import com.connectivity.Model.Dao.Markers.Id;

import java.sql.Date;

    @Entity(tableName = "User")
    public class User {
        @Id
        @Column(columnName = "ID", isNotNull = true, isAutoIncrement = true)
        private Integer id;
        @Column(isNotNull = true, isUnique = true)
        private String name;

        @Column(isNotNull = true)
        private String password;

        @Column(columnName = "date")
        private Date year;

        public User() {
        }

        public User(Integer id) {
            this.id = id;
        }



        public User(Integer id, String name, String password, Date year) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.year = year;
        }

        public User(String name, String password) {
            this.name = name;
            this.password = password;
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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Date getYear() {
            return year;
        }

        public void setYear(Date year) {
            this.year = year;
        }

        public User(String name, String password, Date year) {
            this.name = name;
            this.password = password;
            this.year = year;
        }
    }

