package com.connectivity.Model.Entity;

import com.connectivity.Model.Dao.Markers.Column;
import com.connectivity.Model.Dao.Markers.Entity;
import com.connectivity.Model.Dao.Markers.Id;
import com.connectivity.Model.Dao.Markers.JoinField;

@Entity(tableName = "users_roles")
public class JoinUserRole {
    @Id
    @Column(columnName = "ID",isNotNull = true, isAutoIncrement = true)
    private Integer id;

    @JoinField(referencedClass = User.class, columnName = "ID", onDelete = JoinField.OnDelete.CASCADE)
    @Column(columnName = "user_id",isNotNull = true)
    Integer user_id;

    @JoinField(referencedClass = Role.class, columnName = "ID", onDelete = JoinField.OnDelete.CASCADE)
    @Column(columnName = "role_id",isNotNull = true)
    Integer role_id;

    public JoinUserRole(Integer user_id, Integer role_id) {
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public JoinUserRole() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getId() {
        return id;
    }

    public JoinUserRole(Integer id) {
        this.id = id;
    }
}
