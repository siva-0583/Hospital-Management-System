package com.klef.jfsd.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Appointment;
import com.klef.jfsd.springboot.model.Doctor;
import com.klef.jfsd.springboot.model.Patient;
import com.klef.jfsd.springboot.model.Prescription;
import com.klef.jfsd.springboot.model.Receptionist;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.AppointmentService;
import com.klef.jfsd.springboot.service.DoctorService;
import com.klef.jfsd.springboot.service.PatientService;
import com.klef.jfsd.springboot.service.PrescriptionService;
import com.klef.jfsd.springboot.service.ReceptionistService;

@Controller
public class ClientController
{
	@Autowired
	private PatientService employeeService;
	
	@Autowired
	private AdminService adminService; 
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ReceptionistService receptionistService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@GetMapping("/")
	public String mainhomedemo()
	{
		return "index";
	}
	
	@GetMapping("/employeereg")
	public ModelAndView employeeregdemo()
	{
		ModelAndView mv = new ModelAndView("patientregistration", "pat",new Patient());
		return mv;
	}
	
	@PostMapping("/addpatient")
	public ModelAndView addemployeedemo(@ModelAttribute("pat") Patient employee)
	{
		employeeService.addemployee(employee);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
//		mv.addObject("msg", "Employee Registered Successfully");
		return mv;
	}
	
	@GetMapping("/employeelogin")
	public ModelAndView employeeogindemo()
	{
		ModelAndView mv = new ModelAndView("patientlogin");
		
		return mv;
	}
	
	@PostMapping("/checkemplogin")
	public ModelAndView checkemplogindemo(HttpServletRequest request)
	{
		ModelAndView mv =  new ModelAndView();
		
		String euname = request.getParameter("euname");
		String epwd = request.getParameter("epwd");
		
		Patient emp = employeeService.checkemplogin(euname, epwd);
		
		if(emp!=null)
		{
			HttpSession session = request.getSession();
			
			session.setAttribute("euname", euname);
			
			mv.setViewName("patienthome");
		}
		else
		{
			mv.setViewName("patientlogin");
//			mv.addObject("msg", "Login Failed");
		}
		return mv;
	}
	@GetMapping("/adminhome")
	public ModelAndView adminhomedemo()
	{
		ModelAndView mv = new ModelAndView("admindashh");
		
		return mv;
	}
	
	@GetMapping("/adminlogin")
	public ModelAndView adminlogindemo()
	{
		ModelAndView mv = new ModelAndView("adminlogin");
		
		return mv;
	}
	
	@PostMapping("/checkadminlogin")
	public ModelAndView checkadminlogindemo(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("admindashh");
		
		String auname = request.getParameter("auname");
		String apwd = request.getParameter("apwd");
		
		Admin admin = adminService.checkadminlogin(auname, apwd);
		
		if(admin!=null)
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("auname", auname);
			long c1 = adminService.countdoctors();
			long c2 = adminService.countpatients();
			long c3 = adminService.countreceptionists();
			long sum = c1+c2+c3;
			mv.addObject("cou1",c1);
			mv.addObject("cou2",c2);
			mv.addObject("cou3",c3);
			mv.addObject("sum",sum);
			return mv;
		}
		else
		{
			mv.setViewName("adminlogin");
			mv.addObject("msg", "Login Failed");
		}
		return mv;
	}
	
	@PostMapping("/adddoctor")
	  public ModelAndView adddoctordemo(@ModelAttribute("doc") Doctor doctor)
	  {
	    
	    doctorService.adddoctor(doctor);
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("successdoc");
	   // mv.addObject("msg", "Doctor Registered Successfully");
	    return mv;
	  }
	
	@GetMapping("/doctorreg")
	  public ModelAndView doctorregdemo()
	  {
	    ModelAndView mv = new ModelAndView("doctorregistration", "doc",new Doctor());
	    return mv;
	  }
	@GetMapping("/receptionistreg")
	  public ModelAndView receptionistregdemo()
	  {
	    ModelAndView mv = new ModelAndView("receptionistregistration", "rep",new Receptionist());
	    return mv;
	  }
	@PostMapping("/addreceptionist")
	  public ModelAndView addreceptionistdemo(@ModelAttribute("rep") Receptionist receptionist)
	  {
	    receptionistService.addreceptionist(receptionist);
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("successrec");
	   // mv.addObject("msg", "Receptionist Registered Successfully");
	    return mv;
	    
	    
	  }
	@GetMapping("/adminpage")
	public ModelAndView adminpagedemo()
	{
		ModelAndView mv = new ModelAndView("adminpage");
		
		return mv;
	}
	
	@GetMapping("/receptionistlogin")
	  public ModelAndView receptionistlogindemo()
	  {
	    ModelAndView mv = new ModelAndView("receptionistlogin");
	    
	    return mv;
	  }
	
	@PostMapping("/checkreplogin")
	  public ModelAndView checkreplogindemo(HttpServletRequest request)
	  {
	    ModelAndView mv =  new ModelAndView();
	    
	    String runame = request.getParameter("runame");
	    String rpwd = request.getParameter("rpwd");
	    
	    Receptionist rep = receptionistService.checkreceptlogin(runame, rpwd);
	    
	    if(rep!=null)
	    {
	      HttpSession session = request.getSession();
	      
	      session.setAttribute("runame", runame);
	      
	      mv.setViewName("recpsuccess");
	    }
	    else
	    {
	      mv.setViewName("receptionistlogin");
	      mv.addObject("msg", "Login Failed");
	    }
	    
	    
	    return mv;
	  }
	
	@GetMapping("/viewallpats")
	  public ModelAndView viewallpatsdemo()
	  {
	    ModelAndView mv = new ModelAndView("viewallpatients");
	    
	    List<Patient> patlist = adminService.viewallpatients();
	    mv.addObject("patlist",patlist);
	    return mv;
	  }
	@GetMapping("/viewalldocs")
	  public ModelAndView viewalldocsdemo()
	  {
	    ModelAndView mv = new ModelAndView("viewalldoctors");
	    
	    List<Doctor> doclist = adminService.viewalldoctors();
	    mv.addObject("doclist",doclist);
	    return mv;
	  }
	@GetMapping("/viewallrecs")
	  public ModelAndView viewallrecsdemo()
	  {
	    ModelAndView mv = new ModelAndView("viewallreceptionists");
	    
	    List<Receptionist> reclist = adminService.viewallreceptionists();
	    mv.addObject("reclist",reclist);
	    return mv;
	  }
	
	@GetMapping("/deletepat")
	  public String deletepatdemo(@RequestParam("id") int eid)
	  {
	    adminService.deletepatient(eid);
	    return "redirect:viewallpats";
	  }
	
	@GetMapping("/deletedoc")
	  public String deletedocdemo(@RequestParam("id") int eid)
	  {
	    adminService.deletedoctor(eid);
	    return "redirect:viewalldocs";
	  }
	
	@GetMapping("/deleterec")
	  public String deleterecdemo(@RequestParam("id") int eid)
	  {
	    adminService.deletereceptionist(eid);
	    return "redirect:viewallrecs";
	  }
	
	@GetMapping("/viewempbyid")
	  public ModelAndView viewempbyiddemo(@RequestParam("id") int eid)
	  {
	    Patient emp = adminService.viewemployeebyid(eid);
	    
	    ModelAndView mv = new ModelAndView();
	    
	    mv.setViewName("viewpatientbyid");
	    mv.addObject("emp",emp);
	    
	    return mv;
	  }
	
	@GetMapping("/viewemp")
	public ModelAndView viewemp(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		String euname = (String) session.getAttribute("euname");
		
		Patient emp =  employeeService.viewemployee(euname);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewpatient");
		mv.addObject("emp",emp);
		return mv;
	}
	
	@GetMapping("/makeapp")
	  public ModelAndView makeappointment(HttpServletRequest request)
	  {
	    
		ModelAndView mv = new ModelAndView("makeapp");
	    List<Doctor> doclist = adminService.viewalldoctors();
	    mv.addObject("doclist",doclist);
	    return mv;
	  }
	
	@RequestMapping("/addapp")
	  public ModelAndView addappointment(@RequestParam("dname") String dname, HttpServletRequest request)
	  {
	    ModelAndView mv=new ModelAndView("addapp","app",new Appointment());
	    HttpSession session = request.getSession();
		String euname = (String) session.getAttribute("euname");
	    mv.addObject("dname", dname);
	    return mv;
	  }
	
	@PostMapping("/addappointment")
	public ModelAndView addappointmentdemo(@ModelAttribute("app") Appointment appointment,HttpServletRequest request)
	{
		appointmentService.addapp(appointment);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		HttpSession session = request.getSession();
		String euname = (String) session.getAttribute("euname");
		mv.addObject("pname",euname);
		return mv;
	}
	
	@GetMapping("/doctorlogin")
	public ModelAndView doctorlogindemo()
	{
		ModelAndView mv = new ModelAndView("doctorlogin");
		
		return mv;
	}
	
	@PostMapping("/checkdoclogin")
	public ModelAndView checkdoclogindemo(HttpServletRequest request)
	{
		ModelAndView mv =  new ModelAndView();
		
		String duname = request.getParameter("duname");
		String dpwd = request.getParameter("dpwd");
		
		Doctor emp = doctorService.checkdoclogin(duname, dpwd);
		
		if(emp!=null)
		{
			HttpSession session = request.getSession();
			
			session.setAttribute("duname", duname);
			
			mv.setViewName("doctorhome");
		}
		else
		{
			mv.setViewName("doctorlogin");
//			mv.addObject("msg", "Login Failed");
		}
		return mv;
	}
	
	@GetMapping("/viewapp")
	public ModelAndView viewapp(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		String duname = (String) session.getAttribute("duname");
		ModelAndView mv = new ModelAndView("viewapp");
		List<Appointment> applist = doctorService.viewappointment(duname);
		mv.addObject("applist",applist);
		return mv;
	}
	@GetMapping("/deleteapp")
	  public String deleteappdemo(@RequestParam("id") int eid)
	  {
	    doctorService.deleteappointment(eid);
	    return "redirect:viewapp";
	  }
	@RequestMapping("/addpre")
	  public ModelAndView addprescription(@RequestParam("dname") String dname,@RequestParam("pname") String pname, HttpServletRequest request)
	  {
	    ModelAndView mv=new ModelAndView("addpre","pre",new Prescription());
//	    HttpSession session = request.getSession();
//		String euname = (String) session.getAttribute("euname");
	    mv.addObject("dname", dname);
	    mv.addObject("pname", pname);
	    return mv;
	  }
	
	@PostMapping("/addprescription")
	public ModelAndView addprescriptiondemo(@ModelAttribute("pre") Prescription prescription,HttpServletRequest request)
	{
		prescriptionService.addpre(prescription);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
//		HttpSession session = request.getSession();
//		String euname = (String) session.getAttribute("euname");
		//mv.addObject("pname",pname);
		return mv;
	}
	
	@GetMapping("/viewpre")
	public ModelAndView viewpre(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		String euname = (String) session.getAttribute("euname");
		ModelAndView mv = new ModelAndView("viewpre");
		List<Prescription> prelist = employeeService.viewprescription(euname);
		mv.addObject("prelist",prelist);
		return mv;
	}
	
	@GetMapping("/admindashboard")
	public ModelAndView admindashboarddemo()
	{
		long c1 = adminService.countdoctors();
		long c2 = adminService.countpatients();
		long c3 = adminService.countreceptionists();
		ModelAndView mv = new ModelAndView("admindashh");
		mv.addObject("cou1",c1);
		mv.addObject("cou2",c2);
		mv.addObject("cou3",c3);
		return mv;
	}
	
	@GetMapping("/echangepwd")
    public ModelAndView echangepwd(HttpServletRequest request)
    {
      HttpSession session = request.getSession();
      
      String euname = (String) session.getAttribute("euname");
      
      ModelAndView mv = new ModelAndView();
      mv.setViewName("updatepass");
      mv.addObject("euname",euname);
      
      return mv;
    }
    
    @PostMapping("/updateemppwd")
    public ModelAndView updateemppwddemo(HttpServletRequest request)
    {
      ModelAndView mv = new ModelAndView();
      
      
      HttpSession session = request.getSession();
      
      String euname = (String) session.getAttribute("euname");
      
      String eoldpwd = request.getParameter("eopwd");
      String enewpwd = request.getParameter("enpwd");
      
      int n = employeeService.changeemployeepassword(eoldpwd, enewpwd, euname);
      
      if(n > 0)
      {
        
        mv.setViewName("successpass");
      }
      else
      {
         mv.setViewName("updatepass");
         mv.addObject("msg","Old Password is Incorrect");
      }
      
      return mv;
    }
	
    @GetMapping("/docchangepwd")
    public ModelAndView docchangepwd(HttpServletRequest request)
    {
      HttpSession session = request.getSession();
      
      String duname = (String) session.getAttribute("duname");
      
      ModelAndView mv = new ModelAndView();
      mv.setViewName("docupdatepass");
      mv.addObject("duname",duname);
      
      return mv;
    }
    
    @PostMapping("/updatedocpwd")
    public ModelAndView updatedocpwddemo(HttpServletRequest request)
    {
      ModelAndView mv = new ModelAndView();
      
      
      HttpSession session = request.getSession();
      
      String duname = (String) session.getAttribute("duname");
      
      String doldpwd = request.getParameter("dopwd");
      String dnewpwd = request.getParameter("dnpwd");
      
      int n = doctorService.changedoctorpassword(doldpwd, dnewpwd, duname);
      
      if(n > 0)
      {
        
        mv.setViewName("successpass");
      }
      else
      {
         mv.setViewName("docupdatepass");
         mv.addObject("msg","Old Password is Incorrect");
      }
      
      return mv;
    }
    
    @GetMapping("/recpchangepwd")
    public ModelAndView recpchangepwd(HttpServletRequest request)
    {
      HttpSession session = request.getSession();
      
      String runame = (String) session.getAttribute("runame");
      
      ModelAndView mv = new ModelAndView();
      mv.setViewName("recpupdatepass");
      mv.addObject("runame",runame);
      
      return mv;
    }
    
    @PostMapping("/updaterecppwd")
    public ModelAndView updaterecppwddemo(HttpServletRequest request)
    {
      ModelAndView mv = new ModelAndView();
      
      
      HttpSession session = request.getSession();
      
      String runame = (String) session.getAttribute("runame");
      
      String roldpwd = request.getParameter("ropwd");
      String rnewpwd = request.getParameter("rnpwd");
      
      int n = receptionistService.changereceptionistpassword(roldpwd, rnewpwd, runame);
      
      if(n > 0)
      {
        
        mv.setViewName("successpass");
      }
      else
      {
         mv.setViewName("recpupdatepass");
         mv.addObject("msg","Old Password is Incorrect");
      }
      
      return mv;
    }
    
}
