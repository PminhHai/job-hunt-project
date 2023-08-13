

window.addEventListener('DOMContentLoaded', event => {
    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }
});
const searchParams = new URLSearchParams(window.location.search)
/*press enter on search input text-box to search method*/
$('#searchInput').keydown(function(e) {
			if (e.keyCode == 13) {
				var query = $('#searchInput').val();
				if(searchParams.has('id')) {
						var id =  searchParams.get('id');
						window.location.href = window.location.pathname + "?query=" + query+"&id=" + id;
						}
						else
				window.location.href = window.location.pathname + "?query=" + query;
			}
		});

/*select entries per page to change*/
		$('#accountInPage').on(
				'change',
				function() {
					var query = $('#searchInput').val();
					var number = $('#accountInPage').find(":selected").val();
					if(searchParams.has('id')) {
						var id =  searchParams.get('id');
						window.location.href = window.location.pathname + "?query=" + query
							+ "&numberShown=" + number+ "&id="+id;
					}else
					window.location.href = window.location.pathname + "?query=" + query
							+ "&numberShown=" + number;
				});
/*retain selected entries per page after click*/
		$(document).ready(
				function() {
					
					if(!searchParams.has('numberShown') ) {
						$("#accountInPage").val(5).attr('selected',
							'selected');
					}else {
						let numberShown = searchParams.get('numberShown');
					$("#accountInPage").val(numberShown).attr('selected',
							'selected');
					}
					
				});
/*show alert message*/
if(searchParams.has('alertMessage')) {
			var alertMes =  searchParams.get('alertMessage');
			 alert (alertMes);  
		} 
		
/*Controller for donation button*/
		$('.updateBtn').click(function() {
			//alert("Sadddd");
			var idBtn = $(this).attr('id');
			var id = idBtn.substring(13);
			$('#inputDonationId').val(id);
			$('#exampleModalUpdate').toggleClass('show');
			$('#exampleModalUpdate').css("display", "block");

		});

		/*close icon event*/
		$('.btn-close').click(function() {
			
			$('#exampleModalUpdate').toggleClass('show');
			$('#exampleModalUpdate').css("display", "none");
		});
		/*đóng button event*/
		$('.btn-secondary').click(function() {
			
			$('#exampleModalUpdate').toggleClass('show');
			$('#exampleModalUpdate').css("display", "none");
		});
		
		
//		register page
		/*hide or show company input when role dropdown is selected*/
		var addCompanyStatus = 0; //0 is employee selected ; 1 is choosing existing company ; 2 is input new company
		$('#roleId1').change(function() {
			var value = this.value;
			
			if(value!= 1) {
				$("#company-input").css("display", "inline-table");
				$("#new-company-btn").css("display", "block");
				$('#companyId1').attr('disabled',false);
				addCompanyStatus =1 ;
				$("#new-company-btn1").text("add new company");
			}else{
			$("#new-company-input").css("display", "none");
			$('#new-company-input-text').attr('disabled',true);
			$('#companyId1').attr('disabled',true);
			$("#company-input").css("display", "none");
			$("#new-company-btn").css("display", "none");
			addCompanyStatus = 0;
			}
			
			
			
		});
		
		/* hide or show new input company */
		$('#new-company-btn').click(function() {
            if(addCompanyStatus==1) {
				$("#company-input").css("display", "none");
				$("#new-company-input").css("display", "inline-table");
				$('#companyId1').attr('disabled',true);
				$('#new-company-input-text').attr('disabled',false);
				$("#new-company-btn1").text("choose existed company");
				addCompanyStatus = 2;		
				
			}
			else{
				$("#company-input").css("display", "inline-table");
				$("#new-company-input").css("display", "none");
				$('#companyId1').attr('disabled',false);
				$('#new-company-input-text').attr('disabled',true);
				addCompanyStatus=1;		
				$("#new-company-btn1").text("add new company");
			} 
		});
		
		/*all input ediable if click on edit button*/ 
		$('#edit-input').click(function() {
			$('.profile-form').attr('disabled',false);
			$(this).css('display', "none");
			$('#confirm-btn').css('display', "inline-block");
		});
		
		$('#edit-company-input').click(function() {
			$('.company-form').attr('disabled',false);
			$(this).css('display', "none");
			$('#confirm-company-btn').css('display', "inline-block");
		});
		
		
		