/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(name = "xyz", query = "select e from Employee e order by e.id")
})

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    //  @SequenceGenerator(name="Emp_Gen", sequenceName="Emp_Seq")
    private int id;

    private String name;
    private String Address;
    private int DeptId;

    public Employee() {
    }

    public Employee(int id, String name, String Address, int DeptId) {
        this.id = id;
        this.name = name;
        this.Address = Address;
        this.DeptId = DeptId;
    }

    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    public int getId() {
        return id;
    }

    @Column(name = "NAME", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    @Column(name = "ADDRESS", nullable = false, length = 50)
    public String getAddress() {
        return Address;
    }

    @Column(name = "DEPTID", nullable = false)
    public int getDeptId() {
        return DeptId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setDeptId(int DeptId) {
        this.DeptId = DeptId;
    }

}
