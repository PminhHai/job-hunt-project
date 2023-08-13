package com.fx21044.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fx21044.dto.ApplyPostDTO;
import com.fx21044.dto.PostDTO;
import com.fx21044.model.ApplyPost;
import com.fx21044.model.Category;
import com.fx21044.model.Company;
import com.fx21044.model.JobType;
import com.fx21044.model.Post;
import com.fx21044.model.User;
import com.fx21044.service.ApplyPostService;
import com.fx21044.service.CategoryService;
import com.fx21044.service.CompanyService;
import com.fx21044.service.JobTypeService;
import com.fx21044.service.PostService;
import com.fx21044.service.UserService;

@Controller
public class PostController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private JobTypeService jobTypeService;
	
	@Autowired
	private ApplyPostService applyPostService;
	
	@Autowired
	private HomeController homeController;
	
	//danh sách post của công ty
	@RequestMapping("/listPostCompany/{companyId}")
	public String listPostCompany(Authentication authentication, Model model,
								@RequestParam(value = "page", defaultValue = "1") int page,
								@PathVariable("companyId") int id) {
		Company company = companyService.getCompanyById(id);
		model.addAttribute("company", company);
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		model.addAttribute("username",username);
		List<Post> posts = postService.getPostsByCompanyID(company.getId(), page);
		int countPost = postService.getCountByCompanyId(company.getId());
		model.addAttribute("posts",posts);
		model.addAttribute("maxPage",(countPost - 1) / 5 + 1);
		model.addAttribute("page", page);
		return "list-post-company";
	}
	
	//danh sách post user đã apply
	@RequestMapping("/postApplied")
	public String showPostApplyList(Authentication authentication, Model model,
									@RequestParam(value = "page", defaultValue = "1") int page) {
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		List<Post> posts = postService.getPostsByUserApplied(user.getId(), page);
		int countPost = postService.getAllPostsByUserApplied(user.getId());
		System.out.println(countPost);
		model.addAttribute("posts",posts);
		model.addAttribute("maxPage",(countPost - 1) / 5 + 1);
		model.addAttribute("page",page);
		model.addAttribute("username",username);
		return "listPostApplied";
	}
	
	//danh sách post đã tạo
	@RequestMapping("/recruiter/postList")
	public String showPostsList(Authentication authentication,Model model,
			@RequestParam(value="page",defaultValue = "1") int page) {
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		List<Post> posts = postService.getPostsByUserID(user.getId(), page);
		int countPost = postService.getCountByUserId(user.getId());
		model.addAttribute("posts",posts);
		model.addAttribute("maxPage",(countPost-1)/5+1);
		model.addAttribute("page",page);
		return "postList";
	}
	
	//trang tạo post
	@RequestMapping("/recruiter/newPostForm")
	public String showNewPost(Authentication authentication, Model model, PostDTO postDTO) {
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		Company company = user.getCompany();
		if( postDTO == null) {
			postDTO = new PostDTO();
		}
		List<Category> categories = categoryService.getCategories();
		List<JobType> jobTypes = jobTypeService.getJobTypes();
		
		model.addAttribute("post", postDTO);
		model.addAttribute("categories",categories);
		model.addAttribute("jobTypes",jobTypes);
		model.addAttribute("companyAddress",company.getAddress());
		
		return "newPostForm";
	}
	
	
	@PostMapping("/newPost")
	public String addNewPost(Authentication authentication, Model model, 
							@RequestBody @Valid @ModelAttribute(value = "post") PostDTO postDTO,
							BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors()) {
			return showNewPost(authentication, model, postDTO);
		}
		
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		int result = postService.addPost(postDTO, user);
		if(result == 0) {
			model.addAttribute("errorMessage","something gone wrong");
			return showNewPost(authentication, model, postDTO);
		}
		model.addAttribute("message","Bài đăng tuyển đã được thêm");
		return showPostsList(authentication, model, 1);
	}
	
	//trang cập nhật post
	@RequestMapping("/recruiter/editPostForm")
	public String showEditPost(Authentication authentication, Model model,
								PostDTO postDTO, 
								@RequestParam(value = "id") int postId) {
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		Company company = user.getCompany();
		postDTO = new PostDTO();
		Post post = postService.getPostById(postId);
		postDTO.setTitle(post.getTitle());
		postDTO.setDescription(post.getDescription());
		postDTO.setExperience(post.getExperience());
		postDTO.setNumberOfRecruit(post.getNumberOfRecruit()+"");
		SimpleDateFormat sdf = new SimpleDateFormat(
			    "yyyy-MM-dd");
		postDTO.setExpireDate(sdf.format(post.getExpireDate()));
		postDTO.setSalary(post.getSalary());
		postDTO.setLocation(post.getLocation());
		postDTO.setCategoryId(post.getCategory().getId());
		postDTO.setJobTypeId(post.getJobType().getId());
		List<Category> categories =  categoryService.getCategories();
		List<JobType> jobTypes = jobTypeService.getJobTypes();
		model.addAttribute("post",postDTO);
		model.addAttribute("categories",categories);
		model.addAttribute("jobTypes",jobTypes);
		model.addAttribute("companyAddress",company.getAddress());
		model.addAttribute("id",postId);
		return "postEditForm";
	}
	
	@PostMapping(value = "/editPost")
	public String editPost(Authentication authentication, Model model,
							@RequestBody @Valid @ModelAttribute(value = "post") PostDTO postDTO,
							BindingResult bindingResult,
							@RequestParam(value = "id") int postId) {
		if(bindingResult.hasErrors()) {
			return showEditPost(authentication, model, postDTO, postId);
		}
		
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		postService.updatePost(postDTO, user, postId);
		model.addAttribute("message", "bài đăng " + postDTO.getTitle() +" đã được cập nhật");
		return showPostsList(authentication, model, 1);
	}
	
	//xóa post
	@RequestMapping("/recruiter/deletePost")
	public String deletePost(Authentication authentication, Model model,
							@RequestParam(value = "id") int id) {
		int result = postService.deletePost(id);
		if(result == 1) {
			model.addAttribute("message", "bài đăng đã bị xóa");
		}
		return showPostsList(authentication, model, 1);
	}
	
	//Trang chi tiết post
	@RequestMapping("/viewPost")
	public String viewPost(Authentication authentication, Model model,
							@RequestParam(value = "id") int postId) {
		Post post = postService.getPostById(postId);
		model.addAttribute("post",post);
		List<ApplyPost> applyPosts = applyPostService.getApplyPostsByPostId(postId);
		model.addAttribute("applyPosts",applyPosts);
		return "detail-post";
	}
	
	//Tìm Post
	@RequestMapping("/search")
	public String searchPost(Model model,
							@RequestParam(value = "type") int type,
							@RequestParam(value = "searchQuery") String queryString,
							@RequestParam(value = "page", defaultValue = "1") int page,
							Authentication authentication) {
		List<Post> posts;
		if(type == 0) {
			posts = postService.getPostsByCategory(queryString, page);
		} else if (type == 1) {
			posts = postService.getPostsByCompanyName(queryString, page);
		} else {
			posts = postService.getPostsByAddress(queryString, page);
		}
		int countPost = postService.getCountOfLastSearchQuery();
		model.addAttribute("searchQuery",queryString);
		model.addAttribute("posts",posts);
		model.addAttribute("maxPage",(countPost-1)/5+1);
		model.addAttribute("page",page);
		model.addAttribute("type",type);
		String username = authentication.getName();
		model.addAttribute("username",username);
		return "postSearchResult";
	}
	
	//Chấp thuận apply
	@RequestMapping("/approveApply")
	public String approveApplyProcess(Authentication authentication, Model model,
										@RequestParam(value = "id") int applyPostId) {
		ApplyPost applyPost = applyPostService.getApplyPostById(applyPostId);
		applyPostService.approveApplyPost(applyPost);
		model.addAttribute("message","đơn ứng tuyển đã được chấp nhận");
		return viewPost(authentication, model, applyPost.getPost().getId());
	}
	
	//Từ chối apply
	@RequestMapping("/refuseApply")
	public String refuseApplyProcess(Authentication authentication, Model model,
									@RequestParam(value = "id") int applyPostId) {
		ApplyPost applyPost = applyPostService.getApplyPostById(applyPostId);
		applyPostService.refuseApplyPost(applyPost);
		model.addAttribute("message","đơn ứng tuyển đã được chấp nhận");
		return viewPost(authentication, model, applyPost.getPost().getId());
	}
	
	//from apply trang chủ
	@PostMapping("/applyPostHome")
	public String applyPostHome(@RequestParam MultipartFile file,
							@RequestParam(value = "description") String description,
							@RequestParam(value = "cvSubmitType") int cvSubmitType,
							@RequestParam int postId,
							Model model,
							@RequestParam(value = "page", defaultValue = "1") int page,
							Authentication authentication) {
		byte[] inputFile = null;
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		Post post = postService.getPostById(postId);
		
		if(cvSubmitType == 1) {
			if(user.getFileCv() == null) {
				model.addAttribute("errorMessage","Bạn phải cập nhập CV trước");
				return homeController.showHomePage(model, authentication);
			}
			inputFile = user.getFileCv();
		} else {
			if(file.isEmpty()) {
				model.addAttribute("errorMessage","Bạn phải chọn file trước");
				return homeController.showHomePage(model, authentication);
			}
			try {
				inputFile = file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		applyPostService.addNeApplyPost(user, post, inputFile, description);
		model.addAttribute("message","Đã ứng tuyển cho công việc này thành công");
		return showPostApplyList(authentication, model, page);
	}
	
	//form apply post trang của công ty
	@PostMapping("/applyPostCompany")
	public String applyPostCompany(@RequestParam MultipartFile file,
							@RequestParam(value = "description") String description,
							@RequestParam(value = "cvSubmitType") int cvSubmitType,
							@RequestParam int postId,
							@RequestParam int companyId,
							Model model,
							@RequestParam(value = "page", defaultValue = "1") int page,
							Authentication authentication) {
		byte[] inputFile = null;
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		Post post = postService.getPostById(postId);
		
		
		if(cvSubmitType == 1) {
			if(user.getFileCv() == null) {
				model.addAttribute("errorMessage","Bạn phải cập nhập CV trước");
				return listPostCompany(authentication, model, page, companyId);
			}
			inputFile = user.getFileCv();
		} else {
			if(file.isEmpty()) {
				model.addAttribute("errorMessage","Bạn phải chọn file trước");
				return listPostCompany(authentication, model, page, companyId);
			}
			try {
				inputFile = file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		applyPostService.addNeApplyPost(user, post, inputFile, description);
		model.addAttribute("message","Đã ứng tuyển cho công việc này thành công");
		return showPostApplyList(authentication, model, page);
	}
	
	//form apply trang search
	@PostMapping("/applyPostSearch")
	public String applyPostSearch(@RequestParam MultipartFile file,
							@RequestParam(value = "description") String description,
							@RequestParam(value = "cvSubmitType") int cvSubmitType,
							@RequestParam int postId,
							Model model,
							@RequestParam(value = "type") int type,
							@RequestParam(value = "searchQuery") String queryString,
							@RequestParam(value = "page", defaultValue = "1") int page,
							Authentication authentication) {
		byte[] inputFile = null;
		String username = authentication.getName();
		User user = userService.findUserByUserName(username);
		Post post = postService.getPostById(postId);
		
		
		if(cvSubmitType == 1) {
			if(user.getFileCv() == null) {
				model.addAttribute("errorMessage","Bạn phải cập nhập CV trước");
				return searchPost(model, type, queryString, page, authentication);
			}
			inputFile = user.getFileCv();
		} else {
			if(file.isEmpty()) {
				model.addAttribute("errorMessage","Bạn phải chọn file trước");
				return searchPost(model, type, queryString, page, authentication);
			}
			try {
				inputFile = file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		applyPostService.addNeApplyPost(user, post, inputFile, description);
		model.addAttribute("message","Đã ứng tuyển cho công việc này thành công");
		return showPostApplyList(authentication, model, page);
	}
}
