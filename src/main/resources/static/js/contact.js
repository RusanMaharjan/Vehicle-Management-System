$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact, status){
			$('#idEdit').val(contact.id);
			$('#editFirstName').val(contact.firstName);
			$('#editLastName').val(contact.lastName);
			$('#editMobile').val(contact.mobile);
			$('#editPhone').val(contact.phone);
			$('#editEmail').val(contact.email);
			$('#editRemarks').val(contact.remarks);
			$('#txtNameEdit').val(contact.name);	
			$('#txtPhoneEdit').val(contact.phone);			
			$('#ddlStateEdit').val(contact.stateid);	
			$('#txtWebsiteEdit').val(contact.website);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact, status){
			$('#idDetails').val(contact.id);
			$('#detailsFirstName').val(contact.firstName);
			$('#detailsLastName').val(contact.lastName);
			$('#detailsMobile').val(contact.mobile);
			$('#detailsPhone').val(contact.phone);
			$('#detailsEmail').val(contact.email);
			$('#detailsRemarks').val(contact.remarks);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delContact').attr('href', href);
		$('#deleteModal').modal();		
	});	
});