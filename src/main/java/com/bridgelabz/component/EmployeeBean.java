package com.bridgelabz.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBean {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeBean.class);

    private int eid;
    private String ename;

    @Autowired
    private DepartmentBean deptBean;

    public EmployeeBean() {
    }

    @Autowired
    public EmployeeBean(DepartmentBean deptBean) {
        logger.trace("*** Autowiring via Constructor ***");
        this.deptBean = deptBean;
    }

    public int getEid() { return eid; }
    public void setEid(int eid) { this.eid = eid; }

    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }

    public DepartmentBean getDeptBean() { return deptBean; }

    @Autowired
    public void setDeptBean(DepartmentBean deptBean) {
        logger.trace("*** Autowiring via Setter ***");
        this.deptBean = deptBean;
    }

    public void showEmployeeDetails() {
        deptBean.setDeptName("Engineering");
        logger.debug("Employee Id   : {}", eid);
        logger.debug("Employee Name : {}", ename);
        logger.debug("Department    : {}", deptBean.getDeptName());
    }
}