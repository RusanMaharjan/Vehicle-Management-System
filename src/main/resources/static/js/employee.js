$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employee, status){
			$('#txtAddressEdit').val(employee.address);
			$('#txtCityEdit').val(employee.city);
			$('#ddlNationalityEdit').val(employee.countryid);			
			var dob = employee.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(employee.email);
			$('#txtFirstnameEdit').val(employee.firstName);
			$('#ddlGenderEdit').val(employee.gender);
			$('#txtIdEdit').val(employee.id);
			$('#txtInitialsEdit').val(employee.initials);
			$('#txtLastnameEdit').val(employee.lastName);
			$('#ddlMaritalStatusEdit').val(employee.maritalStatus);
			$('#txtMobileEdit').val(employee.mobile);
			$('#txtOthernameEdit').val(employee.otherName);		
			$('#txtPhoneEdit').val(employee.phone);			
			$('#fupPhotoEdit').val(employee.photo);			
			$('#txtSSNEdit').val(employee.socialSecurityNumber);			
			$('#ddlStateEdit').val(employee.stateid);	
			$('#ddlTitleEdit').val(employee.title);			
			$('#ddlEmployeeTypeEdit').val(employee.employeetypeid);				
			var hireDate = employee.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(employee.jobtitleid);			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employee, status){
			$('#txtAddressDetails').val(employee.address);
			$('#txtCityDetails').val(employee.city);
			$('#ddlNationalityDetails').val(employee.countryid);			
			var dob = employee.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthDetails').val(dob);
			$('#txtEmailDetails').val(employee.email);
			$('#txtFirstnameDetails').val(employee.firstName);
			$('#ddlGenderDetails').val(employee.gender);
			$('#txtIdDetails').val(employee.id);
			$('#txtInitialsDetails').val(employee.initials);
			$('#txtLastnameDetails').val(employee.lastName);
			$('#ddlMaritalStatusDetails').val(employee.maritalStatus);
			$('#txtMobileDetails').val(employee.mobile);
			$('#txtOthernameDetails').val(employee.otherName);		
			$('#txtPhoneDetails').val(employee.phone);			
			$('#fupPhotoDetails').val(employee.photo);			
			$('#txtSSNDetails').val(employee.socialSecurityNumber);			
			$('#ddlStateDetails').val(employee.stateid);	
			$('#ddlTitleDetails').val(employee.title);			
			$('#ddlEmployeeTypeDetails').val(employee.employeetypeid);				
			var hireDate = employee.hireDate.substr(0,10);
			$('#txtHireDateDetails').val(hireDate);
			$('#ddlJobTitleDetails').val(employee.jobtitleid);	
			$('#lastModifiedByDetails').val(employee.lastModifiedBy);
			$('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
	
	$('.table #photoButton').on('Click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('photoModal').modal();
	});
	
});