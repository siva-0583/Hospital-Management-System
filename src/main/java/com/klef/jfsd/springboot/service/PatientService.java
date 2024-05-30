package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Patient;
import com.klef.jfsd.springboot.model.Prescription;

public interface PatientService
{
	public Patient addemployee(Patient employee);
	public Patient checkemplogin(String uname,String pwd);
	public Patient viewemployee(String uname);
	public int changeemployeepassword(String empoldpwd,String empnewpwd,String euname);
	public List<Prescription> viewprescription(String euname);
}
