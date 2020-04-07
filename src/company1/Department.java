/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department implements Serializable {

    @Id
    @Column(name = "deptid", unique = true, nullable = false)
//    @SequenceGenerator(name = "Dept_Gen", sequenceName = "Dept_Seq")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "deptname", nullable = false, length = 20)
    private String deptname;

//    @ManyToOne
//    @JoinColumn(name ="Deptid")
//    private Employee emp ;
    public int getId() {
        return id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

}
