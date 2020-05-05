package com.akademikwebapp.akademikwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akademikwebapp.akademikwebapp.SendEmail;
import com.akademikwebapp.akademikwebapp.User;
import com.akademikwebapp.akademikwebapp.entity.Authorities;
import com.akademikwebapp.akademikwebapp.entity.Jelo;
import com.akademikwebapp.akademikwebapp.entity.Users;
import com.akademikwebapp.akademikwebapp.service.ServiceDAO;

@Controller
public class MainController {

	@Autowired
	private ServiceDAO theServiceDAO;

	@GetMapping("/home")
	public String getMainPage() {
		return "/menis/home";
	}

	@GetMapping("/jelovnik")
	public String getAllMenis(@RequestParam String vrsta_jela, Model theModel) {
		List<Jelo> listaJela = theServiceDAO.findAll();

		if (!(vrsta_jela == null)) {

			for (int i = 0; i < listaJela.size(); i++) {
				if (!(listaJela.get(i).getVrstaJela().equals(vrsta_jela))) {
					listaJela.remove(i);

					--i;
				}

			}

			theModel.addAttribute("jela", listaJela);
		}

		theModel.addAttribute("vJela", vrsta_jela.toUpperCase());

		return "/menis/jelovnik";

	}

	@GetMapping("/about")
	public String getAboutPage() {
		return "/menis/about";
	}

	@GetMapping("/contact")
	public String getContactPage(Model theModel) {
		
		SendEmail sendEmail = new SendEmail();
		
		theModel.addAttribute("email", sendEmail);
		
		return "/menis/contact";
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute("email") SendEmail tempEmail)
	{
		
		System.out.println(tempEmail.getfromEmail());
		try {
			tempEmail.sendMail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/home";
	}

	@GetMapping("/showMyLoginPage")
	public String fancyLogin() {
		return "/menis/fancy-login";
	}

	@GetMapping("/access-denied")
	public String fancyLogina() {
		return "/menis/contact";
	}

	@GetMapping("/lista-jela")
	public String getListaJela(Model theModel) {

		List<Jelo> listaJela = theServiceDAO.findAll();

		theModel.addAttribute("jela1", listaJela);

		return "/menis/lista-jela";
	}

	@GetMapping("/updateJelo")
	public String updateJelo(@RequestParam int jeloId, Model theModel) {

		Jelo theJelo = theServiceDAO.findById(jeloId);

		theModel.addAttribute("jeloId", theJelo);

		return "/menis/update-jelo";
	}

	@GetMapping("/dodajJelo")
	public String dodajJelo(Model theModel) {

		Jelo theJelo = new Jelo();

		theModel.addAttribute("jeloId", theJelo);

		return "/menis/dodaj-jelo";
	}

	@PostMapping("/save")
	public String saveJelo(@ModelAttribute("jeloId") Jelo jeloId) {

		theServiceDAO.save(jeloId);

		return "redirect:/lista-jela";

	}

	@GetMapping("/deleteJelo")
	public String deleteJelo(@RequestParam int jeloId) {

		theServiceDAO.deleteById(jeloId);

		return "redirect:/lista-jela";
	}

	@GetMapping("/admin/lista-administratora")
	public String getListaAdministratora(Model theModel) {
		List<Users> listaAdministracija = theServiceDAO.findaAll();

		List<User> user = new ArrayList<User>();

		for (Users tempUsers : listaAdministracija) {
			for (int i = 0; i < tempUsers.getAuthorities().size(); i++) {
				User tempUser = new User(tempUsers.getUsername(), tempUsers.getPassword(), tempUsers.getEnabled(),
						tempUsers.getAuthorities().get(i).getAuthority(), tempUsers.getAuthorities().get(i).getId());

				user.add(tempUser);
			}
		}

		theModel.addAttribute("administracije1", user);

		return "/menis/lista-administratora";
	}

	@GetMapping("/admin/dodaj-administratora")
	public String getDodajAdministratora(Model theModel) {

		Users user = new Users();

		user.addAuthorities(new Authorities());
		user.addAuthorities(new Authorities());
		user.addAuthorities(new Authorities());

		theModel.addAttribute("user", user);

		return "/menis/dodaj-administratora";
	}

	@GetMapping("/admin/update-administratora")
	public String getUpdateAdministratora(@RequestParam String administratorUsername, Model theModel) {

		Users user = theServiceDAO.findUserById(administratorUsername);

		if (user.getAuthorities().size() == 1) {
			user.getAuthorities().add(new Authorities());
			user.getAuthorities().add(new Authorities());
		}

		if (user.getAuthorities().size() == 2)
			user.getAuthorities().add(new Authorities());

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (user.getAuthorities().get(j).getAuthority() != null) {
					if (user.getAuthorities().get(j).getAuthority().equals("ROLE_EMPLOYEE")) {
						Authorities tempAuthorities = user.getAuthorities().get(0);

						user.getAuthorities().set(0, user.getAuthorities().get(j));

						user.getAuthorities().set(j, tempAuthorities);

					}

					else if (user.getAuthorities().get(j).getAuthority().equals("ROLE_MANAGER")) {
						Authorities tempAuthorities = user.getAuthorities().get(1);

						user.getAuthorities().set(1, user.getAuthorities().get(j));

						user.getAuthorities().set(j, tempAuthorities);
					}

					else if (user.getAuthorities().get(j).getAuthority().equals("ROLE_ADMIN")) {
						Authorities tempAuthorities = user.getAuthorities().get(2);

						user.getAuthorities().set(2, user.getAuthorities().get(j));

						user.getAuthorities().set(j, tempAuthorities);
					}
				}
			}
		}

		theModel.addAttribute("user", user);

		return "/menis/update-administratora";
	}

	@PostMapping("/admin/save")
	public String saveUser(@ModelAttribute("user") Users user) {

		System.out.println(user);

		for (int i = 0; i < user.getAuthorities().size(); i++)
			if (user.getAuthorities().get(i).getAuthority() == null) {

				System.out.println(i);
				user.getAuthorities().remove(i);
				--i;
			}

		System.out.println(user);
		theServiceDAO.saveUser(user);

		return "redirect:/admin/lista-administratora";

	}

	@PostMapping("/admin/saveAdministrator")
	public String saveUserAdministrator(@ModelAttribute("user") Users user) {

		for (int i = 0; i < user.getAuthorities().size(); i++) {

			if (user.getAuthorities().get(i).getAuthority() == null) {
				user.getAuthorities().remove(i);
				i--;
			}
		}

		theServiceDAO.saveUser(user);

		return "redirect:/admin/lista-administratora";

	}

	@GetMapping("/admin/delete")
	public String deleteAuthoritie(@RequestParam int administratorRoleId) {

		theServiceDAO.deleteAuthorityRole(administratorRoleId);

		return "redirect:/admin/lista-administratora";
	}

}
