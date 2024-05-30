package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Receptionist;
import com.klef.jfsd.springboot.repository.ReceptionistRepository;

@Service
public class ReceptionistServiceImpl implements ReceptionistService
{

	@Autowired
	private ReceptionistRepository receptionistRepository;
	
	@Override
	public Receptionist addreceptionist(Receptionist receptionist) 
	{
		return receptionistRepository.save(receptionist);
	}

	@Override
	public Receptionist checkreceptlogin(String uname, String pwd)
	{
		
		return receptionistRepository.checkreplogin(uname, pwd);
	}

	@Override
	public Receptionist viewreceptionist(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	  public int changereceptionistpassword(String repoldpwd, String repnewpwd, String runame) {
	    return receptionistRepository.updaterecppassword(repnewpwd, repoldpwd, runame);
	  }

}
