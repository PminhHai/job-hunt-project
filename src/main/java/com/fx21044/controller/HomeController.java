package com.fx21044.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fx21044.dto.CompanyDTO;
import com.fx21044.dto.TopCategoryDTO;
import com.fx21044.dto.UpdateUserDTO;
import com.fx21044.model.Company;
import com.fx21044.model.Post;
import com.fx21044.model.User;
import com.fx21044.service.CategoryService;
import com.fx21044.service.CompanyService;
import com.fx21044.service.PostService;
import com.fx21044.service.UserService;

@Controller
public class HomeController {
	@Autowired
	public UserService userService;
	
	@Autowired
	public CompanyService companyService;
	
	@Autowired
	public PostService postService;
	
	@Autowired
	public CategoryService categoryService;
	
	@GetMapping("/")
	public String showHome() {
		return "homerole";
	}
	
	//show trang chủ
	@GetMapping("/homepage")
	public String showHomePage(Model theModel,Authentication authentication) {
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		List<Company> companiesList = companyService.getTopFiveCompanies();
		List<Post> posts = postService.getTopFivePosts();
		List<TopCategoryDTO> categoryDTOs = categoryService.getTopCategoryDTOs();
		theModel.addAttribute("companies",companiesList);
		theModel.addAttribute("posts",posts);
		theModel.addAttribute("username",username);
		theModel.addAttribute("categories", categoryDTOs);
		return "home";
	}
	
	//trang profile
	@RequestMapping("/profile")
	public String showProfile(Authentication authentication, Model model) {
		String userName = authentication.getName();
		User user = userService.findUserByUserName(userName);
		
			if(user.getImage() != null) {
				System.out.println("avatar != null");
				byte[] encodeBase64 = Base64.getEncoder().encode(user.getImage());
				String base64Encode = "";
				
					try {
						System.out.println("running");
						base64Encode = new String(encodeBase64, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						System.out.println("something gone wrong!");
					}
				model.addAttribute("base64Encoded",base64Encode);
			}
			model.addAttribute("user",user);
			
			Company company;
			
			boolean hasRecruiterRole = authentication.getAuthorities().stream()
								.anyMatch(r -> r.getAuthority().equals("ROLE_RECRUITER"));
			if(hasRecruiterRole) {
				company = user.getCompany();
				model.addAttribute("company",company);
			}
			
		return "profile";
	}
	
	//Cập nhật profile
	@PostMapping("/updateProfile")
	public String updateProfile(Authentication authentication, Model model,
								@ModelAttribute(value = "user") UpdateUserDTO userDTO) {
		
		userService.updateUser(userDTO);
		model.addAttribute("message","Hồ sơ đã được cập nhật");
		return showProfile(authentication, model);
	}
	
	//Cập nhật công ty
	@PostMapping("/updateCompany")
	public String updateCompany(Authentication authentication,Model model,
								@ModelAttribute(value = "company") CompanyDTO companyDTO) {
		companyService.updateCompany(companyDTO);
		model.addAttribute("message","Thông tin công ty đã được cập nhật");
		return showProfile(authentication, model);
	}
	
	private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");
	
	//tải ảnh lên
	@PostMapping("/uploadAvatar")
	public String uploadAvatar(@RequestParam MultipartFile file, Model model,
								Authentication authentication, HttpSession session) throws IOException {
		
		if(file.isEmpty()) {
			model.addAttribute("error","Chưa chọn file để cập nhật");
			return showProfile(authentication, model);
		}
		
		String fileContentType = file.getContentType();
		if(!contentTypes.contains(fileContentType)) { 
			model.addAttribute("errorMessage","Phải là file ảnh");
			return showProfile(authentication, model);
		}
		
		byte[] prototypeFile = file.getBytes();
		String userName = authentication.getName();
		User user = userService.findUserByUserName(userName);
		user.setImage(prototypeFile);
		userService.saveFile(user);
		model.addAttribute("message","avatar đã được cập nhật");
		return showProfile(authentication, model);
	}
	
	//cập nhật cv
	@PostMapping(value = "/uploadCV")
	public String uploadCV(@RequestParam MultipartFile file, Model model,
							Authentication authentication, HttpSession session) throws IOException {
		if(file.isEmpty()) {
			model.addAttribute("error","Chưa chọn file để cập nhật");
			return showProfile(authentication, model);
		}
		
		String fileContentType = file.getContentType();
		
		if(!fileContentType.equals("application/pdf")) {
			model.addAttribute("errorMessage","Phải là file pdf");
			return showProfile(authentication, model);
		}
		
		byte[] prototypeFile = file.getBytes();
		String userName = authentication.getName();
		User user = userService.findUserByUserName(userName);
		user.setFileCv(prototypeFile);
		userService.saveFile(user);
		model.addAttribute("message","cv đã được cập nhật");
		return showProfile(authentication, model);
	}
	public String showLeaders() {
		return "leaders";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
